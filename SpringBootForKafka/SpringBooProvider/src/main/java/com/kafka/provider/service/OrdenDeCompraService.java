package com.kafka.provider.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.provider.dtos.ProductoEnOCDTO;
import com.kafka.provider.entities.OrdenDeCompra;
import com.kafka.provider.entities.OrdenDeDespacho;
import com.kafka.provider.entities.ProductProvider;
import com.kafka.provider.entities.ProductoEnOC;
import com.kafka.provider.repository.IOrdenDeCompraRepository;
import com.kafka.provider.repository.IOrdenDeDespachoRepository;
import com.kafka.provider.repository.ProductProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
public class OrdenDeCompraService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ProductProviderRepository productProviderRepository;

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private IOrdenDeDespachoRepository ordenDeDespachoRepository;

    @KafkaListener(topics = "orden-de-compra", groupId = "provider-group")
    public void listen(String mensajeJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserializar el JSON a un Map
            Map<String, Object> mensajeMap = objectMapper.readValue(mensajeJson, new TypeReference<Map<String, Object>>() {});

            // Acceder a los atributos
            //String tiendaCodigo = (String) mensajeMap.get("tiendaCodigo");
            int ordenId = (Integer) mensajeMap.get("ordenId");
            //List<ProductoEnOCDTO> items = (List<ProductoEnOCDTO>) mensajeMap.get("items");
            //String fechaSolicitudStr = (String) mensajeMap.get("fechaSolicitud");

            // Transformar la cadena a LocalDate
            //LocalDate fechaSolicitud = null;
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //try {
            //    fechaSolicitud = LocalDate.parse(fechaSolicitudStr, formatter);
            //} catch (DateTimeParseException e) {
            //    throw new RuntimeException(e);
            //}

            atenderOrdenDeCompra(ordenId);


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void atenderOrdenDeCompra(int ordenDeCompraId) throws JsonProcessingException {
        Optional<OrdenDeCompra> ordenDeCompraOptional = ordenDeCompraRepository.findById(ordenDeCompraId);
        if (ordenDeCompraOptional.isEmpty()){
            throw new NoSuchElementException("No se encontró la Orden de Compra con ID: " + ordenDeCompraId);
        }
        OrdenDeCompra ordenDeCompra = ordenDeCompraOptional.get();
        List<String> errores = new ArrayList<>();
        List<ProductoEnOC> itemsFaltantes = new ArrayList<>();
        List<ProductProvider> productos = productProviderRepository.findAll();
        boolean puedeCumplir = true;

        // Verificar los artículos
        for (ProductoEnOC item : ordenDeCompra.getProductosEnOC()) {
            if (item.getCantidadSolicitada() < 1) {
                errores.add("Articulo " + item.getCodigo() + ": cantidad mal informada");
                puedeCumplir = false;
            }

            if (!proveedorTieneArticulo(item.getCodigo(), item.getColor(), item.getTalle(), productos)) {
                errores.add("Articulo " + item.getCodigo() + ": no existe");
                puedeCumplir = false;
            } else if (!proveedorTieneStockSuficiente(item.getCodigo(), item.getColor(), item.getTalle(), item.getCantidadSolicitada(), productos)) {
                itemsFaltantes.add(item);
                puedeCumplir = false;
            }
        }

        // Si esta rechazada
        if (!errores.isEmpty()) {
            enviarRespuesta(ordenDeCompra.getTienda().getCodigo(), ordenDeCompraId, "RECHAZADA", String.join(", ", errores));
            ordenDeCompra.setEstado("RECHAZADA");
            ordenDeCompraRepository.save(ordenDeCompra);
            return;
        }

        // Si falta Stock
        if (!puedeCumplir) {
            enviarRespuesta(ordenDeCompra.getTienda().getCodigo(), ordenDeCompraId, "ACEPTADA", "Faltante de stock para articulos: " + itemsFaltantes);
            ordenDeCompra.setEstado("ACEPTADA");
            ordenDeCompra.setPausada(true);
            ordenDeCompraRepository.save(ordenDeCompra);
            return;
        }

        // Si esta correcto
        ordenDeCompra.setEstado("ACEPTADA");// esto se hace desde el que consume "/{codigo de tienda}/solicitudes" o aca?
        ordenDeCompraRepository.save(ordenDeCompra);
        enviarRespuesta(ordenDeCompra.getTienda().getCodigo(), ordenDeCompraId, "ACEPTADA", "Orden aceptada");
        int ordenDespachoId = generarOrdenDespacho(ordenDeCompraId);
        enviarOrdenDespacho(ordenDespachoId);
        restarStockProveedor(ordenDeCompra.getProductosEnOC());
    }

    private void enviarRespuesta(String tiendaCodigo, int ordenId, String estado, String observacion) throws JsonProcessingException {
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("tiendaCodigo", tiendaCodigo);
        mensaje.put("ordenId", ordenId);
        mensaje.put("estado", estado);
        mensaje.put("observacion", observacion);

        String jsonMensaje = new ObjectMapper().writeValueAsString(mensaje);

        kafkaTemplate.send(tiendaCodigo + "-solicitudes", jsonMensaje);
    }

    private int generarOrdenDespacho(int ordenDeCompraId) {

        Optional<OrdenDeCompra> ordenDeCompraOptional = ordenDeCompraRepository.findById(ordenDeCompraId);
        OrdenDeDespacho ordenDeDespacho = new OrdenDeDespacho();

        if (ordenDeCompraOptional.isPresent()) {
            OrdenDeCompra ordenDeCompra = ordenDeCompraOptional.get();

            LocalDate fechaEstimadoEnvio = ordenDeCompra.getFechaDeSolicitud().plusDays(7);
            ordenDeDespacho.setFechaEstimadaDeEnvio(fechaEstimadoEnvio);
            ordenDeDespachoRepository.save(ordenDeDespacho);

            ordenDeCompra.setOrdenDeDespacho(ordenDeDespacho);
            ordenDeCompraRepository.save(ordenDeCompra);
        }

        return ordenDeDespacho.getId();
    }

    private void enviarOrdenDespacho(int ordenDespachoId) throws JsonProcessingException {
        Optional<OrdenDeDespacho> ordenDeDespachoOptional = ordenDeDespachoRepository.findById(ordenDespachoId);
        if(ordenDeDespachoOptional.isPresent()){
            OrdenDeDespacho ordenDeDespacho = ordenDeDespachoOptional.get();
            Map<String, Object> mensaje = new HashMap<>();
            mensaje.put("idOrdenDespacho", ordenDespachoId);
            mensaje.put("idOrdenCompra", ordenDeDespacho.getOrdenDeCompra().getId());
            mensaje.put("fechaEstimadoEnvio", ordenDeDespacho.getFechaEstimadaDeEnvio().toString());

            String jsonMensaje = new ObjectMapper().writeValueAsString(mensaje);

            kafkaTemplate.send(ordenDeDespacho.getOrdenDeCompra().getTienda().getCodigo() + "-despacho", jsonMensaje);
        }
    }

    private void restarStockProveedor(List<ProductoEnOC> items) {
        for (ProductoEnOC item : items) {
            String codigoArticulo = item.getCodigo();
            int cantidadSolicitada = item.getCantidadSolicitada();

            Optional<ProductProvider> productoOptional = productProviderRepository.findByCodigo(codigoArticulo);
            if (productoOptional.isPresent()) {
                ProductProvider producto = productoOptional.get();
                producto.setStock(producto.getStock() - cantidadSolicitada);
                productProviderRepository.save(producto);
            }
        }
    }

    private boolean proveedorTieneArticulo(String codigoArticulo, String color, String talle, List<ProductProvider> productos) {
        return productos.stream()
                .anyMatch(producto -> producto.getCodigo().equals(codigoArticulo)
                        && producto.getColor().equals(color)
                        && producto.getTalle().equals(talle));
    }

    private boolean proveedorTieneStockSuficiente(String codigoArticulo, String color, String talle, int cantidadSolicitada, List<ProductProvider> productos) {
        return productos.stream()
                .filter(producto -> producto.getCodigo().equals(codigoArticulo)
                        && producto.getColor().equals(color)
                        && producto.getTalle().equals(talle))
                .anyMatch(producto -> producto.getStock() >= cantidadSolicitada);
    }

}

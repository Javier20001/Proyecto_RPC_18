package com.kafka.consumer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.entities.OrdenDeCompra;
import com.kafka.consumer.entities.ProductoEnOC;
import com.kafka.consumer.entities.ProductoEnTienda;
import com.kafka.consumer.listener.KafkaConsumerListener;
import com.kafka.consumer.models.OrdenDeCompraModel;
import com.kafka.consumer.models.ProductoEnOCModel;
import com.kafka.consumer.repositories.IOrdenDeCompraRepository;
import com.kafka.consumer.repositories.IProductoEnTiendaRepository;
import com.kafka.consumer.repositories.ITiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("OrdenDeCompraService")
public class OrdenDeCompraService {

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Autowired
    private IProductoEnTiendaRepository productoEnTiendaRepository;

    @Autowired
    private KafkaConsumerListener kafkaConsumerListener;

    public ResponseEntity<String> createOrdenDeCompra(OrdenDeCompraModel model) {

        OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
        ordenDeCompra.setEstado("SOLICITADA");
        ordenDeCompra.setObservaciones(model.getObservaciones());
        ordenDeCompra.setPausada(false);
        if (tiendaRepository.findById(model.getTiendaId()).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No se encontro la tienda con el ID especificado.");

        }
        ordenDeCompra.setTienda(tiendaRepository.findById(model.getTiendaId()).get());

        List<ProductoEnOC> productos = model.getProductosEnOC().stream().map(productoModel -> {
            ProductoEnOC producto = new ProductoEnOC();
            producto.setCodigo(productoModel.getCodigo());
            producto.setColor(productoModel.getColor());
            producto.setTalle(productoModel.getTalle());
            producto.setCantidadSolicitada(productoModel.getCantidadSolicitada());
            producto.setOrdenDeCompra(ordenDeCompra);
            return producto;
        }).collect(Collectors.toList());

        ordenDeCompra.setProductosEnOC(productos);

        ordenDeCompraRepository.save(ordenDeCompra);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, Object> mensajeMap = new HashMap<>();

            mensajeMap.put("tiendaCodigo", ordenDeCompra.getTienda().getCodigo());
            mensajeMap.put("ordenId", ordenDeCompra.getId());
            mensajeMap.put("items", productos);
            mensajeMap.put("fechaSolicitud", ordenDeCompra.getFechaDeSolicitud().toString());

            String mensajeJson = objectMapper.writeValueAsString(mensajeMap);
            kafkaConsumerListener.sendMessage("orden-de-compra", mensajeJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Orden de compra creada exitosamente");
    }

    public ResponseEntity<String> receiveOrden(int idOrden) {
        Optional<OrdenDeCompra> ordenDeCompraOptional = ordenDeCompraRepository.findById(idOrden);
        if (ordenDeCompraOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado una orden de compra con ese id");
        }
        OrdenDeCompra ordenDeCompra = ordenDeCompraOptional.get();
        ordenDeCompra.setEstado("RECIBIDA");
        ordenDeCompra.setFechaDeRecepcion(LocalDate.now());

        for (ProductoEnOC productoEnOC : ordenDeCompra.getProductosEnOC()) {

            Optional<ProductoEnTienda> productoEnTiendaOptional = productoEnTiendaRepository.findByProducto_CodigoAndTalleAndColorAndTienda_Id(
                    productoEnOC.getCodigo(),
                    productoEnOC.getTalle(),
                    productoEnOC.getColor(),
                    ordenDeCompra.getTienda().getId()
            );

            // Siempre la tendria que encontrar igualmente, dado que creas la OC con productos ya agregados
            if (productoEnTiendaOptional.isPresent()) {
                ProductoEnTienda productoEnTienda = productoEnTiendaOptional.get();
                productoEnTienda.setStock(productoEnTienda.getStock() + productoEnOC.getCantidadSolicitada());
                productoEnTiendaRepository.save(productoEnTienda);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
            }
        }

        ordenDeCompraRepository.save(ordenDeCompra);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, Object> mensajeMap = new HashMap<>();

            Map<String, Object> ordenDeDespachoMap = new HashMap<>();


            ordenDeDespachoMap.put("id", ordenDeCompra.getOrdenDeDespacho().getId());
            ordenDeDespachoMap.put("fechaEstimadaDeEnvio", ordenDeCompra.getOrdenDeDespacho().getFechaEstimadaDeEnvio().toString());

            mensajeMap.put("ordenDeDespacho", ordenDeDespachoMap);
            mensajeMap.put("fechaRecepcion", ordenDeCompra.getFechaDeRecepcion().toString());

            String mensajeJson = objectMapper.writeValueAsString(mensajeMap);
            kafkaConsumerListener.sendMessage("recepcion", mensajeJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("Orden de compra recibida correctamente");
    }

    public List<OrdenDeCompraModel> obtenerTodasLasOrdenes() {
        List<OrdenDeCompra> ordenes = ordenDeCompraRepository.findAll();
        return ordenes.stream()
                .map(this::convertirAOrdenDeCompraModel)
                .collect(Collectors.toList());
    }

    public List<OrdenDeCompraModel> obtenerTodasLasOrdenesAceptadasYConOrdenDeDespacho(int idTienda) {
        List<OrdenDeCompra> ordenes = ordenDeCompraRepository.findByTienda_IdAndEstadoAndOrdenDeDespachoIsNotNull(idTienda,"ACEPTADA");
        return ordenes.stream()
                .map(this::convertirAOrdenDeCompraModel)
                .collect(Collectors.toList());
    }

    private OrdenDeCompraModel convertirAOrdenDeCompraModel(OrdenDeCompra orden) {
        OrdenDeCompraModel model = new OrdenDeCompraModel();
        model.setId(orden.getId());
        model.setEstado(orden.getEstado());
        model.setObservaciones(orden.getObservaciones());
        model.setProductosEnOC(orden.getProductosEnOC().stream()
                .map(this::convertirAProductoEnOCModel)
                .collect(Collectors.toList()));
        model.setTiendaId(orden.getTienda().getId());
        if (orden.getOrdenDeDespacho() != null){
            model.setOrdenDeDespachoId(orden.getOrdenDeDespacho().getId());
        }
        model.setFechaDeSolicitud(orden.getFechaDeSolicitud());
        model.setFechaDeRecepcion(orden.getFechaDeRecepcion());
        model.setPausada(orden.getPausada());
        return model;
    }

    private ProductoEnOCModel convertirAProductoEnOCModel(ProductoEnOC producto) {
        ProductoEnOCModel model = new ProductoEnOCModel();
        model.setId(producto.getId());
        model.setCodigo(producto.getCodigo());
        model.setColor(producto.getColor());
        model.setTalle(producto.getTalle());
        model.setCantidadSolicitada(producto.getCantidadSolicitada());
        return model;
    }

}

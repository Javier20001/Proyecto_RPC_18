package com.kafka.consumer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.entities.OrdenDeCompra;
import com.kafka.consumer.entities.ProductoEnOC;
import com.kafka.consumer.listener.KafkaConsumerListener;
import com.kafka.consumer.models.OrdenDeCompraModel;
import com.kafka.consumer.repositories.IOrdenDeCompraRepository;
import com.kafka.consumer.repositories.ITiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("OrdenDeCompraService")
public class OrdenDeCompraService {

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Autowired
    private KafkaConsumerListener kafkaConsumerListener;

    public ResponseEntity<String> saveOrUpdate(OrdenDeCompraModel model) {

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

}
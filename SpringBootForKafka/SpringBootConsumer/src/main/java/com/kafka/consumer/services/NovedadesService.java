package com.kafka.consumer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.entities.Producto;
import com.kafka.consumer.entities.ProductoEnNovedades;
import com.kafka.consumer.entities.ProductoEnTienda;
import com.kafka.consumer.repositories.IProductoEnNovedadesRepository;
import com.kafka.consumer.repositories.IProductoEnTiendaRepository;
import com.kafka.consumer.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class NovedadesService {

    @Autowired
    private IProductoEnNovedadesRepository productoEnNovedadesRepository;

    @Autowired
    private IProductoEnTiendaRepository productoEnTiendaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @KafkaListener(topics = "novedades", groupId = "my-group-id")
    public void listen(String mensajeJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Deserializar el JSON a un Map
            Map<String, Object> mensajeMap = objectMapper.readValue(mensajeJson, new TypeReference<Map<String, Object>>() {});

            // Acceder a los atributos
            String codigoDelProducto = (String) mensajeMap.get("codigoDelProducto");
            String talle = (String) mensajeMap.get("talle");
            String color = (String) mensajeMap.get("color");
            String fotoURL = (String) mensajeMap.get("fotoURL");

            if (productoEnNovedadesRepository.findByCodigoAndTalleAndColor(codigoDelProducto, talle, color).isPresent()){
                throw new RuntimeException("Producto Ya esta en la lista de producto en novedades.");
            }

            ProductoEnNovedades productoEnNovedades = new ProductoEnNovedades();
            productoEnNovedades.setAceptado(false);
            productoEnNovedades.setFoto(fotoURL);
            productoEnNovedades.setTalle(talle);
            productoEnNovedades.setCodigo(codigoDelProducto);
            productoEnNovedades.setColor(color);
            productoEnNovedadesRepository.save(productoEnNovedades);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<String> darDeAltaProducto(int id) {

        Optional<ProductoEnNovedades> productoEnNovedadesOptional = productoEnNovedadesRepository.findById(id);
        if (productoEnNovedadesOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado un producto en novedades con ese id");
        }
        ProductoEnNovedades productoEnNovedades = productoEnNovedadesOptional.get();

        if (productoEnNovedades.isAceptado()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este producto ya esta aceptado.");
        }

        Optional<Producto> existingProducto = productoRepository.findByCodigo(productoEnNovedades.getCodigo());

        Producto productoEntity;
        if (existingProducto.isPresent()) {
            productoEntity = existingProducto.get();
        } else {
            //el nombre se pone como "Nombre a modificar" porque no especifica en ningun momento el atributo nombre por el topico
            productoEntity = new Producto("Nombre a modificar", productoEnNovedades.getCodigo(), productoEnNovedades.getFoto());
            productoEntity = productoRepository.save(productoEntity);
        }

        if (productoEnTiendaRepository.findByProducto_CodigoAndTalleAndColorAndTiendaIsNull(productoEnNovedades.getCodigo(), productoEnNovedades.getTalle(), productoEnNovedades.getColor()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya hay un producto creado con esos datos (codigo, talle y color).");
        }

        ProductoEnTienda productoEnTiendaEntity = new ProductoEnTienda(
                null,
                productoEntity,
                0,
                productoEnNovedades.getTalle(),
                productoEnNovedades.getColor()
        );
        productoEnTiendaEntity = productoEnTiendaRepository.save(productoEnTiendaEntity);

        //esto haria que no este mas en la parte
        productoEnNovedades.setAceptado(true);
        productoEnNovedadesRepository.save(productoEnNovedades);

        return ResponseEntity.ok("Producto Dado de alta correctamente.");

    }

}

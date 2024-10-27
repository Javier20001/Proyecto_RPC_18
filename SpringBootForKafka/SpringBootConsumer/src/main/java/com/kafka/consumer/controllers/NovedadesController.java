package com.kafka.consumer.controllers;

import com.kafka.consumer.entities.ProductoEnNovedades;
import com.kafka.consumer.repositories.IProductoEnNovedadesRepository;
import com.kafka.consumer.services.NovedadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/novedades")
public class NovedadesController {

    @Autowired
    IProductoEnNovedadesRepository productoEnNovedadesRepository;

    @Autowired
    NovedadesService novedadesService;

    @GetMapping
    public ResponseEntity<List<ProductoEnNovedades>> getAllNoAceptadas(){
        List<ProductoEnNovedades> productoEnNovedades = productoEnNovedadesRepository.findByAceptadoFalse();
        return ResponseEntity.ok(productoEnNovedades);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<String> darDeAltaProducto(@PathVariable(name = "id") int id){
        return novedadesService.darDeAltaProducto(id);
    }

}

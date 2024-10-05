package com.kafka.provider.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.provider.dtos.ProductProviderDTO;
import com.kafka.provider.service.ProductProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/proveedor")
public class ProductProviderController {
    @Autowired
    private ProductProviderService productProviderService;

    @PostMapping
    public ResponseEntity<String> addProducto(@RequestBody ProductProviderDTO productProviderDTO) throws JsonProcessingException {
        return  productProviderService.addProductProvider(productProviderDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductProviderDTO>> getAll() {
        List<ProductProviderDTO> productosDTO = productProviderService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productosDTO);
    }

    //sirve para actualizar el stock del producto y su foto, en caso de querer actualizar demas campos descomentar codigo en productProviderService.actualizarProducto
    @PutMapping("/{id}")
    public ResponseEntity<ProductProviderDTO> actualizarProducto(@PathVariable int id, @RequestBody ProductProviderDTO productProviderDTO) throws JsonProcessingException {
        return productProviderService.actualizarProducto(id, productProviderDTO);
    }

}

package com.soap.SoapClient.controllers;

import com.example.consumingwebservice.wsdl.*;
import com.soap.SoapClient.services.CatalogoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogos")
public class CatalogoController {
    private final CatalogoClient catalogoClient;

    @Autowired
    public CatalogoController(CatalogoClient catalogoClient) {
        this.catalogoClient = catalogoClient;
    }

    @PostMapping("/add")
    public AddCatalogoResponse addCatalogo(@RequestBody CatalogoDto catalogoDto) {
        // Validación del ID
        if (catalogoDto.getId() == null) {
            throw new IllegalArgumentException("El ID del catálogo no puede ser nulo");
        }

        return catalogoClient.addCatalogo(catalogoDto);
    }

    @PutMapping("/update/{id}")
    public UpdateCatalogoResponse updateCatalogo(@PathVariable int id, @RequestBody CatalogoDto catalogoDto) {
        return catalogoClient.updateCatalogo(id, catalogoDto);
    }

    @DeleteMapping("/delete/{id}")
    public DeleteCatalogoResponse deleteCatalogo(@PathVariable int id) {
        return catalogoClient.deleteCatalogo(id);
    }

    @PostMapping("/{catalogoId}/producto/add")
    public AddProductoToCatalogoResponse addProductoToCatalogo(@PathVariable int catalogoId, @RequestBody ProductoDto productoDto) {
        return catalogoClient.addProductoToCatalogo(catalogoId, productoDto);
    }

    @DeleteMapping("/{catalogoId}/producto/delete/{productoId}")
    public DeleteProductoFromCatalogoResponse deleteProductoFromCatalogo(@PathVariable int catalogoId, @PathVariable int productoId) {
        return catalogoClient.deleteProductoFromCatalogo(catalogoId, productoId);
    }


}



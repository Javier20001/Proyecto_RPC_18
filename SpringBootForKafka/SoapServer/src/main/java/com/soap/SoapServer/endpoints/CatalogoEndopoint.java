package com.soap.SoapServer.endpoints;

import com.example.catalogo.*;
import com.soap.SoapServer.services.CatalogoService;
import com.soap.SoapServer.entities.Catalogo;
import com.soap.SoapServer.entities.Producto;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.stream.Collectors;

@Endpoint
public class CatalogoEndopoint {

    private static final String NAMESPACE_URI = "http://www.example.com/catalogo";
    private final CatalogoService catalogoService;

    public CatalogoEndopoint(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    // Endpoint para agregar un catálogo
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCatalogoRequest")
    @ResponsePayload
    public AddCatalogoResponse addCatalogo(@RequestPayload AddCatalogoRequest request) {
        Catalogo catalogo = catalogoService.addCatalogo(convertToEntity(request.getCatalogo()));
        AddCatalogoResponse response = new AddCatalogoResponse();
        response.setCatalogo(convertToDto(catalogo));
        return response;
    }

    // Endpoint para actualizar un catálogo
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCatalogoRequest")
    @ResponsePayload
    public UpdateCatalogoResponse updateCatalogo(@RequestPayload UpdateCatalogoRequest request) {
        Catalogo catalogo = catalogoService.updateCatalogo(request.getCatalogoId(), convertToEntity(request.getCatalogo()));
        UpdateCatalogoResponse response = new UpdateCatalogoResponse();
        response.setCatalogo(convertToDto(catalogo));
        return response;
    }

    // Endpoint para eliminar un catálogo
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCatalogoRequest")
    @ResponsePayload
    public DeleteCatalogoResponse deleteCatalogo(@RequestPayload DeleteCatalogoRequest request) {
        catalogoService.deleteCatalogo(request.getCatalogoId());
        return new DeleteCatalogoResponse();
    }

    // Endpoint para agregar un producto a un catálogo
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addProductoToCatalogoRequest")
    @ResponsePayload
    public AddProductoToCatalogoResponse addProductoToCatalogo(@RequestPayload AddProductoToCatalogoRequest request) {
        Catalogo catalogo = catalogoService.addProductoToCatalogo(request.getCatalogoId(), convertToEntity(request.getProducto()));
        AddProductoToCatalogoResponse response = new AddProductoToCatalogoResponse();
        response.setCatalogo(convertToDto(catalogo));
        return response;
    }

    // Endpoint para eliminar un producto de un catálogo
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductoFromCatalogoRequest")
    @ResponsePayload
    public DeleteProductoFromCatalogoResponse deleteProductoFromCatalogo(@RequestPayload DeleteProductoFromCatalogoRequest request) {
        catalogoService.deleteProductoFromCatalogo(request.getCatalogoId(), request.getProductoId());
        return new DeleteProductoFromCatalogoResponse();
    }

    // Métodos auxiliares para convertir entre las entidades y los DTOs de SOAP
    private Catalogo convertToEntity(CatalogoDto catalogoDto) {
        Catalogo catalogo = new Catalogo();
        // Manejar caso donde el ID podría ser null
        if ((catalogoDto.getId() == null)) {
            catalogo.setId(catalogoDto.getId());
        } else {
            // Manejar el caso según tu lógica de negocio, por ejemplo:
            throw new IllegalArgumentException("El ID del catálogo no puede ser nulo");
        }
        catalogo.setNombre(catalogoDto.getNombre());
        // Convierte la lista de ProductoDto a una lista de Producto
        if (catalogoDto.getProductos() != null) {
            catalogo.setProductos(
                    catalogoDto.getProductos().stream()
                            .map(this::convertToEntity)
                            .collect(Collectors.toList())
            );
        }
        return catalogo;
    }

    private Producto convertToEntity(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setId(productoDto.getId());
        producto.setNombre(productoDto.getNombre());
        producto.setFotoUrl(productoDto.getFotoUrl());
        return producto;
    }

    private CatalogoDto convertToDto(Catalogo catalogo) {
        CatalogoDto catalogoDto = new CatalogoDto();
        catalogoDto.setId(catalogo.getId());
        catalogoDto.setNombre(catalogo.getNombre());
        return catalogoDto;
    }

    private ProductoDto convertToDto(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setNombre(producto.getNombre());
        productoDto.setFotoUrl(producto.getFotoUrl());
        return productoDto;
    }
}



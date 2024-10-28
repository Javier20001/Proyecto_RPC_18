package com.soap.SoapServer.endpoints;

import com.example.catalogo.*;
import com.example.consumingwebservice.wsdl.DeleteCatalogoResponse;
import com.soap.SoapServer.services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CatalogoEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/catalogo"; // Cambia esto según tu esquema

    @Autowired
    private CatalogoService catalogoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateCatalogoRequest")
    @ResponsePayload
    public CreateCatalogoResponse createCatalogo(@RequestPayload CreateCatalogoRequest request) {
        return catalogoService.createCatalogo(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCatalogoByIdRequest")
    @ResponsePayload
    public GetCatalogoByIdResponse getCatalogoById(@RequestPayload GetCatalogoByIdRequest request) {
        return catalogoService.getCatalogoById(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateCatalogoRequest")
    @ResponsePayload
    public UpdateCatalogoResponse updateCatalogo(@RequestPayload UpdateCatalogoRequest request) {
        return catalogoService.updateCatalogo(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteCatalogoRequest")
    @ResponsePayload
    public DeleteCatalogoResponse deleteCatalogo(@RequestPayload DeleteCatalogoRequest request) {
        return catalogoService.deleteCatalogo(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetProductosByCatalogoIdRequest")
    @ResponsePayload
    public GetProductosByCatalogoIdResponse getProductosByCatalogoId(@RequestPayload GetProductosByCatalogoIdRequest request) {
        return catalogoService.getProductosByCatalogoId(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddProductoToCatalogoRequest")
    @ResponsePayload
    public AddProductoToCatalogoResponse addProductoToCatalogo(@RequestPayload AddProductoToCatalogoRequest request) {
        return catalogoService.addProductoToCatalogo(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ExportCatalogoToPdfRequest")
    @ResponsePayload
    public ExportCatalogoToPdfResponse exportCatalogoToPdf(@RequestPayload ExportCatalogoToPdfRequest request) {
        return catalogoService.exportCatalogoToPdf(request);
    }
}

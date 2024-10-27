package com.soap.SoapServer.endpoints;


import com.example.catalogo.*;
import com.soap.SoapServer.services.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CatalogoEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/catalogo";

    private final CatalogoService catalogoService;

    @Autowired
    public CatalogoEndpoint(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCatalogoRequest")
    @ResponsePayload
    public CreateCatalogoResponse createCatalogo(@RequestPayload CreateCatalogoRequest request) {
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setNombre(request.getCatalogoDTO().getNombre());
        catalogoDTO.setDescripcion(request.getCatalogoDTO().getDescripcion());
        CatalogoDTO createdCatalogo = catalogoService.createCatalogo(catalogoDTO);

        CreateCatalogoResponse response = new CreateCatalogoResponse();
        response.setCatalogoDTO(createdCatalogo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCatalogoByIdRequest")
    @ResponsePayload
    public GetCatalogoByIdResponse getCatalogoById(@RequestPayload GetCatalogoByIdRequest request) {
        CatalogoDTO catalogoDTO = catalogoService.getCatalogoById(request.getId());
        GetCatalogoByIdResponse response = new GetCatalogoByIdResponse();
        response.setCatalogoDTO(catalogoDTO);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCatalogoRequest")
    @ResponsePayload
    public UpdateCatalogoResponse updateCatalogo(@RequestPayload UpdateCatalogoRequest request) {
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setNombre(request.getCatalogoDTO().getNombre());
        catalogoDTO.setDescripcion(request.getCatalogoDTO().getDescripcion());
        CatalogoDTO updatedCatalogo = catalogoService.updateCatalogo(request.getId(), catalogoDTO);

        UpdateCatalogoResponse response = new UpdateCatalogoResponse();
        response.setCatalogoDTO(updatedCatalogo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCatalogoRequest")
    @ResponsePayload
    public DeleteCatalogoResponse deleteCatalogo(@RequestPayload DeleteCatalogoRequest request) {
        catalogoService.deleteCatalogo(request.getId());
        DeleteCatalogoResponse response = new DeleteCatalogoResponse();
        return response;
    }

}
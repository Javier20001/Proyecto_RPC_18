package com.soap.SoapServer.endpoints;

import com.example.ordenes.*;
import com.soap.SoapServer.services.OrdenDeCompraSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class OrdenDeCompraEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/ordenes";

    @Autowired
    private OrdenDeCompraSoapService ordenDeCompraSoapService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOrdenesDeCompraRequest")
    @ResponsePayload
    public GetAllOrdenesDeCompraResponse getAllOrdenesDeCompra(@RequestPayload GetAllOrdenesDeCompraRequest request){
        List<OrdenDeCompraDTO> ordenes = ordenDeCompraSoapService.findAll();
        GetAllOrdenesDeCompraResponse response = new GetAllOrdenesDeCompraResponse();
        response.getOrdenesDeCompra().addAll(ordenes);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrdenesDeCompraFiltradasRequest")
    @ResponsePayload
    public GetOrdenesDeCompraFiltradasResponse getAllOrdenesDeCompraFiltradas(@RequestPayload GetOrdenesDeCompraFiltradasRequest request){
        List<GetOrdenesDeCompraFiltradasResponse.OrdenesAgrupadas> ordenes = ordenDeCompraSoapService.filtrarOrdenes(request);
        GetOrdenesDeCompraFiltradasResponse response = new GetOrdenesDeCompraFiltradasResponse();
        response.getOrdenesAgrupadas().addAll(ordenes);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addFiltroRequest")
    @ResponsePayload
    public AddFiltroResponse addFiltro(@RequestPayload AddFiltroRequest request){
        return ordenDeCompraSoapService.addFiltro(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFiltrosByUsuarioRequest")
    @ResponsePayload
    public GetFiltrosByUsuarioResponse getFiltrosByUsuario(@RequestPayload GetFiltrosByUsuarioRequest request){
        return ordenDeCompraSoapService.getFiltrosByUsuarioId(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOrdenesByFiltroIdRequest")
    @ResponsePayload
    public GetAllOrdenesByFiltroIdResponse getAllOrdenesByFiltroId(@RequestPayload GetAllOrdenesByFiltroIdRequest request) {
        return ordenDeCompraSoapService.getAllOrdenesByFiltroId(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateFiltroByIdRequest")
    @ResponsePayload
    public UpdateFiltroByIdResponse updateFiltro(@RequestPayload UpdateFiltroByIdRequest request) {
        return ordenDeCompraSoapService.updateFiltroById(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteFiltroByIdRequest")
    @ResponsePayload
    public DeleteFiltroByIdResponse deleteFiltro(@RequestPayload DeleteFiltroByIdRequest request) {
        return ordenDeCompraSoapService.deleteFiltroById(request);
    }

}

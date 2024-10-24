package com.soap.SoapClient.services;

import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class OrdenesClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(OrdenesClient.class);

    public GetAllOrdenesDeCompraResponse getAllOrdenes() {

        GetAllOrdenesDeCompraRequest request = new GetAllOrdenesDeCompraRequest();

        log.info("Requesting all ordenes");

        GetAllOrdenesDeCompraResponse response = (GetAllOrdenesDeCompraResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/GetAllOrdenesDeCompraRequest"));

        return response;
    }

    public GetOrdenesDeCompraFiltradasResponse filtrarOrdenes(GetOrdenesDeCompraFiltradasRequest request) {

        log.info("Requesting filtered ordenes with filters: {}", request);

        GetOrdenesDeCompraFiltradasResponse response = (GetOrdenesDeCompraFiltradasResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/GetOrdenesDeCompraFiltradasRequest"));

        return response;
    }

    public AddFiltroResponse addFiltro(AddFiltroRequest request) {
        log.info("Adding filtro with request: {}", request);

        AddFiltroResponse response = (AddFiltroResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/AddFiltroRequest"));

        return response;
    }

    public GetFiltrosByUsuarioResponse getFiltrosByUsuario(int usuarioId) {
        GetFiltrosByUsuarioRequest request = new GetFiltrosByUsuarioRequest();
        request.setUsuarioId(usuarioId);

        log.info("Requesting filtros for usuarioId: {}", usuarioId);

        GetFiltrosByUsuarioResponse response = (GetFiltrosByUsuarioResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/GetFiltrosByUsuarioRequest"));

        return response;
    }

    public GetAllOrdenesByFiltroIdResponse getAllOrdenesByFiltroId(int filtroId) {
        GetAllOrdenesByFiltroIdRequest request = new GetAllOrdenesByFiltroIdRequest();
        request.setFiltroId(filtroId);

        log.info("Requesting ordenes for filtroId: {}", filtroId);

        GetAllOrdenesByFiltroIdResponse response = (GetAllOrdenesByFiltroIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/GetAllOrdenesByFiltroIdRequest"));

        return response;
    }

    public UpdateFiltroByIdResponse updateFiltroById(UpdateFiltroByIdRequest request) {
        log.info("Updating filtro with request: {}", request);

        UpdateFiltroByIdResponse response = (UpdateFiltroByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/UpdateFiltroByIdRequest"));

        return response;
    }

    public DeleteFiltroByIdResponse deleteFiltroById(int filtroId) {
        DeleteFiltroByIdRequest request = new DeleteFiltroByIdRequest();
        request.setFiltroId(filtroId);

        log.info("Deleting filtro with filtroId: {}", filtroId);

        DeleteFiltroByIdResponse response = (DeleteFiltroByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/ordenes", request,
                        new SoapActionCallback(
                                "http://www.example.com/ordenes/DeleteFiltroByIdRequest"));

        return response;
    }




}

package com.soap.SoapClient.services;

import com.example.consumingwebservice.wsdl.GetAllOrdenesDeCompraRequest;
import com.example.consumingwebservice.wsdl.GetAllOrdenesDeCompraResponse;
import com.example.consumingwebservice.wsdl.GetOrdenesDeCompraFiltradasRequest;
import com.example.consumingwebservice.wsdl.GetOrdenesDeCompraFiltradasResponse;
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

}

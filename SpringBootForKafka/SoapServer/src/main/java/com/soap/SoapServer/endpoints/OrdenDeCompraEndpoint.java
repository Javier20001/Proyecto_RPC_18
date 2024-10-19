package com.soap.SoapServer.endpoints;

import com.soap.SoapServer.dtos.OrdenDeCompraDTO;
import com.soap.SoapServer.soapservices.OrdenDeCompraSoapService;
import com.soap.SoapServer.soapservices.requests.GetAllOrdenesDeCompraRequest;
import com.soap.SoapServer.soapservices.requests.GetOrdenDeCompraByIdRequest;
import com.soap.SoapServer.soapservices.responses.GetAllOrdenesDeCompraResponse;
import com.soap.SoapServer.soapservices.responses.GetOrdenDeCompraByIdResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.namespace.QName;
import java.util.List;

@Endpoint
public class OrdenDeCompraEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/ordenes";

    @Autowired
    private OrdenDeCompraSoapService ordenDeCompraSoapService; // Tu servicio que maneja la lógica de negocio

    // Obtener orden por ID
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOrdenDeCompraByIdRequest")
    @ResponsePayload
    public JAXBElement<GetOrdenDeCompraByIdResponse> getOrdenDeCompraById(@RequestPayload JAXBElement<GetOrdenDeCompraByIdRequest> request) throws DatatypeConfigurationException {
        OrdenDeCompraDTO orden = ordenDeCompraSoapService.findById(request.getValue().getId());
        GetOrdenDeCompraByIdResponse response = new GetOrdenDeCompraByIdResponse();
        response.setOrdenDeCompra(orden);
        return createJaxbElement(response, GetOrdenDeCompraByIdResponse.class);
    }

    // Obtener todas las órdenes
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOrdenesDeCompraRequest")
    @ResponsePayload
    public JAXBElement<GetAllOrdenesDeCompraResponse> getAllOrdenesDeCompra(@RequestPayload JAXBElement<GetAllOrdenesDeCompraRequest> request) {
        List<OrdenDeCompraDTO> ordenes = ordenDeCompraSoapService.findAll();
        GetAllOrdenesDeCompraResponse response = new GetAllOrdenesDeCompraResponse();
        response.setOrdenesDeCompra(ordenes);
        return createJaxbElement(response, GetAllOrdenesDeCompraResponse.class);
    }

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }

}

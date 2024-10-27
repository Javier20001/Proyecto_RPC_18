package com.soap.SoapClient.services;



import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CatalogoClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CatalogoClient.class);


    public CreateCatalogoResponse createCatalogo(CreateCatalogoRequest request) {
        log.info("Creating catalogo: {}", request);

        return (CreateCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/catalogo", request,
                        new SoapActionCallback(
                                "http://www.example.com/catalogo/CreateCatalogoRequest"));
    }

    public DeleteCatalogoResponse deleteCatalogo(Long catalogoId) {
        DeleteCatalogoRequest request = new DeleteCatalogoRequest();
        request.setId(Math.toIntExact(catalogoId));
        log.info("Deleting catalogo with ID: {}", catalogoId);

        return (DeleteCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/catalogo", request,
                        new SoapActionCallback(
                                "http://www.example.com/catalogo/DeleteCatalogoRequest"));
    }

    public byte[] exportarCatalogoPDF(Long catalogoId) {
        ExportarCatalogoPDFRequest request = new ExportarCatalogoPDFRequest();
        request.setCatalogoId(catalogoId);

        // Llamada al servicio SOAP
        ExportarCatalogoPDFResponse response = (ExportarCatalogoPDFResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/catalogo", request,
                        new SoapActionCallback("http://www.example.com/catalogo/ExportarCatalogoPDFRequest"));

        // Retorna el PDF en formato de arreglo de bytes
        return response.getPdfBytes();
    }



}


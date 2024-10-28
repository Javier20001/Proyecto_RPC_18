package com.soap.SoapClient.services;

import com.example.consumingwebservice.wsdl.ProcessCsvFileRequest;
import com.example.consumingwebservice.wsdl.ProcessCsvFileResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.io.StringWriter;

@Service
public class UserClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public ProcessCsvFileResponse processCsvFile(ProcessCsvFileRequest request) {
        try {
            // Crear el contexto JAXB para la clase ProcessCsvFileRequest
            JAXBContext jaxbContext = JAXBContext.newInstance(ProcessCsvFileRequest.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshalizar la solicitud a XML
            StringWriter writer = new StringWriter();
            marshaller.marshal(request, writer);
            System.out.println("XML generado en UserClient:");
            System.out.println(writer.toString());

            // Enviar la solicitud al servicio SOAP
            ProcessCsvFileResponse response = (ProcessCsvFileResponse) webServiceTemplate.marshalSendAndReceive(
                    "http://url-del-servicio-soap", // Reemplaza con la URL de tu servicio
                    request
            );

            return response; // Devuelve la respuesta

        } catch (JAXBException e) {
            System.err.println("Error en la configuración JAXB dentro de UserClient: " + e.getMessage());
            e.printStackTrace();
            return null; // Devuelve null o maneja el error según sea necesario
        }
    }

    // Método para marshalizar la respuesta a XML
    private String marshallResponse(ProcessCsvFileResponse response) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ProcessCsvFileResponse.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(response, writer);
        return writer.toString();
    }
}













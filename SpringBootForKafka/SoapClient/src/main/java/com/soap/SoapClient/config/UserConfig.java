package com.soap.SoapClient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;


@Configuration
public class UserConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // Configura el paquete que contiene las clases generadas por JAXB (las clases del XSD)
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller); // Necesitarás configurar esto para que use JAXB
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri("http://localhost:8088/ws");
        return webServiceTemplate;
    }
}

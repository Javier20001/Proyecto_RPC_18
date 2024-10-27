package com.soap.SoapClient.config;

import com.soap.SoapClient.services.CatalogoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CatalogoConfiguration {

    @Bean
    public Jaxb2Marshaller catalogoMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // El paquete debe coincidir con el especificado en el <generatePackage> de pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public CatalogoClient catalogoClient(Jaxb2Marshaller catalogoMarshaller) {
        CatalogoClient catalogoClient = new CatalogoClient();
        catalogoClient.setDefaultUri("http://localhost:8088/ws");
        catalogoClient.setMarshaller(catalogoMarshaller);
        catalogoClient.setUnmarshaller(catalogoMarshaller);
        return catalogoClient;
    }
}


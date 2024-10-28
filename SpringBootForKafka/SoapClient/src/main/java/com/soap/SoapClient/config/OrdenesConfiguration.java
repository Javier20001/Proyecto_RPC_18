package com.soap.SoapClient.config;

import com.soap.SoapClient.services.OrdenesClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrdenesConfiguration {

    @Bean
    public Jaxb2Marshaller ordenesMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public OrdenesClient ordenesClient(Jaxb2Marshaller ordenesMarshaller) {
        OrdenesClient ordenes = new OrdenesClient();
        ordenes.setDefaultUri("http://localhost:8088/ws");
        ordenes.setMarshaller(ordenesMarshaller);
        ordenes.setUnmarshaller(ordenesMarshaller);
        return ordenes;
    }

}

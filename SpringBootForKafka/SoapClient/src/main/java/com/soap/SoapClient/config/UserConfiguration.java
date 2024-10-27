package com.soap.SoapClient.config;

import com.soap.SoapClient.services.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UserConfiguration {

    @Bean
    public Jaxb2Marshaller userMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // El paquete debe coincidir con el especificado en el <generatePackage> de pom.xml
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller userMarshaller) {
        UserClient userClient = new UserClient();
        userClient.setDefaultUri("http://localhost:8088/ws");
        userClient.setMarshaller(userMarshaller);
        userClient.setUnmarshaller(userMarshaller);
        return userClient;
    }
}


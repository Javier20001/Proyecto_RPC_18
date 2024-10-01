package com.kafka.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringBooProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBooProviderApplication.class, args);
	}

	// Producer: Envía un mensaje al topic "Comunicacion-Topic"
	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("Comunicacion-Topic", "hola mundo");
		};
	}

	// Consumer: Escucha mensajes del topic "Respuesta-Topic"
	@KafkaListener(topics = "Respuesta-Topic", groupId = "provider-group")
	public void listen(String message) {
		System.out.println("Mensaje recibido del consumer: " + message);
		// Procesar el mensaje recibido aquí
	}
}

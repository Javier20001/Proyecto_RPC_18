package com.kafka.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaConsumerListener {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    // Inyectar KafkaTemplate para enviar mensajes de vuelta
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = {"Comunicacion-Topic"}, groupId = "my-group-id")
    public void listener(String message) {
        LOGGER.info("Mensaje recibido: " + message);

        // Aquí puedes procesar el mensaje y luego enviar una respuesta
        String respuesta = "response: Mensaje procesado por el consumer";
        sendResponse(respuesta);
    }

    // Método para enviar respuesta
    public void sendResponse(String responseMessage) {
        kafkaTemplate.send("Respuesta-Topic", responseMessage);  // Usar el mismo topic o cambiar a uno diferente
        LOGGER.info("Mensaje de respuesta enviado: " + responseMessage);
    }

    // Metodo para enviar mensajes desde el servicio
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        LOGGER.info("Mensaje enviado al topic '{}': {}", topic, message);
    }

}

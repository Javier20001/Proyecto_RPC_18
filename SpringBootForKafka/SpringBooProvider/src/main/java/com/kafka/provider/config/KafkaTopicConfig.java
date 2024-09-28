package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String,String> configurations = new HashMap<>();

        //(delete) se borra los mensajes luego de cierto tiempo
        //(conpact) borra todos los mensajes a excepcion del ultimo
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        //cuanto tiempo se van a retener los mensajes dentro del topic, se especifica en milisegundo
        //86400000 = 1 día
        //lo que suceda luego pasado ese tiempo es la eleccion de la opción de arriba
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //por defecto esta en -1
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //tamaño maximo de bytes por segmento 1073741824 = 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); //tamaño de los mensajes, por defecto 1MB
        return TopicBuilder.name("Comunicacion-Topic")
                .partitions(2)//indica la cantida dde particiones que tendra el topic
                .replicas(2)//estoindica cuantos backups tendra el topic para los mensajes
                .configs(configurations)
                .build();
    }

}

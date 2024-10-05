package com.kafka.provider.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.provider.entities.OrdenDeCompra;
import com.kafka.provider.repository.IOrdenDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Optional;

@Service
public class RecepcionService {

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @KafkaListener(topics = "recepcion", groupId = "provider-group")
    public void listen(String mensajeJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            Map<String, Object> mensajeMap = objectMapper.readValue(mensajeJson, new TypeReference<Map<String, Object>>() {});
            Map<String, Object> ordenDeDespacho = (Map<String, Object>) mensajeMap.get("ordenDeDespacho");

            int ordenId = (Integer) ordenDeDespacho.get("id");
            String fechaEstimadaDeEnvioStr = (String) ordenDeDespacho.get("fechaEstimadaDeEnvio");
            String fechaRecepcionStr = (String) mensajeMap.get("fechaRecepcion");

            LocalDate fechaEstimadaDeEnvio = parseFecha(fechaEstimadaDeEnvioStr);
            LocalDate fechaRecepcion = parseFecha(fechaRecepcionStr);

            Optional<OrdenDeCompra> ordenDeCompraOptional = ordenDeCompraRepository.findByOrdenDeDespacho_Id(ordenId);
            if (ordenDeCompraOptional.isEmpty()){
                throw new IllegalStateException("No se encuentra orden de compra con esa orden de despacho");
            }
            OrdenDeCompra ordenDeCompra = ordenDeCompraOptional.get();
            ordenDeCompra.setFechaDeRecepcion(fechaRecepcion);
            ordenDeCompraRepository.save(ordenDeCompra);

            System.out.println("Orden ID: " + ordenId);
            System.out.println("Fecha Estimada de Envío: " + fechaEstimadaDeEnvio);
            System.out.println("Fecha de Recepción: " + fechaRecepcion);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al procesar el mensaje", e);
        }
    }

    private LocalDate parseFecha(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Error al parsear la fecha: " + fechaStr, e);
        }
    }

}

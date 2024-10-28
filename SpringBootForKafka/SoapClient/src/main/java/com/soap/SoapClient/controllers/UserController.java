package com.soap.SoapClient.controllers;

import com.example.consumingwebservice.wsdl.ProcessCsvFileRequest;
import com.example.consumingwebservice.wsdl.ProcessCsvFileResponse;
import com.soap.SoapClient.services.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/load")
    public ResponseEntity<String> loadCsvFile() {
        try {
            // Cargar el archivo user.csv desde resources
            Resource resource = resourceLoader.getResource("classpath:users.csv");
            Path filePath = resource.getFile().toPath();
            byte[] fileContent = Files.readAllBytes(filePath); // Leer el contenido del archivo

            // Crear la solicitud
            ProcessCsvFileRequest request = new ProcessCsvFileRequest();
            request.setFileContent(fileContent); // Establecer contenido del archivo en la solicitud

            // Procesar la solicitud
            ProcessCsvFileResponse response = userClient.processCsvFile(request);
            return ResponseEntity.ok(response.getResult()); // Retornar resultado

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar el archivo: " + e.getMessage());
        }
    }

}










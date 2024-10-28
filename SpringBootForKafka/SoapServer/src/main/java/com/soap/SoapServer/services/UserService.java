package com.soap.SoapServer.services;

import com.soap.SoapServer.entities.Tienda;
import com.soap.SoapServer.entities.User;
import com.soap.SoapServer.repositories.ITiendaRepository;
import com.soap.SoapServer.repositories.IUserRepository;
import com.example.users.ProcessCsvFileRequest;
import com.example.users.ProcessCsvFileResponse;
import jakarta.jws.WebMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ITiendaRepository tiendaRepository;

    private Set<String> existingUsers = new HashSet<>();

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @WebMethod
    public ProcessCsvFileResponse processCsvFile(ProcessCsvFileRequest request) {
        ProcessCsvFileResponse response = new ProcessCsvFileResponse();
        StringBuilder result = new StringBuilder();
        StringBuilder errorReport = new StringBuilder();

        try {
            String csvContent = new String(request.getFileContent(), StandardCharsets.UTF_8);
            System.out.println("Contenido CSV decodificado:\n" + csvContent);

            try (BufferedReader br = new BufferedReader(new StringReader(csvContent))) {
                String line = br.readLine(); // Omitir el encabezado
                int lineNumber = 1;

                while ((line = br.readLine()) != null) {
                    lineNumber++;
                    String[] data = line.split(";");

                    // Validación de campos vacíos
                    if (data.length != 5 || anyFieldEmpty(data)) {
                        errorReport.append("Línea ").append(lineNumber).append(": Error - Campos vacíos o incompletos.\n");
                        continue;
                    }

                    String username = data[0];
                    String password = data[1];
                    String nombre = data[2];
                    String apellido = data[3];
                    String codigoTienda = data[4];

                    String validationError = validateUser(username, codigoTienda);
                    if (validationError != null) {
                        errorReport.append("Línea ").append(lineNumber).append(": ").append(validationError).append("\n");
                        continue;
                    }

                    Optional<Tienda> tienda = tiendaRepository.findByCodigo(codigoTienda);
                    if (tienda.isPresent()) {
                        User newUser = new User(username, passwordEncoder.encode(password), nombre, apellido, true, "user");
                        newUser.setTienda(tienda.get());
                        userRepository.save(newUser); // Guardar usuario en la base de datos
                        result.append("Usuario creado: ").append(username).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            response.setResult("Error al procesar el archivo: " + e.getMessage());
            return response;
        }

        response.setResult(result.append("\nErrores encontrados:\n").append(errorReport.toString()).toString());
        return response;
    }

    // Método para validar usuario según requisitos
    private String validateUser(String username, String codigoTienda) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Error: Usuario duplicado - " + username;
        }

        Optional<Tienda> tiendaOptional = tiendaRepository.findByCodigo(codigoTienda);
        if (tiendaOptional.isEmpty()) {
            return "Error: Código de tienda no existe - " + codigoTienda;
        }

        Tienda tienda = tiendaOptional.get();
        if (!tienda.getHabilitada()) {
            return "Error: La tienda está deshabilitada - " + codigoTienda;
        }

        return null;
    }

    // Método para comprobar si algún campo está vacío
    private boolean anyFieldEmpty(String[] data) {
        for (String field : data) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}


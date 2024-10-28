package com.soap.SoapServer.services;

import com.soap.SoapServer.repositories.IUserRepository;
import com.example.users.ProcessCsvFileRequest;
import com.example.users.ProcessCsvFileResponse;
import jakarta.jws.WebMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final IUserRepository userRepository;

    private Set<String> existingUsers = new HashSet<>();

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @WebMethod
    public ProcessCsvFileResponse processCsvFile(ProcessCsvFileRequest request) {
        ProcessCsvFileResponse response = new ProcessCsvFileResponse();
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new ByteArrayInputStream(Base64.getDecoder().decode(request.getFileContent()))))) {

            String line;
            br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length != 5) {
                    result.append("Error: Línea con formato incorrecto - ").append(line).append("\n");
                    continue;
                }

                String usuario = data[0];
                String contraseña = data[1];
                String nombre = data[2];
                String apellido = data[3];
                String codigoTienda = data[4];

                String validationError = validateUser(usuario, codigoTienda);
                if (validationError != null) {
                    result.append(validationError).append("\n");
                    continue;
                }

                existingUsers.add(usuario);
                result.append("Usuario creado: ").append(usuario).append("\n");
            }
        } catch (IOException e) {
            response.setResult("Error al procesar el archivo: " + e.getMessage());
            return response;
        }

        response.setResult(result.toString());
        return response;
    }

    private String validateUser(String usuario, String codigoTienda) {
        if (existingUsers.contains(usuario)) {
            return "Error: Usuario duplicado - " + usuario;
        }

        if (!isTiendaExist(codigoTienda)) {
            return "Error: Código de tienda no existe - " + codigoTienda;
        }
        if (!isTiendaEnabled(codigoTienda)) {
            return "Error: La tienda está deshabilitada - " + codigoTienda;
        }

        return null;
    }

    private boolean isTiendaExist(String codigoTienda) {
        return "codigo1".equals(codigoTienda) || "codigo2".equals(codigoTienda);
    }

    private boolean isTiendaEnabled(String codigoTienda) {
        return !"codigo3".equals(codigoTienda);
    }
}


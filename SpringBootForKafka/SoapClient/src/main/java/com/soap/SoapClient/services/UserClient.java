package com.soap.SoapClient.services;

import com.example.consumingwebservice.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(UserClient.class);

    // Método para obtener todos los usuarios
    public GetAllUsersResponse getAllUsers(GetAllUsersRequest request) {
        log.info("Requesting all users");

        return (GetAllUsersResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/users",
                        new GetAllUsersRequest(),
                        new SoapActionCallback("http://www.example.com/users/getAllUsersRequest"));
    }

    // Método para obtener un usuario por ID
    public GetUserByIdResponse getUserById(GetUserByIdRequest userId) {
        log.info("Requesting user with ID: {}", userId);

        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setId(Math.toIntExact(userId.getId()));

        return (GetUserByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/users",
                        request,
                        new SoapActionCallback("http://www.example.com/users/getUserByIdRequest"));
    }

    // Método para agregar un usuario
    public AddUserResponse addUser(UserDTO user) {
        log.info("Adding user: {}", user);

        AddUserRequest request = new AddUserRequest();
        request.setUser(user);

        return (AddUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/users",
                        request,
                        new SoapActionCallback("http://www.example.com/users/addUserRequest"));
    }

    // Método para actualizar un usuario
    public UpdateUserResponse updateUser(UserDTO user) {
        log.info("Updating user: {}", user);

        UpdateUserRequest request = new UpdateUserRequest();
        request.setUser(user);

        return (UpdateUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/users",
                        request,
                        new SoapActionCallback("http://www.example.com/users/updateUserRequest"));
    }

    // Método para eliminar un usuario
    public DeleteUserResponse deleteUser(DeleteUserRequest userId) {
        log.info("Deleting user with ID: {}", userId);

        DeleteUserRequest request = new DeleteUserRequest();
        request.setId(Math.toIntExact(userId.getId()));

        return (DeleteUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws/users",
                        request,
                        new SoapActionCallback("http://www.example.com/users/deleteUserRequest"));
    }
}


package com.soap.SoapClient.controllers;

import com.example.consumingwebservice.wsdl.*;
import com.soap.SoapClient.services.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserClient userClient;

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public GetAllUsersResponse getAllUsers() {
        GetAllUsersRequest request = new GetAllUsersRequest();
        return userClient.getAllUsers(request);
    }

    // Endpoint para obtener un usuario por ID
    @GetMapping("/{id}")
    public GetUserByIdResponse getUserById(@PathVariable int id) {
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setId(id);
        return userClient.getUserById(request);
    }

    // Endpoint para agregar un nuevo usuario
    @PostMapping
    public AddUserResponse addUser(@RequestBody UserDTO user) {
        AddUserRequest request = new AddUserRequest();
        request.setUser(user);
        return userClient.addUser(request.getUser());
    }

    // Endpoint para actualizar un usuario
    @PutMapping
    public UpdateUserResponse updateUser(@RequestBody UserDTO user) {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setUser(user);
        return userClient.updateUser(request.getUser());
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public DeleteUserResponse deleteUser(@PathVariable int id) {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setId(id);
        return userClient.deleteUser(request);
    }
}

package com.soap.SoapServer.endpoints;

import com.example.users.*;
import com.soap.SoapServer.entities.User;
import com.soap.SoapServer.services.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/users";

    private final UserService userService;

    public UserEndpoint(UserService userService){
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers() {
        GetAllUsersResponse response = new GetAllUsersResponse();
        List<User> users = userService.findAll();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setNombre(user.getNombre());
            userDTO.setApellido(user.getApellido());
            userDTO.setHabilitado(String.valueOf(user.getHabilitado()));
            userDTO.setRol(user.getRol());
            response.getUsers().add(userDTO);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request) {
        GetUserByIdResponse response = new GetUserByIdResponse();
        User user = userService.findById(request.getId()).orElse(null);

        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setNombre(user.getNombre());
            userDTO.setApellido(user.getApellido());
            userDTO.setHabilitado(String.valueOf(user.getHabilitado()));
            userDTO.setRol(user.getRol());
            response.setUser(userDTO);
        }
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();
        UserDTO user = request.getUser();

        // Suponiendo que user se tiene que mapear a la entidad de dominio User
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setNombre(user.getNombre());
        newUser.setApellido(user.getApellido());
        newUser.setHabilitado(Boolean.valueOf(user.getHabilitado()));
        newUser.setRol(user.getRol());

        userService.save(newUser);
        response.setStatus("User added successfully");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        UserDTO user = request.getUser();

        // Mapeo a la entidad de dominio
        User existingUser = userService.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setNombre(user.getNombre());
            existingUser.setApellido(user.getApellido());
            existingUser.setHabilitado(Boolean.valueOf(user.getHabilitado()));
            existingUser.setRol(user.getRol());

            userService.update(existingUser);
            response.setStatus("User updated successfully");
        } else {
            response.setStatus("User not found");
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        userService.deleteById(request.getId());
        response.setStatus("User deleted successfully");
        return response;
    }


}

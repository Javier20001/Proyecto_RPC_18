package com.soap.SoapServer.endpoints;

import com.example.users.ProcessCsvFileRequest;
import com.example.users.ProcessCsvFileResponse;
import com.soap.SoapServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/users";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processCsvFileRequest")
    @ResponsePayload
    public ProcessCsvFileResponse processCsvFile(@RequestPayload ProcessCsvFileRequest request) {
        return userService.processCsvFile(request);
    }
}


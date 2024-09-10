package com.grpc.grpc_server.services;

import com.grpc.grpc_server.entities.User;
import com.grpc.grpc_server.repositories.IUserRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.grpc.grpc_server.services.LoginServiceProto.LoginResponse;
import com.grpc.grpc_server.services.LoginServiceProto.LoginRequest;

import java.util.Optional;

@GRpcService
public class LoginService extends LoginServiceGrpc.LoginServiceImplBase {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                if (user.getHabilitado()) {
                    LoginResponse response = LoginResponse.newBuilder()
                            .setMessage("Login exitoso")
                            .setRole(user.getRol())
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                } else {
                    LoginResponse response = LoginResponse.newBuilder()
                            .setMessage("Usuario no habilitado")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            } else {
                LoginResponse response = LoginResponse.newBuilder()
                        .setMessage("Contraseña incorrecta")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } else {
            LoginResponse response = LoginResponse.newBuilder()
                    .setMessage("Usuario no encontrado")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

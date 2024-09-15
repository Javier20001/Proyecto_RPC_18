package com.grpc.grpc_server.services;

import com.grpc.grpc_server.entities.Tienda;
import com.grpc.grpc_server.entities.User;
import com.grpc.grpc_server.repositories.ITiendaRepository;
import com.grpc.grpc_server.repositories.IUserRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@GRpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //devuelve la lista de todos los usuarios con sus tiendas
    @Override
    public void findAll(UserServiceProto.Empty request, StreamObserver<UserServiceProto.Users> responseObserver) {
        Iterable<User> userEntities = userRepository.findAll();
        UserServiceProto.Users.Builder usersBuilder = UserServiceProto.Users.newBuilder();

        for (User userEntity : userEntities) {
            usersBuilder.addUser(convertUserToProto(userEntity));
        }

        responseObserver.onNext(usersBuilder.build());
        responseObserver.onCompleted();
    }

    //devuelve un usuario segun la id que le envies
    @Override
    public void findById(UserServiceProto.User request, StreamObserver<UserServiceProto.User> responseObserver) {
        User userEntity = userRepository.findById(request.getId()).orElse(null);

        if (userEntity != null) {
            responseObserver.onNext(convertUserToProto(userEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("User not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    //creacion de usuario, habria que enviarle los datos completos, si se envia sin tienda simplemente se le pone null
    @Override
    public void addUser(UserServiceProto.User request, StreamObserver<UserServiceProto.User> responseObserver) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()){
            responseObserver.onError(
                    io.grpc.Status.ALREADY_EXISTS.withDescription("User with this username already exists").asRuntimeException()
            );
            return;
        }

        User userEntity = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getNombre(),
                request.getApellido(),
                request.getHabilitado(),
                request.getRol()
        );

        Tienda tiendaEntity = null;
        if (request.hasTienda()) {
            tiendaEntity = tiendaRepository.findById(request.getTienda().getId()).orElse(null);
            if (tiendaEntity == null) {
                responseObserver.onError(
                        io.grpc.Status.INVALID_ARGUMENT.withDescription("Tienda not found").asRuntimeException()
                );
                return;
            }
        }
        userEntity.setTienda(tiendaEntity);

        User savedUserEntity = userRepository.save(userEntity);
        responseObserver.onNext(convertUserToProto(savedUserEntity));
        responseObserver.onCompleted();
    }

    //IMPORTANTE: enviar todos los datos del usuario, sino se pondran en null (se puede modificar esto de ultima), la contraseña no es necesario enviarla para que no se modifique
    //Recibe un usuario y segun el id le modifica los datos enviados de: password, nombre, apellido, habilitado, rol y tienda
    @Override
    public void modifyUser(UserServiceProto.User request, StreamObserver<UserServiceProto.User> responseObserver) {
        Optional<User> optionalUserEntity = userRepository.findById(request.getId());

        if (optionalUserEntity.isPresent()) {
            User userEntity = optionalUserEntity.get();

            // Modificar los atributos que se pueden cambiar
            if (!request.getPassword().isEmpty()){
                userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
            }
            userEntity.setNombre(request.getNombre());
            userEntity.setApellido(request.getApellido());
            userEntity.setHabilitado(request.getHabilitado());
            userEntity.setRol(request.getRol());

            if (request.hasTienda()) {
                Tienda tiendaEntity = tiendaRepository.findById(request.getTienda().getId()).orElse(null);
                userEntity.setTienda(tiendaEntity);
            } else {
                userEntity.setTienda(null);
            }

            // Guardar cambios
            User updatedUserEntity = userRepository.save(userEntity);
            responseObserver.onNext(convertUserToProto(updatedUserEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("User not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    //con el username del usuario, envia el objeto completo de usuario (sin la contraseña obvio)
    @Override
    public void findByUsername(UserServiceProto.User request, StreamObserver<UserServiceProto.User> responseObserver) {
        Optional<User> optionalUserEntity = userRepository.findByUsername(request.getUsername());
        if (optionalUserEntity.isPresent()) {
            responseObserver.onNext(convertUserToProto(optionalUserEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("User not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    //con la id de la tienda, o el codigo de la tienda, envia todos los usuarios que pertenecen a ella
    @Override
    public void findAllByTienda(TiendaServiceProto.Tienda request, StreamObserver<UserServiceProto.Users> responseObserver) {
        List<User> users;

        // Aca busca tanto por el id de la tienda como por el codigo, eliminar una en cuanto se sepa que enviara el cliente.
        if (request.getId() > 0) {
            Optional<Tienda> tiendaOptional = tiendaRepository.findById(request.getId());
            if (tiendaOptional.isPresent()) {
                users = userRepository.findByTienda(tiendaOptional.get());
            } else {
                responseObserver.onError(
                        io.grpc.Status.NOT_FOUND.withDescription("Tienda with the given ID not found").asRuntimeException()
                );
                return;
            }
        } else if (!request.getCodigo().isEmpty()) {
            Optional<Tienda> tiendaOptional = tiendaRepository.findByCodigo(request.getCodigo());
            if (tiendaOptional.isPresent()) {
                users = userRepository.findByTienda(tiendaOptional.get());
            } else {
                responseObserver.onError(
                        io.grpc.Status.NOT_FOUND.withDescription("Tienda with the given code not found").asRuntimeException()
                );
                return;
            }
        } else {
            responseObserver.onError(
                    io.grpc.Status.INVALID_ARGUMENT.withDescription("Tienda ID or Codigo required").asRuntimeException()
            );
            return;
        }
        UserServiceProto.Users.Builder usersBuilder = UserServiceProto.Users.newBuilder();
        for (User user : users) {
            usersBuilder.addUser(convertUserToProto(user));
        }

        responseObserver.onNext(usersBuilder.build());
        responseObserver.onCompleted();
    }

    //con la id del usuario le cambia el atributo "habilitado" a 0
    @Override
    public void disableUser(UserServiceProto.User request, StreamObserver<UserServiceProto.User> responseObserver) {
        Optional<User> optionalUserEntity = userRepository.findById(request.getId());

        if (optionalUserEntity.isPresent()) {
            User userEntity = optionalUserEntity.get();
            userEntity.setHabilitado(false);

            User updatedUserEntity = userRepository.save(userEntity);
            responseObserver.onNext(convertUserToProto(updatedUserEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("User not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    private UserServiceProto.User convertUserToProto(User userEntity) {
        UserServiceProto.User.Builder userBuilder = UserServiceProto.User.newBuilder()
                .setId(userEntity.getId())
                .setUsername(userEntity.getUsername())
                .setNombre(userEntity.getNombre())
                .setApellido(userEntity.getApellido())
                .setHabilitado(userEntity.getHabilitado())
                .setRol(userEntity.getRol());

        Tienda tiendaEntity = userEntity.getTienda();
        if (tiendaEntity != null) {
            userBuilder.setTienda(convertTiendaToProto(tiendaEntity));
        }
        return userBuilder.build();
    }

    private TiendaServiceProto.Tienda convertTiendaToProto(Tienda tiendaEntity) {
        return TiendaServiceProto.Tienda.newBuilder()
                .setId(tiendaEntity.getId())
                .setCodigo(tiendaEntity.getCodigo())
                .setProvincia(tiendaEntity.getProvincia())
                .setCiudad(tiendaEntity.getCiudad())
                .setDireccion(tiendaEntity.getDireccion())
                .setHabilitada(tiendaEntity.getHabilitada())
                .build();
    }

}

package com.grpc.grpc_server.services;

import com.grpc.grpc_server.entities.Tienda;
import com.grpc.grpc_server.repositories.ITiendaRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@GRpcService
public class TiendaService extends TiendaServiceGrpc.TiendaServiceImplBase{

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Override
    public void findAll(TiendaServiceProto.TiendaEmpty request, StreamObserver<TiendaServiceProto.Tiendas> responseObserver) {
        Iterable<Tienda> tiendaEntities = tiendaRepository.findAll();
        TiendaServiceProto.Tiendas.Builder tiendasBuilder = TiendaServiceProto.Tiendas.newBuilder();

        for (Tienda tiendaEntity : tiendaEntities) {
            tiendasBuilder.addTienda(convertTiendaToProto(tiendaEntity));
        }

        responseObserver.onNext(tiendasBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void findById(TiendaServiceProto.Tienda request, StreamObserver<TiendaServiceProto.Tienda> responseObserver) {
        Optional<Tienda> tiendaEntity = tiendaRepository.findById(request.getId());

        if (tiendaEntity.isPresent()) {
            responseObserver.onNext(convertTiendaToProto(tiendaEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Tienda not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    @Override
    public void findByCodigo(TiendaServiceProto.Tienda request, StreamObserver<TiendaServiceProto.Tienda> responseObserver) {
        Optional<Tienda> tiendaEntity = tiendaRepository.findByCodigo(request.getCodigo());

        if (tiendaEntity.isPresent()) {
            responseObserver.onNext(convertTiendaToProto(tiendaEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Tienda not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    @Override
    public void findAllTiendasHabilitadas(TiendaServiceProto.TiendaEmpty request, StreamObserver<TiendaServiceProto.Tiendas> responseObserver) {
        List<Tienda> tiendaEntities = tiendaRepository.findAllByHabilitada(true);
        TiendaServiceProto.Tiendas.Builder tiendasBuilder = TiendaServiceProto.Tiendas.newBuilder();

        for (Tienda tiendaEntity : tiendaEntities) {
            tiendasBuilder.addTienda(convertTiendaToProto(tiendaEntity));
        }

        responseObserver.onNext(tiendasBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addTienda(TiendaServiceProto.Tienda request, StreamObserver<TiendaServiceProto.Tienda> responseObserver) {

        if (tiendaRepository.findByCodigo(request.getCodigo()).isPresent()){
            responseObserver.onError(
                   Status.ALREADY_EXISTS.withDescription("Tienda with this codigo already exists.").asRuntimeException()
            );
            return;
        }

        Tienda tiendaEntity = new Tienda(
                request.getCodigo(),
                request.getProvincia(),
                request.getCiudad(),
                request.getDireccion(),
                request.getHabilitada()
        );

        Tienda savedTiendaEntity = tiendaRepository.save(tiendaEntity);
        responseObserver.onNext(convertTiendaToProto(savedTiendaEntity));
        responseObserver.onCompleted();
    }

    @Override
    public void modifyTienda(TiendaServiceProto.Tienda request, StreamObserver<TiendaServiceProto.Tienda> responseObserver) {
        Optional<Tienda> optionalTiendaEntity = tiendaRepository.findById(request.getId());

        if (optionalTiendaEntity.isPresent()) {
            Tienda tiendaEntity = optionalTiendaEntity.get();

            // Modificar los atributos que se pueden cambiar
            tiendaEntity.setProvincia(request.getProvincia());
            tiendaEntity.setCiudad(request.getCiudad());
            tiendaEntity.setDireccion(request.getDireccion());
            tiendaEntity.setHabilitada(request.getHabilitada());

            if (tiendaRepository.findByProvinciaAndCiudadAndDireccion(request.getProvincia(),request.getCiudad(),request.getDireccion()).isPresent()){
                responseObserver.onError(
                        Status.ALREADY_EXISTS.withDescription("Tienda with this provincia, ciudad and direccion already exists.").asRuntimeException()
                );
                return;
            }

            Tienda updatedTiendaEntity = tiendaRepository.save(tiendaEntity);
            responseObserver.onNext(convertTiendaToProto(updatedTiendaEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Tienda not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    @Override
    public void disableTienda(TiendaServiceProto.Tienda request, StreamObserver<TiendaServiceProto.Tienda> responseObserver) {
        Optional<Tienda> optionalTiendaEntity = tiendaRepository.findById(request.getId());

        if (optionalTiendaEntity.isPresent()) {
            Tienda tiendaEntity = optionalTiendaEntity.get();
            tiendaEntity.setHabilitada(false);

            Tienda updatedTiendaEntity = tiendaRepository.save(tiendaEntity);
            responseObserver.onNext(convertTiendaToProto(updatedTiendaEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Tienda not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
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

package com.grpc.grpc_server.services;


import com.grpc.grpc_server.entities.Tienda;
import com.grpc.grpc_server.entities.User;
import com.grpc.grpc_server.repositories.ITiendaRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@GRpcService
public class TiendaService extends TiendaServiceGrpc.TiendaServiceImplBase {
    @Autowired

    private ITiendaRepository tiendaRepository;

    @Override
    public void findAll(TiendaServiceProto.TiendaEmpty request, StreamObserver<TiendaServiceProto.Tiendas> responseObserver){
        Iterable<Tienda> tiendaEntities =  tiendaRepository.findAll();
        TiendaServiceProto.Tiendas.Builder tiendaBuilder = TiendaServiceProto.Tiendas.newBuilder();

        for(Tienda tienda : tiendaEntities){
            tiendaBuilder.addTienda(convertTiendaToProto(tienda));
        }

        responseObserver.onNext(tiendaBuilder.build());
        responseObserver.onCompleted();
    }

    private TiendaServiceProto.Tienda convertTiendaToProto(Tienda tiendaEntity) {
        TiendaServiceProto.Tienda.Builder tiendaBuilder = TiendaServiceProto.Tienda.newBuilder()
                .setId(tiendaEntity.getId())
                .setCodigo(tiendaEntity.getCodigo())
                .setProvincia(tiendaEntity.getProvincia())
                .setCiudad(tiendaEntity.getCiudad())
                .setDireccion(tiendaEntity.getDireccion())
                .setHabilitada(tiendaEntity.getHabilitada());

        return tiendaBuilder.build();
    }

}

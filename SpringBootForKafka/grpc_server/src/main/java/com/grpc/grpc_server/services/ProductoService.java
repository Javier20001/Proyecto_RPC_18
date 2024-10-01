package com.grpc.grpc_server.services;

import com.grpc.grpc_server.entities.Producto;
import com.grpc.grpc_server.repositories.IProductoRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@GRpcService
public class ProductoService extends ProductoServiceGrpc.ProductoServiceImplBase{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void findAll(ProductoServiceProto.ProductoEmpty request, StreamObserver<ProductoServiceProto.Productos> responseObserver) {
        Iterable<Producto> productoEntities = productoRepository.findAll();
        ProductoServiceProto.Productos.Builder productosBuilder = ProductoServiceProto.Productos.newBuilder();

        for (Producto productoEntity : productoEntities) {
            productosBuilder.addProducto(convertProductoToProto(productoEntity));
        }

        responseObserver.onNext(productosBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void findById(ProductoServiceProto.Producto request, StreamObserver<ProductoServiceProto.Producto> responseObserver) {
        Optional<Producto> productoEntity = productoRepository.findById(request.getId());

        if (productoEntity.isPresent()) {
            responseObserver.onNext(convertProductoToProto(productoEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    @Override
    public void findByCodigo(ProductoServiceProto.Producto request, StreamObserver<ProductoServiceProto.Producto> responseObserver) {
        Optional<Producto> productoEntity = productoRepository.findByCodigo(request.getCodigo());

        if (productoEntity.isPresent()) {
            responseObserver.onNext(convertProductoToProto(productoEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    @Override
    public void findByNombre(ProductoServiceProto.Producto request, StreamObserver<ProductoServiceProto.Producto> responseObserver) {
        Optional<Producto> productoEntity = productoRepository.findByNombre(request.getNombre());

        if (productoEntity.isPresent()) {
            responseObserver.onNext(convertProductoToProto(productoEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    @Override
    public void addProducto(ProductoServiceProto.Producto request, StreamObserver<ProductoServiceProto.Producto> responseObserver) {

        if (productoRepository.findByCodigo(request.getCodigo()).isPresent()){
            responseObserver.onError(
                    Status.ALREADY_EXISTS.withDescription("Producto with this codigo already exists.").asRuntimeException()
            );
            return;
        }

        Producto productoEntity = new Producto(
                request.getNombre(),
                request.getCodigo(),
                request.getFoto()
        );

        Producto savedProductoEntity = productoRepository.save(productoEntity);
        responseObserver.onNext(convertProductoToProto(savedProductoEntity));
        responseObserver.onCompleted();
    }

    @Override
    public void modifyProducto(ProductoServiceProto.Producto request, StreamObserver<ProductoServiceProto.Producto> responseObserver) {
        Optional<Producto> optionalProductoEntity = productoRepository.findById(request.getId());

        if (optionalProductoEntity.isPresent()) {
            Producto productoEntity = optionalProductoEntity.get();

            // Modificar los atributos que se pueden cambiar
            productoEntity.setNombre(request.getNombre());
            productoEntity.setCodigo(request.getCodigo());
            productoEntity.setFoto(request.getFoto());

            if (productoRepository.findByCodigo(request.getCodigo()).isPresent()){
                responseObserver.onError(
                        Status.ALREADY_EXISTS.withDescription("Producto with this codigo already exists.").asRuntimeException()
                );
                return;
            }

            Producto updatedProductoEntity = productoRepository.save(productoEntity);
            responseObserver.onNext(convertProductoToProto(updatedProductoEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    private ProductoServiceProto.Producto convertProductoToProto(Producto productoEntity) {
        return ProductoServiceProto.Producto.newBuilder()
                .setId(productoEntity.getId())
                .setNombre(productoEntity.getNombre())
                .setCodigo(productoEntity.getCodigo())
                .setFoto(productoEntity.getFoto())
                .build();
    }
}

package com.grpc.grpc_server.services;

import com.grpc.grpc_server.entities.Producto;
import com.grpc.grpc_server.entities.ProductoEnTienda;
import com.grpc.grpc_server.entities.Tienda;
import com.grpc.grpc_server.repositories.IProductoEnTiendaRepository;
import com.grpc.grpc_server.repositories.IProductoRepository;
import com.grpc.grpc_server.repositories.ITiendaRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@GRpcService
public class ProductoManagerService extends ProductoManagerServiceGrpc.ProductoManagerServiceImplBase{

    @Autowired
    private IProductoEnTiendaRepository productoEnTiendaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //Recibe el id de un producto en ProductoEnTienda, este id es diferente al producto en si, envia el ProductoEnTienda completo
    @Override
    public void findById(ProductoManagerServiceProto.ProductoEnTienda request, StreamObserver<ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
        Optional<ProductoEnTienda> productoEnTiendaEntity = productoEnTiendaRepository.findById(request.getId());

        if (productoEnTiendaEntity.isPresent()) {
            responseObserver.onNext(convertProductoEnTiendaToProto(productoEnTiendaEntity.get()));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto en tienda not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    //Envia todos los ProductoEnTienda, en vez de una tienda completa, envia solo su id para no enviar tantos datos (facil de modificar)
    @Override
    public void findAll(ProductoManagerServiceProto.ProductoManagerEmpty request, StreamObserver<ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
        Iterable<ProductoEnTienda> productoEnTiendaEntities = productoEnTiendaRepository.findAll();
        ProductoManagerServiceProto.ProductosEnTienda.Builder productosBuilder = ProductoManagerServiceProto.ProductosEnTienda.newBuilder();

        for (ProductoEnTienda productoEnTienda : productoEnTiendaEntities) {
            productosBuilder.addProductoEnTienda(convertProductoEnTiendaToProto(productoEnTienda));
        }

        responseObserver.onNext(productosBuilder.build());
        responseObserver.onCompleted();
    }

    //Recibe el id de un producto y devuelve todos los ProductoEnTienda que tengan ese producto (todas las combinaciones de color-talle de un producto + stock y tienda)
    @Override
    public void findAllByProductoId(ProductoServiceProto.Producto request, StreamObserver<ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
        List<ProductoEnTienda> productosEnTienda = productoEnTiendaRepository.findAllByProducto_Id(request.getId());

        ProductoManagerServiceProto.ProductosEnTienda.Builder responseBuilder = ProductoManagerServiceProto.ProductosEnTienda.newBuilder();

        for (ProductoEnTienda productoEnTienda : productosEnTienda) {
            responseBuilder.addProductoEnTienda(convertProductoEnTiendaToProto(productoEnTienda));
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    //Recibe el id de una tienda y devuelve todos productos agregados a esa tienda
    @Override
    public void findAllByTiendaId(TiendaServiceProto.Tienda request, StreamObserver<ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
        List<ProductoEnTienda> productosEnTienda = productoEnTiendaRepository.findAllByTienda_Id(request.getId());

        ProductoManagerServiceProto.ProductosEnTienda.Builder responseBuilder = ProductoManagerServiceProto.ProductosEnTienda.newBuilder();

        for (ProductoEnTienda productoEnTienda : productosEnTienda) {
            responseBuilder.addProductoEnTienda(convertProductoEnTiendaToProto(productoEnTienda));
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    //Recibe un customFilter que puede incluir nombre, codigo, talle, color o tienda(id). Puede recibir uno, dos, o todos los que quieras de estos atributos.
    //Si se envia por tienda ID un -1, filtraria exclusivamente por productos que no tengan tienda.
    //Devuelve una listado filtrando segun los datos enviados.
    @Override
    public void findAllByCustomFilter(ProductoManagerServiceProto.CustomFilter request, StreamObserver<ProductoManagerServiceProto.ProductosEnTienda> responseObserver){
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<ProductoEnTienda> query = cb.createQuery(ProductoEnTienda.class);
            Root<ProductoEnTienda> root = query.from(ProductoEnTienda.class);

            List<Predicate> predicates = new ArrayList<>();

            if (!request.getNombre().isEmpty()) {
                predicates.add(cb.equal(root.get("producto").get("nombre"), request.getNombre()));
            }

            if (!request.getCodigo().isEmpty()) {
                predicates.add(cb.equal(root.get("producto").get("codigo"), request.getCodigo()));
            }

            if (!request.getTalle().isEmpty()) {
                predicates.add(cb.equal(root.get("talle"), request.getTalle()));
            }

            if (!request.getColor().isEmpty()) {
                predicates.add(cb.equal(root.get("color"), request.getColor()));
            }

            if (request.hasTienda()) {
                int tiendaId = request.getTienda().getId();
                if (tiendaId == -1) {
                    predicates.add(cb.isNull(root.get("tienda")));
                } else if (tiendaId != 0) {
                    predicates.add(cb.equal(root.get("tienda").get("id"), tiendaId));
                }
            }

            query.where(predicates.toArray(new Predicate[0]));

            Iterable<ProductoEnTienda> productoEnTiendaEntities = entityManager.createQuery(query).getResultList();
            ProductoManagerServiceProto.ProductosEnTienda.Builder productosBuilder = ProductoManagerServiceProto.ProductosEnTienda.newBuilder();

            for (ProductoEnTienda productoEnTienda : productoEnTiendaEntities) {
                productosBuilder.addProductoEnTienda(convertProductoEnTiendaToProto(productoEnTienda));
            }

            responseObserver.onNext(productosBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    io.grpc.Status.INTERNAL.withDescription("Error al procesar la solicitud: " + e.getMessage()).asRuntimeException()
            );
        }

    }

    //Recibe el AssignToTiendaMessage, se necesita que en la tienda se envie el id, y en el ProductoBase se envie el codigo/id, color y talle
    //setea la tienda enviada al producto.
    @Override
    public void assingProductoToTienda(ProductoManagerServiceProto.AssignToTiendaMessage request, StreamObserver<ProductoManagerServiceProto.AssignResponse> responseObserver) {
        try {
            Optional<Producto> productoEntity = productoRepository.findByCodigo(request.getProductoBase().getCodigo());
            Optional<Tienda> tiendaEntity = tiendaRepository.findById(request.getTienda().getId());

            if (tiendaEntity.isEmpty()){
                responseObserver.onError(
                        io.grpc.Status.NOT_FOUND.withDescription("Tienda not found").asRuntimeException()
                );
            }

            if (productoEntity.isEmpty()){
                productoEntity = productoRepository.findById(request.getProductoBase().getId());
                if (productoEntity.isEmpty()){
                    responseObserver.onError(
                            io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
                    );
                }
            }

            List<ProductoEnTienda> alreadyCreatedProductoEnTiendaCheck = productoEnTiendaRepository
                    .findByProductoAndTalleAndColorAndTienda(productoEntity.get(), request.getProductoBase().getTalle(), request.getProductoBase().getColor(), tiendaEntity.get());

            if (!alreadyCreatedProductoEnTiendaCheck.isEmpty()){
                responseObserver.onError(
                        io.grpc.Status.NOT_FOUND.withDescription("Ya se encontro un producto creado con esta combinacion asignado a esta tienda").asRuntimeException()
                );
                return;
            }

            Optional<ProductoEnTienda> existingProductoEnTienda = productoEnTiendaRepository
                    .findByProductoAndTalleAndColorAndTiendaIsNull(productoEntity.get(), request.getProductoBase().getTalle(), request.getProductoBase().getColor());

            if (existingProductoEnTienda.isEmpty()){
                responseObserver.onError(
                        io.grpc.Status.NOT_FOUND.withDescription("No se encontro producto con la misma combinacion de codigo, talle y color creado.").asRuntimeException()
                );
                return;
            }

            //si el producto ya esta en ProductoEnTienda pero no tiene asignado una tienda
            if (existingProductoEnTienda.get().getTienda() == null) {
                existingProductoEnTienda.get().setTienda(tiendaEntity.get());
                productoEnTiendaRepository.save(existingProductoEnTienda.get());

                //creo un nuevo productoEnTienda sin asignarle tienda para futuras adiciones
                ProductoEnTienda nuevoProductoEnTiendaEntity = new ProductoEnTienda(
                        null,
                        productoEntity.get(),
                        0,
                        existingProductoEnTienda.get().getTalle(),
                        existingProductoEnTienda.get().getColor()
                );
                productoEnTiendaRepository.save(nuevoProductoEnTiendaEntity);
            } else { //si el producto ya esta asignado a una tienda
                responseObserver.onError(
                        io.grpc.Status.ALREADY_EXISTS.withDescription("Producto con la misma combinacion de codigo, talle y color ya asignado a tienda.").asRuntimeException()
                );
                return;
            }

            ProductoManagerServiceProto.AssignResponse response = ProductoManagerServiceProto.AssignResponse.newBuilder()
                    .setMessage("Producto asignado exitosamente a las tienda.")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            ProductoManagerServiceProto.AssignResponse response = ProductoManagerServiceProto.AssignResponse.newBuilder()
                    .setMessage("Error al asignar producto a la tienda: " + e.getMessage())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    //añade un ProductoBase, sin asignarle tienda, tiene que recibir los datos nombre, codigo, foto (opcional), talle, color
    //devuelve ese producto con la entidad de ProductoEnTienda, le setea el stock a 0 y le pone la tienda en null.
    @Override
    public void addProducto(ProductoManagerServiceProto.ProductoBase request, StreamObserver<ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {

        try {
            Optional<Producto> existingProducto = productoRepository.findByCodigo(request.getCodigo());

            Producto productoEntity;
            if (existingProducto.isPresent()) {
                productoEntity = existingProducto.get();
            } else {
                productoEntity = new Producto(request.getNombre(), request.getCodigo(), request.getFoto());
                productoEntity = productoRepository.save(productoEntity);
            }

            Optional<ProductoEnTienda> existingProductoEnTienda = productoEnTiendaRepository
                    .findByProductoAndTalleAndColor(productoEntity, request.getTalle(), request.getColor());

            if (existingProductoEnTienda.isPresent() && existingProductoEnTienda.get().getTienda() == null) {
                responseObserver.onError(
                        io.grpc.Status.ALREADY_EXISTS.withDescription("Producto con la misma combinacion de codigo, talle y color ya existe.").asRuntimeException()
                );
                return;
            }

            ProductoEnTienda productoEnTiendaEntity = new ProductoEnTienda(
                    null,
                    productoEntity,
                    0,
                    request.getTalle(),
                    request.getColor()
            );

            // Save the new ProductoEnTienda entity
            productoEnTiendaEntity = productoEnTiendaRepository.save(productoEnTiendaEntity);

            // Return the newly created ProductoEnTienda object
            responseObserver.onNext(convertProductoEnTiendaToProto(productoEnTiendaEntity));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    io.grpc.Status.INTERNAL.withDescription("Error al procesar la solicitud: " + e.getMessage()).asRuntimeException()
            );
        }
    }


    //Recibe un id de ProductoEnTienda y le modifica todos los campos enviados de "ProductoBase", (nombre, foto, talleee, color)
    //Si no se le envia algun dato se pondra vacio (se puede modificar)
    @Override
    public void modifyProducto(ProductoManagerServiceProto.ProductoBase request, StreamObserver<ProductoManagerServiceProto.ProductoEnTienda> responseObserver){

        Optional<ProductoEnTienda> optionalProductoEnTiendaEntity = productoEnTiendaRepository.findById(request.getId());

        if (optionalProductoEnTiendaEntity.isPresent()){
            ProductoEnTienda productoEnTiendaEntity = optionalProductoEnTiendaEntity.get();

            productoEnTiendaEntity.getProducto().setNombre(request.getNombre());
            productoEnTiendaEntity.getProducto().setFoto(request.getFoto());
            productoEnTiendaEntity.setTalle(request.getTalle());
            productoEnTiendaEntity.setColor(request.getColor());

            productoRepository.save(productoEnTiendaEntity.getProducto());

            ProductoEnTienda updatedProductoEnTiendaEntity = productoEnTiendaRepository.save(productoEnTiendaEntity);
            responseObserver.onNext(convertProductoEnTiendaToProto(updatedProductoEnTiendaEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }

    //Recibe el id del ProductoEnTienda y el id de la tienda.
    //Modifica el stock segun el atributo de ProductoEnTienda.stock que se le haya enviado
    @Override
    public void modifyStock(ProductoManagerServiceProto.ProductoEnTienda request, StreamObserver<ProductoManagerServiceProto.ProductoEnTienda> responseObserver){

        if (request.getStock()<0){
            responseObserver.onError(
                io.grpc.Status.CANCELLED.withDescription("Stock can't be less than 0").asRuntimeException()
            );
        }

        Optional<ProductoEnTienda> optionalProductoEnTiendaEntity = productoEnTiendaRepository.findByIdAndTienda(request.getId(), tiendaRepository.findById(request.getTienda().getId()).get());

        if (optionalProductoEnTiendaEntity.isPresent()){
            ProductoEnTienda productoEnTiendaEntity = optionalProductoEnTiendaEntity.get();
            productoEnTiendaEntity.setStock(request.getStock());

            ProductoEnTienda updatedProductoEnTiendaEntity = productoEnTiendaRepository.save(productoEnTiendaEntity);
            responseObserver.onNext(convertProductoEnTiendaToProto(updatedProductoEnTiendaEntity));
        } else {
            responseObserver.onError(
                    io.grpc.Status.NOT_FOUND.withDescription("Producto not found").asRuntimeException()
            );
        }
        responseObserver.onCompleted();

    }

    private ProductoManagerServiceProto.ProductoEnTienda convertProductoEnTiendaToProto(ProductoEnTienda productoEnTienda) {
        ProductoManagerServiceProto.ProductoEnTienda.Builder builder = ProductoManagerServiceProto.ProductoEnTienda.newBuilder()
                .setId(productoEnTienda.getId())
                .setProducto(convertProductoToProto(productoEnTienda.getProducto()))
                .setStock(productoEnTienda.getStock())
                .setTalle(productoEnTienda.getTalle())
                .setColor(productoEnTienda.getColor());

        if (productoEnTienda.getTienda() != null) {
            builder.setTienda(TiendaServiceProto.Tienda.newBuilder().setId(productoEnTienda.getTienda().getId()));
        }
        return builder.build();
    }

    private ProductoServiceProto.Producto convertProductoToProto(Producto producto) {
        return ProductoServiceProto.Producto.newBuilder()
                .setId(producto.getId())
                .setNombre(producto.getNombre())
                .setCodigo(producto.getCodigo())
                .setFoto(producto.getFoto())
                .build();
    }

}

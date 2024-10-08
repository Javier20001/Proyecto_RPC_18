package com.grpc.grpc_server.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: producto_manager.proto")
public final class ProductoManagerServiceGrpc {

  private ProductoManagerServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductoManagerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindById",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getFindByIdMethod;
    if ((getFindByIdMethod = ProductoManagerServiceGrpc.getFindByIdMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getFindByIdMethod = ProductoManagerServiceGrpc.getFindByIdMethod) == null) {
          ProductoManagerServiceGrpc.getFindByIdMethod = getFindByIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("FindById"))
              .build();
        }
      }
    }
    return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllMethod;
    if ((getFindAllMethod = ProductoManagerServiceGrpc.getFindAllMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getFindAllMethod = ProductoManagerServiceGrpc.getFindAllMethod) == null) {
          ProductoManagerServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByProductoIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllByProductoId",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByProductoIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByProductoIdMethod;
    if ((getFindAllByProductoIdMethod = ProductoManagerServiceGrpc.getFindAllByProductoIdMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getFindAllByProductoIdMethod = ProductoManagerServiceGrpc.getFindAllByProductoIdMethod) == null) {
          ProductoManagerServiceGrpc.getFindAllByProductoIdMethod = getFindAllByProductoIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllByProductoId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("FindAllByProductoId"))
              .build();
        }
      }
    }
    return getFindAllByProductoIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByTiendaIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllByTiendaId",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByTiendaIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByTiendaIdMethod;
    if ((getFindAllByTiendaIdMethod = ProductoManagerServiceGrpc.getFindAllByTiendaIdMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getFindAllByTiendaIdMethod = ProductoManagerServiceGrpc.getFindAllByTiendaIdMethod) == null) {
          ProductoManagerServiceGrpc.getFindAllByTiendaIdMethod = getFindAllByTiendaIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllByTiendaId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("FindAllByTiendaId"))
              .build();
        }
      }
    }
    return getFindAllByTiendaIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByCustomFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllByCustomFilter",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByCustomFilterMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> getFindAllByCustomFilterMethod;
    if ((getFindAllByCustomFilterMethod = ProductoManagerServiceGrpc.getFindAllByCustomFilterMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getFindAllByCustomFilterMethod = ProductoManagerServiceGrpc.getFindAllByCustomFilterMethod) == null) {
          ProductoManagerServiceGrpc.getFindAllByCustomFilterMethod = getFindAllByCustomFilterMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllByCustomFilter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("FindAllByCustomFilter"))
              .build();
        }
      }
    }
    return getFindAllByCustomFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse> getAssingProductoToTiendaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssingProductoToTienda",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse> getAssingProductoToTiendaMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage, com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse> getAssingProductoToTiendaMethod;
    if ((getAssingProductoToTiendaMethod = ProductoManagerServiceGrpc.getAssingProductoToTiendaMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getAssingProductoToTiendaMethod = ProductoManagerServiceGrpc.getAssingProductoToTiendaMethod) == null) {
          ProductoManagerServiceGrpc.getAssingProductoToTiendaMethod = getAssingProductoToTiendaMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage, com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssingProductoToTienda"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("AssingProductoToTienda"))
              .build();
        }
      }
    }
    return getAssingProductoToTiendaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getAddProductoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddProducto",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getAddProductoMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getAddProductoMethod;
    if ((getAddProductoMethod = ProductoManagerServiceGrpc.getAddProductoMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getAddProductoMethod = ProductoManagerServiceGrpc.getAddProductoMethod) == null) {
          ProductoManagerServiceGrpc.getAddProductoMethod = getAddProductoMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddProducto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("AddProducto"))
              .build();
        }
      }
    }
    return getAddProductoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getModifyProductoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyProducto",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getModifyProductoMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getModifyProductoMethod;
    if ((getModifyProductoMethod = ProductoManagerServiceGrpc.getModifyProductoMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getModifyProductoMethod = ProductoManagerServiceGrpc.getModifyProductoMethod) == null) {
          ProductoManagerServiceGrpc.getModifyProductoMethod = getModifyProductoMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyProducto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("ModifyProducto"))
              .build();
        }
      }
    }
    return getModifyProductoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getModifyStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyStock",
      requestType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.class,
      responseType = com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda,
      com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getModifyStockMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> getModifyStockMethod;
    if ((getModifyStockMethod = ProductoManagerServiceGrpc.getModifyStockMethod) == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        if ((getModifyStockMethod = ProductoManagerServiceGrpc.getModifyStockMethod) == null) {
          ProductoManagerServiceGrpc.getModifyStockMethod = getModifyStockMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda, com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoManagerServiceMethodDescriptorSupplier("ModifyStock"))
              .build();
        }
      }
    }
    return getModifyStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductoManagerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductoManagerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductoManagerServiceStub>() {
        @java.lang.Override
        public ProductoManagerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductoManagerServiceStub(channel, callOptions);
        }
      };
    return ProductoManagerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductoManagerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductoManagerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductoManagerServiceBlockingStub>() {
        @java.lang.Override
        public ProductoManagerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductoManagerServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductoManagerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductoManagerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductoManagerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductoManagerServiceFutureStub>() {
        @java.lang.Override
        public ProductoManagerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductoManagerServiceFutureStub(channel, callOptions);
        }
      };
    return ProductoManagerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductoManagerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findById(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void findAll(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void findAllByProductoId(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllByProductoIdMethod(), responseObserver);
    }

    /**
     */
    public void findAllByTiendaId(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllByTiendaIdMethod(), responseObserver);
    }

    /**
     */
    public void findAllByCustomFilter(com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllByCustomFilterMethod(), responseObserver);
    }

    /**
     */
    public void assingProductoToTienda(com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssingProductoToTiendaMethod(), responseObserver);
    }

    /**
     */
    public void addProducto(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductoMethod(), responseObserver);
    }

    /**
     */
    public void modifyProducto(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyProductoMethod(), responseObserver);
    }

    /**
     */
    public void modifyStock(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getFindAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getFindAllByProductoIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.Producto,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>(
                  this, METHODID_FIND_ALL_BY_PRODUCTO_ID)))
          .addMethod(
            getFindAllByTiendaIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>(
                  this, METHODID_FIND_ALL_BY_TIENDA_ID)))
          .addMethod(
            getFindAllByCustomFilterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>(
                  this, METHODID_FIND_ALL_BY_CUSTOM_FILTER)))
          .addMethod(
            getAssingProductoToTiendaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse>(
                  this, METHODID_ASSING_PRODUCTO_TO_TIENDA)))
          .addMethod(
            getAddProductoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>(
                  this, METHODID_ADD_PRODUCTO)))
          .addMethod(
            getModifyProductoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>(
                  this, METHODID_MODIFY_PRODUCTO)))
          .addMethod(
            getModifyStockMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda,
                com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>(
                  this, METHODID_MODIFY_STOCK)))
          .build();
    }
  }

  /**
   */
  public static final class ProductoManagerServiceStub extends io.grpc.stub.AbstractAsyncStub<ProductoManagerServiceStub> {
    private ProductoManagerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoManagerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductoManagerServiceStub(channel, callOptions);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAll(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllByProductoId(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllByProductoIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllByTiendaId(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllByTiendaIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllByCustomFilter(com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllByCustomFilterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assingProductoToTienda(com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssingProductoToTiendaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addProducto(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyProducto(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyProductoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyStock(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductoManagerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductoManagerServiceBlockingStub> {
    private ProductoManagerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoManagerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductoManagerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda findById(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda findAll(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda findAllByProductoId(com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllByProductoIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda findAllByTiendaId(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllByTiendaIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda findAllByCustomFilter(com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllByCustomFilterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse assingProductoToTienda(com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssingProductoToTiendaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda addProducto(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda modifyProducto(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyProductoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda modifyStock(com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyStockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductoManagerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProductoManagerServiceFutureStub> {
    private ProductoManagerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoManagerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductoManagerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> findById(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> findAll(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> findAllByProductoId(
        com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllByProductoIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> findAllByTiendaId(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllByTiendaIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda> findAllByCustomFilter(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllByCustomFilterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse> assingProductoToTienda(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssingProductoToTiendaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> addProducto(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> modifyProducto(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyProductoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda> modifyStock(
        com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_BY_ID = 0;
  private static final int METHODID_FIND_ALL = 1;
  private static final int METHODID_FIND_ALL_BY_PRODUCTO_ID = 2;
  private static final int METHODID_FIND_ALL_BY_TIENDA_ID = 3;
  private static final int METHODID_FIND_ALL_BY_CUSTOM_FILTER = 4;
  private static final int METHODID_ASSING_PRODUCTO_TO_TIENDA = 5;
  private static final int METHODID_ADD_PRODUCTO = 6;
  private static final int METHODID_MODIFY_PRODUCTO = 7;
  private static final int METHODID_MODIFY_STOCK = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductoManagerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductoManagerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>) responseObserver);
          break;
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoManagerEmpty) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_PRODUCTO_ID:
          serviceImpl.findAllByProductoId((com.grpc.grpc_server.services.ProductoServiceProto.Producto) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_TIENDA_ID:
          serviceImpl.findAllByTiendaId((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_CUSTOM_FILTER:
          serviceImpl.findAllByCustomFilter((com.grpc.grpc_server.services.ProductoManagerServiceProto.CustomFilter) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductosEnTienda>) responseObserver);
          break;
        case METHODID_ASSING_PRODUCTO_TO_TIENDA:
          serviceImpl.assingProductoToTienda((com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignToTiendaMessage) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.AssignResponse>) responseObserver);
          break;
        case METHODID_ADD_PRODUCTO:
          serviceImpl.addProducto((com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>) responseObserver);
          break;
        case METHODID_MODIFY_PRODUCTO:
          serviceImpl.modifyProducto((com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoBase) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>) responseObserver);
          break;
        case METHODID_MODIFY_STOCK:
          serviceImpl.modifyStock((com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoManagerServiceProto.ProductoEnTienda>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProductoManagerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductoManagerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.grpc_server.services.ProductoManagerServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductoManagerService");
    }
  }

  private static final class ProductoManagerServiceFileDescriptorSupplier
      extends ProductoManagerServiceBaseDescriptorSupplier {
    ProductoManagerServiceFileDescriptorSupplier() {}
  }

  private static final class ProductoManagerServiceMethodDescriptorSupplier
      extends ProductoManagerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductoManagerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductoManagerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductoManagerServiceFileDescriptorSupplier())
              .addMethod(getFindByIdMethod())
              .addMethod(getFindAllMethod())
              .addMethod(getFindAllByProductoIdMethod())
              .addMethod(getFindAllByTiendaIdMethod())
              .addMethod(getFindAllByCustomFilterMethod())
              .addMethod(getAssingProductoToTiendaMethod())
              .addMethod(getAddProductoMethod())
              .addMethod(getModifyProductoMethod())
              .addMethod(getModifyStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}

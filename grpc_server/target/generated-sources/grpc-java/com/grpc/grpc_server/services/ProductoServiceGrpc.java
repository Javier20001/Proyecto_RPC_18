package com.grpc.grpc_server.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: producto.proto")
public final class ProductoServiceGrpc {

  private ProductoServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty,
      com.grpc.grpc_server.services.ProductoServiceProto.Productos> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty.class,
      responseType = com.grpc.grpc_server.services.ProductoServiceProto.Productos.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty,
      com.grpc.grpc_server.services.ProductoServiceProto.Productos> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty, com.grpc.grpc_server.services.ProductoServiceProto.Productos> getFindAllMethod;
    if ((getFindAllMethod = ProductoServiceGrpc.getFindAllMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getFindAllMethod = ProductoServiceGrpc.getFindAllMethod) == null) {
          ProductoServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty, com.grpc.grpc_server.services.ProductoServiceProto.Productos>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Productos.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindById",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      responseType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByIdMethod;
    if ((getFindByIdMethod = ProductoServiceGrpc.getFindByIdMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getFindByIdMethod = ProductoServiceGrpc.getFindByIdMethod) == null) {
          ProductoServiceGrpc.getFindByIdMethod = getFindByIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("FindById"))
              .build();
        }
      }
    }
    return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByCodigoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindByCodigo",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      responseType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByCodigoMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByCodigoMethod;
    if ((getFindByCodigoMethod = ProductoServiceGrpc.getFindByCodigoMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getFindByCodigoMethod = ProductoServiceGrpc.getFindByCodigoMethod) == null) {
          ProductoServiceGrpc.getFindByCodigoMethod = getFindByCodigoMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindByCodigo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("FindByCodigo"))
              .build();
        }
      }
    }
    return getFindByCodigoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByNombreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindByNombre",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      responseType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByNombreMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto> getFindByNombreMethod;
    if ((getFindByNombreMethod = ProductoServiceGrpc.getFindByNombreMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getFindByNombreMethod = ProductoServiceGrpc.getFindByNombreMethod) == null) {
          ProductoServiceGrpc.getFindByNombreMethod = getFindByNombreMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindByNombre"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("FindByNombre"))
              .build();
        }
      }
    }
    return getFindByNombreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getAddProductoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddProducto",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      responseType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getAddProductoMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto> getAddProductoMethod;
    if ((getAddProductoMethod = ProductoServiceGrpc.getAddProductoMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getAddProductoMethod = ProductoServiceGrpc.getAddProductoMethod) == null) {
          ProductoServiceGrpc.getAddProductoMethod = getAddProductoMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddProducto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("AddProducto"))
              .build();
        }
      }
    }
    return getAddProductoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getModifyProductoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyProducto",
      requestType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      responseType = com.grpc.grpc_server.services.ProductoServiceProto.Producto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto,
      com.grpc.grpc_server.services.ProductoServiceProto.Producto> getModifyProductoMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto> getModifyProductoMethod;
    if ((getModifyProductoMethod = ProductoServiceGrpc.getModifyProductoMethod) == null) {
      synchronized (ProductoServiceGrpc.class) {
        if ((getModifyProductoMethod = ProductoServiceGrpc.getModifyProductoMethod) == null) {
          ProductoServiceGrpc.getModifyProductoMethod = getModifyProductoMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.ProductoServiceProto.Producto, com.grpc.grpc_server.services.ProductoServiceProto.Producto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyProducto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.ProductoServiceProto.Producto.getDefaultInstance()))
              .setSchemaDescriptor(new ProductoServiceMethodDescriptorSupplier("ModifyProducto"))
              .build();
        }
      }
    }
    return getModifyProductoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductoServiceStub>() {
        @java.lang.Override
        public ProductoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductoServiceStub(channel, callOptions);
        }
      };
    return ProductoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductoServiceBlockingStub>() {
        @java.lang.Override
        public ProductoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductoServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductoServiceFutureStub>() {
        @java.lang.Override
        public ProductoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductoServiceFutureStub(channel, callOptions);
        }
      };
    return ProductoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Productos> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void findByCodigo(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByCodigoMethod(), responseObserver);
    }

    /**
     */
    public void findByNombre(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByNombreMethod(), responseObserver);
    }

    /**
     */
    public void addProducto(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductoMethod(), responseObserver);
    }

    /**
     */
    public void modifyProducto(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyProductoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty,
                com.grpc.grpc_server.services.ProductoServiceProto.Productos>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getFindByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.Producto,
                com.grpc.grpc_server.services.ProductoServiceProto.Producto>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getFindByCodigoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.Producto,
                com.grpc.grpc_server.services.ProductoServiceProto.Producto>(
                  this, METHODID_FIND_BY_CODIGO)))
          .addMethod(
            getFindByNombreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.Producto,
                com.grpc.grpc_server.services.ProductoServiceProto.Producto>(
                  this, METHODID_FIND_BY_NOMBRE)))
          .addMethod(
            getAddProductoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.Producto,
                com.grpc.grpc_server.services.ProductoServiceProto.Producto>(
                  this, METHODID_ADD_PRODUCTO)))
          .addMethod(
            getModifyProductoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.ProductoServiceProto.Producto,
                com.grpc.grpc_server.services.ProductoServiceProto.Producto>(
                  this, METHODID_MODIFY_PRODUCTO)))
          .build();
    }
  }

  /**
   */
  public static final class ProductoServiceStub extends io.grpc.stub.AbstractAsyncStub<ProductoServiceStub> {
    private ProductoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductoServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Productos> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByCodigo(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByCodigoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByNombre(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByNombreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addProducto(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyProducto(com.grpc.grpc_server.services.ProductoServiceProto.Producto request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyProductoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductoServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductoServiceBlockingStub> {
    private ProductoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoServiceProto.Productos findAll(com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoServiceProto.Producto findById(com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoServiceProto.Producto findByCodigo(com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByCodigoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoServiceProto.Producto findByNombre(com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByNombreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoServiceProto.Producto addProducto(com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.ProductoServiceProto.Producto modifyProducto(com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyProductoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductoServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProductoServiceFutureStub> {
    private ProductoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoServiceProto.Productos> findAll(
        com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoServiceProto.Producto> findById(
        com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoServiceProto.Producto> findByCodigo(
        com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByCodigoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoServiceProto.Producto> findByNombre(
        com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByNombreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoServiceProto.Producto> addProducto(
        com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.ProductoServiceProto.Producto> modifyProducto(
        com.grpc.grpc_server.services.ProductoServiceProto.Producto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyProductoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_FIND_BY_ID = 1;
  private static final int METHODID_FIND_BY_CODIGO = 2;
  private static final int METHODID_FIND_BY_NOMBRE = 3;
  private static final int METHODID_ADD_PRODUCTO = 4;
  private static final int METHODID_MODIFY_PRODUCTO = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.grpc.grpc_server.services.ProductoServiceProto.ProductoEmpty) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Productos>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.grpc.grpc_server.services.ProductoServiceProto.Producto) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto>) responseObserver);
          break;
        case METHODID_FIND_BY_CODIGO:
          serviceImpl.findByCodigo((com.grpc.grpc_server.services.ProductoServiceProto.Producto) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto>) responseObserver);
          break;
        case METHODID_FIND_BY_NOMBRE:
          serviceImpl.findByNombre((com.grpc.grpc_server.services.ProductoServiceProto.Producto) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto>) responseObserver);
          break;
        case METHODID_ADD_PRODUCTO:
          serviceImpl.addProducto((com.grpc.grpc_server.services.ProductoServiceProto.Producto) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto>) responseObserver);
          break;
        case METHODID_MODIFY_PRODUCTO:
          serviceImpl.modifyProducto((com.grpc.grpc_server.services.ProductoServiceProto.Producto) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.ProductoServiceProto.Producto>) responseObserver);
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

  private static abstract class ProductoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.grpc_server.services.ProductoServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductoService");
    }
  }

  private static final class ProductoServiceFileDescriptorSupplier
      extends ProductoServiceBaseDescriptorSupplier {
    ProductoServiceFileDescriptorSupplier() {}
  }

  private static final class ProductoServiceMethodDescriptorSupplier
      extends ProductoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductoServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getFindByIdMethod())
              .addMethod(getFindByCodigoMethod())
              .addMethod(getFindByNombreMethod())
              .addMethod(getAddProductoMethod())
              .addMethod(getModifyProductoMethod())
              .build();
        }
      }
    }
    return result;
  }
}

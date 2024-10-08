package com.grpc.grpc_server.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: tienda.proto")
public final class TiendaServiceGrpc {

  private TiendaServiceGrpc() {}

  public static final String SERVICE_NAME = "TiendaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty,
      com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tiendas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty,
      com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty, com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> getFindAllMethod;
    if ((getFindAllMethod = TiendaServiceGrpc.getFindAllMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getFindAllMethod = TiendaServiceGrpc.getFindAllMethod) == null) {
          TiendaServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty, com.grpc.grpc_server.services.TiendaServiceProto.Tiendas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tiendas.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindById",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getFindByIdMethod;
    if ((getFindByIdMethod = TiendaServiceGrpc.getFindByIdMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getFindByIdMethod = TiendaServiceGrpc.getFindByIdMethod) == null) {
          TiendaServiceGrpc.getFindByIdMethod = getFindByIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("FindById"))
              .build();
        }
      }
    }
    return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getFindByCodigoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindByCodigo",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getFindByCodigoMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getFindByCodigoMethod;
    if ((getFindByCodigoMethod = TiendaServiceGrpc.getFindByCodigoMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getFindByCodigoMethod = TiendaServiceGrpc.getFindByCodigoMethod) == null) {
          TiendaServiceGrpc.getFindByCodigoMethod = getFindByCodigoMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindByCodigo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("FindByCodigo"))
              .build();
        }
      }
    }
    return getFindByCodigoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty,
      com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> getFindAllTiendasHabilitadasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllTiendasHabilitadas",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tiendas.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty,
      com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> getFindAllTiendasHabilitadasMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty, com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> getFindAllTiendasHabilitadasMethod;
    if ((getFindAllTiendasHabilitadasMethod = TiendaServiceGrpc.getFindAllTiendasHabilitadasMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getFindAllTiendasHabilitadasMethod = TiendaServiceGrpc.getFindAllTiendasHabilitadasMethod) == null) {
          TiendaServiceGrpc.getFindAllTiendasHabilitadasMethod = getFindAllTiendasHabilitadasMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty, com.grpc.grpc_server.services.TiendaServiceProto.Tiendas>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllTiendasHabilitadas"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tiendas.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("FindAllTiendasHabilitadas"))
              .build();
        }
      }
    }
    return getFindAllTiendasHabilitadasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getAddTiendaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTienda",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getAddTiendaMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getAddTiendaMethod;
    if ((getAddTiendaMethod = TiendaServiceGrpc.getAddTiendaMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getAddTiendaMethod = TiendaServiceGrpc.getAddTiendaMethod) == null) {
          TiendaServiceGrpc.getAddTiendaMethod = getAddTiendaMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddTienda"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("AddTienda"))
              .build();
        }
      }
    }
    return getAddTiendaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getModifyTiendaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyTienda",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getModifyTiendaMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getModifyTiendaMethod;
    if ((getModifyTiendaMethod = TiendaServiceGrpc.getModifyTiendaMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getModifyTiendaMethod = TiendaServiceGrpc.getModifyTiendaMethod) == null) {
          TiendaServiceGrpc.getModifyTiendaMethod = getModifyTiendaMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyTienda"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("ModifyTienda"))
              .build();
        }
      }
    }
    return getModifyTiendaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getDisableTiendaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableTienda",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getDisableTiendaMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda> getDisableTiendaMethod;
    if ((getDisableTiendaMethod = TiendaServiceGrpc.getDisableTiendaMethod) == null) {
      synchronized (TiendaServiceGrpc.class) {
        if ((getDisableTiendaMethod = TiendaServiceGrpc.getDisableTiendaMethod) == null) {
          TiendaServiceGrpc.getDisableTiendaMethod = getDisableTiendaMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.TiendaServiceProto.Tienda>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableTienda"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setSchemaDescriptor(new TiendaServiceMethodDescriptorSupplier("DisableTienda"))
              .build();
        }
      }
    }
    return getDisableTiendaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TiendaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TiendaServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TiendaServiceStub>() {
        @java.lang.Override
        public TiendaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TiendaServiceStub(channel, callOptions);
        }
      };
    return TiendaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TiendaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TiendaServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TiendaServiceBlockingStub>() {
        @java.lang.Override
        public TiendaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TiendaServiceBlockingStub(channel, callOptions);
        }
      };
    return TiendaServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TiendaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TiendaServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TiendaServiceFutureStub>() {
        @java.lang.Override
        public TiendaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TiendaServiceFutureStub(channel, callOptions);
        }
      };
    return TiendaServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TiendaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void findByCodigo(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByCodigoMethod(), responseObserver);
    }

    /**
     */
    public void findAllTiendasHabilitadas(com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllTiendasHabilitadasMethod(), responseObserver);
    }

    /**
     */
    public void addTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddTiendaMethod(), responseObserver);
    }

    /**
     */
    public void modifyTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyTiendaMethod(), responseObserver);
    }

    /**
     */
    public void disableTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableTiendaMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty,
                com.grpc.grpc_server.services.TiendaServiceProto.Tiendas>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getFindByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getFindByCodigoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda>(
                  this, METHODID_FIND_BY_CODIGO)))
          .addMethod(
            getFindAllTiendasHabilitadasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty,
                com.grpc.grpc_server.services.TiendaServiceProto.Tiendas>(
                  this, METHODID_FIND_ALL_TIENDAS_HABILITADAS)))
          .addMethod(
            getAddTiendaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda>(
                  this, METHODID_ADD_TIENDA)))
          .addMethod(
            getModifyTiendaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda>(
                  this, METHODID_MODIFY_TIENDA)))
          .addMethod(
            getDisableTiendaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda>(
                  this, METHODID_DISABLE_TIENDA)))
          .build();
    }
  }

  /**
   */
  public static final class TiendaServiceStub extends io.grpc.stub.AbstractAsyncStub<TiendaServiceStub> {
    private TiendaServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TiendaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TiendaServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByCodigo(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByCodigoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllTiendasHabilitadas(com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllTiendasHabilitadasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddTiendaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyTiendaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disableTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableTiendaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TiendaServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TiendaServiceBlockingStub> {
    private TiendaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TiendaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TiendaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tiendas findAll(com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tienda findById(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tienda findByCodigo(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByCodigoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tiendas findAllTiendasHabilitadas(com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllTiendasHabilitadasMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tienda addTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddTiendaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tienda modifyTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyTiendaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.TiendaServiceProto.Tienda disableTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableTiendaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TiendaServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TiendaServiceFutureStub> {
    private TiendaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TiendaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TiendaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> findAll(
        com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> findById(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> findByCodigo(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByCodigoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas> findAllTiendasHabilitadas(
        com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllTiendasHabilitadasMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> addTienda(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddTiendaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> modifyTienda(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyTiendaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.TiendaServiceProto.Tienda> disableTienda(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableTiendaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_FIND_BY_ID = 1;
  private static final int METHODID_FIND_BY_CODIGO = 2;
  private static final int METHODID_FIND_ALL_TIENDAS_HABILITADAS = 3;
  private static final int METHODID_ADD_TIENDA = 4;
  private static final int METHODID_MODIFY_TIENDA = 5;
  private static final int METHODID_DISABLE_TIENDA = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TiendaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TiendaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda>) responseObserver);
          break;
        case METHODID_FIND_BY_CODIGO:
          serviceImpl.findByCodigo((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda>) responseObserver);
          break;
        case METHODID_FIND_ALL_TIENDAS_HABILITADAS:
          serviceImpl.findAllTiendasHabilitadas((com.grpc.grpc_server.services.TiendaServiceProto.TiendaEmpty) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tiendas>) responseObserver);
          break;
        case METHODID_ADD_TIENDA:
          serviceImpl.addTienda((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda>) responseObserver);
          break;
        case METHODID_MODIFY_TIENDA:
          serviceImpl.modifyTienda((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda>) responseObserver);
          break;
        case METHODID_DISABLE_TIENDA:
          serviceImpl.disableTienda((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.TiendaServiceProto.Tienda>) responseObserver);
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

  private static abstract class TiendaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TiendaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.grpc_server.services.TiendaServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TiendaService");
    }
  }

  private static final class TiendaServiceFileDescriptorSupplier
      extends TiendaServiceBaseDescriptorSupplier {
    TiendaServiceFileDescriptorSupplier() {}
  }

  private static final class TiendaServiceMethodDescriptorSupplier
      extends TiendaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TiendaServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TiendaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TiendaServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getFindByIdMethod())
              .addMethod(getFindByCodigoMethod())
              .addMethod(getFindAllTiendasHabilitadasMethod())
              .addMethod(getAddTiendaMethod())
              .addMethod(getModifyTiendaMethod())
              .addMethod(getDisableTiendaMethod())
              .build();
        }
      }
    }
    return result;
  }
}

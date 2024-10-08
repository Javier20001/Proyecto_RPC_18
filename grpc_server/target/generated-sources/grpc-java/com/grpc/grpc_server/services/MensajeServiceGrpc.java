package com.grpc.grpc_server.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: prueba.proto")
public final class MensajeServiceGrpc {

  private MensajeServiceGrpc() {}

  public static final String SERVICE_NAME = "MensajeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest,
      com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse> getEnviarMensajeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "enviarMensaje",
      requestType = com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest.class,
      responseType = com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest,
      com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse> getEnviarMensajeMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest, com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse> getEnviarMensajeMethod;
    if ((getEnviarMensajeMethod = MensajeServiceGrpc.getEnviarMensajeMethod) == null) {
      synchronized (MensajeServiceGrpc.class) {
        if ((getEnviarMensajeMethod = MensajeServiceGrpc.getEnviarMensajeMethod) == null) {
          MensajeServiceGrpc.getEnviarMensajeMethod = getEnviarMensajeMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest, com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "enviarMensaje"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MensajeServiceMethodDescriptorSupplier("enviarMensaje"))
              .build();
        }
      }
    }
    return getEnviarMensajeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MensajeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MensajeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MensajeServiceStub>() {
        @java.lang.Override
        public MensajeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MensajeServiceStub(channel, callOptions);
        }
      };
    return MensajeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MensajeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MensajeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MensajeServiceBlockingStub>() {
        @java.lang.Override
        public MensajeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MensajeServiceBlockingStub(channel, callOptions);
        }
      };
    return MensajeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MensajeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MensajeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MensajeServiceFutureStub>() {
        @java.lang.Override
        public MensajeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MensajeServiceFutureStub(channel, callOptions);
        }
      };
    return MensajeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MensajeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void enviarMensaje(com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnviarMensajeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnviarMensajeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest,
                com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse>(
                  this, METHODID_ENVIAR_MENSAJE)))
          .build();
    }
  }

  /**
   */
  public static final class MensajeServiceStub extends io.grpc.stub.AbstractAsyncStub<MensajeServiceStub> {
    private MensajeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MensajeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MensajeServiceStub(channel, callOptions);
    }

    /**
     */
    public void enviarMensaje(com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnviarMensajeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MensajeServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MensajeServiceBlockingStub> {
    private MensajeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MensajeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MensajeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse enviarMensaje(com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnviarMensajeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MensajeServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MensajeServiceFutureStub> {
    private MensajeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MensajeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MensajeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse> enviarMensaje(
        com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnviarMensajeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENVIAR_MENSAJE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MensajeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MensajeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENVIAR_MENSAJE:
          serviceImpl.enviarMensaje((com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse>) responseObserver);
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

  private static abstract class MensajeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MensajeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.grpc_server.services.MensajeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MensajeService");
    }
  }

  private static final class MensajeServiceFileDescriptorSupplier
      extends MensajeServiceBaseDescriptorSupplier {
    MensajeServiceFileDescriptorSupplier() {}
  }

  private static final class MensajeServiceMethodDescriptorSupplier
      extends MensajeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MensajeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MensajeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MensajeServiceFileDescriptorSupplier())
              .addMethod(getEnviarMensajeMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package com.grpc.grpc_server.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: user.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.Empty,
      com.grpc.grpc_server.services.UserServiceProto.Users> getFindAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAll",
      requestType = com.grpc.grpc_server.services.UserServiceProto.Empty.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.Users.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.Empty,
      com.grpc.grpc_server.services.UserServiceProto.Users> getFindAllMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.Empty, com.grpc.grpc_server.services.UserServiceProto.Users> getFindAllMethod;
    if ((getFindAllMethod = UserServiceGrpc.getFindAllMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getFindAllMethod = UserServiceGrpc.getFindAllMethod) == null) {
          UserServiceGrpc.getFindAllMethod = getFindAllMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.UserServiceProto.Empty, com.grpc.grpc_server.services.UserServiceProto.Users>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.Users.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("FindAll"))
              .build();
        }
      }
    }
    return getFindAllMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getFindByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindById",
      requestType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getFindByIdMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User> getFindByIdMethod;
    if ((getFindByIdMethod = UserServiceGrpc.getFindByIdMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getFindByIdMethod = UserServiceGrpc.getFindByIdMethod) == null) {
          UserServiceGrpc.getFindByIdMethod = getFindByIdMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("FindById"))
              .build();
        }
      }
    }
    return getFindByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getAddUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddUser",
      requestType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getAddUserMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User> getAddUserMethod;
    if ((getAddUserMethod = UserServiceGrpc.getAddUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getAddUserMethod = UserServiceGrpc.getAddUserMethod) == null) {
          UserServiceGrpc.getAddUserMethod = getAddUserMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("AddUser"))
              .build();
        }
      }
    }
    return getAddUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getModifyUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyUser",
      requestType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getModifyUserMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User> getModifyUserMethod;
    if ((getModifyUserMethod = UserServiceGrpc.getModifyUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getModifyUserMethod = UserServiceGrpc.getModifyUserMethod) == null) {
          UserServiceGrpc.getModifyUserMethod = getModifyUserMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("ModifyUser"))
              .build();
        }
      }
    }
    return getModifyUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getFindByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindByUsername",
      requestType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getFindByUsernameMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User> getFindByUsernameMethod;
    if ((getFindByUsernameMethod = UserServiceGrpc.getFindByUsernameMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getFindByUsernameMethod = UserServiceGrpc.getFindByUsernameMethod) == null) {
          UserServiceGrpc.getFindByUsernameMethod = getFindByUsernameMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("FindByUsername"))
              .build();
        }
      }
    }
    return getFindByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.UserServiceProto.Users> getFindAllByTiendaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllByTienda",
      requestType = com.grpc.grpc_server.services.TiendaServiceProto.Tienda.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.Users.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
      com.grpc.grpc_server.services.UserServiceProto.Users> getFindAllByTiendaMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.UserServiceProto.Users> getFindAllByTiendaMethod;
    if ((getFindAllByTiendaMethod = UserServiceGrpc.getFindAllByTiendaMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getFindAllByTiendaMethod = UserServiceGrpc.getFindAllByTiendaMethod) == null) {
          UserServiceGrpc.getFindAllByTiendaMethod = getFindAllByTiendaMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.TiendaServiceProto.Tienda, com.grpc.grpc_server.services.UserServiceProto.Users>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllByTienda"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.TiendaServiceProto.Tienda.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.Users.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("FindAllByTienda"))
              .build();
        }
      }
    }
    return getFindAllByTiendaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getDisableUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableUser",
      requestType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      responseType = com.grpc.grpc_server.services.UserServiceProto.User.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User,
      com.grpc.grpc_server.services.UserServiceProto.User> getDisableUserMethod() {
    io.grpc.MethodDescriptor<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User> getDisableUserMethod;
    if ((getDisableUserMethod = UserServiceGrpc.getDisableUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDisableUserMethod = UserServiceGrpc.getDisableUserMethod) == null) {
          UserServiceGrpc.getDisableUserMethod = getDisableUserMethod =
              io.grpc.MethodDescriptor.<com.grpc.grpc_server.services.UserServiceProto.User, com.grpc.grpc_server.services.UserServiceProto.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.grpc_server.services.UserServiceProto.User.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DisableUser"))
              .build();
        }
      }
    }
    return getDisableUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findAll(com.grpc.grpc_server.services.UserServiceProto.Empty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.Users> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllMethod(), responseObserver);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByIdMethod(), responseObserver);
    }

    /**
     */
    public void addUser(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddUserMethod(), responseObserver);
    }

    /**
     */
    public void modifyUser(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyUserMethod(), responseObserver);
    }

    /**
     */
    public void findByUsername(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void findAllByTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.Users> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllByTiendaMethod(), responseObserver);
    }

    /**
     */
    public void disableUser(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindAllMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.UserServiceProto.Empty,
                com.grpc.grpc_server.services.UserServiceProto.Users>(
                  this, METHODID_FIND_ALL)))
          .addMethod(
            getFindByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.UserServiceProto.User,
                com.grpc.grpc_server.services.UserServiceProto.User>(
                  this, METHODID_FIND_BY_ID)))
          .addMethod(
            getAddUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.UserServiceProto.User,
                com.grpc.grpc_server.services.UserServiceProto.User>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            getModifyUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.UserServiceProto.User,
                com.grpc.grpc_server.services.UserServiceProto.User>(
                  this, METHODID_MODIFY_USER)))
          .addMethod(
            getFindByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.UserServiceProto.User,
                com.grpc.grpc_server.services.UserServiceProto.User>(
                  this, METHODID_FIND_BY_USERNAME)))
          .addMethod(
            getFindAllByTiendaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.TiendaServiceProto.Tienda,
                com.grpc.grpc_server.services.UserServiceProto.Users>(
                  this, METHODID_FIND_ALL_BY_TIENDA)))
          .addMethod(
            getDisableUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.grpc.grpc_server.services.UserServiceProto.User,
                com.grpc.grpc_server.services.UserServiceProto.User>(
                  this, METHODID_DISABLE_USER)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAll(com.grpc.grpc_server.services.UserServiceProto.Empty request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.Users> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findById(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addUser(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyUser(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findByUsername(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllByTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.Users> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllByTiendaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disableUser(com.grpc.grpc_server.services.UserServiceProto.User request,
        io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.Users findAll(com.grpc.grpc_server.services.UserServiceProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.User findById(com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.User addUser(com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.User modifyUser(com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.User findByUsername(com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.Users findAllByTienda(com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllByTiendaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.grpc.grpc_server.services.UserServiceProto.User disableUser(com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableUserMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.Users> findAll(
        com.grpc.grpc_server.services.UserServiceProto.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.User> findById(
        com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.User> addUser(
        com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.User> modifyUser(
        com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.User> findByUsername(
        com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindByUsernameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.Users> findAllByTienda(
        com.grpc.grpc_server.services.TiendaServiceProto.Tienda request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllByTiendaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.grpc.grpc_server.services.UserServiceProto.User> disableUser(
        com.grpc.grpc_server.services.UserServiceProto.User request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL = 0;
  private static final int METHODID_FIND_BY_ID = 1;
  private static final int METHODID_ADD_USER = 2;
  private static final int METHODID_MODIFY_USER = 3;
  private static final int METHODID_FIND_BY_USERNAME = 4;
  private static final int METHODID_FIND_ALL_BY_TIENDA = 5;
  private static final int METHODID_DISABLE_USER = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL:
          serviceImpl.findAll((com.grpc.grpc_server.services.UserServiceProto.Empty) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.Users>) responseObserver);
          break;
        case METHODID_FIND_BY_ID:
          serviceImpl.findById((com.grpc.grpc_server.services.UserServiceProto.User) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User>) responseObserver);
          break;
        case METHODID_ADD_USER:
          serviceImpl.addUser((com.grpc.grpc_server.services.UserServiceProto.User) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User>) responseObserver);
          break;
        case METHODID_MODIFY_USER:
          serviceImpl.modifyUser((com.grpc.grpc_server.services.UserServiceProto.User) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User>) responseObserver);
          break;
        case METHODID_FIND_BY_USERNAME:
          serviceImpl.findByUsername((com.grpc.grpc_server.services.UserServiceProto.User) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User>) responseObserver);
          break;
        case METHODID_FIND_ALL_BY_TIENDA:
          serviceImpl.findAllByTienda((com.grpc.grpc_server.services.TiendaServiceProto.Tienda) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.Users>) responseObserver);
          break;
        case METHODID_DISABLE_USER:
          serviceImpl.disableUser((com.grpc.grpc_server.services.UserServiceProto.User) request,
              (io.grpc.stub.StreamObserver<com.grpc.grpc_server.services.UserServiceProto.User>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.grpc_server.services.UserServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getFindAllMethod())
              .addMethod(getFindByIdMethod())
              .addMethod(getAddUserMethod())
              .addMethod(getModifyUserMethod())
              .addMethod(getFindByUsernameMethod())
              .addMethod(getFindAllByTiendaMethod())
              .addMethod(getDisableUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}

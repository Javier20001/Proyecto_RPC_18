# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc
import warnings

import tienda_service_pb2 as tienda__service__pb2

GRPC_GENERATED_VERSION = '1.66.1'
GRPC_VERSION = grpc.__version__
_version_not_supported = False

try:
    from grpc._utilities import first_version_is_lower
    _version_not_supported = first_version_is_lower(GRPC_VERSION, GRPC_GENERATED_VERSION)
except ImportError:
    _version_not_supported = True

if _version_not_supported:
    raise RuntimeError(
        f'The grpc package installed is at version {GRPC_VERSION},'
        + f' but the generated code in tienda_service_pb2_grpc.py depends on'
        + f' grpcio>={GRPC_GENERATED_VERSION}.'
        + f' Please upgrade your grpc module to grpcio>={GRPC_GENERATED_VERSION}'
        + f' or downgrade your generated code using grpcio-tools<={GRPC_VERSION}.'
    )


class TiendaServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.FindAll = channel.unary_unary(
                '/TiendaService/FindAll',
                request_serializer=tienda__service__pb2.TiendaEmpty.SerializeToString,
                response_deserializer=tienda__service__pb2.Tiendas.FromString,
                _registered_method=True)
        self.FindById = channel.unary_unary(
                '/TiendaService/FindById',
                request_serializer=tienda__service__pb2.Tienda.SerializeToString,
                response_deserializer=tienda__service__pb2.Tienda.FromString,
                _registered_method=True)
        self.FindByCodigo = channel.unary_unary(
                '/TiendaService/FindByCodigo',
                request_serializer=tienda__service__pb2.Tienda.SerializeToString,
                response_deserializer=tienda__service__pb2.Tienda.FromString,
                _registered_method=True)
        self.FindAllTiendasHabilitadas = channel.unary_unary(
                '/TiendaService/FindAllTiendasHabilitadas',
                request_serializer=tienda__service__pb2.TiendaEmpty.SerializeToString,
                response_deserializer=tienda__service__pb2.Tiendas.FromString,
                _registered_method=True)
        self.AddTienda = channel.unary_unary(
                '/TiendaService/AddTienda',
                request_serializer=tienda__service__pb2.Tienda.SerializeToString,
                response_deserializer=tienda__service__pb2.Tienda.FromString,
                _registered_method=True)
        self.ModifyTienda = channel.unary_unary(
                '/TiendaService/ModifyTienda',
                request_serializer=tienda__service__pb2.Tienda.SerializeToString,
                response_deserializer=tienda__service__pb2.Tienda.FromString,
                _registered_method=True)
        self.DisableTienda = channel.unary_unary(
                '/TiendaService/DisableTienda',
                request_serializer=tienda__service__pb2.Tienda.SerializeToString,
                response_deserializer=tienda__service__pb2.Tienda.FromString,
                _registered_method=True)


class TiendaServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def FindAll(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindById(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindByCodigo(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def FindAllTiendasHabilitadas(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def AddTienda(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def ModifyTienda(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def DisableTienda(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_TiendaServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'FindAll': grpc.unary_unary_rpc_method_handler(
                    servicer.FindAll,
                    request_deserializer=tienda__service__pb2.TiendaEmpty.FromString,
                    response_serializer=tienda__service__pb2.Tiendas.SerializeToString,
            ),
            'FindById': grpc.unary_unary_rpc_method_handler(
                    servicer.FindById,
                    request_deserializer=tienda__service__pb2.Tienda.FromString,
                    response_serializer=tienda__service__pb2.Tienda.SerializeToString,
            ),
            'FindByCodigo': grpc.unary_unary_rpc_method_handler(
                    servicer.FindByCodigo,
                    request_deserializer=tienda__service__pb2.Tienda.FromString,
                    response_serializer=tienda__service__pb2.Tienda.SerializeToString,
            ),
            'FindAllTiendasHabilitadas': grpc.unary_unary_rpc_method_handler(
                    servicer.FindAllTiendasHabilitadas,
                    request_deserializer=tienda__service__pb2.TiendaEmpty.FromString,
                    response_serializer=tienda__service__pb2.Tiendas.SerializeToString,
            ),
            'AddTienda': grpc.unary_unary_rpc_method_handler(
                    servicer.AddTienda,
                    request_deserializer=tienda__service__pb2.Tienda.FromString,
                    response_serializer=tienda__service__pb2.Tienda.SerializeToString,
            ),
            'ModifyTienda': grpc.unary_unary_rpc_method_handler(
                    servicer.ModifyTienda,
                    request_deserializer=tienda__service__pb2.Tienda.FromString,
                    response_serializer=tienda__service__pb2.Tienda.SerializeToString,
            ),
            'DisableTienda': grpc.unary_unary_rpc_method_handler(
                    servicer.DisableTienda,
                    request_deserializer=tienda__service__pb2.Tienda.FromString,
                    response_serializer=tienda__service__pb2.Tienda.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'TiendaService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))
    server.add_registered_method_handlers('TiendaService', rpc_method_handlers)


 # This class is part of an EXPERIMENTAL API.
class TiendaService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def FindAll(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/FindAll',
            tienda__service__pb2.TiendaEmpty.SerializeToString,
            tienda__service__pb2.Tiendas.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def FindById(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/FindById',
            tienda__service__pb2.Tienda.SerializeToString,
            tienda__service__pb2.Tienda.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def FindByCodigo(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/FindByCodigo',
            tienda__service__pb2.Tienda.SerializeToString,
            tienda__service__pb2.Tienda.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def FindAllTiendasHabilitadas(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/FindAllTiendasHabilitadas',
            tienda__service__pb2.TiendaEmpty.SerializeToString,
            tienda__service__pb2.Tiendas.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def AddTienda(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/AddTienda',
            tienda__service__pb2.Tienda.SerializeToString,
            tienda__service__pb2.Tienda.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def ModifyTienda(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/ModifyTienda',
            tienda__service__pb2.Tienda.SerializeToString,
            tienda__service__pb2.Tienda.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

    @staticmethod
    def DisableTienda(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(
            request,
            target,
            '/TiendaService/DisableTienda',
            tienda__service__pb2.Tienda.SerializeToString,
            tienda__service__pb2.Tienda.FromString,
            options,
            channel_credentials,
            insecure,
            call_credentials,
            compression,
            wait_for_ready,
            timeout,
            metadata,
            _registered_method=True)

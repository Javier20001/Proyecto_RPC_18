# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# NO CHECKED-IN PROTOBUF GENCODE
# source: tienda_service.proto
# Protobuf Python Version: 5.27.2
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import runtime_version as _runtime_version
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
_runtime_version.ValidateProtobufRuntimeVersion(
    _runtime_version.Domain.PUBLIC,
    5,
    27,
    2,
    '',
    'tienda_service.proto'
)
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x14tienda_service.proto\"\r\n\x0bTiendaEmpty\"\"\n\x07Tiendas\x12\x17\n\x06tienda\x18\x01 \x03(\x0b\x32\x07.Tienda\"n\n\x06Tienda\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x0e\n\x06\x63odigo\x18\x02 \x01(\t\x12\x11\n\tprovincia\x18\x03 \x01(\t\x12\x0e\n\x06\x63iudad\x18\x04 \x01(\t\x12\x11\n\tdireccion\x18\x05 \x01(\t\x12\x12\n\nhabilitada\x18\x06 \x01(\x08\x32\x8b\x02\n\rTiendaService\x12!\n\x07\x46indAll\x12\x0c.TiendaEmpty\x1a\x08.Tiendas\x12\x1c\n\x08\x46indById\x12\x07.Tienda\x1a\x07.Tienda\x12 \n\x0c\x46indByCodigo\x12\x07.Tienda\x1a\x07.Tienda\x12\x33\n\x19\x46indAllTiendasHabilitadas\x12\x0c.TiendaEmpty\x1a\x08.Tiendas\x12\x1d\n\tAddTienda\x12\x07.Tienda\x1a\x07.Tienda\x12 \n\x0cModifyTienda\x12\x07.Tienda\x1a\x07.Tienda\x12!\n\rDisableTienda\x12\x07.Tienda\x1a\x07.TiendaB3\n\x1d\x63om.grpc.grpc_server.servicesB\x12TiendaServiceProtob\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'tienda_service_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  _globals['DESCRIPTOR']._loaded_options = None
  _globals['DESCRIPTOR']._serialized_options = b'\n\035com.grpc.grpc_server.servicesB\022TiendaServiceProto'
  _globals['_TIENDAEMPTY']._serialized_start=24
  _globals['_TIENDAEMPTY']._serialized_end=37
  _globals['_TIENDAS']._serialized_start=39
  _globals['_TIENDAS']._serialized_end=73
  _globals['_TIENDA']._serialized_start=75
  _globals['_TIENDA']._serialized_end=185
  _globals['_TIENDASERVICE']._serialized_start=188
  _globals['_TIENDASERVICE']._serialized_end=455
# @@protoc_insertion_point(module_scope)

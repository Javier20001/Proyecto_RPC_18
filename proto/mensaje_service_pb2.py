# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# NO CHECKED-IN PROTOBUF GENCODE
# source: mensaje_service.proto
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
    'mensaje_service.proto'
)
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x15mensaje_service.proto\"!\n\x0eMensajeRequest\x12\x0f\n\x07mensaje\x18\x01 \x01(\t\"$\n\x0fMensajeResponse\x12\x11\n\trespuesta\x18\x01 \x01(\t2D\n\x0eMensajeService\x12\x32\n\renviarMensaje\x12\x0f.MensajeRequest\x1a\x10.MensajeResponseB4\n\x1d\x63om.grpc.grpc_server.servicesB\x13MensajeServiceProtob\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'mensaje_service_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  _globals['DESCRIPTOR']._loaded_options = None
  _globals['DESCRIPTOR']._serialized_options = b'\n\035com.grpc.grpc_server.servicesB\023MensajeServiceProto'
  _globals['_MENSAJEREQUEST']._serialized_start=25
  _globals['_MENSAJEREQUEST']._serialized_end=58
  _globals['_MENSAJERESPONSE']._serialized_start=60
  _globals['_MENSAJERESPONSE']._serialized_end=96
  _globals['_MENSAJESERVICE']._serialized_start=98
  _globals['_MENSAJESERVICE']._serialized_end=166
# @@protoc_insertion_point(module_scope)

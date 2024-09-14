import sys
import grpc
import tienda_pb2
import tienda_pb2_grpc

class TiendaClient:
    def __init__(self, channel):
        self.stub = tienda_pb2_grpc.TiendaServiceStub(channel)

    def get_all_tiendas(self):
        tienda_empty_request = tienda_pb2.TiendaEmpty()
        response = self.stub.FindAll(tienda_empty_request)
        return response

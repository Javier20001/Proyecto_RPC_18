import grpc
import tienda_service_pb2
import tienda_service_pb2_grpc

class TiendaClient:
    def __init__(self, channel):
        self.stub = tienda_service_pb2_grpc.TiendaServiceStub(channel)

    def find_all(self):
        """Obtiene todas las tiendas"""
        try:
            response = self.stub.FindAll(tienda_service_pb2.TiendaEmpty())
            for tienda in response.tienda:
                print(f"Tienda: ID={tienda.id}, Código={tienda.codigo}, Provincia={tienda.provincia}, Ciudad={tienda.ciudad}, Dirección={tienda.direccion}, Habilitada={tienda.habilitada}")

            return response
        except grpc.RpcError as e:
            print(f"Error al obtener tiendas: {e.details()}")

    def find_by_id(self, tienda_id):
        """Busca una tienda por su ID"""
        try:
            tienda_request = tienda_service_pb2.Tienda(id=tienda_id)
            response = self.stub.FindById(tienda_request)
            print(f"Tienda encontrada: ID={response.id}, Código={response.codigo}, Provincia={response.provincia}, Ciudad={response.ciudad}, Dirección={response.direccion}, Habilitada={response.habilitada}")

            return response
        except grpc.RpcError as e:
            print(f"Error al obtener la tienda por ID: {e.details()}")

    def find_by_codigo(self, codigo):
        """Busca una tienda por su código"""
        try:
            tienda_request = tienda_service_pb2.Tienda(codigo=codigo)
            response = self.stub.FindByCodigo(tienda_request)
            print(f"Tienda encontrada: ID={response.id}, Código={response.codigo}, Provincia={response.provincia}, Ciudad={response.ciudad}, Dirección={response.direccion}, Habilitada={response.habilitada}")

            return response
        except grpc.RpcError as e:
            print(f"Error al obtener la tienda por código: {e.details()}")

    def find_all_tiendas_habilitadas(self):
        """Lista todas las tiendas habilitadas"""
        try:
            response = self.stub.FindAllTiendasHabilitadas(tienda_service_pb2.TiendaEmpty())

            for tienda in response.tienda:
                print(f"Tienda habilitada: ID={tienda.id}, Código={tienda.codigo}, Provincia={tienda.provincia}, Ciudad={tienda.ciudad}, Dirección={tienda.direccion}")

                return response
        except grpc.RpcError as e:
            print(f"Error al listar las tiendas habilitadas: {e.details()}")

    def add_tienda(self, codigo, provincia, ciudad, direccion, habilitada):
        """Agrega una nueva tienda"""
        try:
            new_tienda = tienda_service_pb2.Tienda(
                codigo=codigo,
                provincia=provincia,
                ciudad=ciudad,
                direccion=direccion,
                habilitada=True
            )
            response = self.stub.AddTienda(new_tienda)
            print(f"Tienda añadida: ID={response.id}, Código={response.codigo}, Provincia={response.provincia}, Ciudad={response.ciudad}, Dirección={response.direccion}, Habilitada={response.habilitada}")

            return response
        except grpc.RpcError as e:
            print(f"Error al agregar la tienda: {e.details()}")
            

    def modify_tienda(self, tienda_id, codigo, provincia, ciudad, direccion, habilitada):
        """Modifica una tienda existente"""
        try:
            tienda = tienda_service_pb2.Tienda(
                id=tienda_id,
                codigo=codigo,
                provincia=provincia,
                ciudad=ciudad,
                direccion=direccion,
                habilitada=habilitada
            )
            response = self.stub.ModifyTienda(tienda)
            print(f"Tienda modificada: ID={response.id}, Código={response.codigo}, Provincia={response.provincia}, Ciudad={response.ciudad}, Dirección={response.direccion}, Habilitada={response.habilitada}")

            return response
        except grpc.RpcError as e:
            print(f"Error al modificar la tienda: {e.details()}")

    def disable_tienda(self, tienda_id):
        """Deshabilita una tienda"""
        try:
            tienda = tienda_service_pb2.Tienda(id=tienda_id)
            response = self.stub.DisableTienda(tienda)
            print(f"Tienda deshabilitada: ID={response.id}, Código={response.codigo}")

            return response
        except grpc.RpcError as e:
            print(f"Error al deshabilitar la tienda: {e.details()}")

    def close(self):
        """Cierra el canal gRPC"""
        self.channel.close()



       

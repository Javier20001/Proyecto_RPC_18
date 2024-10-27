import grpc 
import login_service_pb2
import login_service_pb2_grpc

class LoginClient:
    def __init__(self, channel):
        # Crear un stub del servicio LoginService
        self.stub = login_service_pb2_grpc.LoginServiceStub(channel)

    def login(self, username, password):
        # Crear la solicitud de login
        login_request = login_service_pb2.LoginRequest(
            username=username,
            password=password
        )
        try:
            # Llamar al método Login del servidor
            response = self.stub.Login(login_request)
            print(f"Login message: {response.message}")
            print(f"User role: {response.role}")
            print(f"User ID: {response.id}")
            print(f"Tienda ID: {response.idTienda}")
            return response
        except grpc.RpcError as e:
            print(f"Error durante el login: {e.details()}")
            return None
def close(self):
        """Cierra el canal gRPC"""
        self.channel.close()

import grpc
import login_pb2
import login_pb2_grpc

def run():
    # Crear un canal para conectarse al servidor gRPC
    with grpc.insecure_channel('localhost:9090') as channel:
        # Crear un stub (cliente) del servicio LoginService
        stub = login_pb2_grpc.LoginServiceStub(channel)

        # Crear una solicitud de login con username y password
        request = login_pb2.LoginRequest(username="admin", password="admin")

        try:
            # Hacer la solicitud al servidor
            response = stub.Login(request)
            print(f"Mensaje: {response.message}")
            if response.message == "Login exitoso":
                print(f"Rol: {response.role}")
                print(f"ID: {response.id}")
        except grpc.RpcError as e:
            print(f"gRPC error: {e.details()}")

if __name__ == '__main__':
    run()

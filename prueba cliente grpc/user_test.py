import grpc
import user_pb2
import user_pb2_grpc

def print_user(user):
    print(f"ID: {user.id}, Username: {user.username}, Nombre: {user.nombre}, Apellido: {user.apellido}, Habilitado: {user.habilitado}, Rol: {user.rol}")
    if user.HasField('tienda'):
        tienda = user.tienda
        print(f"Tienda ID: {tienda.id}, Codigo: {tienda.codigo}, Provincia: {tienda.provincia}, Ciudad: {tienda.ciudad}, Direccion: {tienda.direccion}, Habilitada: {tienda.habilitada}")

def run():
    # Conexión con el servidor gRPC
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = user_pb2_grpc.UserServiceStub(channel)

        # Prueba del método FindAll
        try:
            response = stub.FindAll(user_pb2.Empty())
            print("FindAll response:")
            for user in response.user:
                print_user(user)
        except grpc.RpcError as e:
            print(f"FindAll error: {e}")

        # Prueba del método FindById
        user_id = 3  # Cambia el ID según sea necesario
        try:
            response = stub.FindById(user_pb2.User(id=user_id))
            print("\nFindById response:")
            print_user(response)
        except grpc.RpcError as e:
            print(f"FindById error: {e}")

if __name__ == '__main__':
    run()

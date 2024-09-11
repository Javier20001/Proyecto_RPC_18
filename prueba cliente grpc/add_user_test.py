import grpc
import user_pb2
import user_pb2_grpc
import tienda_pb2

def print_user(user):
    print(f"ID: {user.id}, Username: {user.username}, Nombre: {user.nombre}, Apellido: {user.apellido}, Habilitado: {user.habilitado}, Rol: {user.rol}")
    if user.HasField('tienda'):
        tienda = user.tienda
        print(f"Tienda ID: {tienda.id}, Codigo: {tienda.codigo}, Provincia: {tienda.provincia}, Ciudad: {tienda.ciudad}, Direccion: {tienda.direccion}, Habilitada: {tienda.habilitada}")

def run():
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = user_pb2_grpc.UserServiceStub(channel)

        # Prueba del método AddUser
        tienda = tienda_pb2.Tienda(id=2)  # Cambia el ID según sea necesario
        request = user_pb2.User(
            username="prueba6username",
            password="prueba6username",
            tienda=tienda,
            nombre="prueba6nombre",
            apellido="prueba6apellido",
            habilitado=True,
            rol="TIENDA"
        )
        try:
            response = stub.AddUser(request)
            print("\nAddUser response:")
            print_user(response)
        except grpc.RpcError as e:
            print(f"AddUser error: {e}")

if __name__ == '__main__':
    run()

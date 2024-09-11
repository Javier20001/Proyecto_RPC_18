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

        # Prueba del método find_by_username
        request = user_pb2.User(
            username="user1",
        )
        try:
            response = stub.FindByUsername(request)
            print("\find_by_username response:")
            print_user(response)
        except grpc.RpcError as e:
            print(f"find_by_username error: {e}")

        # Prueba del método findAllByTienda
        #tienda = tienda_pb2.Tienda(id=1)
        request = tienda=tienda_pb2.Tienda(
                id=1
            )
        try:
            response = stub.FindAllByTienda(request)
            print("\findAllByTienda response:")
            for user in response.user:
                print(f"ID: {user.id}, Username: {user.username}, Nombre: {user.nombre}, Apellido: {user.apellido}, Habilitado: {user.habilitado}, Rol: {user.rol}")
        except grpc.RpcError as e:
            print(f"findAllByTienda error: {e}")

        # Prueba del método disableUser
        #tienda = tienda_pb2.Tienda(id=1)
        request = user_pb2.User(
            id=3,
        )
        try:
            response = stub.DisableUser(request)
            print("\disableUser response:")
            print_user(response)
        except grpc.RpcError as e:
            print(f"disableUser error: {e}")

        # Prueba del método modifyUser
        #tienda = tienda_pb2.Tienda(id=1)
        request = user_pb2.User(
            id=4,
            tienda=tienda_pb2.Tienda(
                id=1
            ),
            password="modificada",
            nombre="modificada"
        )
        try:
            response = stub.ModifyUser(request)
            print("\ModifyUser response:")
            print_user(response)
        except grpc.RpcError as e:
            print(f"ModifyUser error: {e}")

if __name__ == '__main__':
    run()

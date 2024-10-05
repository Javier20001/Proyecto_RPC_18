import grpc
import user_service_pb2
import user_service_pb2_grpc
import tienda_service_pb2

class UserClient:
    def __init__(self, channel):
        # Crear un stub para el servicio UserService
        self.stub = user_service_pb2_grpc.UserServiceStub(channel)

    def find_all(self):
        # Crear una solicitud vacía
        empty_request = user_service_pb2.Empty()
        try:
            # Llamar al método FindAll del servidor
            response = self.stub.FindAll(empty_request)
            for user in response.user:
                print(f"ID: {user.id}, Username: {user.username}, Nombre: {user.nombre}, Rol: {user.rol}")
            return response
        except grpc.RpcError as e:
            print(f"Error en FindAll: {e.details()}")

    def find_by_id(self, user_id):
        # Crear la solicitud para buscar un usuario por ID
        user_request = user_service_pb2.User(id=user_id)
        try:
            response = self.stub.FindById(user_request)
            print(f"ID: {response.id}, Username: {response.username}, Nombre: {response.nombre}, Rol: {response.rol}")
            return response 
        except grpc.RpcError as e:
            print(f"Error en FindById: {e.details()}")

    def add_user(self, username, password, tienda_id, nombre, apellido, habilitado, rol):
        try:
        
        # Crear una tienda asociada (parte del user_service_pb2)
            tienda = tienda_service_pb2.Tienda(id=tienda_id)
        # Crear la solicitud de usuario
            new_user = user_service_pb2.User(
                username=username,
                password=password,
                tienda=tienda,
                nombre=nombre,
                apellido=apellido,
                habilitado=True,
                rol=rol
        )
        
            # Llamar al método AddUser del servidor
            response = self.stub.AddUser(new_user)
            print(f"Usuario añadido: ID: {response.id}, Username: {response.username}")
            
            return response
        except grpc.RpcError as e:
            print(f"Error en AddUser: {e.details()}")

    def disable_user(self, user_id):
        # Crear la solicitud para deshabilitar un usuario
        user_request = user_service_pb2.User(id=user_id)
        try:
            # Llamar al método DisableUser del servidor
            response = self.stub.DisableUser(user_request)
            print(f"Usuario deshabilitado: ID: {response.id}, Habilitado: {response.habilitado}")
            return response
        except grpc.RpcError as e:
            print(f"Error en DisableUser: {e.details()}")

    # Nuevo método para modificar un usuario
    def modify_user(self, user_id, username, password, tienda_id, nombre, apellido, habilitado, rol):
        try:
        # Crear una tienda asociada (parte del user_service_pb2)
            tienda = tienda_service_pb2.Tienda(id=tienda_id)
            # Crear la solicitud de usuario a modificar
            modified_user = user_service_pb2.User(
                id=int(user_id),
                username=username,
                password=password,
                tienda=tienda,
                nombre=nombre,
                apellido=apellido,
                habilitado=habilitado,
                rol=rol
            )
       
            # Llamar al método ModifyUser del servidor
            response = self.stub.ModifyUser(modified_user)
            print(f"Usuario modificado: ID: {response.id}, Username: {response.username}")

            return response
        except grpc.RpcError as e:
            print(f"Error en ModifyUser: {e.details()}")

    # Nuevo método para buscar usuario por nombre de usuario
    def find_by_username(self, username):
        # Crear la solicitud para buscar un usuario por su nombre de usuario
        user_request = user_service_pb2.User(username=username)
        try:
            # Llamar al método FindByUsername del servidor
            response = self.stub.FindByUsername(user_request)
            print(f"ID: {response.id}, Username: {response.username}, Nombre: {response.nombre}, Rol: {response.rol}")
            return response
        except grpc.RpcError as e:
            print(f"Error en FindByUsername: {e.details()}")

    # Nuevo método para encontrar todos los usuarios de una tienda
    def find_all_by_tienda(self, tienda_id):
        # Crear la solicitud para buscar todos los usuarios de una tienda
        tienda_request = tienda_service_pb2.Tienda(id=tienda_id)
        try:
            # Llamar al método FindAllByTienda del servidor
            response = self.stub.FindAllByTienda(tienda_request)
            for user in response.user:
                print(f"ID: {user.id}, Username: {user.username}, Nombre: {user.nombre}, Rol: {user.rol}")

                return response
        except grpc.RpcError as e:
            print(f"Error en FindAllByTienda: {e.details()}")



    





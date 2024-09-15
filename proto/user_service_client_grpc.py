import grpc
import user_service_pb2
import user_service_pb2_grpc
import tienda_service_pb2

# Función para listar todos los usuarios
def find_all_users(stub):
    try:
        response = stub.FindAll(user_service_pb2.Empty())
        print("Usuarios encontrados:")
        for user in response.user:
            print(f"ID: {user.id}, Username: {user.username}, Tienda: {user.tienda.codigo}")
    except grpc.RpcError as e:
        print(f"Error al obtener usuarios: {e.details()}")

# Función para encontrar un usuario por ID
def find_user_by_id(stub, user_id):
    try:
        user = user_service_pb2.User(id=user_id)
        response = stub.FindById(user)
        print(f"Usuario encontrado: ID: {response.id}, Username: {response.username}")
    except grpc.RpcError as e:
        print(f"Error al obtener usuario por ID: {e.details()}")

# Función para agregar un nuevo usuario
def add_user(stub, username, password, tienda_codigo, nombre, apellido, rol):
    try:
        # Creando el objeto Tienda
        tienda = tienda_service_pb2.Tienda(codigo=tienda_codigo)
        
        # Creando el objeto User
        new_user = user_service_pb2.User(
            username=username,
            password=password,
            tienda=tienda,
            nombre=nombre,
            apellido=apellido,
            habilitado=True,
            rol=rol
        )
        
        # Llamando al RPC AddUser
        response = stub.AddUser(new_user)
        print(f"Usuario añadido: ID: {response.id}, Username: {response.username}")
    except grpc.RpcError as e:
        print(f"Error al agregar usuario: {e.details()}")

# Función principal del cliente
def run():
    # Dirección y puerto del servidor gRPC
    channel = grpc.insecure_channel('localhost:9090')
    
    # Crear stub para interactuar con el servicio
    stub = user_service_pb2_grpc.UserServiceStub(channel)
    
    # Ejemplo de uso de las funciones
    print("Listando todos los usuarios:")
    find_all_users(stub)
    
    print("\nBuscando usuario por ID (1):")
    find_user_by_id(stub, 1)
    
    print("\nAgregando nuevo usuario:")
    add_user(stub, "nuevo_usuario", "password123", "T001", "Juan", "Perez", "admin")

if __name__ == "__main__":
    run()

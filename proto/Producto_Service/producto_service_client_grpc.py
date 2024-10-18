import grpc
import producto_service_pb2
import producto_service_pb2_grpc

class ProductoClient:
    def __init__(self, channel):
        self.stub = producto_service_pb2_grpc.ProductoServiceStub(channel)

    def find_all(self):
        """Recupera todos los productos"""
        try:
            # Crear un objeto vacío para la solicitud (si es necesario)
            request = producto_service_pb2.ProductoEmpty()
            
            # Llamar al método FindAll del servidor gRPC
            response = self.stub.FindAll(request)
            
            # Devolver la respuesta del servidor (que debería ser una lista de productos)
            return response
        except grpc.RpcError as e:
            print(f"Error en FindAllProductos: {e.details()}")
            return None

    def find_by_id(self, producto_id):
        """Recupera un producto por su ID"""
        try:
            # Crear la solicitud para el producto por ID
            producto_request = producto_service_pb2.Producto(id=producto_id)
            
            # Llamar al método FindById del servidor gRPC
            response = self.stub.FindById(producto_request)
            
            # Devolver la respuesta del servidor
            return response
        except grpc.RpcError as e:
            print(f"Error en FindByIdProducto: {e.details()}")
            return None


    def find_by_codigo(self, codigo):
        """Recupera un producto por su código"""
        try:
            # Crear la solicitud para el producto por código
            producto_request = producto_service_pb2.Producto(codigo=codigo)
            
            # Llamar al método FindByCodigo del servidor gRPC
            response = self.stub.FindByCodigo(producto_request)
            
            # Devolver la respuesta del servidor
            return response
        except grpc.RpcError as e:
            print(f"Error en FindByCodigoProducto: {e.details()}")
            return None


    def find_by_nombre(self, nombre):
        """Busca un producto por Nombre"""
        try:
            request = producto_service_pb2.Producto(nombre=nombre)
            response = self.stub.FindByNombre(request)
            producto = {
                'id': response.id,
                'nombre': response.nombre,
                'codigo': response.codigo,
                'foto': response.foto
            }
            print(f"Producto encontrado: {producto}")
            return producto
        except grpc.RpcError as e:
            print(f"Error al obtener el producto por nombre: {e.details()}")
            return None

    def add_producto(self, nombre, codigo, foto):
        try:
            # Crear un objeto Producto para la solicitud
            nuevo_producto = producto_service_pb2.Producto(
                nombre=nombre,
                codigo=codigo,
                foto=foto
            )
            
            # Hacer la solicitud al servidor gRPC
            response = self.stub.AddProducto(nuevo_producto)
            
            # Comprobar que la respuesta sea un objeto Producto
            if isinstance(response, producto_service_pb2.Producto):
                return response
            else:
                raise ValueError("Unexpected response type")
        
        except grpc.RpcError as e:
            print(f"Error al agregar el producto: {e.details()}")
            return None

    def modify_producto(self, producto_id, nombre, codigo, foto):
        """Modifica un producto existente"""
        try:
            # Crear un objeto Producto para enviar al servidor
            producto = producto_service_pb2.Producto(
                id=producto_id,
                nombre=nombre,
                codigo=codigo,
                foto=foto
            )
            
            # Llamar al método ModifyProducto en el servidor gRPC
            response = self.stub.ModifyProducto(producto)
            
            # Devolver la respuesta del servidor gRPC
            return response
        except grpc.RpcError as e:
            print(f"Error en ModifyProducto: {e.details()}")
            return None

        
    def close(self):
        """Cierra el canal gRPC"""
        self.channel.close()


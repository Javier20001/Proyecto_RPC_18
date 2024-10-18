import grpc
# En Tienda_Service/tienda_service_client_grpc.py
import sys
import os

# Asegúrate de agregar el directorio raíz a sys.path
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '../Tienda_Service')))

import tienda_service_pb2
import producto_manager_pb2
import producto_manager_pb2_grpc
import producto_service_pb2 # Importación directa


class ProductoManagerClient:
    def __init__(self, channel):
        self.stub = producto_manager_pb2_grpc.ProductoManagerServiceStub(channel)

    def find_by_id(self, producto_id, tienda_id):
        """Busca un producto en una tienda por su ID"""
        try:
            request = producto_manager_pb2.ProductoEnTienda(
                id=producto_id,
                tienda=producto_manager_pb2.Tienda(id=tienda_id)
            )
            response = self.stub.FindById(request)
            print(f"Producto encontrado: ID={response.id}, Stock={response.stock}, Talle={response.talle}, Color={response.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al buscar producto por ID: {e.details()}")

    def find_all(self):
        """Obtiene todos los productos en tiendas"""
        try:
            response = self.stub.FindAll(producto_manager_pb2.ProductoManagerEmpty())
            for producto in response.productoEnTienda:
                print(f"Producto: ID={producto.id}, Stock={producto.stock}, Talle={producto.talle}, Color={producto.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al obtener productos: {e.details()}")

    def find_all_by_producto_id(self, producto_id):
        """Obtiene todos los productos en tiendas por el ID del producto"""
        try:
            request = producto_service_pb2.Producto(id=producto_id)
            response = self.stub.FindAllByProductoId(request)
            for producto in response.productoEnTienda:
                print(f"Producto en tienda: ID={producto.id}, Stock={producto.stock}, Talle={producto.talle}, Color={producto.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al obtener productos por ID de producto: {e.details()}")

    def find_all_by_tienda_id(self, tienda_id):
        """Obtiene todos los productos en una tienda por el ID de la tienda"""
        try:
            request = tienda_service_pb2.Tienda(id=tienda_id)
            response = self.stub.FindAllByTiendaId(request)
            for producto in response.productoEnTienda:
                print(f"Producto en tienda: ID={producto.id}, Stock={producto.stock}, Talle={producto.talle}, Color={producto.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al obtener productos por ID de tienda: {e.details()}")

    def find_all_by_custom_filter(self, nombre, codigo, talle, color, tienda_id):
        """Obtiene productos según un filtro personalizado"""
        try:
            request = producto_manager_pb2.CustomFilter(
                nombre=nombre,
                codigo=codigo,
                talle=talle,
                color=color,
                tienda=tienda_service_pb2.Tienda(id=tienda_id)
            )
            response = self.stub.FindAllByCustomFilter(request)
            for producto in response.productoEnTienda:
                print(f"Producto filtrado: ID={producto.id}, Stock={producto.stock}, Talle={producto.talle}, Color={producto.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al obtener productos por filtro: {e.details()}")

    def assign_producto_to_tienda(self, producto_id, nombre, codigo, foto, talle, color, tienda_id):
        """Asigna un producto a una tienda"""
        try:
            producto_base = producto_manager_pb2.ProductoBase(
                id=producto_id,
                nombre=nombre,
                codigo=codigo,
                foto=foto,
                talle=talle,
                color=color
            )
            request = producto_manager_pb2.AssignToTiendaMessage(
                productoBase=producto_base,
                tienda=tienda_service_pb2.Tienda(id=tienda_id)
            )
            response = self.stub.AssingProductoToTienda(request)
            print(f"Producto asignado: {response.message}")
            return response
        except grpc.RpcError as e:
            print(f"Error al asignar producto a tienda: {e.details()}")

    def add_producto(self, nombre, codigo, foto, talle, color):
        """Agrega un nuevo producto"""
        try:
            producto_base = producto_manager_pb2.ProductoBase(
                nombre=nombre,
                codigo=codigo,
                foto=foto,
                talle=talle,
                color=color
            )
            response = self.stub.AddProducto(producto_base)
            print(f"Producto añadido: ID={response.id}, Stock={response.stock}, Talle={response.talle}, Color={response.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al agregar producto: {e.details()}")

    def modify_producto(self, producto_id, nombre, codigo, foto, talle, color):
        """Modifica un producto existente"""
        try:
            producto_base = producto_manager_pb2.ProductoBase(
                id=producto_id,
                nombre=nombre,
                codigo=codigo,
                foto=foto,
                talle=talle,
                color=color
            )
            response = self.stub.ModifyProducto(producto_base)
            print(f"Producto modificado: ID={response.id}, Stock={response.stock}, Talle={response.talle}, Color={response.color}")
            return response
        except grpc.RpcError as e:
            print(f"Error al modificar producto: {e.details()}")

    def modify_stock(self, producto_id, tienda_id, stock, talle, color):
        """Modifica el stock de un producto en una tienda"""
        try:
            producto_en_tienda = producto_manager_pb2.ProductoEnTienda(
                id=producto_id,
                tienda=tienda_service_pb2.Tienda(id=tienda_id),
                stock=stock,
                talle=talle,
                color=color
            )
            response = self.stub.ModifyStock(producto_en_tienda)
            print(f"Stock modificado: ID={response.id}, Stock={response.stock}")
            return response
        except grpc.RpcError as e:
            print(f"Error al modificar stock: {e.details()}")

    def close(self):
        """Cierra el canal gRPC"""
        self.channel.close()

import sys
import grpc
from flask import Flask, jsonify, request
from tienda_service_client_grpc import TiendaClient
from user_service_client_grpc import UserClient 
from producto_service_client_grpc import ProductoClient 
from producto_manager_service_client_grpc import ProductoManagerClient
import tienda_service_pb2
import user_service_pb2





app = Flask(__name__)


channel = grpc.insecure_channel('localhost:9090')
tiendaclient = TiendaClient(channel)
user_client = UserClient(channel)
productoclient = ProductoClient(channel)


@app.route('/tiendas', methods=['GET'])
def gettiendas():
    try:
        # Obtener todas las tiendas usando el cliente gRPC
        tiendas_response = tiendaclient.find_all()
        # Formatear la respuesta para el frontend
        tiendas_list = [{
            'id': tienda.id,
            'codigo': tienda.codigo,
            'provincia': tienda.provincia,
            'ciudad': tienda.ciudad,
            'direccion': tienda.direccion,
            'habilitada': tienda.habilitada
        } for tienda in tiendas_response.tienda]

        return jsonify(tiendas_list)
    except Exception as e:
        return jsonify({'error': str(e)}), 500
    
#---------------------------------------------------------------------------------------------------------------------

@app.route('/tiendas/<int:tienda_id>', methods=['GET'])
def get_tienda_by_id(tienda_id):
    try:
        # Llamar al método gRPC para buscar la tienda por ID
        response = tiendaclient.find_by_id(tienda_id)
        
        # Si se encuentra la tienda, devolver los detalles
        if response:
            tienda_data = {
                'id': response.id,
                'codigo': response.codigo,
                'provincia': response.provincia,
                'ciudad': response.ciudad,
                'direccion': response.direccion,
                'habilitada': response.habilitada
            }
            return jsonify(tienda_data)
        else:
            return jsonify({'error': 'Tienda no encontrada'}), 404
    except grpc.RpcError as e:
        return jsonify({'error': str(e.details())}), 500
    
#---------------------------------------------------------------------------------------------------------------------

@app.route('/tiendas/codigo/<string:codigo>', methods=['GET'])
def get_tienda_by_codigo(codigo):
    try:
        # Llamar al método gRPC para buscar la tienda por código
        response = tiendaclient.find_by_codigo(codigo)
        
        # Si se encuentra la tienda, devolver los detalles
        if response:
            tienda_data = {
                'id': response.id,
                'codigo': response.codigo,
                'provincia': response.provincia,
                'ciudad': response.ciudad,
                'direccion': response.direccion,
                'habilitada': response.habilitada
            }
            return jsonify(tienda_data)
        else:
            return jsonify({'error': 'Tienda no encontrada'}), 404
    except grpc.RpcError as e:
        return jsonify({'error': str(e.details())}), 500
    
#---------------------------------------------------------------------------------------------------------------------
@app.route('/tiendas/habilitadas', methods=['GET'])
def get_tiendas_habilitadas():
    try:
        # Obtener todas las tiendas habilitadas usando el cliente gRPC
        tiendas_response = tiendaclient.find_all_tiendas_habilitadas()
        # Formatear la respuesta para el frontend
        tiendas_list = [{
            'id': tienda.id,
            'codigo': tienda.codigo,
            'provincia': tienda.provincia,
            'ciudad': tienda.ciudad,
            'direccion': tienda.direccion,
            'habilitada': tienda.habilitada
        } for tienda in tiendas_response.tienda]

        return jsonify(tiendas_list)
    except Exception as e:
        return jsonify({'error': str(e)}), 500

#---------------------------------------------------------------------------------------------------------------------
@app.route('/tiendas', methods=['POST'])
def add_tienda():
    try:
        # Obtener los datos de la nueva tienda desde el cuerpo de la solicitud
        data = request.get_json()
        
        codigo = data.get('codigo')
        provincia = data.get('provincia')
        ciudad = data.get('ciudad')
        direccion = data.get('direccion')
        habilitada = data.get('habilitada')
        
        
        # Llamar al método AddTienda del servicio gRPC
        response = tiendaclient.add_tienda(codigo, provincia, ciudad, direccion, habilitada)
        
        # Devolver la respuesta de la tienda añadida
        return jsonify({
            'id': response.id,
            'codigo': response.codigo,
            'provincia': response.provincia,
            'ciudad': response.ciudad,
            'direccion': response.direccion,
            'habilitada': response.habilitada
        }), 201
    except Exception as e:
        return jsonify({'error': str(e)}), 500
    
#---------------------------------------------------------------------------------------------------------------------
    
@app.route('/tiendas/<int:tienda_id>', methods=['PUT'])
def update_tienda(tienda_id):
    data = request.json
    try:
        # Obtener los datos necesarios de la solicitud
        codigo = data.get('codigo')
        provincia = data.get('provincia')
        ciudad = data.get('ciudad')
        direccion = data.get('direccion')
        habilitada = data.get('habilitada')
        
        # Llamar al método ModifyTienda del cliente gRPC
        response = tiendaclient.modify_tienda(tienda_id, codigo, provincia, ciudad, direccion, habilitada)
        
        if response:
            return jsonify({
                'id': response.id,
                'codigo': response.codigo,
                'provincia': response.provincia,
                'ciudad': response.ciudad,
                'direccion': response.direccion,
                'habilitada': response.habilitada
            })
        else:
            return jsonify({'error': 'No se pudo actualizar la tienda'}), 500
    except grpc.RpcError as e:
        return jsonify({'error': str(e.details())}), 500
    
#--------------------------------------------------------------------------------------------------------------------
    
@app.route('/tiendas/<int:tienda_id>/disable', methods=['DELETE'])
def delete_tienda(tienda_id):
    try:
        # Llamar al método gRPC para deshabilitar la tienda
        response = tiendaclient.disable_tienda(tienda_id)
        
        # Verificar si la tienda fue deshabilitada correctamente
        if response:
            return jsonify({
                'id': response.id,
                'codigo': response.codigo,
                'provincia': response.provincia,
                'ciudad': response.ciudad,
                'direccion': response.direccion,
                'habilitada': response.habilitada
            })
        else:
            return jsonify({'error': 'No se pudo deshabilitar la tienda'}), 500
    except grpc.RpcError as e:
        return jsonify({'error': str(e.details())}), 500



#---------------------------------------------------------------------------------------------------------------------------

#Agregar producto

@app.route('/productos', methods=['POST'])
def add_producto():
    try:
        # Obtener los datos del cuerpo de la solicitud
        data = request.json
        
        nombre = data.get('nombre')
        codigo = data.get('codigo')
        foto = data.get('foto')
        
        # Validar que todos los datos necesarios estén presentes
        if not all([nombre, codigo, foto]):
            return jsonify({'error': 'Nombre, código y foto son requeridos'}), 400
        
        # Llamar al método AddProducto del cliente gRPC
        response = productoclient.add_producto(nombre, codigo, foto)
        
        if response:
            # Acceder a los atributos del objeto response
            return jsonify({
                'id': response.id,
                'nombre': response.nombre,
                'codigo': response.codigo,
                'foto': response.foto
            }), 201
        else:
            return jsonify({'error': 'Unable to add producto'}), 500
    except Exception as e:
        return jsonify({'error': str(e)}), 500

#----------------------------------------------------------------------------------------------------------------------

#modificar producto

@app.route('/productos/<int:producto_id>', methods=['PUT'])
def update_producto(producto_id):
    try:
        # Obtener los datos del cuerpo de la solicitud
        data = request.json
        
        nombre = data.get('nombre')
        codigo = data.get('codigo')
        foto = data.get('foto')
        
        # Validar que todos los datos necesarios estén presentes
        if not all([nombre, codigo, foto]):
            return jsonify({'error': 'Nombre, código y foto son requeridos'}), 400
        
        # Llamar al método ModifyProducto del cliente gRPC
        response = productoclient.modify_producto(producto_id, nombre, codigo, foto)
        
        if response:
            # Acceder a los atributos del objeto response
            return jsonify({
                'id': response.id,
                'nombre': response.nombre,
                'codigo': response.codigo,
                'foto': response.foto
            }), 200  # Devuelve 200 OK para una actualización exitosa
        else:
            return jsonify({'error': 'Unable to update producto'}), 500
    except Exception as e:
        return jsonify({'error': str(e)}), 500

#--------------------------------------------------------------------------------------------------------------------------

#Traer todos los productos

@app.route('/productos', methods=['GET'])
def find_all_productos():
    try:
        # Llamar al método find_all del cliente gRPC para obtener todos los productos
        productos_response = productoclient.find_all()
        
        # Formatear la respuesta para el frontend
        productos_list = [{
            'id': producto.id,
            'nombre': producto.nombre,
            'codigo': producto.codigo,
            'foto': producto.foto
        } for producto in productos_response.producto]  # Asumiendo que 'producto' es una lista en 'productos_response'

        # Devolver la lista de productos en formato JSON
        return jsonify(productos_list), 200
    except Exception as e:
        return jsonify({'error': str(e)}), 500
#-----------------------------------------------------------------------------------------------------------------------------

#Traer producto por ID

@app.route('/productos/<int:producto_id>', methods=['GET'])
def find_producto_by_id(producto_id):
    try:
        # Llamar al método find_by_id del cliente gRPC para obtener el producto
        producto_response = productoclient.find_by_id(producto_id)
        
        if producto_response:
            # Formatear la respuesta del producto
            return jsonify({
                'id': producto_response.id,
                'nombre': producto_response.nombre,
                'codigo': producto_response.codigo,
                'foto': producto_response.foto
            }), 200
        else:
            return jsonify({'error': 'Producto no encontrado'}), 404
    except Exception as e:
        return jsonify({'error': str(e)}), 500

#-----------------------------------------------------------------------------------------------------------------------------

#Traer producto por codigo

@app.route('/productos/codigo/<string:codigo>', methods=['GET'])
def find_producto_by_codigo(codigo):
    try:
        # Llamar al método find_by_codigo del cliente gRPC para obtener el producto
        producto_response = productoclient.find_by_codigo(codigo)
        
        if producto_response:
            # Formatear la respuesta del producto
            return jsonify({
                'id': producto_response.id,
                'nombre': producto_response.nombre,
                'codigo': producto_response.codigo,
                'foto': producto_response.foto
            }), 200
        else:
            return jsonify({'error': 'Producto no encontrado'}), 404
    except Exception as e:
        return jsonify({'error': str(e)}), 500

#--------------------------------------------------------------------------------------------------------------------------

#Metodos para producto_manager

#Metodo agregar producto

@app.route('/producto_manager', methods=['POST'])
def add_producto_manager():
    try:
        # Obtener los datos del cuerpo de la solicitud
        data = request.json
        
        nombre = data.get('nombre')
        codigo = data.get('codigo')
        foto = data.get('foto')
        talle = data.get('talle')
        color = data.get('color')
        
        # Validar que todos los datos necesarios estén presentes
        if not all([nombre, codigo, foto, talle, color]):
            return jsonify({'error': 'Nombre, código, foto, talle y color son requeridos'}), 400
        
        # Llamar al método AddProducto del cliente gRPC
        response = productoclient.add_producto(nombre, codigo, foto, talle, color)
        
        if response:
            # Acceder a los atributos del objeto response
            return jsonify({
                'id': response.id,
                'nombre': response.nombre,
                'codigo': response.codigo,
                'foto': response.foto,
                'talle': response.talle,
                'color': response.color
            }), 201
        else:
            return jsonify({'error': 'Unable to add producto'}), 500
    except Exception as e:
        return jsonify({'error': str(e)}), 500





if __name__ == '__main__':
    app.run(port=8081)

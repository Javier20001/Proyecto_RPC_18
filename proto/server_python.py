import sys
import grpc
from flask_cors import CORS
from flask import Flask, jsonify, request
from tienda_service_client_grpc import TiendaClient
from user_service_client_grpc import UserClient 
from producto_service_client_grpc import ProductoClient 
from producto_manager_cliente_grpc import ProductoManagerClient
import producto_manager_pb2
import producto_manager_pb2_grpc


app = Flask(__name__)
CORS(app)

channel = grpc.insecure_channel('localhost:9090')
tiendaclient = TiendaClient(channel)
user_client = UserClient(channel)
productoclient = ProductoClient(channel)
productomanagerclient = ProductoManagerClient(channel)


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

# Método agregar producto
@app.route('/producto/<int:producto_id>/tienda/<int:tienda_id>_manager', methods=['GET'])
def find_by_id_manager(producto_id, tienda_id):
    """Endpoint para buscar un producto por su ID en una tienda específica"""
    response = productomanagerclient.find_by_id(producto_id, tienda_id)
    if response:
        return jsonify({
            'id': response.id,
            'stock': response.stock,
            'talle': response.talle,
            'color': response.color
        }), 200
    else:
        return jsonify({'error': 'Producto no encontrado'}), 404

@app.route('/productos_manager', methods=['GET'])
def find_all_manager():
    """Endpoint para obtener todos los productos en todas las tiendas"""
    response = productomanagerclient.find_all()
    productos = [{
        'id': producto.id,
        'producto': {
            'nombre': producto.producto.nombre,  # Aquí mapeas los atributos del objeto Producto
            'codigo': producto.producto.codigo,
            'foto': producto.producto.foto  # Agrega más atributos según tu mensaje Producto
        },
        'tienda':{
            'id': producto.tienda.id
        },
        'stock': producto.stock,
        'talle': producto.talle,
        'color': producto.color
    } for producto in response.productoEnTienda]
    return jsonify(productos), 200

@app.route('/productos/tienda/<int:tienda_id>_manager', methods=['GET'])
def find_all_by_tienda_id_manager(tienda_id):
    """Endpoint para obtener todos los productos en una tienda por el ID de la tienda"""
    response = productomanagerclient.find_all_by_tienda_id(tienda_id)
    productos = [{
        'id_productoEnTienda': producto.id,
        'producto': {
            'nombre': producto.producto.nombre,  # Aquí mapeas los atributos del objeto Producto
            'codigo': producto.producto.codigo   # Agrega más atributos según tu mensaje Producto
        },
        'stock': producto.stock,
        'talle': producto.talle,
        'color': producto.color
    } for producto in response.productoEnTienda]
    return jsonify(productos), 200

@app.route('/productos/producto/<int:producto_id>_manager', methods=['GET'])
def find_all_by_producto_id_manager(producto_id):
    """Endpoint para obtener todos los productos en tiendas por el ID del producto"""
    response = productomanagerclient.find_all_by_producto_id(producto_id)
    productos = [{
        'id_productoEnTienda': producto.id,
        'stock': producto.stock,
        'talle': producto.talle,
        'color': producto.color
    } for producto in response.productoEnTienda]
    return jsonify(productos), 200

@app.route('/productos/filter_manager', methods=['POST'])
def find_all_by_custom_filter_manager():
    """Endpoint para obtener productos con un filtro personalizado"""
    data = request.json
    nombre = data.get('nombre')
    codigo = data.get('codigo')
    talle = data.get('talle')
    color = data.get('color')
    tienda_id = data.get('tienda_id')
    
    response = productomanagerclient.find_all_by_custom_filter(nombre, codigo, talle, color, tienda_id)
    productos = [{
        'id_productoEnTienda': producto.id,
        'stock': producto.stock,
        'talle': producto.talle,
        'color': producto.color
    } for producto in response.productoEnTienda]
    return jsonify(productos), 200

@app.route('/producto/asignar_manager', methods=['POST'])
def assign_producto_to_tienda_manager():
    """Endpoint para asignar un producto a una tienda"""
    data = request.json
    producto_id = data['producto_id']
    nombre = data['nombre']
    codigo = data['codigo']
    foto = data.get('foto', '')
    talle = data['talle']
    color = data['color']
    tienda_id = data['tienda_id']
    
    response = productomanagerclient.assign_producto_to_tienda(
        producto_id, nombre, codigo, foto, talle, color, tienda_id
    )
    return jsonify({'message': response.message}), 200

@app.route('/producto_manager', methods=['POST'])
def add_producto_manager():
    """Endpoint para agregar un nuevo producto"""
    data = request.json
    nombre = data['nombre']
    codigo = data['codigo']
    foto = data.get('foto', '')
    talle = data['talle']
    color = data['color']
    
    response = productomanagerclient.add_producto(nombre, codigo, foto, talle, color)
    return jsonify({
        'id_productoEnTienda': response.id,
        'producto': {
            'nombre': response.producto.nombre,  # Aquí mapeas los atributos del objeto Producto
            'codigo': response.producto.codigo   # Agrega más atributos según tu mensaje Producto
        },
        'stock': response.stock,
        'talle': response.talle,
        'color': response.color
    }), 201

@app.route('/producto_manager', methods=['PUT'])
def modify_producto_manager():
    """Endpoint para modificar un producto existente"""
    data = request.json
    producto_id = data['producto_id'] #este es el id DEL PRODUCTO_EN_TIENDA no el del producto
    nombre = data['nombre']
    codigo = data['codigo']
    foto = data.get('foto', '')
    talle = data['talle']
    color = data['color']
    
    response = productomanagerclient.modify_producto(producto_id, nombre, codigo, foto, talle, color)
    return jsonify({
        'id_productoEnTienda': response.id,
        'producto': {
            'nombre': response.producto.nombre,  # Aquí mapeas los atributos del objeto Producto
            'codigo': response.producto.codigo   # Agrega más atributos según tu mensaje Producto
        },
        'stock': response.stock,
        'talle': response.talle,
        'color': response.color
    }), 200

@app.route('/producto/stock_manager', methods=['PUT'])
def modify_stock_manager():
    """Endpoint para modificar el stock de un producto en una tienda"""
    data = request.json
    producto_id = data['producto_id']
    tienda_id = data['tienda_id']
    stock = data['stock']
    talle = data['talle']
    color = data['color']
    
    response = productomanagerclient.modify_stock(producto_id, tienda_id, stock, talle, color)
    return jsonify({
        'id_productoEnTienda': response.id,
        'stock': response.stock
    }), 200


if __name__ == '__main__':
    app.run(port=8081)

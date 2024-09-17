import sys
import grpc
from flask import Flask, jsonify, request
from tienda_service_client_grpc import TiendaClient
from user_service_client_grpc import UserClient 
#import tienda_service_pb2
import user_service_pb2




app = Flask(__name__)


channel = grpc.insecure_channel('localhost:9090')
tiendaclient = TiendaClient(channel)
user_client = UserClient(channel)


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

@app.route('/usuarios', methods=['POST'])
def add_user():
    try:
        # Obtener datos del cuerpo de la solicitud
        data = request.json
        username = data.get('username')
        password = data.get('password')
        tienda_id = int(data.get('tienda'))  # Obtener el valor de tienda
        nombre = data.get('nombre')
        apellido = data.get('apellido')
        rol = data.get('rol')
        habilitado = data.get('habilitado')

       # Llamar al método add_user del cliente gRPC
        user = user_client.add_user(username, password, tienda_id, nombre, apellido, rol, habilitado)

        if user:
            return jsonify(user), 201
        else:
            return jsonify({'error': 'Unable to add user'}), 500
    except Exception as e:
        return jsonify({'error': str(e)}), 500



if __name__ == '__main__':
    app.run(port=8081)

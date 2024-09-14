import sys
import grpc
from flask import Flask, jsonify

# Importar los módulos
from clienteGRCP import TiendaClient
import tienda_pb2

app = Flask(__name__)

# Crear el canal gRPC y el cliente
channel = grpc.insecure_channel('localhost:9090')
tienda_client = TiendaClient(channel)

@app.route('/tiendas', methods=['GET'])
def get_tiendas():
    try:
        # Obtener todas las tiendas usando el cliente gRPC
        tiendas_response = tienda_client.get_all_tiendas()
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

if __name__ == '__main__':
    app.run(port=8080)

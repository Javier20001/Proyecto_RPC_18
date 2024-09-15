import grpc
import mensaje_service_pb2
import mensaje_service_pb2_grpc

def run():
    # Crear un canal hacia el servidor gRPC (puerto 9090)
    with grpc.insecure_channel('localhost:9090') as channel:
        # Crear el stub (cliente gRPC)
        stub = mensaje_service_pb2_grpc.MensajeServiceStub(channel)

        # Crear la solicitud con el mensaje a enviar
        mensaje_request = mensaje_service_pb2.MensajeRequest(mensaje="Hola desde el cliente Python")

        # Llamar al método enviarMensaje del servicio gRPC
        response = stub.enviarMensaje(mensaje_request)

        # Mostrar la respuesta del servidor
        print(f"Respuesta del servidor: {response.respuesta}")

if __name__ == '__main__':
    run()

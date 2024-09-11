import grpc
import mensaje_pb2
import mensaje_pb2_grpc

def run():
    # Configura la conexión con el servidor GRPC
    with grpc.insecure_channel('localhost:9090') as channel:
        stub = mensaje_pb2_grpc.MensajeServiceStub(channel)
        
        # Crea una solicitud
        request = mensaje_pb2.MensajeRequest(mensaje="Hola desde el cliente!")
        
        # Llama al servicio y obtiene la respuesta
        response = stub.enviarMensaje(request)
        
        # Imprime la respuesta
        print("Respuesta del servidor: " + response.respuesta)

if __name__ == '__main__':
    run()

package com.grpc.grpc_server.services;
import com.grpc.grpc_server.services.MensajeServiceProto.MensajeResponse;
import com.grpc.grpc_server.services.MensajeServiceProto.MensajeRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class MensajeServiceImpl extends MensajeServiceGrpc.MensajeServiceImplBase{

    @Override
    public void enviarMensaje(MensajeRequest request, StreamObserver<MensajeResponse> responseObserver) {
        // Lógica del servicio GRPC
        String mensaje = request.getMensaje();
        // Construir la respuesta basada en la solicitud
        MensajeResponse response = MensajeResponse.newBuilder()
                .setRespuesta("Mensaje recibido: " + mensaje)
                .build();

        // Enviar la respuesta al cliente
        responseObserver.onNext(response);
        // Marcar la finalización de la transmisión de respuestas
        responseObserver.onCompleted();
    }

}

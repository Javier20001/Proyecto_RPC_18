package com.soap.SoapClient.services;



import com.example.consumingwebservice.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CatalogoClient extends WebServiceGatewaySupport {

    public AddCatalogoResponse addCatalogo(CatalogoDto catalogoDto) {
        AddCatalogoRequest request = new AddCatalogoRequest();
        request.setCatalogo(catalogoDto);
        return (AddCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws", request);
    }

    // Método para eliminar un catálogo
    public DeleteCatalogoResponse deleteCatalogo(int catalogoId) {
        DeleteCatalogoRequest request = new DeleteCatalogoRequest();
        request.setCatalogoId(catalogoId);
        return (DeleteCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws", request);
    }

    // Método para actualizar un catálogo
    public UpdateCatalogoResponse updateCatalogo(int catalogoId, CatalogoDto catalogoDto) {
        UpdateCatalogoRequest request = new UpdateCatalogoRequest();
        request.setCatalogoId(catalogoId);
        request.setCatalogo(catalogoDto);
        return (UpdateCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws", request);
    }
    public AddProductoToCatalogoResponse addProductoToCatalogo(int catalogoId, ProductoDto productoDto) {
        AddProductoToCatalogoRequest request = new AddProductoToCatalogoRequest();
        request.setCatalogoId(catalogoId);
        request.setProducto(productoDto);
        return (AddProductoToCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws", request);
    }
    // Método para eliminar un producto de un catálogo
    public DeleteProductoFromCatalogoResponse deleteProductoFromCatalogo(int catalogoId, int productoId) {
        DeleteProductoFromCatalogoRequest request = new DeleteProductoFromCatalogoRequest();
        request.setCatalogoId(catalogoId);
        request.setProductoId(productoId);
        return (DeleteProductoFromCatalogoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/ws", request);
    }
}

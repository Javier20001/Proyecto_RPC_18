package com.kafka.consumer.controllers;

import com.kafka.consumer.models.OrdenDeCompraModel;
import com.kafka.consumer.services.OrdenDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/ordenes-de-compra") //esto va a cambiar
public class OrdenDeCompraController {

    @Autowired
    private OrdenDeCompraService ordenDeCompraService;

    // Pide los datos de observaciones, idTienda y una lista de productos(color, talle, cantidadSolicitada)
    @PostMapping("")
    public ResponseEntity<String> post(@RequestBody OrdenDeCompraModel model) {
        return ordenDeCompraService.createOrdenDeCompra(model);
    }

}

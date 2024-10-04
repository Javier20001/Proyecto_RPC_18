package com.kafka.consumer.controllers;

import com.kafka.consumer.models.OrdenDeCompraModel;
import com.kafka.consumer.services.OrdenDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recepcion") //esto puede cambiar
public class RecepcionController {

    @Autowired
    private OrdenDeCompraService ordenDeCompraService;

    @GetMapping(value = "/{idTienda}")
    public ResponseEntity<List<OrdenDeCompraModel>> getAllAccepted(@PathVariable(name = "idTienda") int idTienda) {
        List<OrdenDeCompraModel> ordenesModel = ordenDeCompraService.obtenerTodasLasOrdenesAceptadasYConOrdenDeDespacho(idTienda);
        return ResponseEntity.ok(ordenesModel);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrdenDeCompraModel>> getAll() {
        List<OrdenDeCompraModel> ordenesModel = ordenDeCompraService.obtenerTodasLasOrdenes();
        return ResponseEntity.ok(ordenesModel);
    }

    @PostMapping(value = "/{idTienda}/{idOrden}")
    public ResponseEntity<String> receivetOrden(@PathVariable(name = "idOrden") int idOrden) {
        return ordenDeCompraService.receiveOrden(idOrden);
    }

}

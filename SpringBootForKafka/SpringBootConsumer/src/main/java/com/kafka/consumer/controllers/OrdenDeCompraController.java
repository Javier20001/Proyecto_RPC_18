package com.kafka.consumer.controllers;

import com.kafka.consumer.models.OrdenDeCompraModel;
import com.kafka.consumer.services.OrdenDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ordenes-de-compra") //esto va a cambiar
public class OrdenDeCompraController {

    @Autowired
    private OrdenDeCompraService ordenDeCompraService;

    @PostMapping("")
    public ResponseEntity<String> post(@RequestBody OrdenDeCompraModel model) {
        return ordenDeCompraService.saveOrUpdate(model);
    }

}

package com.soap.SoapClient.controllers;

import com.example.consumingwebservice.wsdl.GetAllOrdenesDeCompraResponse;
import com.example.consumingwebservice.wsdl.GetOrdenesDeCompraFiltradasRequest;
import com.example.consumingwebservice.wsdl.GetOrdenesDeCompraFiltradasResponse;
import com.soap.SoapClient.services.OrdenesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/ordenesDeCompra")
public class OrdenesDeCompraController {

    @Autowired
    private OrdenesClient ordenesClient;

    @GetMapping("/getAll")
    public GetAllOrdenesDeCompraResponse getAllOrdenes() {
        return ordenesClient.getAllOrdenes();
    }

    //este es el body: (Aclaracion: el fechaInicio y fechaFin, filtraria la fecha de solicitud de las Ordenes de compra, no la fecha de recepcion.)
    /*
    {
        "codigoProducto": "PROD001",
        "estado": "ACEPTADA",
        "fechaInicio": "2023-01-01",
        "fechaFin": "2024-12-31",
        "tiendaId": 1
    }
     */
    @PostMapping("/filtrar")
    public GetOrdenesDeCompraFiltradasResponse filtrarOrdenes(@RequestBody GetOrdenesDeCompraFiltradasRequest request) {
        return ordenesClient.filtrarOrdenes(request);
    }

}

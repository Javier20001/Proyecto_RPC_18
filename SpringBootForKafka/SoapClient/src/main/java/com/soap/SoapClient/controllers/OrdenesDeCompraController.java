package com.soap.SoapClient.controllers;

import com.example.consumingwebservice.wsdl.*;
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
    /* se pueden enviar todos los datos vacios
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

    /* se pueden enviar todos los datos vacios menos usuarioId
    {
        "usuarioId": 1,
        "codigoProducto": "PROD001",
        "nombre": "nombre 1",
        "estado": "ACEPTADA",
        "fechaInicio": "2023-01-01",
        "fechaFin": "2024-12-31",
        "tiendaId": 1
    }
     */
    @PostMapping("/addFiltro")
    public AddFiltroResponse addFiltro(@RequestBody AddFiltroRequest request) {
        return ordenesClient.addFiltro(request);
    }

    @GetMapping("/filtros/{usuarioId}")
    public GetFiltrosByUsuarioResponse getFiltrosByUsuario(@PathVariable int usuarioId) {
        return ordenesClient.getFiltrosByUsuario(usuarioId);
    }

    @GetMapping("/ordenesByFiltro/{filtroId}")
    public GetAllOrdenesByFiltroIdResponse getAllOrdenesByFiltroId(@PathVariable int filtroId) {
        return ordenesClient.getAllOrdenesByFiltroId(filtroId);
    }

    /* Se pueden enviar todos los datos vacios menos filtroId
    {
        "filtroId": 4,
        "codigoProducto": "PROD001",
        "nombre": "nombre 1",
        "estado": "ACEPTADA",
        "fechaInicio": "2023-01-01",
        "fechaFin": "2024-12-31",
        "tiendaId": 1
    }
     */
    @PutMapping("/updateFiltro")
    public UpdateFiltroByIdResponse updateFiltro(@RequestBody UpdateFiltroByIdRequest request) {
        return ordenesClient.updateFiltroById(request);
    }

    @DeleteMapping("/deleteFiltro/{filtroId}")
    public DeleteFiltroByIdResponse deleteFiltro(@PathVariable int filtroId) {
        return ordenesClient.deleteFiltroById(filtroId);
    }

}

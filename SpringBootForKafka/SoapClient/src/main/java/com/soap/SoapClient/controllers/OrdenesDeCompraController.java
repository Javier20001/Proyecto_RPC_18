package com.soap.SoapClient.controllers;

import com.example.consumingwebservice.wsdl.*;
import com.soap.SoapClient.services.OrdenesClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/ordenesDeCompra")
public class OrdenesDeCompraController {

    //Link swagger: http://localhost:8087/swagger-ui.html

    @Autowired
    private OrdenesClient ordenesClient;

    @Operation(summary = "Obtener todas las órdenes de compra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Órdenes obtenidas exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/getAll")
    public GetAllOrdenesDeCompraResponse getAllOrdenes() {
        return ordenesClient.getAllOrdenes();
    }

    @Operation(summary = "Filtrar órdenes de compra por parámetros")
    @PostMapping("/filtrar")
    public GetOrdenesDeCompraFiltradasResponse filtrarOrdenes(@RequestBody GetOrdenesDeCompraFiltradasRequest request) {
        return ordenesClient.filtrarOrdenes(request);
    }

    @Operation(summary = "Agregar filtro para usuario")
    @PostMapping("/addFiltro")
    public AddFiltroResponse addFiltro(@RequestBody AddFiltroRequest request) {
        return ordenesClient.addFiltro(request);
    }

    @Operation(summary = "Obtener filtros por usuario")
    @GetMapping("/filtros/{usuarioId}")
    public GetFiltrosByUsuarioResponse getFiltrosByUsuario(@PathVariable int usuarioId) {
        return ordenesClient.getFiltrosByUsuario(usuarioId);
    }

    @Operation(summary = "Obtener órdenes de compra por ID de filtro")
    @GetMapping("/ordenesByFiltro/{filtroId}")
    public GetAllOrdenesByFiltroIdResponse getAllOrdenesByFiltroId(@PathVariable int filtroId) {
        return ordenesClient.getAllOrdenesByFiltroId(filtroId);
    }

    @Operation(summary = "Actualizar filtro por ID")
    @PutMapping("/updateFiltro")
    public UpdateFiltroByIdResponse updateFiltro(@RequestBody UpdateFiltroByIdRequest request) {
        return ordenesClient.updateFiltroById(request);
    }

    @Operation(summary = "Eliminar filtro por ID")
    @DeleteMapping("/deleteFiltro/{filtroId}")
    public DeleteFiltroByIdResponse deleteFiltro(@PathVariable int filtroId) {
        return ordenesClient.deleteFiltroById(filtroId);
    }

}

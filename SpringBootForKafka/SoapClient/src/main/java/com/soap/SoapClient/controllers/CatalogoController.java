package com.soap.SoapClient.controllers;


import com.example.consumingwebservice.wsdl.CreateCatalogoRequest;
import com.example.consumingwebservice.wsdl.CreateCatalogoResponse;
import com.example.consumingwebservice.wsdl.DeleteCatalogoResponse;
import com.soap.SoapClient.services.CatalogoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoClient catalogoClient;

    @PostMapping("/create")
    public CreateCatalogoResponse createCatalogo(@RequestBody CreateCatalogoRequest request) {
        // Método para crear un nuevo catálogo
        return catalogoClient.createCatalogo(request);
    }

    @DeleteMapping("/{catalogoId}")
    public DeleteCatalogoResponse deleteCatalogo(@PathVariable Long catalogoId) {
        // Método para eliminar un catálogo por ID
        return catalogoClient.deleteCatalogo(catalogoId);
    }

    @GetMapping("/exportarPDF/{catalogoId}")
    public ResponseEntity<byte[]> exportarCatalogoPDF(@PathVariable Long catalogoId) {
        byte[] pdfBytes = catalogoClient.exportarCatalogoPDF(catalogoId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "catalogo.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }




}


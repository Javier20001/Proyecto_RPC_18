package com.kafka.provider.controller;


import com.kafka.provider.dtos.ProductProviderDTO;
import com.kafka.provider.service.ProductProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/proveedor")
public class ProductProviderController {
    @Autowired
    private ProductProviderService productProviderService;

    @PostMapping
    public ResponseEntity<String> addProductProvider(@RequestBody ProductProviderDTO productProviderDTO){
        return  productProviderService.addProductProvider(productProviderDTO);
    }
}

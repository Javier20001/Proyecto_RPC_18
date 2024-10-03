package com.kafka.provider.service;


import com.kafka.provider.dtos.ProductProviderDTO;
import com.kafka.provider.entities.ProductProvider;
import com.kafka.provider.repository.ProductProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("productProviderService")
public class ProductProviderService {

    @Autowired
    private ProductProviderRepository productProviderRepository;

    public ResponseEntity<String> addProductProvider(ProductProviderDTO ppd){
        if(productProviderRepository.findByCodigoAndColorAndTalleAndStock(ppd.getCodigo(),ppd.getColor(),ppd.getTalle(),ppd.getStock()).isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("Error: ya se encontro un producto con estas caracteristicas");
        }
        productProviderRepository.save(ppd.toProductProvider());
        return ResponseEntity.ok("Orden de compra creada exitosamente");
    }




}

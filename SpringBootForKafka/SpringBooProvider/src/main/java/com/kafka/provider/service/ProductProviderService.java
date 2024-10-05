package com.kafka.provider.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.provider.dtos.ProductProviderDTO;
import com.kafka.provider.entities.OrdenDeCompra;
import com.kafka.provider.entities.ProductProvider;
import com.kafka.provider.repository.IOrdenDeCompraRepository;
import com.kafka.provider.repository.ProductProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("productProviderService")
public class ProductProviderService {

    @Autowired
    private ProductProviderRepository productProviderRepository;

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private OrdenDeCompraService ordenDeCompraService;

    public ResponseEntity<String> addProductProvider(ProductProviderDTO ppd){
        if(productProviderRepository.findByCodigoAndColorAndTalleAndStock(ppd.getCodigo(),ppd.getColor(),ppd.getTalle(),ppd.getStock()).isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("Error: ya se encontro un producto con estas caracteristicas");
        }
        productProviderRepository.save(ppd.toProductProvider());
        return ResponseEntity.ok("Orden de compra creada exitosamente");
    }

    public List<ProductProviderDTO> obtenerTodosLosProductos() {
        List<ProductProvider> productos = productProviderRepository.findAll();
        return productos.stream()
                .map(this::convertirAProductProviderDTO)
                .collect(Collectors.toList());
    }

    public ResponseEntity<ProductProviderDTO> actualizarProducto(int id, ProductProviderDTO productProviderDTO) throws JsonProcessingException {

        Optional<ProductProvider> optionalProduct = productProviderRepository.findById(id);
        boolean actualizoStock = false;

        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ProductProvider existingProduct = optionalProduct.get();

        //if (productProviderDTO.getCodigo() != null && !productProviderDTO.getCodigo().isEmpty()) {
        //    existingProduct.setCodigo(productProviderDTO.getCodigo());
        //}
        //if (productProviderDTO.getColor() != null && !productProviderDTO.getColor().isEmpty()) {
        //    existingProduct.setColor(productProviderDTO.getColor());
        //}
        //if (productProviderDTO.getTalle() != null && !productProviderDTO.getTalle().isEmpty()) {
        //    existingProduct.setTalle(productProviderDTO.getTalle());
        //}
        if (productProviderDTO.getStock() != existingProduct.getStock()) {
            existingProduct.setStock(productProviderDTO.getStock());
            actualizoStock = true;
        }
        existingProduct.setFoto(productProviderDTO.getFoto());


        ProductProvider updatedProduct = productProviderRepository.save(existingProduct);

        ProductProviderDTO updatedProductDTO = convertirAProductProviderDTO(updatedProduct);

        if (actualizoStock){
            List<OrdenDeCompra> ordenes = ordenDeCompraRepository.findPausadasByProducto(updatedProductDTO.getCodigo(), updatedProductDTO.getColor(), updatedProductDTO.getTalle());
            if (!ordenes.isEmpty()){
                for (OrdenDeCompra orden : ordenes) {
                    ordenDeCompraService.atenderOrdenDeCompra(orden.getId());
                }
            }
        }

        return ResponseEntity.ok(updatedProductDTO);
    }

    private ProductProviderDTO convertirAProductProviderDTO(ProductProvider productProvider){
        ProductProviderDTO productProviderDTO = new ProductProviderDTO();
        productProviderDTO.setCodigo(productProvider.getCodigo());
        productProviderDTO.setId(productProvider.getId());
        productProviderDTO.setFoto(productProvider.getFoto());
        productProviderDTO.setTalle(productProvider.getTalle());
        productProviderDTO.setStock(productProvider.getStock());
        productProviderDTO.setColor(productProvider.getColor());
        return productProviderDTO;
    }

}

package com.kafka.provider.repository;

import com.kafka.provider.entities.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("productProviderRepository")
public interface ProductProviderRepository extends JpaRepository<ProductProvider,Integer> {

    // Busca un ProductProvider basado en todos los campos
    Optional<ProductProvider> findByCodigoAndColorAndTalleAndStock(String codigo, String color, String talle, int stock);
}

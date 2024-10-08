package com.kafka.consumer.repositories;

import com.kafka.consumer.entities.ProductoEnNovedades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("productoEnNovedadesRepository")
public interface IProductoEnNovedadesRepository extends JpaRepository<ProductoEnNovedades, Integer> {

    List<ProductoEnNovedades> findByAceptadoFalse();

    public abstract Optional<ProductoEnNovedades> findByCodigoAndTalleAndColor(String codigo, String talle, String color);

}

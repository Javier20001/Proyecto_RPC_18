package com.kafka.consumer.repositories;


import com.kafka.consumer.entities.Producto;
import com.kafka.consumer.entities.ProductoEnTienda;
import com.kafka.consumer.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("productoEnTiendaRepository")
public interface IProductoEnTiendaRepository extends JpaRepository<ProductoEnTienda, Integer> {

    Optional<ProductoEnTienda> findByProductoAndTalleAndColor(Producto producto, String talle, String color);

    Optional<ProductoEnTienda> findByProductoAndTalleAndColorAndTiendaIsNull(Producto producto, String talle, String color);

    Optional<ProductoEnTienda> findByProducto_CodigoAndTalleAndColorAndTiendaIsNull(String productoCodigo, String talle, String color);

    Optional<ProductoEnTienda> findByProducto_CodigoAndTalleAndColorAndTienda_Id(String productoCodigo, String talle, String color, int tiendaId);

    List<ProductoEnTienda> findByProductoAndTalleAndColorAndTienda(Producto producto, String talle, String color, Tienda tienda);

    List<ProductoEnTienda> findAllByProducto_Id(int productoId);

    List<ProductoEnTienda> findAllByTienda_Id(int tiendaId);

    Optional<ProductoEnTienda> findByIdAndTienda(int tiendaId, Tienda tienda);

}

package com.grpc.grpc_server.repositories;

import com.grpc.grpc_server.entities.Producto;
import com.grpc.grpc_server.entities.ProductoEnTienda;
import com.grpc.grpc_server.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("productoEnTiendaRepository")
public interface IProductoEnTiendaRepository extends JpaRepository<ProductoEnTienda, Integer> {

    Optional<ProductoEnTienda> findByProductoAndTalleAndColor(Producto producto, String talle, String color);

    Optional<ProductoEnTienda> findByProductoAndTalleAndColorAndTiendaIsNull(Producto producto, String talle, String color);

    List<ProductoEnTienda> findByProductoAndTalleAndColorAndTienda(Producto producto, String talle, String color, Tienda tienda);

    List<ProductoEnTienda> findAllByProducto_Id(int productoId);

    List<ProductoEnTienda> findAllByTienda_Id(int tiendaId);

    Optional<ProductoEnTienda> findByIdAndTienda(int tiendaId, Tienda tienda);

}

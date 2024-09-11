package com.grpc.grpc_server.repositories;

import com.grpc.grpc_server.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    public abstract Optional<Producto> findByCodigo(String codigo);

}

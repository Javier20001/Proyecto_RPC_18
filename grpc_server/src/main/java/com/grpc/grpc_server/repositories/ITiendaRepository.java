package com.grpc.grpc_server.repositories;

import com.grpc.grpc_server.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("tiendaRepository")
public interface ITiendaRepository extends JpaRepository<Tienda, Integer> {

    public abstract Optional<Tienda> findByCodigo(String codigo);

}

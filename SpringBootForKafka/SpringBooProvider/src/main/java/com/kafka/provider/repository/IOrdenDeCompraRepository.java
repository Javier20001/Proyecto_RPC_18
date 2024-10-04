package com.kafka.provider.repository;

import com.kafka.provider.entities.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("OrdenDeCompraRepository")
public interface IOrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {

    Optional<OrdenDeCompra> findByOrdenDeDespacho_Id(int ordenDeDespachoId);

}

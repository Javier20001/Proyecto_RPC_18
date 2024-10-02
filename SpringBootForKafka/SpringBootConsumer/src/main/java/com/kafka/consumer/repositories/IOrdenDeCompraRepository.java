package com.kafka.consumer.repositories;

import com.kafka.consumer.entities.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OrdenDeCompraRepository")
public interface IOrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {
}

package com.kafka.consumer.repositories;

import com.kafka.consumer.entities.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OrdenDeCompraRepository")
public interface IOrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {

    public abstract List<OrdenDeCompra> findByTienda_IdAndEstadoAndOrdenDeDespachoIsNotNull(int tiendaId, String estado);

}

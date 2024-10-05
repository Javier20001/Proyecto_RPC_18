package com.kafka.provider.repository;

import com.kafka.provider.entities.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("OrdenDeCompraRepository")
public interface IOrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Integer> {

    Optional<OrdenDeCompra> findByOrdenDeDespacho_Id(int ordenDeDespachoId);

    @Query("SELECT o FROM OrdenDeCompra o JOIN o.productosEnOC p " +
            "WHERE p.codigo = :codigo AND p.color = :color AND p.talle = :talle AND o.pausada = true")
    List<OrdenDeCompra> findPausadasByProducto(@Param("codigo") String codigo,
                                               @Param("color") String color,
                                               @Param("talle") String talle);

}

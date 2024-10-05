package com.kafka.consumer.repositories;


import com.kafka.consumer.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("tiendaRepository")
public interface ITiendaRepository extends JpaRepository<Tienda, Integer> {

    public abstract Optional<Tienda> findByCodigo(String codigo);

}

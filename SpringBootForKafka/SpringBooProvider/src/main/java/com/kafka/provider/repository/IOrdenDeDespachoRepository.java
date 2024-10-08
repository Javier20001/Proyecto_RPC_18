package com.kafka.provider.repository;

import com.kafka.provider.entities.OrdenDeDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OrdenDeDespachoRepository")
public interface IOrdenDeDespachoRepository extends JpaRepository<OrdenDeDespacho, Integer> {
}

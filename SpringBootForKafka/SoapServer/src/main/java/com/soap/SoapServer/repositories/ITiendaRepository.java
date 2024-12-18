package com.soap.SoapServer.repositories;

import com.soap.SoapServer.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("tiendaRepository")
public interface ITiendaRepository extends JpaRepository<Tienda, Integer> {

    public abstract Optional<Tienda> findByCodigo(String codigo);

    public abstract List<Tienda> findAllByHabilitada(boolean habilitada);

    public abstract Optional<Tienda> findByProvinciaAndCiudadAndDireccion(String provincia, String ciudad, String direccion);

}

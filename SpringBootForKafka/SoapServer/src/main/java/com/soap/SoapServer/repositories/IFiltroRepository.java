package com.soap.SoapServer.repositories;

import com.soap.SoapServer.entities.Filtro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("FiltroRepository")
public interface IFiltroRepository extends JpaRepository<Filtro, Integer> {

    public abstract List<Filtro> findByUserId(int userId);

}

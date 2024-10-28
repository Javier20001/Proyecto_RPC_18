package com.soap.SoapServer.repositories;

import com.soap.SoapServer.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogoRepository extends JpaRepository<Catalogo, Long> {

}

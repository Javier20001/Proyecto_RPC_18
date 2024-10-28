package com.soap.SoapServer.repositories;

import com.soap.SoapServer.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICatalogoRepository extends JpaRepository<Catalogo, Integer> {
    // Método para buscar catálogos por nombre (sensible a mayúsculas y minúsculas)

    List<Catalogo> findByNombre(String nombre);

    // Método para buscar catálogos que contengan una subcadena en el nombre
    List<Catalogo> findByNombreContainingIgnoreCase(String nombre);

    // Método para buscar catálogos por descripción
    List<Catalogo> findByDescripcion(String descripcion);

    // Método para buscar catálogos que contengan una subcadena en la descripción
    List<Catalogo> findByDescripcionContainingIgnoreCase(String descripcion);

    // Método para buscar catálogos por nombre o descripción
    @Query("SELECT c FROM Catalogo c WHERE c.nombre LIKE %:term% OR c.descripcion LIKE %:term%")
    List<Catalogo> searchByNombreOrDescripcion(@Param("term") String term);
}

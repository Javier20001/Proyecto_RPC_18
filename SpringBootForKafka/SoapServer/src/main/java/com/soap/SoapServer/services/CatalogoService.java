package com.soap.SoapServer.services;


import com.example.catalogo.CatalogoDTO;
import com.soap.SoapServer.entities.Catalogo;
import com.soap.SoapServer.repositories.ICatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogoService {

    private final ICatalogoRepository catalogoRepository;

    @Autowired
    public CatalogoService(ICatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    // Método para crear un nuevo catálogo
    public CatalogoDTO createCatalogo(CatalogoDTO catalogoDTO) {
        Catalogo catalogo = new Catalogo();
        catalogo.setNombre(catalogoDTO.getNombre());
        catalogo.setDescripcion(catalogoDTO.getDescripcion());
        catalogo = catalogoRepository.save(catalogo);
        return convertToDto(catalogo);
    }

    // Método para obtener un catálogo por ID
    public CatalogoDTO getCatalogoById(int id) {
        Optional<Catalogo> catalogo = catalogoRepository.findById(id);
        return catalogo.map(this::convertToDto).orElse(null);
    }

    // Método para obtener todos los catálogos
    public List<CatalogoDTO> getAllCatalogos() {
        return catalogoRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método para actualizar un catálogo existente
    public CatalogoDTO updateCatalogo(int id, CatalogoDTO catalogoDTO) {
        Optional<Catalogo> existingCatalogo = catalogoRepository.findById(id);
        if (existingCatalogo.isPresent()) {
            Catalogo catalogo = existingCatalogo.get();
            catalogo.setNombre(catalogoDTO.getNombre());
            catalogo.setDescripcion(catalogoDTO.getDescripcion());
            catalogo = catalogoRepository.save(catalogo);
            return convertToDto(catalogo);
        }
        return null; // O puedes lanzar una excepción personalizada si prefieres
    }

    // Método para eliminar un catálogo por ID
    public void deleteCatalogo(int id) {
        catalogoRepository.deleteById(id);
    }

    // Método para buscar catálogos por nombre
    public List<CatalogoDTO> searchCatalogosByName(String nombre) {
        return catalogoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método para buscar catálogos por descripción
    public List<CatalogoDTO> searchCatalogosByDescription(String descripcion) {
        return catalogoRepository.findByDescripcionContainingIgnoreCase(descripcion)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Método auxiliar para convertir Catalogo a CatalogoDTO
    private CatalogoDTO convertToDto(Catalogo catalogo) {
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setId(catalogo.getId());
        catalogoDTO.setNombre(catalogo.getNombre());
        catalogoDTO.setDescripcion(catalogo.getDescripcion());
        return catalogoDTO;
    }
}


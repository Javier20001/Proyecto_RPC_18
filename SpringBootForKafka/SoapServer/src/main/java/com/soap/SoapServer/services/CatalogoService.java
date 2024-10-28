package com.soap.SoapServer.services;



import com.soap.SoapServer.entities.Catalogo;
import com.soap.SoapServer.entities.Producto;
import com.soap.SoapServer.repositories.ICatalogoRepository;
import com.soap.SoapServer.repositories.ITiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CatalogoService {
    @Autowired
    private ICatalogoRepository catalogoRepository;


    @Autowired
    private ITiendaRepository tiendaRepository;

    public List<Catalogo> findAll() {
        return catalogoRepository.findAll();
    }

    public Optional<Catalogo> findById(int id) {
        return catalogoRepository.findById(id);
    }

    public Catalogo save(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    public void deleteById(int id) {
        catalogoRepository.deleteById(id);
    }

    // Método para obtener productos asociados a un catálogo
    public List<Producto> getProductosByCatalogoId(int catalogoId) {
        Catalogo catalogo = catalogoRepository.findById(catalogoId).orElse(null);

        if (catalogo != null) {
            return catalogo.getProductos();
        }
        return new ArrayList<>();
    }

    public void addProductoToCatalogo(int catalogoId, Producto producto) {
        Catalogo catalogo = catalogoRepository.findById(catalogoId).orElse(null);
        if (catalogo != null) {
            producto.setCatalogo(catalogo); // Asocia el producto con el catálogo
            catalogo.getProductos().add(producto); // Agrega el producto a la lista del catálogo
            catalogoRepository.save(catalogo); // Guarda el catálogo actualizado
        }

    }

}
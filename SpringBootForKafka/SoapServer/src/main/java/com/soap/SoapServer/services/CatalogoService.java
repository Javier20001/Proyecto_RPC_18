package com.soap.SoapServer.services;


import com.soap.SoapServer.entities.Catalogo;
import com.soap.SoapServer.entities.Producto;
import com.soap.SoapServer.repositories.ICatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogoService {

        @Autowired
        private ICatalogoRepository catalogoRepository;

        // Agregar un nuevo catálogo
        public Catalogo addCatalogo(Catalogo catalogo) {
            return catalogoRepository.save(catalogo);
        }

        // Modificar un catálogo existente
        public Catalogo updateCatalogo(int catalogoId, Catalogo updatedCatalogo) {
            Catalogo catalogo = catalogoRepository.findById((long) catalogoId)
                    .orElseThrow(() -> new RuntimeException("Catálogo no encontrado"));
            catalogo.setNombre(updatedCatalogo.getNombre());
            catalogo.setDescripcion(updatedCatalogo.getDescripcion());
            catalogo.setProductos(updatedCatalogo.getProductos());
            return catalogoRepository.save(catalogo);
        }

        // Eliminar un catálogo
        public void deleteCatalogo(int catalogoId) {
            catalogoRepository.deleteById((long) catalogoId);
        }

        // Agregar un producto a un catálogo
        public Catalogo addProductoToCatalogo(int catalogoId, Producto producto) {
            Catalogo catalogo = catalogoRepository.findById((long) catalogoId)
                    .orElseThrow(() -> new RuntimeException("Catálogo no encontrado"));
            catalogo.getProductos().add(producto);
            return catalogoRepository.save(catalogo);
        }

        // Modificar un producto en un catálogo

        public Producto updateProductoInCatalogo(int catalogoId, int productoId, Producto updatedProducto) {
            Catalogo catalogo = catalogoRepository.findById((long) catalogoId)
                        .orElseThrow(() -> new RuntimeException("Catálogo no encontrado"));

                // Buscar el producto dentro del catálogo
                Producto producto = catalogo.getProductos().stream()
                        .filter(p -> p.getId() == productoId)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado en el catálogo"));
                // Guardar el catálogo con el producto actualizado
                catalogoRepository.save(catalogo);

                return producto;

        }

        // Eliminar un producto de un catálogo
        public void deleteProductoFromCatalogo(int catalogoId, int productoId) {
            Catalogo catalogo = catalogoRepository.findById((long) catalogoId)
                    .orElseThrow(() -> new RuntimeException("Catálogo no encontrado"));
            catalogo.getProductos().removeIf(p -> p.getId() == productoId);
            catalogoRepository.save(catalogo);
        }
}



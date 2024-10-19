package com.soap.SoapServer.soapservices;

import com.soap.SoapServer.dtos.OrdenDeCompraDTO;
import com.soap.SoapServer.dtos.ProductoEnOCDTO;
import com.soap.SoapServer.entities.OrdenDeCompra;
import com.soap.SoapServer.entities.ProductoEnOC;
import com.soap.SoapServer.repositories.IOrdenDeCompraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("OrdenDeCompraSoapService")
public class OrdenDeCompraSoapService {

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    public OrdenDeCompraDTO findById(int id) throws DatatypeConfigurationException {
        Optional<OrdenDeCompra> ordenDeCompraOptional = ordenDeCompraRepository.findById(id);
        if (ordenDeCompraOptional.isPresent()) {
            return convertirAOrdenDeCompraDTO(ordenDeCompraOptional.get());
        } else {
            throw new EntityNotFoundException("Orden de compra no encontrada con id: " + id);
        }
    }

    public List<OrdenDeCompraDTO> findAll() {
        try {
            List<OrdenDeCompra> ordenesDeCompra = ordenDeCompraRepository.findAll();
            return ordenesDeCompra.stream()
                    .map(orden -> {
                        try {
                            return convertirAOrdenDeCompraDTO(orden);
                        } catch (DatatypeConfigurationException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private OrdenDeCompraDTO convertirAOrdenDeCompraDTO(OrdenDeCompra orden) throws DatatypeConfigurationException {
        OrdenDeCompraDTO dto = new OrdenDeCompraDTO();
        dto.setId(orden.getId());
        dto.setEstado(orden.getEstado());
        dto.setObservaciones(orden.getObservaciones());
        dto.setProductosEnOC(orden.getProductosEnOC().stream()
                .map(this::convertirAProductoEnOCDTO)
                .collect(Collectors.toList()));
        dto.setTiendaId(orden.getTienda().getId());
        if (orden.getOrdenDeDespacho() != null){
            dto.setOrdenDeDespachoId(orden.getOrdenDeDespacho().getId());
        }
        dto.setFechaDeSolicitud(convertirALocalDate(orden.getFechaDeSolicitud()));
        dto.setFechaDeRecepcion(convertirALocalDate(orden.getFechaDeRecepcion()));
        dto.setPausada(orden.getPausada());
        return dto;
    }

    private ProductoEnOCDTO convertirAProductoEnOCDTO(ProductoEnOC producto) {
        ProductoEnOCDTO dto = new ProductoEnOCDTO();
        dto.setId(producto.getId());
        dto.setCodigo(producto.getCodigo());
        dto.setColor(producto.getColor());
        dto.setTalle(producto.getTalle());
        dto.setCantidadSolicitada(producto.getCantidadSolicitada());
        return dto;
    }

    private XMLGregorianCalendar convertirALocalDate(LocalDate date) throws DatatypeConfigurationException {
        if (date == null) {
            return null;
        }
        GregorianCalendar c = new GregorianCalendar();
        c.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

}

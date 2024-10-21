package com.soap.SoapServer.services;

//import com.soap.SoapServer.dtos.OrdenDeCompraDTO;
//import com.soap.SoapServer.dtos.ProductoEnOCDTO;
import com.example.ordenes.GetOrdenesDeCompraFiltradasRequest;
import com.example.ordenes.GetOrdenesDeCompraFiltradasResponse;
import com.example.ordenes.OrdenDeCompraDTO;
import com.example.ordenes.ProductoEnOCDTO;
import com.soap.SoapServer.entities.OrdenDeCompra;
import com.soap.SoapServer.entities.ProductoEnOC;
import com.soap.SoapServer.repositories.IOrdenDeCompraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service("OrdenDeCompraSoapService")
public class OrdenDeCompraSoapService {

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private EntityManager entityManager;

    public List<GetOrdenesDeCompraFiltradasResponse.OrdenesAgrupadas> filtrarOrdenes(GetOrdenesDeCompraFiltradasRequest request){

        String codigoProducto = request.getCodigoProducto();
        String estado = request.getEstado();
        LocalDate fechaInicio = convertirAXMLGregorianCalendar(request.getFechaInicio());
        LocalDate fechaFin = convertirAXMLGregorianCalendar(request.getFechaFin());
        Integer tiendaId = request.getTiendaId();

        List<Object[]> resultados = findOrdenesDeCompraFiltradas(codigoProducto, estado, fechaInicio, fechaFin, tiendaId);

        List<GetOrdenesDeCompraFiltradasResponse.OrdenesAgrupadas> ordenesAgrupadasList = new ArrayList<>();

        for (Object[] resultado : resultados) {
            GetOrdenesDeCompraFiltradasResponse.OrdenesAgrupadas ordenAgrupada = new GetOrdenesDeCompraFiltradasResponse.OrdenesAgrupadas();

            ordenAgrupada.setCodigoProducto((String) resultado[0]);
            ordenAgrupada.setEstado((String) resultado[1]);
            ordenAgrupada.setTiendaId((Integer) resultado[2]);
            ordenAgrupada.setCantidadTotalPedida(((Integer) resultado[3]));

            ordenesAgrupadasList.add(ordenAgrupada);
        }

        return ordenesAgrupadasList;

    }

    public List<Object[]> findOrdenesDeCompraFiltradas(String codigoProducto, String estado,
                                                       LocalDate fechaInicio, LocalDate fechaFin, Integer tiendaId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<OrdenDeCompra> orden = cq.from(OrdenDeCompra.class);
        Join<OrdenDeCompra, ProductoEnOC> productos = orden.join("productosEnOC", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();

        if (codigoProducto != null && !codigoProducto.isEmpty()) {
            predicates.add(cb.equal(productos.get("codigo"), codigoProducto));
        }
        if (estado != null && !estado.isEmpty()) {
            predicates.add(cb.equal(orden.get("estado"), estado));
        }
        if (fechaInicio != null) {
            predicates.add(cb.greaterThanOrEqualTo(orden.get("fechaDeSolicitud"), fechaInicio));
        }
        if (fechaFin != null) {
            predicates.add(cb.lessThanOrEqualTo(orden.get("fechaDeSolicitud"), fechaFin));
        }
        if (tiendaId != null) {
            predicates.add(cb.equal(orden.get("tienda").get("id"), tiendaId));
        }

        cq.multiselect(
                productos.get("codigo"),
                orden.get("estado"),
                orden.get("tienda").get("id"),
                cb.sum(productos.get("cantidadSolicitada"))
        );
        cq.where(predicates.toArray(new Predicate[0]));

        cq.groupBy(productos.get("codigo"), orden.get("estado"), orden.get("tienda").get("id"));

        return entityManager.createQuery(cq).getResultList();
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
        dto.getProductosEnOC().addAll(orden.getProductosEnOC().stream()
                .map(this::convertirAProductoEnOCDTO)
                .toList());
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

    private LocalDate convertirAXMLGregorianCalendar(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;
        }
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }


}

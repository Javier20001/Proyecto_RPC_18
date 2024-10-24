package com.soap.SoapServer.services;

import com.example.ordenes.*;
import com.soap.SoapServer.entities.Filtro;
import com.soap.SoapServer.entities.OrdenDeCompra;
import com.soap.SoapServer.entities.ProductoEnOC;
import com.soap.SoapServer.repositories.IFiltroRepository;
import com.soap.SoapServer.repositories.IOrdenDeCompraRepository;
import com.soap.SoapServer.repositories.ITiendaRepository;
import com.soap.SoapServer.repositories.IUserRepository;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service("OrdenDeCompraSoapService")
public class OrdenDeCompraSoapService {

    @Autowired
    private IOrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFiltroRepository filtroRepository;

    @Autowired
    private ITiendaRepository tiendaRepository;

    @Autowired
    private EntityManager entityManager;

    public List<GetOrdenesDeCompraFiltradasResponse.OrdenesAgrupadas> filtrarOrdenes(GetOrdenesDeCompraFiltradasRequest request){

        String codigoProducto = request.getCodigoProducto();
        String estado = request.getEstado();
        LocalDate fechaInicio = convertirDeXMLGregorianCalendar(request.getFechaInicio());
        LocalDate fechaFin = convertirDeXMLGregorianCalendar(request.getFechaFin());
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

    public AddFiltroResponse addFiltro(AddFiltroRequest request) {
        AddFiltroResponse response = new AddFiltroResponse();
        if (userRepository.findById(request.getUsuarioId()).isEmpty()){
            response.setSuccess(false);
            response.setMessage("No se ha encontrado usuario con id " + request.getUsuarioId());
            return response;
        }
        Filtro filtro = new Filtro();
        filtro.setUser(userRepository.findById(request.getUsuarioId()).get());

        if (request.getNombre() != null && !request.getNombre().isEmpty()) {
            filtro.setNombre(request.getNombre());
        }
        if (request.getCodigoProducto() != null && !request.getCodigoProducto().isEmpty()) {
            filtro.setCodigoProducto(request.getCodigoProducto());
        }
        if (request.getFechaInicio() != null) {
            filtro.setFechaInicio(convertirDeXMLGregorianCalendar(request.getFechaInicio()));
        }
        if (request.getFechaFin() != null) {
            filtro.setFechaFin(convertirDeXMLGregorianCalendar(request.getFechaFin()));
        }
        if (request.getEstado() != null && !request.getEstado().isEmpty()) {
            filtro.setEstado(request.getEstado());
        }
        //Manejo de roles y tienda
        if (request.getTiendaId() != null) {
            //Si tiene rol de "user" y el id de la tienda enviado es diferente al id de la tienda asignado al usuario tira error.
            if ("user".equals(filtro.getUser().getRol()) && request.getTiendaId() != filtro.getUser().getTienda().getId()) {
                response.setSuccess(false);
                response.setMessage("El id de la tienda es distinta a la tienda asignada al usuario");
                return response;
            } else {
                filtro.setTienda(tiendaRepository.findById(request.getTiendaId()).isPresent() ? tiendaRepository.findById(request.getTiendaId()).get() : null);
            }
        }
        if (request.getTiendaId() == null && "user".equals(filtro.getUser().getRol())) {
            if (filtro.getUser().getTienda() != null){
                filtro.setTienda(tiendaRepository.findById(filtro.getUser().getTienda().getId()).get());
            }
        }
        filtro.setHabilitado(true);
        filtroRepository.save(filtro);
        response.setSuccess(true);
        response.setMessage("Filtro agregado correctamente");

        return response;
    }

    public GetFiltrosByUsuarioResponse getFiltrosByUsuarioId(GetFiltrosByUsuarioRequest request) {
        try {
            List<Filtro> filtros = filtroRepository.findByUserId(request.getUsuarioId());
            GetFiltrosByUsuarioResponse response = new GetFiltrosByUsuarioResponse();

            List<GetFiltrosByUsuarioResponse.Filtros> filtrosSOAP = filtros.stream()
                    .map(filtro -> {
                        try {
                            return convertirAFiltroSOAP(filtro);
                        } catch (DatatypeConfigurationException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();

            response.getFiltros().addAll(filtrosSOAP);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public GetAllOrdenesByFiltroIdResponse getAllOrdenesByFiltroId(GetAllOrdenesByFiltroIdRequest request) {

        Optional<Filtro> filtroOptional = filtroRepository.findById(request.getFiltroId());
        if (filtroOptional.isEmpty()){
            return null;
        }
        Filtro filtro = filtroOptional.get();
        Integer tiendaId = (filtro.getTienda() != null) ? filtro.getTienda().getId() : null;

        List<Object[]> resultados = findOrdenesDeCompraFiltradas(filtro.getCodigoProducto(), filtro.getEstado(), filtro.getFechaInicio(), filtro.getFechaFin(), tiendaId);

        GetAllOrdenesByFiltroIdResponse response = new GetAllOrdenesByFiltroIdResponse();
        List<GetAllOrdenesByFiltroIdResponse.OrdenesAgrupadas> ordenesAgrupadasList = new ArrayList<>();

        for (Object[] resultado : resultados) {
            GetAllOrdenesByFiltroIdResponse.OrdenesAgrupadas ordenAgrupada = new GetAllOrdenesByFiltroIdResponse.OrdenesAgrupadas();

            ordenAgrupada.setCodigoProducto((String) resultado[0]);
            ordenAgrupada.setEstado((String) resultado[1]);
            ordenAgrupada.setTiendaId((Integer) resultado[2]);
            ordenAgrupada.setCantidadTotalPedida(((Integer) resultado[3]));

            ordenesAgrupadasList.add(ordenAgrupada);
        }

        response.getOrdenesAgrupadas().addAll(ordenesAgrupadasList);

        return response;
    }

    public UpdateFiltroByIdResponse updateFiltroById(UpdateFiltroByIdRequest request) {
        UpdateFiltroByIdResponse response = new UpdateFiltroByIdResponse();
        Optional<Filtro> filtroOptional = filtroRepository.findById(request.getFiltroId());
        if (filtroOptional.isEmpty()){
            response.setSuccess(false);
            response.setMessage("No se encontro filtro con id " + request.getFiltroId());
            return response;
        }
        Filtro filtro = filtroOptional.get();
        if (request.getNombre() != null && !request.getNombre().isEmpty()) {
            filtro.setNombre(request.getNombre());
        }
        if (request.getCodigoProducto() != null && !request.getCodigoProducto().isEmpty()) {
            filtro.setCodigoProducto(request.getCodigoProducto());
        }
        if (request.getFechaInicio() != null) {
            filtro.setFechaInicio(convertirDeXMLGregorianCalendar(request.getFechaInicio()));
        }
        if (request.getFechaFin() != null) {
            filtro.setFechaFin(convertirDeXMLGregorianCalendar(request.getFechaFin()));
        }
        if (request.getEstado() != null && !request.getEstado().isEmpty()) {
            filtro.setEstado(request.getEstado());
        }
        //Manejo de roles y tienda
        if (request.getTiendaId() != null) {
            //Si tiene rol de "user" y el id de la tienda enviado es diferente al id de la tienda asignado al usuario tira error.
            if ("user".equals(filtro.getUser().getRol()) && request.getTiendaId() != filtro.getUser().getTienda().getId()) {
                response.setSuccess(false);
                response.setMessage("El id de la tienda es distinta a la tienda asignada al usuario");
                return response;
            } else {
                filtro.setTienda(tiendaRepository.findById(request.getTiendaId()).isPresent() ? tiendaRepository.findById(request.getTiendaId()).get() : null);
            }
        }
        if (request.getTiendaId() == null && "user".equals(filtro.getUser().getRol())) {
            if (filtro.getUser().getTienda() != null){
                filtro.setTienda(tiendaRepository.findById(filtro.getUser().getTienda().getId()).get());
            }
        }
        filtroRepository.save(filtro);
        response.setSuccess(true);
        response.setMessage("Filtro actualizado correctamente");
        return response;
    }

    public DeleteFiltroByIdResponse deleteFiltroById(DeleteFiltroByIdRequest request) {
        DeleteFiltroByIdResponse response = new DeleteFiltroByIdResponse();
        Optional<Filtro> filtroOptional = filtroRepository.findById(request.getFiltroId());
        if (filtroOptional.isEmpty()){
            response.setSuccess(false);
            response.setMessage("No se encontro filtro con id " + request.getFiltroId());
            return response;
        }
        Filtro filtro = filtroOptional.get();
        filtro.setHabilitado(false);
        filtroRepository.save(filtro);
        response.setSuccess(true);
        response.setMessage("Se ha eliminado el filtro con id " + request.getFiltroId());
        return response;
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
        dto.setFechaDeSolicitud(convertirDeLocalDate(orden.getFechaDeSolicitud()));
        dto.setFechaDeRecepcion(convertirDeLocalDate(orden.getFechaDeRecepcion()));
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

    private GetFiltrosByUsuarioResponse.Filtros convertirAFiltroSOAP(Filtro filtro) throws DatatypeConfigurationException {
        GetFiltrosByUsuarioResponse.Filtros filtrosSOAP = new GetFiltrosByUsuarioResponse.Filtros();
        filtrosSOAP.setId(filtro.getId());
        filtrosSOAP.setNombre(filtro.getNombre());
        filtrosSOAP.setCodigoProducto(filtro.getCodigoProducto());
        filtrosSOAP.setFechaInicio(convertirDeLocalDate(filtro.getFechaInicio()));
        filtrosSOAP.setFechaFin(convertirDeLocalDate(filtro.getFechaFin()));
        filtrosSOAP.setEstado(filtro.getEstado());
        if (filtro.getTienda() == null){
            filtrosSOAP.setTiendaId(null);
        } else {
            filtrosSOAP.setTiendaId(filtro.getTienda().getId());
        }
        filtrosSOAP.setHabilitado(filtro.getHabilitado());
        return filtrosSOAP;
    }

    private XMLGregorianCalendar convertirDeLocalDate(LocalDate date) throws DatatypeConfigurationException {
        if (date == null) {
            return null;
        }
        GregorianCalendar c = new GregorianCalendar();
        c.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }

    private LocalDate convertirDeXMLGregorianCalendar(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;
        }
        return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
    }


}

package com.soap.SoapServer.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrdenDeCompraDTO", propOrder = {
        "id", "estado", "observaciones", "productosEnOC", "tiendaId",
        "ordenDeDespachoId", "fechaDeSolicitud", "fechaDeRecepcion", "pausada"
})
@Getter
@Setter
@NoArgsConstructor
public class OrdenDeCompraDTO {

    private int id;
    private String estado;
    private String observaciones;
    private List<ProductoEnOCDTO> productosEnOC;
    private int tiendaId;
    private int ordenDeDespachoId;
    private XMLGregorianCalendar fechaDeSolicitud;
    private XMLGregorianCalendar fechaDeRecepcion;
    private Boolean pausada;

}
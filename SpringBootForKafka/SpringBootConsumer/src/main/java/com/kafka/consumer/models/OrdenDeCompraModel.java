package com.kafka.consumer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdenDeCompraModel {

    private int id;
    private String estado;
    private String observaciones;
    private List<ProductoEnOCModel> productosEnOC;
    private int tiendaId;
    private int ordenDeDespachoId;
    private LocalDate fechaDeSolicitud;
    private LocalDate fechaDeRecepcion;
    private Boolean pausada;

}

package com.kafka.consumer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductoEnOCModel {

    private int id;
    private String codigo;
    private String color;
    private String talle;
    private int cantidadSolicitada;

}

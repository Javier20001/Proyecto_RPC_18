package com.kafka.provider.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductoEnOCDTO {

    private int id;
    private String codigo;
    private String color;
    private String talle;
    private int cantidadSolicitada;

}

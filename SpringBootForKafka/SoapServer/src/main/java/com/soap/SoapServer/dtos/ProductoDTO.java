package com.soap.SoapServer.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductoDTO", propOrder = {
        "id","nombre","codigo", "color", "talle"
})

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {

    private int id;
    private String nombre;
    private String codigo;
    private String color;
    private String talle;

}

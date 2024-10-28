package com.soap.SoapServer.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductoEnOCDTO", propOrder = {
        "id", "codigo", "color", "talle", "cantidadSolicitada"
})
@Getter
@Setter
@NoArgsConstructor
public class ProductoEnOCDTO {

    private int id;
    private String codigo;
    private String color;
    private String talle;
    private int cantidadSolicitada;

}

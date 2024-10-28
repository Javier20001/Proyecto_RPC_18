package com.soap.SoapServer.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogoDTO", propOrder = {
        "id", "nombre", "descripcion", "productos"
})
@Data
@Getter
@Setter
@NoArgsConstructor
public class CatalogoDTO {

    private int id;
    private String nombre;
    private String descripcion;
    private List<ProductoDTO> productos;



}



package com.soap.SoapServer.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
        "id", "username", "password",
        "nombre", "apellido","habilitado",
        "rol"
})

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String username;
    private String password;;
    private String nombre;
    private String apellido;
    private String habilitado;
    private String rol;


}

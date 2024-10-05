package com.grpc.grpc_server.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @Column(name = "foto", nullable = true)
    private String foto;

    public Producto(String nombre, String codigo, String foto) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.foto = foto;
    }
}

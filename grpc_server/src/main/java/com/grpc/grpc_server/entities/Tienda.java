package com.grpc.grpc_server.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tienda")
@Data
@NoArgsConstructor
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo", nullable = false, length = 100)
    private String codigo;

    @Column(name = "provincia", nullable = false, length = 100)
    private String provincia;

    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    @Column(name = "direccion", nullable = false, length = 150)
    private String direccion;

    @Column(name = "habilitada", nullable = false)
    private Boolean habilitada;

}

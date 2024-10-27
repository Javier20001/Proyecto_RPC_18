package com.soap.SoapServer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "filtro")
@Data
@NoArgsConstructor
public class Filtro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado;

}

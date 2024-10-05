package com.kafka.consumer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_en_novedades")
@Data
@NoArgsConstructor
public class ProductoEnNovedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @Column(name = "talle", nullable = false, length = 50)
    private String talle;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "foto", nullable = true)
    private String foto;

    @Column(name = "aceptado", nullable = false)
    private boolean aceptado;

}

package com.kafka.provider.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_provider")
@Data
@NoArgsConstructor
public class ProductProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "talle", nullable = false, length = 50)
    private String talle;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "foto", nullable = true)
    private String foto;

    @Override
    public String toString() {
        return "ProductProvider{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", color='" + color + '\'' +
                ", talle='" + talle + '\'' +
                ", stock=" + stock +
                ", foto='" + foto + '\'' +
                '}';
    }
}
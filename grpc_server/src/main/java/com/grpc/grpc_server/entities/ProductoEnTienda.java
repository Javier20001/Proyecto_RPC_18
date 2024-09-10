package com.grpc.grpc_server.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_en_tienda")
@Data
@NoArgsConstructor
public class ProductoEnTienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tienda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "talle", nullable = false, length = 50)
    private String talle;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

}

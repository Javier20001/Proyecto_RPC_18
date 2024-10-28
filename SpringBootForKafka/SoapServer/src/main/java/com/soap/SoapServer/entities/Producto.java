package com.soap.SoapServer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "producto")
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ElementCollection
    @CollectionTable(name = "producto_colores", joinColumns = @JoinColumn(name = "producto_id"))
    @Column(name = "color")
    private List<String> colores = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "producto_talles", joinColumns = @JoinColumn(name = "producto_id"))
    @Column(name = "talle")
    private List<String> talles = new ArrayList<>();

    @Column(name = "foto_url")
    private String fotoUrl;

    @ManyToOne
    @JoinColumn(name = "catalogo_id", nullable = false) // Establece la relación con Catalogo
    private Catalogo catalogo;

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", colores=" + colores +
                ", talles=" + talles +
                ", fotoUrl='" + fotoUrl + '\'' +
                '}';
    }
}
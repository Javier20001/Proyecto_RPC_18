package com.soap.SoapServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_en_oc")
@Data
@NoArgsConstructor
public class ProductoEnOC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "talle", nullable = false, length = 50)
    private String talle;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "orden_de_compra_id", nullable = false)
    private OrdenDeCompra ordenDeCompra;

    @Column(name = "cantidad_solicitada", nullable = false)
    private int cantidadSolicitada;


    @Override
    public String toString() {
        return "ProductoEnOC{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", color='" + color + '\'' +
                ", talle='" + talle + '\'' +
                ", cantidadSolicitada=" + cantidadSolicitada +
                '}';
    }
}

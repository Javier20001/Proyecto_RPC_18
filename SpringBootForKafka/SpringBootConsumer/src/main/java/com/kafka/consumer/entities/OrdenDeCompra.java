package com.kafka.consumer.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orden_de_compra")
@Data
@NoArgsConstructor
public class OrdenDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "observaciones", length = 200)
    private String observaciones;

    @OneToMany(mappedBy = "ordenDeCompra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductoEnOC> productosEnOC;

    @ManyToOne
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tienda;

    @OneToOne
    @JoinColumn(name = "orden_de_despacho_id", nullable = true)
    private OrdenDeDespacho ordenDeDespacho;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate fechaDeSolicitud;

    @Column(nullable = true)
    private LocalDate fechaDeRecepcion;

    @Column(name = "pausada", nullable = false)
    private Boolean pausada;

}

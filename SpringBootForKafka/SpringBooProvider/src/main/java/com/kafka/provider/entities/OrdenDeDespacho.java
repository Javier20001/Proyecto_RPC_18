package com.kafka.provider.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "orden_de_despacho")
@Data
@NoArgsConstructor
public class OrdenDeDespacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToOne(mappedBy = "ordenDeDespacho", cascade = CascadeType.ALL)
    private OrdenDeCompra ordenDeCompra;

    @Column(name = "fecha_estimada_de_envio", nullable = true)
    private LocalDate fechaEstimadaDeEnvio;

}

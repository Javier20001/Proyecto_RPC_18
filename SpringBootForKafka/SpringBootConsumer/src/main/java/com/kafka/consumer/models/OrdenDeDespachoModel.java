package com.kafka.consumer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrdenDeDespachoModel {

    private int id;
    private LocalDate fechaEstimadaDeEnvio;
    private int ordenDeCompraId;

}

package com.grpc.grpc_server.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "tienda_id", nullable = true)
    private Tienda tienda;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "habilitado", nullable = false)
    private Boolean habilitado;

    @Column(name = "rol", nullable = false)
    private String rol;

    public User(String username, String password, String nombre, String apellido, Boolean habilitado, String rol) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilitado = habilitado;
        this.rol = rol;
    }
}

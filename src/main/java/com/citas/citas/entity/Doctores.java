package com.citas.citas.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table

public class Doctores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    private String especialidad;

}

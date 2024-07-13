package com.citas.citas.entity;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table

public class Consultorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_consultorio")
    private String numeroConsultorio;

    private int piso;
}

package com.citas.citas.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table

public class Citas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultorio_id", referencedColumnName = "id")
    private Consultorios consultorio;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctores doctor;

    @Column(name = "horario_consulta")
    private LocalDateTime horarioConsulta;

    @Column(name = "nombre_paciente")
    private String nombrePaciente;
}

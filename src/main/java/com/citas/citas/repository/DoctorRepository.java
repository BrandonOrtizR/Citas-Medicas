package com.citas.citas.repository;

import com.citas.citas.entity.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctores, Long> {
    // Puedes añadir métodos personalizados de consulta si los necesitas
}
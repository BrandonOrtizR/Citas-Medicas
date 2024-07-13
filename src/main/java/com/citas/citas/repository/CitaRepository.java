package com.citas.citas.repository;

import com.citas.citas.entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Citas, Long> {
    // Puedes añadir métodos personalizados de consulta si los necesitas
}
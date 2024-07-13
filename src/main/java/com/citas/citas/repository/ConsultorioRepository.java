package com.citas.citas.repository;

import com.citas.citas.entity.Consultorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorios, Long> {
    // Puedes añadir métodos personalizados de consulta si los necesitas
}
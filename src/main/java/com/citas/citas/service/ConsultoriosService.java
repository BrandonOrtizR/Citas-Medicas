package com.citas.citas.service;

import com.citas.citas.entity.Consultorios;
import com.citas.citas.repository.ConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultoriosService {

    private final ConsultorioRepository consultorioRepository;

    @Autowired
    public ConsultoriosService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public List<Consultorios> getAllConsultorios() {
        return consultorioRepository.findAll();
    }

    public Optional<Consultorios> getConsultorioById(Long id) {
        return consultorioRepository.findById(id);
    }

    public Consultorios saveConsultorio(Consultorios consultorio) {
        return consultorioRepository.save(consultorio);
    }

    public void deleteConsultorio(Long id) {
        consultorioRepository.deleteById(id);
    }
}

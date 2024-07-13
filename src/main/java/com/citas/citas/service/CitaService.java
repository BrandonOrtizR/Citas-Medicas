package com.citas.citas.service;

import com.citas.citas.entity.Citas;
import com.citas.citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    @Autowired
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Citas> getAllCitas() {
        return citaRepository.findAll();
    }

    public Optional<Citas> getCitaById(Long id) {
        return citaRepository.findById(id);
    }

    public Citas saveCita(Citas cita) {
        return citaRepository.save(cita);
    }

    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }
}

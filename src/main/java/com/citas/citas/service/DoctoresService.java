package com.citas.citas.service;

import com.citas.citas.entity.Doctores;
import com.citas.citas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctoresService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctoresService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    

    public List<Doctores> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctores> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctores saveDoctor(Doctores doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}

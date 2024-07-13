package com.citas.citas.Controller;

import com.citas.citas.entity.Doctores;
import com.citas.citas.service.DoctoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final DoctoresService doctorService;

    @Autowired
    public DoctorController(DoctoresService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctores>> getAllDoctores() {
        List<Doctores> doctores = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctores> getDoctorById(@PathVariable Long id) {
        Doctores doctor = doctorService.getDoctorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<Doctores> saveDoctor(@RequestBody Doctores doctor) {
        Doctores savedDoctor = doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
package com.citas.citas.Controller;

import com.citas.citas.entity.Citas;
import com.citas.citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<Citas>> getAllCitas() {
        List<Citas> citas = citaService.getAllCitas();
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citas> getCitaById(@PathVariable Long id) {
        Citas cita = citaService.getCitaById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita not found with id: " + id));
        return ResponseEntity.ok(cita);
    }

    @PostMapping
    public ResponseEntity<Citas> saveCita(@RequestBody Citas cita) {
        Citas savedCita = citaService.saveCita(cita);
        return new ResponseEntity<>(savedCita, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }
}

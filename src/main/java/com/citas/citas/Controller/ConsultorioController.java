package com.citas.citas.Controller;

import com.citas.citas.entity.Consultorios;
import com.citas.citas.service.ConsultoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {

    private final ConsultoriosService consultorioService;

    @Autowired
    public ConsultorioController(ConsultoriosService consultoriosService) {
        this.consultorioService = consultoriosService;
    }

    @GetMapping
    public ResponseEntity<List<Consultorios>> getAllConsultorios() {
        List<Consultorios> consultorios = consultorioService.getAllConsultorios();
        return ResponseEntity.ok(consultorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultorios> getConsultorioById(@PathVariable Long id) {
        Consultorios consultorio = consultorioService.getConsultorioById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consultorio not found with id: " + id));
        return ResponseEntity.ok(consultorio);
    }

    @PostMapping
    public ResponseEntity<Consultorios> saveConsultorio(@RequestBody Consultorios consultorio) {
        Consultorios savedConsultorio = consultorioService.saveConsultorio(consultorio);
        return new ResponseEntity<>(savedConsultorio, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultorio(@PathVariable Long id) {
        consultorioService.deleteConsultorio(id);
        return ResponseEntity.noContent().build();
    }
}

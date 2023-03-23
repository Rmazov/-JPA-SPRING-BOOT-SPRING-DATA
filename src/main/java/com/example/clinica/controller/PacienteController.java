package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.service.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PacienteController {

    private ServicioPaciente servicioPaciente;

    @Autowired
    public PacienteController(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    @PostMapping("/paciente")
    public Paciente crear(@RequestBody Paciente paciente) {
        return this.servicioPaciente.crear(paciente);
    }



    @GetMapping("/pacientes")
    public List<Paciente> obtenerTodosOdontologos() {
        return servicioPaciente.obtenerOdontologos();
    }


    @DeleteMapping("/pacientes/{dni}")
    public ResponseEntity<Void> eliminarPorMatricula(@PathVariable Integer dni) {
        servicioPaciente.eliminarPorMatricula(dni);
        return ResponseEntity.noContent().build();
    }

    //crear endpoint para eliminar paciente por dni
}

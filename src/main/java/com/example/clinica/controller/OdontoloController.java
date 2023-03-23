package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OdontoloController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontoloController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/odontologo")
    public Odontologo crear(@RequestBody Odontologo odontologo) {
        return this.odontologoService.crear(odontologo);
    }


    @GetMapping("/odontologos")
    public List<Odontologo> obtenerTodosOdontologos() {
        return odontologoService.obtenerOdontologos();
    }


    @DeleteMapping("/odontologo/{matricula}")
    public ResponseEntity<Void> eliminarPorMatricula(@PathVariable Integer matricula) {
        odontologoService.eliminarPorMatricula(matricula);
        return ResponseEntity.noContent().build();
    }

}

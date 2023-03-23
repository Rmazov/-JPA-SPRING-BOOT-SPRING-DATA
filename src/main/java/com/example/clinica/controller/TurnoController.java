package com.example.clinica.controller;

import com.example.clinica.model.Turno;
import com.example.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class TurnoController {

    //crear controlador de asignar el turno.
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/turno/{dni}/{matricula}/{fechaTurno}")
    public ResponseEntity<Turno> crearTurno(@PathVariable Integer dni, @PathVariable Integer matricula, @PathVariable String fechaTurno) {
        Turno turno = turnoService.generar(dni, matricula, fechaTurno);
        return ResponseEntity.ok(turno);
    }
}

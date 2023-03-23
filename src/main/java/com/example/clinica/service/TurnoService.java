package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.model.Turno;
import com.example.clinica.repository.OdontologoRepository;
import com.example.clinica.repository.PacienteRepository;
import com.example.clinica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurnoService {

    private TurnoRepository turnoRepository;
    private OdontologoRepository odontologoRepository;
    private PacienteRepository pacienteRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, OdontologoRepository odontologoRepository, PacienteRepository pacienteRepository) {
        this.turnoRepository = turnoRepository;
        this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Turno generar(Integer dni, Integer matricula, String fechaTurno){
        if(dni < 0 || matricula < 0 || fechaTurno == null) {
            throw new RuntimeException("VALORES NULOS");
        }

        Optional<Odontologo> odontologo =  this.odontologoRepository.findById(matricula);
        Optional<Paciente> paciente =  this.pacienteRepository.findById(dni);

        if(odontologo.isPresent() && paciente.isPresent()){
            Turno turno = new Turno(odontologo.get(), paciente.get(), fechaTurno);
            this.turnoRepository.save(turno);
            return turno;
        }
        return new Turno();
    }
}

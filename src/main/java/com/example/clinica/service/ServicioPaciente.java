package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPaciente {
    private PacienteRepository pacienteRepository;

    @Autowired
    public ServicioPaciente(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente crear(Paciente paciente){
        if(paciente.getDni() < 0 || paciente.getNombre() == null){
            throw new RuntimeException("Paciente no puede tener nombre nulo o dni negativo");
        }
        this.pacienteRepository.save(paciente);
        return paciente;
    }

    public List<Paciente> obtenerOdontologos() {
        return (List<Paciente>) pacienteRepository.findAll();

    }

    public void eliminarPorMatricula(Integer dni) {

        pacienteRepository.deleteById(dni);
    }


}

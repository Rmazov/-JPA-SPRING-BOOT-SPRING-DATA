package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private List<Odontologo> odontologos;
    private OdontologoRepository  odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo crear (Odontologo odontologo){
        this.odontologoRepository.save(odontologo);
        return odontologo;
    }


    public List<Odontologo> obtenerOdontologos() {
        return (List<Odontologo>) odontologoRepository.findAll();
    }
    public void eliminarPorMatricula(Integer matricula) {
        odontologoRepository.deleteById(matricula);
    }

}

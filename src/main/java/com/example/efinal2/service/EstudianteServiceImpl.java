package com.example.efinal2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.efinal2.repository.IEstudianteRepository;
import com.example.efinal2.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void guardar(Estudiante estudiante) {
        this.estudianteRepository.insertar(estudiante);
    }

}

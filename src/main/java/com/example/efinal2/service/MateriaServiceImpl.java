package com.example.efinal2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.efinal2.repository.IMateriaRepository;
import com.example.efinal2.repository.modelo.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService{
    @Autowired
	private IMateriaRepository iMateriaRepository;

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void guardar(Materia materia) {
        this.iMateriaRepository.insertar(materia);
    }

}

package com.example.efinal2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.efinal2.repository.modelo.Matricula;
import com.example.efinal2.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{

    @PersistenceContext
	private EntityManager entityManager;


    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<MatriculaDTO> seleccionarReporteDTO() {
        TypedQuery<MatriculaDTO> myQuery = this.entityManager.createQuery("SELECT new com.example.efinal2.repository.modelo.dto.MatriculaDTO(m.estudiante.cedula,m.materia.nombre,m.materia.cedulaProfesor,m.nombreHilo) FROM Matricula m", MatriculaDTO.class);
		return myQuery.getResultList();
    }
    
    @Override
    @Transactional(value = TxType.REQUIRED)
    public void insertar(Matricula matricula) {
        this.entityManager.persist(matricula);
    }

}

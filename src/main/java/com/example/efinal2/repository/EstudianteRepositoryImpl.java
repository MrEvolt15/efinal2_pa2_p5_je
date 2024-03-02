package com.example.efinal2.repository;

import org.springframework.stereotype.Repository;

import com.example.efinal2.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
    
    @PersistenceContext
	private EntityManager entityManager;

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula", Estudiante.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
    }

}

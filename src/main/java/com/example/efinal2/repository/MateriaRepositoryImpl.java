package com.example.efinal2.repository;

import org.springframework.stereotype.Repository;

import com.example.efinal2.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

    @PersistenceContext
	private EntityManager entityManager;

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Materia seleccionarPorCodigo(String codigo) {
        TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo=:codigo",Materia.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
    }

}

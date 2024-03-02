package com.example.efinal2.repository;

import com.example.efinal2.repository.modelo.Materia;

public interface IMateriaRepository {
    public void insertar(Materia materia);
	public Materia seleccionarPorCodigo(String codigo);
}

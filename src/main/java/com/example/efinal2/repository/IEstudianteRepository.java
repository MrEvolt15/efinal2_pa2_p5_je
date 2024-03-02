package com.example.efinal2.repository;

import com.example.efinal2.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public void insertar(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);
}

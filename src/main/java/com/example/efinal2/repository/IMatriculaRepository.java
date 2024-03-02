package com.example.efinal2.repository;

import java.util.List;

import com.example.efinal2.repository.modelo.Matricula;
import com.example.efinal2.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaRepository {
    public List<MatriculaDTO> seleccionarReporteDTO();
	public void insertar(Matricula matricula);
}

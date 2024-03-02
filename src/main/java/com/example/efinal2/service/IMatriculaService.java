package com.example.efinal2.service;

import java.util.List;

import com.example.efinal2.repository.modelo.Matricula;
import com.example.efinal2.repository.modelo.dto.MatriculaDTO;
import com.example.efinal2.service.dto.MatriculaServiceDTO;

public interface IMatriculaService {
    public List<MatriculaDTO> reporte();
	public void matriculaAsync(MatriculaServiceDTO matriculaTO);
	public void matricularCedulaCodigo(String cedula, String codigo, Matricula matricula);
}

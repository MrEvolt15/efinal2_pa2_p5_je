package com.example.efinal2.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.efinal2.repository.modelo.dto.MatriculaDTO;
import com.example.efinal2.service.IMatriculaService;
import com.example.efinal2.service.dto.MatriculaServiceDTO;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaControler {
    @Autowired
	private IMatriculaService iMatriculaService;

	//http://localhost:8080/matriculas/reporte
	@GetMapping(value = "/reporte")
	public String reporte(MatriculaDTO matriculaDTO, Model model) {
		List<MatriculaDTO> matriculas = this.iMatriculaService.reporte();
		model.addAttribute("matriculas", matriculas);
		return "vistaReporteMatriculas";
	}
	//http://localhost:8080/matriculas/nuevaMatricula
	@GetMapping(value = "/nuevaMatricula")
	public String guardarNueva(MatriculaServiceDTO matriculaTO) {
		return "vistaNuevaMatricula";
	}

	@PostMapping(value = "/matricular")
	public String matricular(MatriculaServiceDTO matriculaServiceDTO) {
		this.iMatriculaService.matriculaAsync(matriculaServiceDTO);
		return "redirect:/matriculas/nuevaMatricula";
	}
}

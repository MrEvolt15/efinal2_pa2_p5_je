package com.example.efinal2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.efinal2.repository.modelo.Estudiante;
import com.example.efinal2.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteControler {
    @Autowired
	private IEstudianteService iEstudianteService;

	//http://localhost:8080/estudiantes/nuevo
	@GetMapping(value = "/nuevo")
	public String guardarNuevo(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}

	@PostMapping(value = "/guardar")
	public String guardar(Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevo";
	}
}

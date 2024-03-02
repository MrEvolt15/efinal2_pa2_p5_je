package com.example.efinal2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.efinal2.repository.modelo.Materia;
import com.example.efinal2.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaControler {
    @Autowired
	private IMateriaService iMateriaService;

	//http://localhost:8080/materias/nueva
	@GetMapping(value = "/nueva")
	public String guardarNueva(Materia materia) {
		return "vistaNuevaMateria";
	}

	@PostMapping(value = "/guardar")
	public String guardar(Materia materia) {
		this.iMateriaService.guardar(materia);
		return "redirect:/materias/nueva";
	}
}

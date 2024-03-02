package com.example.efinal2.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.efinal2.repository.IEstudianteRepository;
import com.example.efinal2.repository.IMateriaRepository;
import com.example.efinal2.repository.IMatriculaRepository;
import com.example.efinal2.repository.modelo.Estudiante;
import com.example.efinal2.repository.modelo.Materia;
import com.example.efinal2.repository.modelo.Matricula;
import com.example.efinal2.repository.modelo.dto.MatriculaDTO;
import com.example.efinal2.service.dto.MatriculaServiceDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

    @Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public List<MatriculaDTO> reporte() {
        return this.iMatriculaRepository.seleccionarReporteDTO();
    }

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void matriculaAsync(MatriculaServiceDTO matriculaServiceDTO) {
        Matricula m1 = new Matricula();
		m1.setFecha(LocalDate.now());
		Materia ma1 = new Materia();
		ma1.setCodigo(matriculaServiceDTO.getCodM1());
		m1.setMateria(ma1);
		Matricula m2 = new Matricula();
		m2.setFecha(LocalDate.now());
		Materia ma2 = new Materia();
		ma2.setCodigo(matriculaServiceDTO.getCodM2());
		m2.setMateria(ma2);
		Matricula m3 = new Matricula();
		m3.setFecha(LocalDate.now());
		Materia ma3 = new Materia();
		ma3.setCodigo(matriculaServiceDTO.getCodM3());
		m3.setMateria(ma3);
		Matricula m4 = new Matricula();
		Materia ma4 = new Materia();
		ma4.setCodigo(matriculaServiceDTO.getCodM4());
		m4.setMateria(ma4);
        List<Matricula> matriculas = new ArrayList<>();
		matriculas.add(m1);
		matriculas.add(m2);
		matriculas.add(m3);
		matriculas.add(m4);


        matriculas.parallelStream().forEach(matricula -> {
			String hilo = Thread.currentThread().getName();
			matricula.setNombreHilo(hilo);
			//clase dto del paquete service
			this.matricularCedulaCodigo(matriculaServiceDTO.getCedulaEstudiante(), matricula.getMateria().getCodigo(),matricula);

		});
    }

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void matricularCedulaCodigo(String cedula, String codigo, Matricula matricula) {

        Estudiante estudiante = this.estudianteRepository.seleccionarPorCedula(cedula);

		Materia materia = this.iMateriaRepository.seleccionarPorCodigo(codigo);

		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDate.now());
		this.iMatriculaRepository.insertar(matricula);
    }

}

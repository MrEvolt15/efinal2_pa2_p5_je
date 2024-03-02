package com.example.efinal2.service.dto;

public class MatriculaServiceDTO {
    private String cedulaEstudiante;
	private String codM1;
	private String codM2;
	private String codM3;
	private String codM4;

    public MatriculaServiceDTO() {
		super();
	}

	public MatriculaServiceDTO(String cedulaEstudiante, String codM1, String codM2,
			String codM3, String codM4) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codM1 = codM1;
		this.codM2 = codM2;
		this.codM3 = codM3;
		this.codM4 = codM4;
	}

    //SETS Y GETS
    public String getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(String cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public String getCodM1() {
        return codM1;
    }

    public void setCodM1(String codM1) {
        this.codM1 = codM1;
    }

    public String getCodM2() {
        return codM2;
    }

    public void setCodM2(String codM2) {
        this.codM2 = codM2;
    }

    public String getCodM3() {
        return codM3;
    }

    public void setCodM3(String codM3) {
        this.codM3 = codM3;
    }

    public String getCodM4() {
        return codM4;
    }

    public void setCodM4(String codM4) {
        this.codM4 = codM4;
    }

    

}

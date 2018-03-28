package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import java.util.Date;

import lombok.Data;

@Data
public class FactEscalaXCategoria {
	private String idEscala;
	private String idTipoPuesto;
	private String idCategoriaSalarial;
	private float tiempoMinimoAlmuerzo;
	private String tipoCalculo;
	private float horasPeriodo;
	private Date horaInicioAdicNocturno;
	private Date horaFinAdicNocturno;	
	
	private boolean horasPeriodoReconfiguradas;
	
	private String horaInicioAdicNocturnoQA;
	private String horaFinAdicNocturnoQA;	
}

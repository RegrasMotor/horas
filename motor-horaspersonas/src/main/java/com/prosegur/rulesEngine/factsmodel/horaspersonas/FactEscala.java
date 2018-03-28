package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import lombok.Data;

@Data
public class FactEscala {
	private String id;
	private int diasTrabajadosXsemana;
	private int diasLibresXsemana;
	private boolean mediaJornada;
	
	private boolean diasTrabajoLibresEscalaReconfiguradas;
}

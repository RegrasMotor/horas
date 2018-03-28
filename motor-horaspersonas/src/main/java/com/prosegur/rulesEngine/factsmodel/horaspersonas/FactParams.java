package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import lombok.Data;

@Data
public class FactParams {
	private float numeroDiasMes;
	private float coeficienteStdDiasXsemana;
	private boolean aceptaPuestosSinCobertura;
	private int numeroFestivosAno;
}

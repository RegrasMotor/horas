package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import lombok.Data;

@Data
public class FactOT {
	private String id;
	private String tipoServicio;	
	private String delegacion;
	private String empresa;
	private FactSubcliente subcliente;
}

package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import lombok.Data;

@Data
public class FactRequest {
	private FactParams params;
	private FactCategoriaSalarial categoriaSalarial;
	private FactEscala escala;
	private FactEscalaXCategoria escalaXcategoria;
	private FactEsquemaOperativo esquemaOperativo;
	private FactOT ot;
	private FactSubcliente subcliente;
	private FactTipoPuesto tipoPuesto;
}

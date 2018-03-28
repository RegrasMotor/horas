package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import java.util.Date;

import lombok.Data;

@Data
public class FactEsquemaOperativo {
	private String id;
	private int numeroPuestos;
	private String idEscala;
	private String idTipoPuesto;
	private boolean mediaJornada;
	private String frecuenciaMediaJornada;
	private float horasJornadaXpersona;
	private boolean puestoSinCobertura;	
	private String idCategoriaSalarial;
	private Date fechaInicioServicio;
	private Date fechaFinServicio;	
	private Date horaInicioJornada;
	private Date horaFinJornada;
	private String coberturaAlmuerzo;
	private float horasAlmuerzo;
	private Float numeroRealPersonasInf;
	private String tipoJornada;
	
	private boolean trabajaLunes;
	private boolean trabajaMartes;
	private boolean trabajaMiercoles;
	private boolean trabajaJueves;
	private boolean trabajaViernes;
	private boolean trabajaSabado;
	private boolean trabajaDomingo;
	
	private String horaInicioJornadaQA;
	private String horaFinJornadaQA;
}

package com.prosegur.rulesEngine.factsmodel.horaspersonas;

import lombok.Data;

@Data
public class FactResponse {
	private Double numeroPersonas;
	private Double numeroRealPersonas;
	private Double horasVendidas;
	private Double horasTrabajadas;
	private Double horasNormales;
	private Double horasExtrasEfetivas;
	private Double horasExtrasLibreTrabajado;
	private Double horasAdicIntrajornada;
	private Double horasAdicNocturno;
	private Double horasExtrasFestivo;
	private Double horasExtrasEspeciales;	
	
	private Float horasAlmuerzoJornadaXpersona;
	private Float horasEfectivasJornadaXpersona;
	private Boolean servicioRif;
	private Integer numeroMesesServicio;
	private Integer numeroTurnosDia;
	private Integer numeroFestivosAnuales;
	private Float numeroFestivosMensuales;
	private Float mediaDiasEfectivosMes;	
	private boolean extensionAdicNocturno;
	private boolean horaExtrasMayor2horas;
	private Float mediaDiasTrabajoMes;
	private Float numeroHorasFestivosMesProporcionalEscala;
	private Float numeroHorasFestivosMesProporcionalLibres;
	private Float mediaDiasEscalaMes;
	private Float numeroDiasFestivosPropEscala;
	private Float numeroDiasEscalaDescFestivos;
	private Float horasEscalaXpersona;
	private Float totalHorasEscala;
	private Float numeroHorasFestivasPropEscala;
	private Float numeroHorasFestivasPropLibres;
	private boolean reconfMaximoHorasExtrasXpersona;
	private Float horasExtrasXpersona;
	private Float horasExtras50Xpersona;
	private Float horasNormalesXpersona;
	private Integer diasTrabajadosXsemana;
	private Float horasJornadaXpuesto;
	private Double numeroTurnosMes;
	private boolean rendeiro;

	
	private boolean horasExtrasXpersonaReconfiguradas;
}

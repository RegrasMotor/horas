package com.prosegur.rulesEngine.services.soapService.model.horaspersonas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@XmlType
public class Params {
	@XmlElement (defaultValue="30.41666667") 
	private float numeroDiasMes = 365/12f;
	
	@XmlElement (defaultValue="4.3452") 
	private float coeficienteStdDiasXsemana = 4.3452f;
	
	@XmlElement (defaultValue="true") 
	private boolean aceptaPuestosSinCobertura = true;
	
	@XmlElement (defaultValue="14")
	private int numeroFestivosAno = 14;
}

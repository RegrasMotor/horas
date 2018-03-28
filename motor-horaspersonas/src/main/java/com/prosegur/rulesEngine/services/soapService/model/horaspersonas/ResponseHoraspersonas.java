package com.prosegur.rulesEngine.services.soapService.model.horaspersonas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.Hora.TipoHora;

@Data
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseHoraspersonas {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(ResponseHoraspersonas.class);
	
	@XmlElement
	private double numeroPersonas;

	@XmlElement
	private double numeroRealPersonas;
	
	@XmlElement
	private double numeroTurnosMes;	

	@XmlElement
	private double horasVendidas;
	
	@XmlElement
	private double horasTrabajadas;	
	
	@XmlElementWrapper (required=true)
	@XmlElement(name = "hora", required=true)
	private List<Hora> horas;
	
	public void addHora (Hora hora) {
		if (horas == null) {
			horas = new ArrayList<Hora>();
		}
		horas.add(hora);
	}
	
	public void addHora (TipoHora tipoHora, double valor) {
		Hora hora = new Hora (tipoHora, valor);

		this.addHora (hora);
	}
	
	public Hora getHora (TipoHora tipoHora) {
		if (horas !=null) {
			for (Hora hora : horas) {
				if (hora.getId() == tipoHora) {
					return hora;
				}
			}
		}
		
		return null;
	}	
}

package com.prosegur.rulesEngine.services.soapService.model.horaspersonas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Escala {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(Escala.class);
	
	@XmlID
	@XmlAttribute (required=true)
	private String uid;
	
	@XmlAttribute (required=true)
	private String id;

	@XmlElement
	private int diasTrabajadosXsemana;
	
	@XmlElement 
	private int diasLibresXsemana;
	
	@XmlElement (name="bolPartTime")
	private boolean mediaJornada;
}

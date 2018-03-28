package com.prosegur.rulesEngine.services.soapService.model.horaspersonas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
public class RequestHoraspersonas {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(RequestHoraspersonas.class);

	@XmlAttribute (required=true)
	private String pais;
	
	@XmlAttribute
	private String simulador;
	
	@XmlElement (required=true)
	private Params params;
	
	@XmlElement (required=true)
	private OT ot;

	@XmlElement (required=true)
	private Subcliente subcliente;
	
	@XmlElement (required=true)
	private EsquemaOperativo esquemaOperativo;
	
	@XmlElement (required=true)
	private TipoPuesto tipoPuesto;

	@XmlElement (required=true)
	private CategoriaSalarial categoriaSalarial;

	@XmlElement (required=true)
	private Escala escala;
	
	@XmlElement (required=true)
	private EscalaXCategoria escalaXcategoria;
}

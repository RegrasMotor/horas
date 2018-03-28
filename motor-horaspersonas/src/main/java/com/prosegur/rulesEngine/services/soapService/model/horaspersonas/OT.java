package com.prosegur.rulesEngine.services.soapService.model.horaspersonas;

import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
@Data
@EqualsAndHashCode
public class OT {
	@Getter(AccessLevel.NONE)	
	private final Logger log = LoggerFactory.getLogger(OT.class);

	@Getter(AccessLevel.NONE)	
	private static MessageSource messageSource;	
	@Autowired
    private void setMessageSource(MessageSource messageSource){
        OT.messageSource = messageSource;
    }
	
	@XmlID
	@XmlAttribute (required=true)
	private String uid;
	
	@XmlElement (required=true)
	private String empresa;	
	
	@XmlElement (required=true)
	private String delegacion;	
	
	@XmlElement (required=true)
	private TipoServicio tipoServicio;	

	@XmlIDREF
	@XmlElement (required=true)
	private Subcliente subcliente;
	
	@XmlEnum
	public enum TipoServicio {
		@XmlEnumValue("RIF") 		RIF("RIF"), 
		@XmlEnumValue("ESPORADICO")	ESPORADICO("ESPORADICO");

		private final String value;
		
		TipoServicio(String v) {
			value = v;
		}
		
		public String value() {
			return value;
		}
		
		public static TipoServicio fromValue(String v) {
	        for (TipoServicio c: TipoServicio.values()) {
	            if (c.value.equals(v)) {
	                return c;
	            }
	        }
	        throw new IllegalArgumentException(messageSource.getMessage("IllegalArgumentException.message",new Object[] {TipoServicio.class.getSimpleName(), v}, Locale.getDefault()));
	    }
	}	
}

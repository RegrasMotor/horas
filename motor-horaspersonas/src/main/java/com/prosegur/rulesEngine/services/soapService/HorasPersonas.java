package com.prosegur.rulesEngine.services.soapService;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.cxf.annotations.SchemaValidation;

import com.prosegur.rulesEngine.services.soapService.exception.WebServiceException;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.RequestHoraspersonas;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.ResponseHoraspersonas;

@WebService
@SchemaValidation
public interface HorasPersonas {
	
	public @WebResult(name="responseHoraspersonas", targetNamespace="http://soapService.services.rulesEngine.prosegur.com/") ResponseHoraspersonas calcularHorasPersonas(
			@XmlElement(required=true) @WebParam(name="requestHoraspersonas") RequestHoraspersonas requestHoraspersonas 
    ) throws WebServiceException;
}


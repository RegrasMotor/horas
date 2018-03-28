package com.prosegur.rulesEngine.services.soapService.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;
import com.prosegur.rulesEngine.services.EngineServices;
import com.prosegur.rulesEngine.services.soapService.HorasPersonas;
import com.prosegur.rulesEngine.services.soapService.exception.SoapFault;
import com.prosegur.rulesEngine.services.soapService.exception.WebServiceException;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.RequestHoraspersonas;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.ResponseHoraspersonas;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.factsformat.FactsFormat;

@WebService(endpointInterface = "com.prosegur.rulesEngine.services.soapService.HorasPersonas")
public class HorasPersonasImpl implements HorasPersonas {
	@SuppressWarnings("unused")	
	private static final Logger log = LoggerFactory.getLogger(HorasPersonasImpl.class);
	
	@Autowired
	private EngineServices engineServices;

	@Override
	public ResponseHoraspersonas calcularHorasPersonas (RequestHoraspersonas request) throws WebServiceException {
		try {
			FactRequest factRequest = FactsFormat.parse(request);
			
			FactResponse factResponse = engineServices.executeHorasPersonas(factRequest, request.getPais(), request.getSimulador());
			
			ResponseHoraspersonas response = FactsFormat.format(factResponse);
			
			return response;
		} catch (Exception e) {
			throw new WebServiceException("There was an unhandled exception at runtime.", new SoapFault(e));
		}			
	}
}


package com.prosegur.rulesEngine.services;

import org.springframework.stereotype.Service;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;
import com.prosegur.rulesEngine.services.exception.ServiceException;

@Service
public interface EngineServices {

	public FactResponse executeHorasPersonas (FactRequest factRequestHoraspersonas, String pais, String simulador) throws ServiceException;
}

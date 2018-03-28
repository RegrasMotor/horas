package com.prosegur.rulesEngine.services;

import java.util.ArrayList;
import java.util.List;

import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prosegur.rulesEngine.engine.Engine;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;
import com.prosegur.rulesEngine.services.exception.ServiceException;

@Component
public class EngineServicesImpl implements EngineServices {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(EngineServicesImpl.class);

	@Autowired private Engine engine;
	@Value("${engine.name}") String engineName;
	
	public FactResponse executeHorasPersonas (FactRequest factRequestHoraspersonas, String pais, String simulador) throws ServiceException {
		List<Object> facts = new ArrayList<Object>();
		facts.add(factRequestHoraspersonas.getParams());
		facts.add(factRequestHoraspersonas.getOt());
		facts.add(factRequestHoraspersonas.getEsquemaOperativo());
		facts.add(factRequestHoraspersonas.getEscala());
		facts.add(factRequestHoraspersonas.getTipoPuesto());
		facts.add(factRequestHoraspersonas.getCategoriaSalarial());
		facts.add(factRequestHoraspersonas.getEscalaXcategoria());
		
		FactResponse factResponse = new FactResponse();        
		facts.add(factResponse);
		
		String knowledgeAgentName = pais + "." + engineName;
		if (simulador!=null && !simulador.isEmpty()) {
			knowledgeAgentName += ("." + simulador);
		}
		
		StatelessKnowledgeSession ksession;
		try {
			ksession = engine.createKnowledgeSession(engine.getKnowledgeAgent(knowledgeAgentName));
		} catch (Exception ex) {
			throw new ServiceException("The request cannot be handled by some knowledge agent configured");
		}
		
		ksession.execute(facts);
		
		return factResponse;		
	}
}

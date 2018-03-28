package com.prosegur.rulesEngine.engine.audit;

import org.drools.definition.rule.Rule;
import org.drools.event.rule.BeforeActivationFiredEvent;
import org.drools.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAgenda extends DefaultAgendaEventListener {
	private static final Logger log = LoggerFactory.getLogger(LogAgenda.class);
	
	@Override
	public void beforeActivationFired(final BeforeActivationFiredEvent event) {
		if (log.isTraceEnabled()) {
			final Rule rule = event.getActivation().getRule();
		
			log.trace("KnowledgeRuntime@" + Integer.toHexString(event.getKnowledgeRuntime().hashCode()) + ". Rule fired: " + rule.getPackageName() + "." + rule.getName());
		}
	}
}
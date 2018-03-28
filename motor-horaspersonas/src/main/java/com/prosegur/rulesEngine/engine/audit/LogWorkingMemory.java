package com.prosegur.rulesEngine.engine.audit;

import org.drools.event.rule.ObjectInsertedEvent;
import org.drools.event.rule.ObjectRetractedEvent;
import org.drools.event.rule.ObjectUpdatedEvent;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogWorkingMemory implements WorkingMemoryEventListener {
	private static final Logger log = LoggerFactory.getLogger(LogWorkingMemory.class);
	
	public void objectUpdated(final ObjectUpdatedEvent event) {
		if (log.isTraceEnabled()) {
			log.trace("KnowledgeRuntime@" + Integer.toHexString(event.getKnowledgeRuntime().hashCode()) + ". Object updated: " + event.getObject().toString());
		}
	}
	
    public void objectInserted(ObjectInsertedEvent event) {
    	if (log.isTraceEnabled()) {
    		log.trace("KnowledgeRuntime@" + Integer.toHexString(event.getKnowledgeRuntime().hashCode()) + ". Object inserted: " + event.getObject().toString());
    	}
    }

    public void objectRetracted(ObjectRetractedEvent event) {
    	if (log.isTraceEnabled()) {
    		log.trace("KnowledgeRuntime@" + Integer.toHexString(event.getKnowledgeRuntime().hashCode()) + ". Object retracted: " + event.getOldObject().toString());
    	}
    }

}
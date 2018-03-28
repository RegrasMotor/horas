package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class CantidadRealDePersonas extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/Cantidad real de personas.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();
		
		assertEquals(5, factResponse.getNumeroRealPersonas(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo2());
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroRealPersonas(), delta);
    }
	
	
	private FactResponse getResponse() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes(21f);
		factResponse.setMediaDiasEscalaMes (20f);
		
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setNumeroRealPersonasInf(5f);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setNumeroRealPersonasInf(0f);
		
		return esquemaOperativo;
	}	
}

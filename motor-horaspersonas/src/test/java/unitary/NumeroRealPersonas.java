package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroRealPersonas extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Cantidad real de personas.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_1();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_1());
		
		ksession.fireAllRules();
		
		assertEquals(3, factResponse.getNumeroRealPersonas(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_1();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_2());

		
		ksession.fireAllRules();
		
		assertEquals(16, factResponse.getNumeroRealPersonas(), delta);		
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse_1();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_3());

		
		ksession.fireAllRules();
		
		assertEquals(3, factResponse.getNumeroRealPersonas(), delta);		
    }
	
	private FactEsquemaOperativo getEsqOp_1() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		
		return factEsquemaOperativo;
	}

	private FactEsquemaOperativo getEsqOp_2() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setNumeroRealPersonasInf((float)16);
		
		return factEsquemaOperativo;
	}

	private FactEsquemaOperativo getEsqOp_3() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setNumeroRealPersonasInf((float)-5);
		
		return factEsquemaOperativo;
	}
	
	private FactResponse getResponse_1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setNumeroPersonas(3d);
		
		return factResponse;
	}	
}

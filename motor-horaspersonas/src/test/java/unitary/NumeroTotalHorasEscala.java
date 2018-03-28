package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroTotalHorasEscala extends JUnitBase {
	
private final static String rulesFile = "rules/horaspersonas/BRA/Numero total de horas escala.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse();
		ksession.insert(factResponse);	
		
		ksession.fireAllRules();
		
		assertEquals(24, factResponse.getTotalHorasEscala(), delta);
    }
	
	
	private FactResponse getResponse() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(6f);
		factResponse.setNumeroRealPersonas(4d);
						
		return factResponse;
	}

}

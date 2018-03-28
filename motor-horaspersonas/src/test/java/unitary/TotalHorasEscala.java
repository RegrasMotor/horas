package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class TotalHorasEscala extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Numero total de horas escala.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_horas150_personas2();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();
		
		assertEquals(300, factResponse.getTotalHorasEscala(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_horas145_personas4();
		ksession.insert(factResponse);		
		
		ksession.fireAllRules();
		
		assertEquals(580, factResponse.getTotalHorasEscala(), delta);
    }	
	
	private FactResponse getResponse_horas150_personas2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(150f);
		factResponse.setNumeroRealPersonas(2d);
		
		return factResponse;
	}	
	
	private FactResponse getResponse_horas145_personas4() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(145f);
		factResponse.setNumeroRealPersonas(4d);
		
		return factResponse;
	}	
}


package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class HorasTrabajadas extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/Horas trabajadas.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas vendidas - Caso general
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
				
		ksession.fireAllRules();		
		
		assertEquals(20, factResponse.getHorasTrabajadas(), delta);

    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasVendidas(20d);
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();
				
		return factResponse;
	}
}

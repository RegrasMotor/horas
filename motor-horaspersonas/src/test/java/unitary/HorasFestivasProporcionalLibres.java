package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasFestivasProporcionalLibres extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Horas Festivas proporcional libres.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroHorasFestivasPropLibres(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);		
		
		ksession.fireAllRules();
		
		assertEquals(5, factResponse.getNumeroHorasFestivasPropLibres(), delta);
    }
	
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
				
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);
		factResponse.setNumeroHorasFestivosMesProporcionalLibres(27f);
		factResponse.setNumeroHorasFestivasPropEscala(22f);
		
		return factResponse;
	}
	
	
}

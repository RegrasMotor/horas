package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class DiasFestivosProporcionalEscala extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Dias Festivos proporcional escala.drl";
	
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
		
		assertEquals(0, factResponse.getNumeroDiasFestivosPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getParams());
				
		ksession.fireAllRules();
		
		assertEquals(1.3150, factResponse.getNumeroDiasFestivosPropEscala(), delta);
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
		factResponse.setNumeroFestivosMensuales(2f);
		factResponse.setMediaDiasEscalaMes (20f);
		
		return factResponse;
	}

	private FactParams getParams() {
		FactParams factParams = new FactParams();
		factParams.setNumeroDiasMes(365/12f);
		
		return factParams;
	}
		
}

package unitary;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class NumeroDiasFestivosPropEscala extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Dias Festivos proporcional escala.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_servicioNoRIF_meses1();
		ksession.insert(factResponse);
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroDiasFestivosPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_servicioNoRIF_meses5();
		ksession.insert(factResponse);		
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(1.3808, factResponse.getNumeroDiasFestivosPropEscala(), delta);
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse_servicioRIF_meses1();
		ksession.insert(factResponse);			
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(1.3808, factResponse.getNumeroDiasFestivosPropEscala(), delta);
    }	
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse_servicioRIF_meses5();
		ksession.insert(factResponse);					
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(1.3808, factResponse.getNumeroDiasFestivosPropEscala(), delta);
    }
	
	private FactResponse getResponse_servicioRIF_meses1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		
		return factResponse;
	}

	private FactResponse getResponse_servicioRIF_meses5() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(5);
		
		return factResponse;
	}

	private FactResponse getResponse_servicioNoRIF_meses1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
		
		return factResponse;
	}

	private FactResponse getResponse_servicioNoRIF_meses5() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(5);
		
		return factResponse;
	}
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setNumeroFestivosMensuales(2f);
		factResponse.setMediaDiasEscalaMes(21f);
		
		return factResponse;
	}
	
	private FactParams getParam() {
		FactParams params = new FactParams();
		params.setNumeroDiasMes(365/12f);
		
		return params;
	}		
}


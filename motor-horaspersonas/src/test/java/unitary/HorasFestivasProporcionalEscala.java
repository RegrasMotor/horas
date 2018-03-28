package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasFestivasProporcionalEscala extends JUnitBase {

	private final static String rulesFile = "rules/horaspersonas/BRA/Horas Festivas proporcional escala.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		//Rule 1
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_servicioNoRIF_meses1();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id1());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		//Rule 2
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_Rule2();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id1());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	
	
	
	@Test
    public void comprobarAccion3CHFT() {
		//Rule 3
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3CHFT" );
		
		FactResponse factResponse = getResponse_Rule3();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id1());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(11.5726, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion3CHEE() {
		//Rule 3
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3CHEE" );
		
		FactResponse factResponse = getResponse_Rule3();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id2());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(11.5726, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion3CHEF() {
		//Rule 3
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3CHEF" );
		
		FactResponse factResponse = getResponse_Rule3();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id3());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(11.5726, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion3SDF() {
		//Rule 3
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3SDF" );
		
		FactResponse factResponse = getResponse_Rule3();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id4());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(11.5726, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	@Test
    public void comprobarAccion4() {
		//Rule 4
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse_Rule3();
		ksession.insert(factResponse);
		ksession.insert(getEscala_id5());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(10.5205, factResponse.getNumeroHorasFestivasPropEscala(), delta);
    }
	
	
	
	private FactResponse getResponse_servicioNoRIF_meses1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
		
		return factResponse;
	}
	
	private FactResponse getResponse_Rule2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(0f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_Rule3() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(4);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(16f);
		factResponse.setMediaDiasTrabajoMes(22f);
		factResponse.setMediaDiasEscalaMes(20f);		
		
		return factResponse;
	}
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes (22f);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(16f);
		
		return factResponse;
	}
	
	private FactEscala getEscala_id1() {
		FactEscala escala = new FactEscala();
		escala.setId("CHFT");	
		
		return escala;
	}	
	
	private FactEscala getEscala_id2() {
		FactEscala escala = new FactEscala();
		escala.setId("CHEE");	
		
		return escala;
	}	
	
	private FactEscala getEscala_id3() {
		FactEscala escala = new FactEscala();
		escala.setId("CHEF");	
		
		return escala;
	}	
	
	private FactEscala getEscala_id4() {
		FactEscala escala = new FactEscala();
		escala.setId("SDF");	
		
		return escala;
	}	
	
	private FactEscala getEscala_id5() {
		FactEscala escala = new FactEscala();
		escala.setId("FALSE");	
		
		return escala;
	}
	
	private FactParams getParams() {
		FactParams factParams = new FactParams();
		factParams.setNumeroDiasMes(365/12f);
		
		return factParams;
	}
}

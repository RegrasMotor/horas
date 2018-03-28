package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactSubcliente;

public class NumeroFestivosMensuales extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Numero de festivos mensuales.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getOt());	
		ksession.insert(getOt().getSubcliente());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroFestivosMensuales(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);		
		
		ksession.fireAllRules();
		
		assertEquals(3.4, factResponse.getNumeroFestivosMensuales(), delta);
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
		factResponse.setNumeroMesesServicio(5);
		factResponse.setNumeroFestivosAnuales(17);
		
		return factResponse;
	}
	
	private FactOT getOt() {
		FactOT ot = new FactOT();
		ot.setSubcliente(getSubcliente());
				
		return ot;
	}	
	
	private FactParams getParams() {
		FactParams params = new FactParams();
		
		params.setNumeroFestivosAno(13);
		
		return params;
	}
	
	private FactSubcliente getSubcliente() {
		FactSubcliente subcliente = new FactSubcliente();
		
		subcliente.setNumeroFestivosSubcliente(4);
		
		return subcliente;
	}
}

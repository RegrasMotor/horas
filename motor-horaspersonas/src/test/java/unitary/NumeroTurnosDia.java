package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroTurnosDia extends JUnitBase {
	
private final static String rulesFile = "rules/horaspersonas/BRA/Numero de turnos por dia.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {

		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();
				
		assertEquals(1, factResponse.getNumeroTurnosDia(), delta);

    }
	
	@Test
    public void comprobarAccion2() {

		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo2());
		
		ksession.fireAllRules();
				
		assertEquals(2, factResponse.getNumeroTurnosDia(), delta);

    }

	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setNumeroTurnosMes(20d);
		factResponse.setMediaDiasTrabajoMes(20f);
						
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setTrabajaLunes(true);
		
		return esquemaOperativo;
	}	
	
	private FactResponse getResponse2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setNumeroTurnosMes(40d);
		factResponse.setMediaDiasTrabajoMes(20f);
						
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setTrabajaLunes(true);
		
		return esquemaOperativo;
	}	
	

}

package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroHorasAlmuerzoXJornada extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Numero de horas de almuerzo por jornada.drl";
	
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
		
		assertEquals(0, factResponse.getHorasAlmuerzoJornadaXpersona(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo2());
		
		ksession.fireAllRules();
		
		assertEquals(3, factResponse.getHorasAlmuerzoJornadaXpersona(), delta);
    }
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
						
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("T");
		esquemaOperativo.setHorasAlmuerzo(3);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("M");
		esquemaOperativo.setHorasAlmuerzo(3);
		
		return esquemaOperativo;
	}	
	
}

package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class DiasEscalaDescontandoFestivos extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Dias Escala descontando festivos.drl";
	
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
		
		assertEquals(14, factResponse.getNumeroDiasEscalaDescFestivos(), delta);
    }
	
	
	private FactResponse getResponse() {
		FactResponse factResponse = new FactResponse();
		factResponse.setNumeroDiasFestivosPropEscala(6f);
		factResponse.setMediaDiasEscalaMes (20f);
		
		return factResponse;
	}
	
}

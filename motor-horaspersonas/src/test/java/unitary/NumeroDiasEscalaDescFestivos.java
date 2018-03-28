package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroDiasEscalaDescFestivos extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Dias Escala descontando festivos.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_dias21_5_festivos1_38();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();
		
		assertEquals(20.12, factResponse.getNumeroDiasEscalaDescFestivos(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_dias21_5_festivos2();
		ksession.insert(factResponse);		
		
		ksession.fireAllRules();
		
		assertEquals(19.5, factResponse.getNumeroDiasEscalaDescFestivos(), delta);
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse_dias21_festivos1_38();
		ksession.insert(factResponse);			
		
		ksession.fireAllRules();
		
		assertEquals(19.62, factResponse.getNumeroDiasEscalaDescFestivos(), delta);
    }	
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse_dias21_festivos2();
		ksession.insert(factResponse);					
		
		ksession.fireAllRules();
		
		assertEquals(19, factResponse.getNumeroDiasEscalaDescFestivos(), delta);
    }
	
	private FactResponse getResponse_dias21_festivos2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasEscalaMes(21f);
		factResponse.setNumeroDiasFestivosPropEscala(2f);
		
		return factResponse;
	}	
	
	private FactResponse getResponse_dias21_festivos1_38() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasEscalaMes(21f);
		factResponse.setNumeroDiasFestivosPropEscala(1.38f);
		
		return factResponse;
	}

	private FactResponse getResponse_dias21_5_festivos2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasEscalaMes(21.5f);
		factResponse.setNumeroDiasFestivosPropEscala(2f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_dias21_5_festivos1_38() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasEscalaMes(21.5f);
		factResponse.setNumeroDiasFestivosPropEscala(1.38f);
		
		return factResponse;
	}	
}


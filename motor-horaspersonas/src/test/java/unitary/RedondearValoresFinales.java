package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class RedondearValoresFinales extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/functions/auxiliares.function;"+
											"rules/horaspersonas/BRA/Redondear valores finales.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_comun1();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();
		
		assertEquals(1.11, factResponse.getNumeroPersonas(), delta);
		assertEquals(2.22, factResponse.getNumeroRealPersonas(), delta);
		assertEquals(3.33, factResponse.getHorasVendidas(), delta);
		assertEquals(4.44, factResponse.getHorasTrabajadas(), delta);
		assertEquals(5.56, factResponse.getHorasNormales(), delta);
		assertEquals(6.67, factResponse.getHorasExtrasEfetivas(), delta);
		assertEquals(7.78, factResponse.getHorasExtrasLibreTrabajado(), delta);
		assertEquals(8.89, factResponse.getHorasAdicIntrajornada(), delta);
		assertEquals(10.00, factResponse.getHorasAdicNocturno(), delta);
		assertEquals(10.12, factResponse.getHorasExtrasFestivo(), delta);
		assertEquals(11.14, factResponse.getHorasExtrasEspeciales(), delta);
    }
	
	private FactResponse getResponse_comun1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setNumeroPersonas (1.11111);
		factResponse.setNumeroRealPersonas (2.22222);
		factResponse.setHorasVendidas (3.33333);
		factResponse.setHorasTrabajadas (4.44444);
		factResponse.setHorasNormales (5.555555);
		factResponse.setHorasExtrasEfetivas (6.666666);
		factResponse.setHorasExtrasLibreTrabajado (7.77777);
		factResponse.setHorasAdicIntrajornada (8.88888);
		factResponse.setHorasAdicNocturno (9.99999);
		factResponse.setHorasExtrasFestivo (10.12345);
		factResponse.setHorasExtrasEspeciales (11.13579);
		
		return factResponse;
	}	
}


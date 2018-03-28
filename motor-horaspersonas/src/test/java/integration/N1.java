package integration;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class N1 extends JUnitBase{
	private final static String changeSetFile = "change-set/change-set-N1.xml";
	
	@BeforeClass
	public static void initialize() {
		initialize (changeSetFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactRequest factRequest = insertRequestFromFile ("request/horaspersonas/BRA/request_001.xml");
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();

		//N0
		assertEquals(1, factResponse.getHorasAlmuerzoJornadaXpersona(), delta);
		assertEquals(false, factResponse.getServicioRif()); 
		assertEquals(true, factResponse.isExtensionAdicNocturno());
		assertEquals(false, factResponse.isHoraExtrasMayor2horas());
		assertEquals(5, factRequest.getEscala().getDiasTrabajadosXsemana());
		assertEquals(2, factRequest.getEscala().getDiasLibresXsemana());
		//N1
		assertEquals(44, factRequest.getEscalaXcategoria().getHorasPeriodo(), delta);
		assertEquals(11, factResponse.getHorasEfectivasJornadaXpersona(), delta);
		assertEquals(1, (long)factResponse.getNumeroMesesServicio());		
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactRequest factRequest = insertRequestFromFile ("request/horaspersonas/BRA/request_002.xml");
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();

		//N0
		assertEquals(1.5, factResponse.getHorasAlmuerzoJornadaXpersona(), delta);
		assertEquals(true, factResponse.getServicioRif()); 
		assertEquals(true, factResponse.isExtensionAdicNocturno());
		assertEquals(false, factResponse.isHoraExtrasMayor2horas());
		assertEquals(5, factRequest.getEscala().getDiasTrabajadosXsemana());
		assertEquals(2, factRequest.getEscala().getDiasLibresXsemana());
		
		//N1
		assertEquals(44, factRequest.getEscalaXcategoria().getHorasPeriodo(), delta);
		assertEquals(12, factResponse.getHorasEfectivasJornadaXpersona(), delta);
		assertEquals(12, (long)factResponse.getNumeroMesesServicio());	
    }	
	
}

package integration;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class N4 extends JUnitBase{
	private final static String changeSetFile = "change-set/change-set-N4.xml";
	
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
		//N2
		assertEquals(14, (long)factResponse.getNumeroFestivosAnuales());
		assertEquals(31, factResponse.getMediaDiasTrabajoMes(),delta);	
		assertEquals(69, factResponse.getNumeroTurnosMes(),delta);
		//N3
		assertEquals(0, factResponse.getNumeroFestivosMensuales(), delta);
		assertEquals(2, factResponse.getNumeroTurnosDia(), delta);		
		assertEquals(31, factResponse.getMediaDiasEscalaMes(), delta);
		assertEquals(0, factResponse.getHorasAdicNocturno (), delta);
		//N4
		assertEquals(31, factResponse.getMediaDiasEfectivosMes(), delta);
		assertEquals(0, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta); 
		assertEquals(0, factResponse.getNumeroDiasFestivosPropEscala(), delta);
		assertEquals(341, factResponse.getHorasEscalaXpersona(), delta);
		assertEquals(3, factResponse.getNumeroPersonas(), delta);
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
		
		//N2
		assertEquals(14, (long)factResponse.getNumeroFestivosAnuales());
		assertEquals(21.72619, factResponse.getMediaDiasTrabajoMes(),delta);
		assertEquals(65.178, factResponse.getNumeroTurnosMes(),delta);
		
		//N3
		assertEquals(1.1666, factResponse.getNumeroFestivosMensuales(), delta);
		assertEquals(3, factResponse.getNumeroTurnosDia(), delta);		
		assertEquals(21.72619, factResponse.getMediaDiasEscalaMes(), delta);
		assertEquals(0, factResponse.getHorasAdicNocturno (), delta);

		//N4
		assertEquals(21.72619, factResponse.getMediaDiasEfectivosMes(), delta);
		assertEquals(42, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta); 
		assertEquals(0.83328, factResponse.getNumeroDiasFestivosPropEscala(), delta);
		assertEquals(260.71428, factResponse.getHorasEscalaXpersona(), delta);
		assertEquals(3, factResponse.getNumeroPersonas(), delta);
		
    }	
	
}



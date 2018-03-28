package unitary;
import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroHorasEscalaXpersona extends JUnitBase {
	
private final static String rulesFile = "rules/horaspersonas/BRA/Numero de horas escala por persona.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Rule 1
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();
				
		assertEquals(120, factResponse.getHorasEscalaXpersona(), delta);

    }
	
	@Test
	public void comprobarAccion2() {
		//Rule 2
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();
				
		assertEquals(115, factResponse.getHorasEscalaXpersona(), delta);

    }
	
	@Test
	public void comprobarAccion3() {
		//Rule 3
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo2());
		
		ksession.fireAllRules();
				
		assertEquals(184, factResponse.getHorasEscalaXpersona(), delta);

    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
				
		return factResponse;
	}
	
	
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setHorasAlmuerzoJornadaXpersona(2f);
		factResponse.setMediaDiasEscalaMes (20f);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setHorasAlmuerzoJornadaXpersona(3f);
		factResponse.setMediaDiasEscalaMes (23f);
		
		return factResponse;
	}


	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("N");
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,20,0).getTime());
		esquemaOperativo.setHorasJornadaXpersona(8);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("P");
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,20,0).getTime());
		esquemaOperativo.setHorasJornadaXpersona(8);
		
		return esquemaOperativo;
	}	
}

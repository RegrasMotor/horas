package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasEfectivasJornadaXpersona extends JUnitBase {
	
private final static String rulesFile = "rules/horaspersonas/BRA/Numero de horas efectivas a trabajar cada jornada.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas Extras eficaces - SDF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_CONCOBERTURA());
		ksession.fireAllRules();		
		
		assertEquals(12, factResponse.getHorasEfectivasJornadaXpersona(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Horas Extras eficaces - CHNIF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_NOTRABAJA_HorasPersonaCubrePuesto());
		ksession.fireAllRules();		
		
		assertEquals(11, factResponse.getHorasEfectivasJornadaXpersona(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Horas Extras eficaces - CHNIF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_TRABAJA_HorasPersonaCubrePuesto());
		ksession.fireAllRules();		
		
		assertEquals(11, factResponse.getHorasEfectivasJornadaXpersona(), delta);

    }	
	
	@Test
    public void comprobarAccion4() {
		//Horas Extras eficaces - Media Jornada
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_DEFAULT_NOTRABAJA());
		ksession.fireAllRules();		
		
		assertEquals(11, factResponse.getHorasEfectivasJornadaXpersona(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Horas Extras eficaces - Media Jornada
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_DEFAULT_NOTRABAJA());
		ksession.fireAllRules();		
		
		assertEquals(11, factResponse.getHorasEfectivasJornadaXpersona(), delta);

    }	
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasAlmuerzoJornadaXpersona(1f);
		
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquema_CONCOBERTURA() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setCoberturaAlmuerzo("C");
		factEsquemaOperativo.setHorasJornadaXpersona(12);
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,12,0).getTime());
		
		return factEsquemaOperativo;
	}

	private FactEsquemaOperativo getEsquema_NOTRABAJA_HorasPersonaCubrePuesto() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setCoberturaAlmuerzo("N");
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,12,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(11);
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_TRABAJA_HorasPersonaCubrePuesto() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setCoberturaAlmuerzo("T");
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,12,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(11);
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_DEFAULT_NOTRABAJA() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setCoberturaAlmuerzo("N");
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,12,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(12);
		
		return factEsquemaOperativo;
	}	
}

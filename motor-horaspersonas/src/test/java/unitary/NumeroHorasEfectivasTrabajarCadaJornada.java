package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroHorasEfectivasTrabajarCadaJornada extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Numero de horas efectivas a trabajar cada jornada.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
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
		
		assertEquals(9, factResponse.getHorasEfectivasJornadaXpersona(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo2());
		
		ksession.fireAllRules();
		
		assertEquals(6, factResponse.getHorasEfectivasJornadaXpersona(), delta);
    }
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo3());
		
		ksession.fireAllRules();
		
		assertEquals(5, factResponse.getHorasEfectivasJornadaXpersona(), delta);
    }
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasAlmuerzoJornadaXpersona(2f);
						
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("C");
		esquemaOperativo.setHorasJornadaXpersona(9);
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("M");
		esquemaOperativo.setHorasJornadaXpersona(6);
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo3() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("M");
		esquemaOperativo.setHorasJornadaXpersona(7);
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		
		return esquemaOperativo;
	}	
	
	
}

package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasFestivasAlMes extends JUnitBase {
	
	
private final static String rulesFile = "rules/horaspersonas/BRA/Horas Festivas al mes.drl;" +
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
				
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo1());
				
		ksession.fireAllRules();
		
		assertEquals(45, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta);
    }
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getEsquemaOperativo2());
				
		ksession.fireAllRules();
		
		assertEquals(60, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta);
    }
	
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);		
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(2);		
		factResponse.setHorasAlmuerzoJornadaXpersona(2f);
		factResponse.setNumeroFestivosMensuales(1.5f);
		
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("T");		
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,20,0).getTime());
		esquemaOperativo.setHorasJornadaXpersona(8);
		esquemaOperativo.setNumeroPuestos(4);
		
		return esquemaOperativo;
	}	

	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("M");		
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,20,0).getTime());
		esquemaOperativo.setNumeroPuestos(4);
		
		return esquemaOperativo;
	}	

	
}

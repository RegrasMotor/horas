package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroMesesDuracionServicio extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Numero de meses de duracion del servicio.drl";
	
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
		
		assertEquals(12, factResponse.getNumeroMesesServicio(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_fechasOK1());
		
		ksession.fireAllRules();
		
		assertEquals(4, factResponse.getNumeroMesesServicio(), delta);
    }
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_fechasOK2());
		
		ksession.fireAllRules();
		
		assertEquals(1, factResponse.getNumeroMesesServicio(), delta);
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);		
		ksession.insert(getEsquema_fechasOK3());
		
		ksession.fireAllRules();
		
		assertEquals(12, factResponse.getNumeroMesesServicio(), delta);
    }
	
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(true);
				
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);

		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquema_fechasOK1() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setFechaInicioServicio(new GregorianCalendar(2014,1,1).getTime());
		esquema.setFechaFinServicio(new GregorianCalendar(2014,5,2).getTime());
		
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquema_fechasOK2() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setFechaInicioServicio(new GregorianCalendar(2014,5,1).getTime());
		esquema.setFechaFinServicio(new GregorianCalendar(2014,5,2).getTime());
		
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquema_fechasOK3() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setFechaInicioServicio(new GregorianCalendar(2013,1,1).getTime());
		esquema.setFechaFinServicio(new GregorianCalendar(2014,5,2).getTime());
		
		return esquema;
	}	
	
}

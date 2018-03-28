package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class CalcularServicioComoRif extends JUnitBase {
	private final static String rulesFile = "rules/horaspersonas/BRA/Calculos en base a la formula RIF.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_RIF());
		ksession.insert(getEsquema_fechasOK());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.getServicioRif());
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_RIF());
		ksession.insert(getEsquema_fechaInicioServicioNULL());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.getServicioRif());		
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_ESPORADICO());
		ksession.insert(getEsquema_fechasOK());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.getServicioRif());		
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_ESPORADICO());
		ksession.insert(getEsquema_fechaInicioServicioNULL());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.getServicioRif());		
    }
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_ESPORADICO());
		ksession.insert(getEsquema_fechaFinServicioNULL());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.getServicioRif());		
    }
	
	private FactOT getOT_RIF() {
		FactOT factOT = new FactOT();
		factOT.setTipoServicio("RIF");
		
		return factOT;
	}

	private FactOT getOT_ESPORADICO() {
		FactOT factOT = new FactOT();
		factOT.setTipoServicio("ESPORADICO");
		
		return factOT;
	}
	
	private FactEsquemaOperativo getEsquema_fechasOK() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setFechaInicioServicio(new GregorianCalendar(2014,9,1).getTime());
		esquema.setFechaFinServicio(new GregorianCalendar(2014,9,30).getTime());
		
		return esquema;
	}	

	private FactEsquemaOperativo getEsquema_fechaInicioServicioNULL() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setFechaFinServicio(new GregorianCalendar(2014,9,30).getTime());
		
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquema_fechaFinServicioNULL() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setFechaInicioServicio(new GregorianCalendar(2014,9,30).getTime());
		
		return esquema;
	}		
}


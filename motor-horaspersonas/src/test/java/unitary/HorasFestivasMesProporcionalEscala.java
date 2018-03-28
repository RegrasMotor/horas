package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasFestivasMesProporcionalEscala extends JUnitBase {

	private final static String rulesFile = "rules/horaspersonas/BRA/Horas Festivas al mes proporcional escala.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		//Rule 1
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_servicioNoRIF_meses1();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		//Rule 2
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_Rule2();
		ksession.insert(factResponse);
		ksession.insert(getEsquema1());
		
		ksession.fireAllRules();
		
		assertEquals(27, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta);
    }
	
	
	@Test
    public void comprobarAccion3() {
		//Rule 2
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_Rule2();
		ksession.insert(factResponse);
		ksession.insert(getEsquema2());
		
		ksession.fireAllRules();
		
		assertEquals(36, factResponse.getNumeroHorasFestivosMesProporcionalEscala(), delta);
    }
	
	
	
	
	
	private FactResponse getResponse_servicioNoRIF_meses1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
		
		return factResponse;
	}
	
	private FactResponse getResponse_Rule2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setHorasAlmuerzoJornadaXpersona(2f);
		factResponse.setNumeroFestivosMensuales(1.5f);
		
		return factResponse;
	}

	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes (22f);
				
		return factResponse;
	}
	
	
	private FactEsquemaOperativo getEsquema1() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setCoberturaAlmuerzo("T");
		esquema.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquema.setHoraInicioJornada(new GregorianCalendar(2000,1,1,20,0).getTime());
		esquema.setHorasJornadaXpersona(8);
		esquema.setNumeroPuestos(2);
		 
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquema2() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setCoberturaAlmuerzo("C");
		esquema.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquema.setHoraInicioJornada(new GregorianCalendar(2000,1,1,20,0).getTime());
		esquema.setHorasJornadaXpersona(8);
		esquema.setNumeroPuestos(2);
		 
		return esquema;
	}	
}

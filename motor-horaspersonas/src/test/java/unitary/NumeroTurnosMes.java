package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class NumeroTurnosMes extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/functions/cantidadPersonasPorDia.function;" + 
										"rules/horaspersonas/BRA/functions/numeroDiasFestivosServicio.function;" + 
										"rules/horaspersonas/BRA/functions/numeroDiasTrabajadosByEsquema.function;" +
										"rules/horaspersonas/BRA/functions/diasTrabajadosXsemanaByEsquema.function;" +
										"rules/horaspersonas/BRA/Dias trabajados por semana.drl;" +
										"rules/horaspersonas/BRA/Numero Turnos Mes.drl;" +
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
		ksession.insert(getEscalaSDF());
		ksession.insert(getEsquema());
		ksession.insert(getOT());
		ksession.insert(getParam1());
		ksession.fireAllRules();		
		
		assertEquals(4, factResponse.getNumeroTurnosMes(), delta);

    }
	
	
	@Test
    public void comprobarAccion2() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaSDF());
		ksession.insert(getEsquema());
		ksession.insert(getOT());
		ksession.insert(getParam1());
		ksession.fireAllRules();		
		
		assertEquals(56, factResponse.getNumeroTurnosMes(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaSDF());
		ksession.insert(getEsquema2());
		ksession.insert(getOT());
		ksession.insert(getParam());
		ksession.fireAllRules();		
		
		assertEquals(86.90, factResponse.getNumeroTurnosMes(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaSDF());
		ksession.insert(getEsquema2());
		ksession.insert(getOT());
		ksession.insert(getParam2());
		ksession.fireAllRules();		
		
		assertEquals(8, factResponse.getNumeroTurnosMes(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaSDF());
		ksession.insert(getEsquema3());
		ksession.insert(getOT());
		ksession.insert(getParam2());
		ksession.fireAllRules();		
		
		assertEquals(20, factResponse.getNumeroTurnosMes(), delta);

    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();		
		factResponse.setHorasExtras50Xpersona(20f);
		factResponse.setNumeroRealPersonas(3d);
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();			
		factResponse.setNumeroMesesServicio(12);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();			
		factResponse.setNumeroMesesServicio(1);
		
		return factResponse;
	}
	
	
	private FactEscala getEscalaSDF() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("SDF");
		factEscala.setDiasTrabajadosXsemana(5);
		factEscala.setDiasLibresXsemana(2);
		
		return factEscala;
	}
	
	private FactEsquemaOperativo getEsquema() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setMediaJornada(true);
		factEsquemaOperativo.setTipoJornada("F");
		factEsquemaOperativo.setPuestoSinCobertura(true);
		factEsquemaOperativo.setNumeroPuestos(2);
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,22,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(8);
		
		factEsquemaOperativo.setTrabajaLunes(true);
		factEsquemaOperativo.setTrabajaMartes(true);
		factEsquemaOperativo.setTrabajaMiercoles(true);
		factEsquemaOperativo.setTrabajaJueves(true);
		factEsquemaOperativo.setTrabajaViernes(true);
		factEsquemaOperativo.setTrabajaSabado(false);
		factEsquemaOperativo.setTrabajaDomingo(false);
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema2() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setMediaJornada(true);
		factEsquemaOperativo.setTipoJornada("H");
		factEsquemaOperativo.setPuestoSinCobertura(true);
		factEsquemaOperativo.setNumeroPuestos(2);
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,22,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(8);
		
		factEsquemaOperativo.setTrabajaLunes(true);
		factEsquemaOperativo.setTrabajaMartes(true);
		factEsquemaOperativo.setTrabajaMiercoles(true);
		factEsquemaOperativo.setTrabajaJueves(true);
		factEsquemaOperativo.setTrabajaViernes(true);
		factEsquemaOperativo.setTrabajaSabado(false);
		factEsquemaOperativo.setTrabajaDomingo(false);
		
		return factEsquemaOperativo;
	}
	
	
	private FactEsquemaOperativo getEsquema3() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setMediaJornada(true);
		factEsquemaOperativo.setTipoJornada("H");
		factEsquemaOperativo.setPuestoSinCobertura(true);
		factEsquemaOperativo.setNumeroPuestos(2);
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,22,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(8);
		
		factEsquemaOperativo.setTrabajaLunes(true);
		factEsquemaOperativo.setTrabajaMartes(true);
		factEsquemaOperativo.setTrabajaMiercoles(true);
		factEsquemaOperativo.setTrabajaJueves(true);
		factEsquemaOperativo.setTrabajaViernes(true);
		factEsquemaOperativo.setTrabajaSabado(false);
		factEsquemaOperativo.setTrabajaDomingo(false);
		
		factEsquemaOperativo.setFechaInicioServicio(new GregorianCalendar(2014,9-1,1).getTime());
		factEsquemaOperativo.setFechaFinServicio(new GregorianCalendar(2014,9-1,6).getTime());
		
		return factEsquemaOperativo;
	}
	
	
	
	private FactOT getOT() {
		
		FactOT factOT = new FactOT();
		
		return factOT;
		
	}
	
	private FactParams getParam() {
		FactParams params = new FactParams();
		
		params.setAceptaPuestosSinCobertura(true);
		params.setNumeroDiasMes(365/12f);
		params.setNumeroFestivosAno(14);
		
		return params;
	}
	
	private FactParams getParam1() {
		FactParams params = new FactParams();
		
		params.setNumeroFestivosAno(14);
		
		return params;
	}
	
	private FactParams getParam2() {
		
		FactParams params = new FactParams();
		params.setAceptaPuestosSinCobertura(false);
		params.setCoeficienteStdDiasXsemana(0.4f);
		params.setNumeroDiasMes(365/12f);
		params.setNumeroFestivosAno(14);
		
		return params;
	}
}

package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class PromedioDiasTrabajadosMesXdiasTrabajadosSemana extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Promedio de dias trabajados al mes de acuerdo con los dias trabajados a la semana.drl";
	
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
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(5, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo2());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(6, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativoM());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(5, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse3();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativoQ());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(12, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativoS());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(21.72619, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	@Test
    public void comprobarAccion6() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo3());
		ksession.insert(getEscala());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(26.0714, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	@Test
    public void comprobarAccion7() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo4());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(21.72619, factResponse.getMediaDiasTrabajoMes(), delta);
    }
	
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
						
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setDiasTrabajadosXsemana(5);
		
		return factResponse;
	}
	
	private FactResponse getResponse3() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setDiasTrabajadosXsemana(6);
		
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setFechaInicioServicio(new GregorianCalendar(2014,9,1).getTime());
		esquemaOperativo.setFechaFinServicio(new GregorianCalendar(2014,9,6).getTime());
		GregorianCalendar gc = new GregorianCalendar(2014, 9, 1, 22, 0); 
		esquemaOperativo.setHoraInicioJornada(gc.getTime());
		gc.set(2014,9,1,9,0);
		esquemaOperativo.setHoraFinJornada(gc.getTime());
		
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setFechaInicioServicio(new GregorianCalendar(2014,9,1).getTime());
		esquemaOperativo.setFechaFinServicio(new GregorianCalendar(2014,9,6).getTime());
		GregorianCalendar gc = new GregorianCalendar(2014, 9, 1, 9, 0); 
		esquemaOperativo.setHoraInicioJornada(gc.getTime());
		gc.set(2014,9,1,22,0);
		esquemaOperativo.setHoraFinJornada(gc.getTime());
		
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativoM() {
		FactEsquemaOperativo esquemaOperativo = fechas_datosComunes();
		esquemaOperativo.setFrecuenciaMediaJornada("M");
		esquemaOperativo.setTrabajaLunes(true);
		esquemaOperativo.setTrabajaMartes(true);
		esquemaOperativo.setTrabajaMiercoles(true);
		esquemaOperativo.setTrabajaJueves(true);
		esquemaOperativo.setTrabajaViernes(true);
		esquemaOperativo.setMediaJornada(true);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativoQ() {
		FactEsquemaOperativo esquemaOperativo = fechas_datosComunes();
		esquemaOperativo.setFrecuenciaMediaJornada("Q");
		esquemaOperativo.setTrabajaLunes(true);
		esquemaOperativo.setTrabajaMartes(true);
		esquemaOperativo.setTrabajaMiercoles(true);
		esquemaOperativo.setTrabajaJueves(true);
		esquemaOperativo.setTrabajaViernes(true);
		esquemaOperativo.setTrabajaSabado(true);
		esquemaOperativo.setMediaJornada(true);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativoS() {
		FactEsquemaOperativo esquemaOperativo = fechas_datosComunes();
		esquemaOperativo.setFrecuenciaMediaJornada("S");
		esquemaOperativo.setTrabajaLunes(true);
		esquemaOperativo.setTrabajaMartes(true);
		esquemaOperativo.setTrabajaMiercoles(true);
		esquemaOperativo.setTrabajaJueves(true);
		esquemaOperativo.setTrabajaViernes(true);

		esquemaOperativo.setMediaJornada(true);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo3() {
		FactEsquemaOperativo esquemaOperativo = fechas_datosComunes();
		esquemaOperativo.setFrecuenciaMediaJornada("X");
		esquemaOperativo.setPuestoSinCobertura(true);
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo4() {
		FactEsquemaOperativo esquemaOperativo = fechas_datosComunes();
		esquemaOperativo.setFrecuenciaMediaJornada("X");
		esquemaOperativo.setPuestoSinCobertura(false);
		esquemaOperativo.setTrabajaLunes(true);
		esquemaOperativo.setTrabajaMartes(true);
		esquemaOperativo.setTrabajaMiercoles(true);
		esquemaOperativo.setTrabajaJueves(true);
		esquemaOperativo.setTrabajaViernes(true);

		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo fechas_datosComunes(){
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setFechaInicioServicio(new GregorianCalendar(2014,9,1).getTime());
		esquemaOperativo.setFechaFinServicio(new GregorianCalendar(2014,9,6).getTime());
		GregorianCalendar gc = new GregorianCalendar(2014, 9, 1, 22, 0); 
		esquemaOperativo.setHoraInicioJornada(gc.getTime());
		gc.set(2014,9,1,9,0);
		esquemaOperativo.setHoraFinJornada(gc.getTime());
		
		return esquemaOperativo;
	}
	
	private FactEscala getEscala() {
		FactEscala escala = new FactEscala();
		escala.setDiasTrabajadosXsemana(6);
		escala.setDiasLibresXsemana(1);
		
		return escala;
	}	

	private FactParams getParam() {
		FactParams params = new FactParams();
		params.setNumeroDiasMes(365/12f);
		
		return params;
	}		
}

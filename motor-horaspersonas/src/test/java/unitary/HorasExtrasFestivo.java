package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasExtrasFestivo extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Horas Extras festivo.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Tipo jornada H
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_H());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasFestivo(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Escala 6X12 y delegacion 04
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscala1());
		ksession.insert(getOT());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasFestivo(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Escala CHNIF y mediaJornada
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscala2());	
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasFestivo(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//NO RIF y meses servicio 1
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_D());
		ksession.fireAllRules();		
		
		assertEquals(1080, factResponse.getHorasExtrasFestivo(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Puesto Sin cobertura
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEscala3());	
		ksession.insert(getEsquema_D());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasFestivo(), delta);

    }
	
	
	@Test
    public void comprobarAccion6() {
		//Resto casos
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
			
		FactResponse factResponse = getResponse3();
		ksession.insert(factResponse);	
		ksession.insert(getEscala4());	
		ksession.insert(getEsquema_S());
		ksession.fireAllRules();		
		
		assertEquals(19, factResponse.getHorasExtrasFestivo(), delta);

    }
	
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();		
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setNumeroFestivosAnuales(15);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setNumeroFestivosAnuales(15);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(55f);
		
		
		return factResponse;
	}
	
	private FactResponse getResponse3() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setNumeroFestivosAnuales(15);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(62f);
		factResponse.setDiasTrabajadosXsemana(5);
		factResponse.setNumeroHorasFestivosMesProporcionalLibres(19f);
		
		return factResponse;
	}
	
	
	private FactEsquemaOperativo getEsquema_H() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setTipoJornada("H");		
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_D() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setTipoJornada("D");	
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setNumeroPuestos(3);
		factEsquemaOperativo.setPuestoSinCobertura(true);
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_S() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setTipoJornada("S");	
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setNumeroPuestos(3);
		factEsquemaOperativo.setPuestoSinCobertura(false);
		factEsquemaOperativo.setTrabajaLunes(true);
		factEsquemaOperativo.setTrabajaMartes(true);
		factEsquemaOperativo.setTrabajaMiercoles(true);
		factEsquemaOperativo.setTrabajaJueves(true);
		factEsquemaOperativo.setTrabajaViernes(true);
		
		return factEsquemaOperativo;
	}
	
	private FactOT getOT() {
		FactOT factOT = new FactOT();
		factOT.setDelegacion("04");
		
		return factOT;
	}	
	
	private FactEscala getEscala1() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("6X12");
		
		return factEscala;
	}
	
	private FactEscala getEscala2() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHNIF");
		factEscala.setMediaJornada(true);
		
		return factEscala;
	}
	
	private FactEscala getEscala3() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("SDF");
		factEscala.setDiasTrabajadosXsemana(5);
		factEscala.setDiasLibresXsemana(2);
		
		return factEscala;
	}
	
	private FactEscala getEscala4() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("5X2");
		factEscala.setDiasTrabajadosXsemana(5);
		factEscala.setDiasLibresXsemana(2);
		
		return factEscala;
	}
	
}

package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasAdicionalesIntrajornada extends JUnitBase {

	private final static String rulesFile = "rules/horaspersonas/BRA/Horas Adicionales intrajornada.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas Adicionales intrajornada - Almuerzo menor tiempo minimo
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_F());
		ksession.insert(getEscalaXCategoria1());
		ksession.fireAllRules();		
		
		assertEquals(198, factResponse.getHorasAdicIntrajornada(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//"Horas Adicionales intrajornada - Cobertura almuerzo T"
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_T());
		ksession.insert(getEscalaXCategoria2());
		ksession.fireAllRules();		
		
		assertEquals(44, factResponse.getHorasAdicIntrajornada(), delta);

    }
		
	@Test
    public void comprobarAccion3() {
		//Horas Adicionales intrajornada - Almuerzo menor 1 hora - Delegacion 4 o 7
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_F());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getOT1());
		ksession.fireAllRules();		
		
		assertEquals(99, factResponse.getHorasAdicIntrajornada(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//Horas Adicionales intrajornada -  Almuerzo tipo T menor 1 hora - Delegacion 4 o 7 
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_T());
		ksession.insert(getEscalaXCategoria3());
		ksession.insert(getOT1());
		ksession.fireAllRules();		
		
		assertEquals(22, factResponse.getHorasAdicIntrajornada(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Horas Adicionales intrajornada -  Almuerzo tipo T menor 1 hora - Delegacion 4 o 7 
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_T());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getOT1());
		ksession.fireAllRules();		
		
		assertEquals(22, factResponse.getHorasAdicIntrajornada(), delta);

    }
	
	@Test
    public void comprobarAccion6() {
		//Horas Adicionales intrajornada -  Escala 6X12
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEsquema_T());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getEscala());
		ksession.insert(getOT2());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasAdicIntrajornada(), delta);
    }
	
	@Test
    public void comprobarAccion7() {
		//Horas Adicionales intrajornada - Default
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasAdicIntrajornada(), delta);
    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();		
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasAlmuerzoJornadaXpersona(2f);
		factResponse.setMediaDiasEfectivosMes(22f);		
		factResponse.setHorasEfectivasJornadaXpersona(8f);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasAlmuerzoJornadaXpersona(0.5f);
		factResponse.setMediaDiasEfectivosMes(22f);		
		factResponse.setHorasEfectivasJornadaXpersona(8f);
		
		return factResponse;
	}
	
	private FactEscalaXCategoria getEscalaXCategoria1() {
		FactEscalaXCategoria factEscalaXCat = new FactEscalaXCategoria();
		factEscalaXCat.setTiempoMinimoAlmuerzo(3);
				
		return factEscalaXCat;
	}
	
	private FactEscalaXCategoria getEscalaXCategoria2() {
		FactEscalaXCategoria factEscalaXCat = new FactEscalaXCategoria();
		factEscalaXCat.setTiempoMinimoAlmuerzo(1);
				
		return factEscalaXCat;
	}
	
	private FactEscalaXCategoria getEscalaXCategoria3() {
		FactEscalaXCategoria factEscalaXCat = new FactEscalaXCategoria();
		factEscalaXCat.setTiempoMinimoAlmuerzo(0);
				
		return factEscalaXCat;
	}
	
	private FactEscala getEscala() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("6X12");
				
		return factEscala;
	}
		
	private FactEsquemaOperativo getEsquema_T() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setCoberturaAlmuerzo("T");
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		factEsquemaOperativo.setNumeroPuestos(2);
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_F() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setCoberturaAlmuerzo("F");
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,0,0).getTime());
		factEsquemaOperativo.setNumeroPuestos(3);
		
		return factEsquemaOperativo;
	}
	
	private FactOT getOT1() {
		FactOT factOT = new FactOT();		
		factOT.setDelegacion("07");
		
		return factOT;
	}
	
	private FactOT getOT2() {
		FactOT factOT = new FactOT();		
		factOT.setDelegacion("04");
		
		return factOT;
	}

}

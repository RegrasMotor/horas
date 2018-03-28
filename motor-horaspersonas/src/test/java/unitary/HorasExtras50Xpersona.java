package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class HorasExtras50Xpersona extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/Horas Extras al 50 por persona.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas Extras al 50 por persona - Sin horas
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse0();
		ksession.insert(factResponse);
		ksession.insert(getOT_pasa2());
		ksession.insert(getEscalaXCategoriaM());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion1bis() {
		//Horas Extras al 50 por persona - Sin horas
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse0bis();
		ksession.insert(factResponse);
		ksession.insert(getOT_pasa2());
		ksession.insert(getEscalaXCategoriaM());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Horas Extras al 50 por persona - Mensual
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getOT_pasa2());
		ksession.insert(getEscalaXCategoriaM());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(36, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Horas Extras al 50 por persona - Mensual NO Delegacion
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getOT_noPasa());
		ksession.insert(getEscalaXCategoriaM());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(2.5, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//Horas Extras al 50 por persona - Semanal
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getOT_pasa2());
		ksession.insert(getEscalaXCategoriaS());
		ksession.insert(getEscala());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(51, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Horas Extras al 50 por persona - Semanal NO Delegacion
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getOT_noPasa());
		ksession.insert(getEscalaXCategoriaS());
		ksession.insert(getEscala());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(2.5, factResponse.getHorasExtras50Xpersona(), delta);

    }
		
	@Test
    public void comprobarAccion6() {
		//Horas Extras al 50 por persona - Diaria
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getOT_pasa1());
		ksession.insert(getEscalaXCategoriaD());
//		ksession.insert(getEscala());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(27, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion7() {
		//Horas Extras al 50 por persona - Diaria NO Delegacion
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getOT_noPasa());
		ksession.insert(getEscalaXCategoriaD());
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();		
		
		assertEquals(2.5, factResponse.getHorasExtras50Xpersona(), delta);

    }
	
	@Test
    public void comprobarAccion8() {
		//Horas Extras al 50 por persona - Defaulr
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion8" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtras50Xpersona(), delta);
    }
		
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHoraExtrasMayor2horas(true);
				
		return factResponse;
	}
	
	private FactResponse getResponse0() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setHorasEscalaXpersona(16f);
		factResponse.setNumeroHorasFestivasPropEscala(7f);
		factResponse.setNumeroTurnosDia(4);
		factResponse.setHorasNormalesXpersona(2f);
		factResponse.setHoraExtrasMayor2horas(false);
		
		return factResponse;
	}
	
	private FactResponse getResponse0bis() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setHorasEscalaXpersona(1f);
		factResponse.setNumeroHorasFestivasPropEscala(7f);
		factResponse.setNumeroTurnosDia(4);
		factResponse.setHorasNormalesXpersona(2f);
		
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setMediaDiasEscalaMes(15f);
		factResponse.setHorasEfectivasJornadaXpersona(7f);
		factResponse.setNumeroDiasEscalaDescFestivos(9f);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setMediaDiasEscalaMes (20f);
		factResponse.setHorasEfectivasJornadaXpersona(7f);
		factResponse.setHorasEscalaXpersona(16f);
		factResponse.setNumeroHorasFestivasPropEscala(7f);
		factResponse.setNumeroTurnosDia(2);
		factResponse.setHorasNormalesXpersona(7f);
		factResponse.setHorasExtrasXpersona(3f);
		
		
		return factResponse;
	}
	
	private FactEscalaXCategoria getEscalaXCategoriaM() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setTipoCalculo("M");
		escalaXCat.setHorasPeriodo(2);
		
		return escalaXCat;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoriaS() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setTipoCalculo("S");
		escalaXCat.setHorasPeriodo(2);
		
		return escalaXCat;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoriaD() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setTipoCalculo("D");
		escalaXCat.setHorasPeriodo(3);
		
		return escalaXCat;
	}	
	
	
	private FactEscala getEscala() {
		FactEscala escala = new FactEscala();
		escala.setDiasTrabajadosXsemana(6);
		
		return escala;
	}	
	
	private FactOT getOT_pasa1() {
		FactOT ot = new FactOT();
		ot.setEmpresa("02");
		ot.setDelegacion("03");
		
		return ot;
	}	
	
	private FactOT getOT_pasa2() {
		FactOT ot = new FactOT();
		ot.setEmpresa("08");
		ot.setDelegacion("10");
		
		return ot;
	}	
	
	private FactOT getOT_noPasa() {
		FactOT ot = new FactOT();
		ot.setEmpresa("08");
		ot.setDelegacion("03");
		
		return ot;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHorasJornadaXpersona(8);
				
		return esquema;
	}	
}

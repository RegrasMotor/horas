package unitary;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class HorasExtrasXpersona extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Horas Extra por persona.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_horasExtrasNO();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getHorasExtrasXpersona(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_horasExtrasDEFAULT();
		ksession.insert(factResponse);		
		
		ksession.fireAllRules();
		
		assertEquals(12, factResponse.getHorasExtrasXpersona(), delta);
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse_horasExtrasDEFAULT2_calculoM();
		ksession.insert(factResponse);			
		ksession.insert(getEscalaXCategoria_calculoM());
		ksession.insert(getEscala_trabajados5());
		
		ksession.fireAllRules();
		
		assertEquals(12, factResponse.getHorasExtrasXpersona(), delta);
    }	
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse_horasExtrasDEFAULT3_calculoS();
		ksession.insert(factResponse);			
		ksession.insert(getEscalaXCategoria_calculoS());
		ksession.insert(getEscala_trabajados5());
		
		ksession.fireAllRules();
		
		assertEquals(12, factResponse.getHorasExtrasXpersona(), delta);
    }
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = getResponse_horasExtrasDEFAULT4_calculoD();
		ksession.insert(factResponse);			
		ksession.insert(getEscalaXCategoria_calculoD());
		ksession.insert(getEscala_trabajados5());
		
		ksession.fireAllRules();
		
		assertEquals(12, factResponse.getHorasExtrasXpersona(), delta);
    }	
	
	@Test
    public void comprobarAccion6() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = getResponse_horasExtras_calculoM();
		ksession.insert(factResponse);			
		ksession.insert(getEscalaXCategoria_calculoM());
		ksession.insert(getEscala_trabajados5());
		
		ksession.fireAllRules();
		
		assertEquals(14, factResponse.getHorasExtrasXpersona(), delta);
    }	
	
	@Test
    public void comprobarAccion7() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = getResponse_horasExtras_calculoS();
		ksession.insert(factResponse);			
		ksession.insert(getEscalaXCategoria_calculoS());
		ksession.insert(getEscala_trabajados5());
		
		ksession.fireAllRules();
		
		assertEquals(22, factResponse.getHorasExtrasXpersona(), delta);
    }		
	
	@Test
    public void comprobarAccion8() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion8" );
		
		FactResponse factResponse = getResponse_horasExtras_calculoD();
		ksession.insert(factResponse);			
		ksession.insert(getEscalaXCategoria_calculoD());
		ksession.insert(getEscala_trabajados5());
		
		ksession.fireAllRules();
		
		assertEquals(34, factResponse.getHorasExtrasXpersona(), delta);
    }		
	
	private FactEscalaXCategoria getEscalaXCategoria_calculoM() {
		FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
		factEscalaXCategoria.setTipoCalculo("M");
		factEscalaXCategoria.setHorasPeriodo(160);
		
		return factEscalaXCategoria;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria_calculoS() {
		FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
		factEscalaXCategoria.setTipoCalculo("S");
		factEscalaXCategoria.setHorasPeriodo(40);
		
		return factEscalaXCategoria;
	}		

	private FactEscalaXCategoria getEscalaXCategoria_calculoD() {
		FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
		factEscalaXCategoria.setTipoCalculo("D");
		factEscalaXCategoria.setHorasPeriodo(8);
		
		return factEscalaXCategoria;
	}
	
	private FactEscala getEscala_trabajados5() {
		FactEscala factEscala = new FactEscala();
		factEscala.setDiasTrabajadosXsemana(5);
		
		return factEscala;
	}	
	
	private FactResponse getResponse_horasExtrasNO() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(1f);
		factResponse.setNumeroHorasFestivasPropEscala(1f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(5f);
		factResponse.setHoraExtrasMayor2horas(true);
		
		return factResponse;
	}
	
	private FactResponse getResponse_horasExtrasDEFAULT() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(false);
		
		return factResponse;
	}	
	
	private FactResponse getResponse_horasExtrasDEFAULT2_calculoM() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(true);
		factResponse.setHorasEfectivasJornadaXpersona(0f);
		factResponse.setMediaDiasEscalaMes(20f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_horasExtrasDEFAULT3_calculoS() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(true);
		factResponse.setHorasEfectivasJornadaXpersona(0f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_horasExtrasDEFAULT4_calculoD() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(true);
		factResponse.setHorasEfectivasJornadaXpersona(0f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_horasExtras_calculoM() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(true);
		factResponse.setHorasEfectivasJornadaXpersona(12f);
		factResponse.setMediaDiasEscalaMes(20f);
		factResponse.setNumeroDiasEscalaDescFestivos(7f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_horasExtras_calculoS() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(true);
		factResponse.setHorasEfectivasJornadaXpersona(12f);
		factResponse.setNumeroDiasEscalaDescFestivos(11f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_horasExtras_calculoD() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasEscalaXpersona(60f);
		factResponse.setNumeroHorasFestivasPropEscala(8f);
		factResponse.setNumeroTurnosDia(1);
		factResponse.setHorasNormalesXpersona(40f);
		
		factResponse.setHoraExtrasMayor2horas(true);
		factResponse.setHorasEfectivasJornadaXpersona(12f);
		factResponse.setNumeroDiasEscalaDescFestivos(17f);
		
		return factResponse;
	}		
}


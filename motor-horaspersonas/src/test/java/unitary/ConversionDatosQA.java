package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;

public class ConversionDatosQA extends JUnitBase {
	private final static String rulesFile = "rules/horaspersonas/BRA/Conversion datos QA.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactEsquemaOperativo factEsquemaOperativo = getEsquema_horasFromWS();
		FactEscalaXCategoria factEscalaXCategoria = getEscalaXCategoria_horasFromWS();
		ksession.insert(factEsquemaOperativo);
		ksession.insert(factEscalaXCategoria);
		
		ksession.fireAllRules();
		
		assertEquals(new GregorianCalendar(1970,0,1,8,0).getTime(), factEsquemaOperativo.getHoraInicioJornada());
		assertEquals(new GregorianCalendar(1970,0,1,22,0).getTime(), factEsquemaOperativo.getHoraFinJornada());
		assertEquals(null, factEsquemaOperativo.getHoraInicioJornadaQA());
		assertEquals(null, factEsquemaOperativo.getHoraFinJornadaQA());
		assertEquals(new GregorianCalendar(1970,0,1,6,0).getTime(), factEscalaXCategoria.getHoraInicioAdicNocturno());
		assertEquals(new GregorianCalendar(1970,0,1,20,0).getTime(), factEscalaXCategoria.getHoraFinAdicNocturno());
		assertEquals(null, factEscalaXCategoria.getHoraInicioAdicNocturnoQA());
		assertEquals(null, factEscalaXCategoria.getHoraFinAdicNocturnoQA());
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactEsquemaOperativo factEsquemaOperativo = getEsquema_horasFromQA();
		FactEscalaXCategoria factEscalaXCategoria = getEscalaXCategoria_horasFromQA();
		ksession.insert(factEsquemaOperativo);
		ksession.insert(factEscalaXCategoria);
		
		ksession.fireAllRules();
		
		assertEquals(new GregorianCalendar(1970,0,1,10,0).getTime(), factEsquemaOperativo.getHoraInicioJornada());
		assertEquals(new GregorianCalendar(1970,0,1,20,0).getTime(), factEsquemaOperativo.getHoraFinJornada());
		assertEquals("10:00", factEsquemaOperativo.getHoraInicioJornadaQA());
		assertEquals("20:00", factEsquemaOperativo.getHoraFinJornadaQA());
		assertEquals(new GregorianCalendar(1970,0,1,12,0).getTime(), factEscalaXCategoria.getHoraInicioAdicNocturno());
		assertEquals(new GregorianCalendar(1970,0,1,23,0).getTime(), factEscalaXCategoria.getHoraFinAdicNocturno());
		assertEquals("12:00", factEscalaXCategoria.getHoraInicioAdicNocturnoQA());
		assertEquals("23:00", factEscalaXCategoria.getHoraFinAdicNocturnoQA());		
    }	

	private FactEsquemaOperativo getEsquema_horasFromWS() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraInicioJornada(new GregorianCalendar(1970,0,1,8,0).getTime());
		esquema.setHoraFinJornada(new GregorianCalendar(1970,0,1,22,0).getTime());
		
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquema_horasFromQA() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraInicioJornadaQA("10:00");
		esquema.setHoraFinJornadaQA("20:00");
		
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria_horasFromWS() {
		FactEscalaXCategoria escalaXcategoria = new FactEscalaXCategoria();
		escalaXcategoria.setHoraInicioAdicNocturno(new GregorianCalendar(1970,0,1,6,0).getTime());
		escalaXcategoria.setHoraFinAdicNocturno(new GregorianCalendar(1970,0,1,20,0).getTime());
		
		return escalaXcategoria;
	}		

	private FactEscalaXCategoria getEscalaXCategoria_horasFromQA() {
		FactEscalaXCategoria escalaXcategoria = new FactEscalaXCategoria();
		escalaXcategoria.setHoraInicioAdicNocturnoQA("12:00");
		escalaXcategoria.setHoraFinAdicNocturnoQA("23:00");
		
		return escalaXcategoria;
	}	

}


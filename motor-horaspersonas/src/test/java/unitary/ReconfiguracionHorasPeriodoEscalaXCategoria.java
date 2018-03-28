package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class ReconfiguracionHorasPeriodoEscalaXCategoria extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Reconfiguracion horas periodo de la escala X categoria.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactEscalaXCategoria factEscalaXCat = getEscalaXCategoria1();
		ksession.insert(factEscalaXCat);	
		ksession.insert(getEsquemaOperativo1());
		
		ksession.fireAllRules();
		
		assertEquals(8, factEscalaXCat.getHorasPeriodo(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactEscalaXCategoria factEscalaXCat = getEscalaXCategoria1();
		ksession.insert(factEscalaXCat);	
		ksession.insert(getEsquemaOperativo2());
		ksession.insert(getResponse());
		
		ksession.fireAllRules();
		
		assertEquals(10, factEscalaXCat.getHorasPeriodo(), delta);
    }
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactEscalaXCategoria factEscalaXCat = getEscalaXCategoria1();
		ksession.insert(factEscalaXCat);	
		ksession.insert(getEsquemaOperativo2());
		ksession.insert(getResponse2());
		
		ksession.fireAllRules();
		
		assertEquals(9, factEscalaXCat.getHorasPeriodo(), delta);
    }
	
	private FactEscalaXCategoria getEscalaXCategoria1() {
		FactEscalaXCategoria escalaXCategoria = new FactEscalaXCategoria();
		escalaXCategoria.setTipoCalculo("D");
		escalaXCategoria.setHorasPeriodo(12);
		
		return escalaXCategoria;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("C");
		esquemaOperativo.setHorasJornadaXpersona(8);
		
		return esquemaOperativo;
	}	
	
	private FactResponse getResponse() {
		FactResponse response = new FactResponse();
		response.setHorasAlmuerzoJornadaXpersona(2f);
		
		return response;
	}	
	
	private FactResponse getResponse2() {
		FactResponse response = new FactResponse();
		response.setHorasAlmuerzoJornadaXpersona(1f);
		
		return response;
	}	
	

	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setCoberturaAlmuerzo("D");
		esquemaOperativo.setHorasJornadaXpersona(10);
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,10,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,22,0).getTime());
		
		return esquemaOperativo;
	}	
}

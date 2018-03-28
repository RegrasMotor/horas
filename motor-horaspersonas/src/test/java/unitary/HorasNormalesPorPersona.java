package unitary;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;



public class HorasNormalesPorPersona extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/Horas normales por persona.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		//Rule 1
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getEscala());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(10, factResponse.getHorasNormalesXpersona(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Rule 2
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getEscala());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(180.27397, factResponse.getHorasNormalesXpersona(), delta);
		
    }
	
	
	@Test
    public void comprobarAccion3() {
		//Rule 3
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		ksession.insert(getEscala());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
		
		assertEquals(200, factResponse.getHorasNormalesXpersona(), delta);
		
    }
	
	
	@Test
    public void comprobarAccion4() {
		//Rule 4
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		ksession.insert(getEscala());
		ksession.insert(getEscalaXCategoria3());
		ksession.insert(getParams());
		
		ksession.fireAllRules();
				
		assertEquals(8, factResponse.getHorasNormalesXpersona(), delta);
		
    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes (22f);
		factResponse.setMediaDiasEscalaMes (20f);
		factResponse.setNumeroFestivosMensuales(3f);
		factResponse.setNumeroDiasEscalaDescFestivos (4f);
		
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setNumeroHorasFestivasPropEscala (5f);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setNumeroHorasFestivasPropEscala (0f);
			
		return factResponse;
	}
	
	private FactEscala getEscala() {
		FactEscala escala = new FactEscala();
		escala.setDiasTrabajadosXsemana (5) ;	
		escala.setDiasLibresXsemana (2) ;
		
		return escala;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria1() {
		FactEscalaXCategoria escalaXCategoria = new FactEscalaXCategoria();
		escalaXCategoria.setHorasPeriodo (10) ;	
		escalaXCategoria.setTipoCalculo("M");
		
		return escalaXCategoria;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria2() {
		FactEscalaXCategoria escalaXCategoria = new FactEscalaXCategoria();
		escalaXCategoria.setHorasPeriodo (10) ;	
		escalaXCategoria.setTipoCalculo("D");
		
		return escalaXCategoria;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria3() {
		FactEscalaXCategoria escalaXCategoria = new FactEscalaXCategoria();
		escalaXCategoria.setHorasPeriodo (10) ;	
		escalaXCategoria.setTipoCalculo("S");
		
		return escalaXCategoria;
	}

	private FactParams getParams() {
		FactParams factParams = new FactParams();
		factParams.setNumeroDiasMes(365/12f);
		
		return factParams;
	}
}

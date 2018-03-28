package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class PromedioDiasTrabajadosMesXescala extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Promedio de dias trabajados al mes de acuerdo con la escala.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(24, factResponse.getMediaDiasEscalaMes(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse2();
		
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo());
		ksession.insert(getEscalaFT());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(21.72619, factResponse.getMediaDiasEscalaMes(), delta);
    }
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaNoFT());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(26.0714, factResponse.getMediaDiasEscalaMes(), delta);
    }
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setMediaDiasTrabajoMes(24f);
						
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setServicioRif(true);
		factResponse.setNumeroMesesServicio(1);
		factResponse.setDiasTrabajadosXsemana(5);
						
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setTrabajaLunes(true);
		esquemaOperativo.setTrabajaMartes(true);
		esquemaOperativo.setTrabajaMiercoles(true);
		esquemaOperativo.setTrabajaJueves(true);
		esquemaOperativo.setTrabajaViernes(true);

		return esquemaOperativo;
	}	
	
	private FactEscala getEscalaFT() {
		FactEscala escala = new FactEscala();
		escala.setId("FT");
		escala.setDiasTrabajadosXsemana(6);
		escala.setDiasLibresXsemana(1);
		
		return escala;
	}	
	
	private FactEscala getEscalaNoFT() {
		FactEscala escala = new FactEscala();
		escala.setId("FX");
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

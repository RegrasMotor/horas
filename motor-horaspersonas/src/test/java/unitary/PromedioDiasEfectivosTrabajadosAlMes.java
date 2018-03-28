package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class PromedioDiasEfectivosTrabajadosAlMes extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Promedio de dias efectivos trabajados al mes.drl";
	
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
		
		assertEquals(23, factResponse.getMediaDiasEfectivosMes(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo2());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(21.4876, factResponse.getMediaDiasEfectivosMes(), delta);
    }
	
	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEsquemaOperativo3());
		ksession.insert(getParam());
		
		ksession.fireAllRules();
		
		assertEquals(2, factResponse.getMediaDiasEfectivosMes(), delta);
    }
	
	private FactResponse getResponse1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes(23f);
		factResponse.setNumeroFestivosMensuales(2f);   
						
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setTipoJornada("T");
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setTipoJornada("H");
		
		return esquemaOperativo;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo3() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setTipoJornada("F");
		
		return esquemaOperativo;
	}	
	
	private FactParams getParam() {
		FactParams params = new FactParams();
		params.setNumeroDiasMes(365/12f);
		
		return params;
	}		
}

package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HoraExtrasMayor2horas extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/decisionTables/Horas Extras Especial mayor de dos horas.gdst";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp1Del1());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isHoraExtrasMayor2horas());
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp1Del3());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isHoraExtrasMayor2horas());		
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del5());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isHoraExtrasMayor2horas());		
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del13());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isHoraExtrasMayor2horas());		
    }
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp1Del1());
		ksession.insert(getEsquema_CatSEAC_PR());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isHoraExtrasMayor2horas());		
    }
	
	@Test
    public void comprobarAccion6() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp1Del1());
		ksession.insert(getEsquema_CatXXX());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isHoraExtrasMayor2horas());		
    }	
	
	@Test
    public void comprobarAccion7() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del7());
		ksession.insert(getEsquema_CatSEAC_PR());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isHoraExtrasMayor2horas());		
    }
	
	@Test
    public void comprobarAccion8() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion8" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del13());
		ksession.insert(getEsquema_CatXXX());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isHoraExtrasMayor2horas());		
    }	
	
	private FactOT getOT_Emp1Del1() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		factOT.setDelegacion("01");
		
		return factOT;
	}

	private FactOT getOT_Emp2Del7() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("07");
		
		return factOT;
	}
	
	private FactOT getOT_Emp1Del3() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		factOT.setDelegacion("03");

		return factOT;
	}

	private FactOT getOT_Emp2Del5() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("04");
		
		return factOT;
	}

	private FactOT getOT_Emp2Del13() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("13");
		
		return factOT;
	}
	
	private FactEsquemaOperativo getEsquema_CatSEAC_PR() {
		FactEsquemaOperativo FactEsquemaOperativo = new FactEsquemaOperativo();
		FactEsquemaOperativo.setIdCategoriaSalarial("SEAC - PR");
		
		return FactEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_CatXXX() {
		FactEsquemaOperativo FactEsquemaOperativo = new FactEsquemaOperativo();
		FactEsquemaOperativo.setIdCategoriaSalarial("XXX");
		
		return FactEsquemaOperativo;
	}	
}


package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class ExtensionAdicNocturno extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/decisionTables/Extension adicional nocturno.gdst";
	
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
		
		assertEquals(true, factResponse.isExtensionAdicNocturno());
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp1Del4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isExtensionAdicNocturno());		
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp1Del5());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isExtensionAdicNocturno());		
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del1());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isExtensionAdicNocturno());		
    }
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isExtensionAdicNocturno());		
    }
	
	@Test
    public void comprobarAccion6() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = new FactResponse();
		ksession.insert(factResponse);		
		ksession.insert(getOT_Emp2Del2());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isExtensionAdicNocturno());		
    }	
	
	private FactOT getOT_Emp1Del1() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		factOT.setDelegacion("01");
		
		return factOT;
	}

	private FactOT getOT_Emp2Del1() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("01");
		
		return factOT;
	}
	
	private FactOT getOT_Emp1Del4() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		factOT.setDelegacion("04");

		return factOT;
	}

	private FactOT getOT_Emp2Del4() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("04");
		
		return factOT;
	}

	private FactOT getOT_Emp1Del5() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		factOT.setDelegacion("05");
		
		return factOT;
	}
	
	private FactOT getOT_Emp2Del2() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("02");
		
		return factOT;
	}	
}


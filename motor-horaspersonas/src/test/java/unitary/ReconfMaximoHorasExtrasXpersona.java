package unitary;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class ReconfMaximoHorasExtrasXpersona extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Reconfigurar maximo Horas Extras por persona.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_extras30();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaSEAC_SC());
		ksession.insert(getOT_empresa1_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(30, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(13, factResponse.getHorasExtras50Xpersona(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_extras50();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaSEAC_SC());
		ksession.insert(getOT_empresa1_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(40, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(10, factResponse.getHorasExtras50Xpersona(), delta);
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse_extras30();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaSINDESP_SC());
		ksession.insert(getOT_empresa1_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(30, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(13, factResponse.getHorasExtras50Xpersona(), delta);
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse_extras50();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaSINDESP_SC());
		ksession.insert(getOT_empresa1_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(40, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(10, factResponse.getHorasExtras50Xpersona(), delta);
    }	
	
	@Test
    public void comprobarAccion5() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = getResponse_extras30();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaXXX());
		ksession.insert(getOT_empresa1_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(30, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(13, factResponse.getHorasExtras50Xpersona(), delta);
    }
	
	@Test
    public void comprobarAccion6() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = getResponse_extras50();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaXXX());
		ksession.insert(getOT_empresa1_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(false, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(50, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(17, factResponse.getHorasExtras50Xpersona(), delta);
    }		

	@Test
    public void comprobarAccion7() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = getResponse_extras30();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaXXX());
		ksession.insert(getOT_empresa2_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(30, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(13, factResponse.getHorasExtras50Xpersona(), delta);
    }
	
	@Test
    public void comprobarAccion8() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion8" );
		
		FactResponse factResponse = getResponse_extras50();
		ksession.insert(factResponse);
		ksession.insert(getEsqOp_categoriaXXX());
		ksession.insert(getOT_empresa2_delegacio4());
		
		ksession.fireAllRules();
		
		assertEquals(true, factResponse.isReconfMaximoHorasExtrasXpersona());
		assertEquals(40, factResponse.getHorasExtrasXpersona(), delta);
		assertEquals(10, factResponse.getHorasExtras50Xpersona(), delta);
    }		
	private FactOT getOT_empresa2_delegacio4() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("02");
		factOT.setDelegacion("04");
		
		return factOT;
	}
	
	private FactOT getOT_empresa1_delegacio4() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		factOT.setDelegacion("04");
		
		return factOT;
	}
	
	private FactEsquemaOperativo getEsqOp_categoriaSEAC_SC() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setIdCategoriaSalarial("SEAC - SC");
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsqOp_categoriaSINDESP_SC() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setIdCategoriaSalarial("SINDESP - SC");
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsqOp_categoriaXXX() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setIdCategoriaSalarial("XXX");
		
		return factEsquemaOperativo;
	}

	private FactResponse getResponse_extras30() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasExtrasXpersona((float)30);
		factResponse.setHorasExtras50Xpersona((float)13);
		
		return factResponse;
	}
	
	private FactResponse getResponse_extras50() {
		FactResponse factResponse = new FactResponse();
		factResponse.setHorasExtrasXpersona((float)50);
		factResponse.setHorasExtras50Xpersona((float)17);
		
		return factResponse;
	}	
}


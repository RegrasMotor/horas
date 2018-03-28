package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasNormales extends JUnitBase {
	
private final static String rulesFile = "rules/horaspersonas/BRA/Horas normales.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas normales - SDF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaSDF());
		
		ksession.fireAllRules();		
		
		assertEquals(50, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Horas normales - CHNIF - Jornada F
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHNIF());
		ksession.insert(getEsquema_F());
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Horas normales - CHFT
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHFT());		
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//Horas normales - CHN - T
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHN());	
		ksession.insert(getEsquema_T());
		
		ksession.fireAllRules();		
		
		assertEquals(43, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Horas normales - CHN - NO T
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHN());	
		ksession.insert(getEsquema_F());
		
		ksession.fireAllRules();		
		
		assertEquals(50, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion6() {
		//Horas normales - CHNIF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHNIF_media());			
		
		ksession.fireAllRules();		
		
		assertEquals(50, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion7() {
		//Horas normales - CHEE
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHEE());			
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasNormales(), delta);

    }
	
	@Test
    public void comprobarAccion8() {
		//Horas normales - Con extras
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion8" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);						
		
		ksession.fireAllRules();		
		
		assertEquals(27, factResponse.getHorasNormales(), delta);

    }
	
    @Test
    public void comprobarAccion9() {
		//Horas normales - Con extras
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion9" );
		
		FactResponse factResponse = getResponse3();
		ksession.insert(factResponse);						
		
		ksession.fireAllRules();		
		
		assertEquals(38, factResponse.getHorasNormales(), delta);

    }
    
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();	
		factResponse.setHorasVendidas(50d);
		factResponse.setHorasExtrasFestivo(7d);
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();		
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasExtrasXpersona(2f);
		factResponse.setHorasNormalesXpersona(9f);
		factResponse.setNumeroRealPersonas(3d);
		
		return factResponse;
	}
	
	private FactResponse getResponse3() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasExtrasXpersona(0f);
		factResponse.setHorasExtrasLibreTrabajado(5d);
		
		return factResponse;
	}
	
	
	
	private FactEscala getEscalaSDF() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("SDF");
				
		return factEscala;
	}
	
	private FactEscala getEscalaCHNIF() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHNIF");
				
		return factEscala;
	}
	
	private FactEscala getEscalaCHNIF_media() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHNIF");
		factEscala.setMediaJornada(true);
				
		return factEscala;
	}
	
	private FactEscala getEscalaCHFT() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHFT");
		factEscala.setMediaJornada(true);
				
		return factEscala;
	}	
	
	private FactEscala getEscalaCHN() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHN");
		factEscala.setMediaJornada(true);
				
		return factEscala;
	}
	
	private FactEscala getEscalaCHEE() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHEE");
		factEscala.setMediaJornada(true);
				
		return factEscala;
	}
	
	private FactEsquemaOperativo getEsquema_F() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setTipoJornada("F");
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsquema_T() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setTipoJornada("T");
		
		return factEsquemaOperativo;
	}
}

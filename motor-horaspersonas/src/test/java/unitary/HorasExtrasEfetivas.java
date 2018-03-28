package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasExtrasEfetivas extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/Horas Extras efetivas.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas Extras eficaces - SDF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaSDF());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasEfetivas(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Horas Extras eficaces - CHNIF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHNIF());
		ksession.insert(getEsquema_F());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasEfetivas(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Horas Extras eficaces - Media Jornada
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHNIF_media());
		ksession.insert(getEsquema_T());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasEfetivas(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//Horas Extras eficaces - CHEE - Jornada T
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHEE());
		ksession.insert(getEsquema_T());
		ksession.fireAllRules();		
		
		assertEquals(35, factResponse.getHorasExtrasEfetivas(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Horas Extras eficaces - CHEE - Jornada NO T
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHEE());
		ksession.insert(getEsquema_F());
		ksession.fireAllRules();		
		
		assertEquals(45, factResponse.getHorasExtrasEfetivas(), delta);

    }
	
	@Test
    public void comprobarAccion6() {
		//"Horas Extras eficaces - Con extras"
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);				
		ksession.fireAllRules();		
		
		assertEquals(12, factResponse.getHorasExtrasEfetivas(), delta);

    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();		
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasVendidas(45d);
		factResponse.setNumeroHorasFestivasPropEscala(10f);
		factResponse.setHorasExtrasXpersona(4f);
		factResponse.setNumeroRealPersonas(3d);
		
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
	
//	private FactEscala getEscalaCHFT() {
//		FactEscala factEscala = new FactEscala();
//		factEscala.setId("CHFT");
//		factEscala.setMediaJornada(true);
//				
//		return factEscala;
//	}	
//	
//	private FactEscala getEscalaCHN() {
//		FactEscala factEscala = new FactEscala();
//		factEscala.setId("CHN");
//		factEscala.setMediaJornada(true);
//				
//		return factEscala;
//	}
	
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

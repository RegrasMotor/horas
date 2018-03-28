package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class HorasExtrasLibreTrabajado extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/functions/auxiliares.function;"+
										"rules/horaspersonas/BRA/Horas Extras libre trabajado.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas Extras libre trabajando - SDF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaSDF());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Horas Extras libre trabajando - CHNIF (F)
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHNIF());
		ksession.insert(getEsquema_F());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Horas Extras libre trabajando - Media Jornada - CHFT (T)
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHFT_media());
		ksession.insert(getEsquema_T());
		ksession.fireAllRules();		
		
		assertEquals(35, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//Horas Extras libre trabajando - Media Jornada - CHFT (NO T)
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHFT_media());
		ksession.insert(getEsquema_F());
		ksession.fireAllRules();		
		
		assertEquals(45, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		//Horas Extras libre trabajando - Media Jornada - CHN/CHNIF/CHEE
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHN_media());
		ksession.insert(getEsquema_T());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	@Test
    public void comprobarAccion6() {
		//Horas Extras libre trabajando - Horas Vendidas > Horas Escala
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHFT_noMedia());
		ksession.insert(getEsquema_T());
		ksession.fireAllRules();		
		
		assertEquals(24, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	@Test
    public void comprobarAccion7() {
		//Horas Extras libre trabajando - Numero real de personas < 0
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);		
		ksession.insert(getEscalaCHFT_noMedia());
		ksession.insert(getEsquema_T());
		ksession.fireAllRules();		
		
		assertEquals(28, factResponse.getHorasExtrasLibreTrabajado(), delta);

    }
	
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();		
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasVendidas(45d);
		factResponse.setNumeroHorasFestivasPropEscala(10f);
		factResponse.setNumeroHorasFestivasPropLibres(14f);
		factResponse.setTotalHorasEscala(7f);
		factResponse.setNumeroRealPersonas(3d);
		
		return factResponse;
	}
	
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();	
		factResponse.setHorasVendidas(45d);
		factResponse.setNumeroHorasFestivasPropEscala(10f);
		factResponse.setNumeroHorasFestivasPropLibres(14f);
		factResponse.setTotalHorasEscala(7f);
		factResponse.setNumeroRealPersonas(0d);
		
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
	
	private FactEscala getEscalaCHFT_media() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHFT");
		factEscala.setMediaJornada(true);
				
		return factEscala;
	}	
	
	private FactEscala getEscalaCHN_media() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHN");
		factEscala.setMediaJornada(true);
				
		return factEscala;
	}
	
	private FactEscala getEscalaCHFT_noMedia() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHFT");
		factEscala.setMediaJornada(false);
				
		return factEscala;
	}	
}

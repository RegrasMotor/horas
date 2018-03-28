package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class HorasExtrasEspeciales extends JUnitBase {

private final static String rulesFile = "rules/horaspersonas/BRA/Horas Extras especiales.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Escala SDF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaSDF());
		ksession.insert(getEsquema());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasEspeciales(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		//Escala SDF
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaCHNIF());
		ksession.insert(getEsquema());
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasEspeciales(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		//Con horas Extras Por persona
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaCHNIF());		
		ksession.fireAllRules();		
		
		assertEquals(60, factResponse.getHorasExtrasEspeciales(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		//Resto casos
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
			
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);	
		ksession.insert(getEscalaCHNIF());		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasExtrasEspeciales(), delta);

    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();		
		factResponse.setHorasExtras50Xpersona(20f);
		factResponse.setNumeroRealPersonas(3d);
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();			
		factResponse.setHorasExtrasXpersona(10f);
		
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();			
		factResponse.setHorasExtrasXpersona(0f);
		
		return factResponse;
	}
	
	private FactEscala getEscalaSDF() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("SDF");
		factEscala.setMediaJornada(true);
		
		return factEscala;
	}
	
	private FactEscala getEscalaCHNIF() {
		FactEscala factEscala = new FactEscala();
		factEscala.setId("CHNIF");
		factEscala.setMediaJornada(true);
		
		return factEscala;
	}
	
	private FactEsquemaOperativo getEsquema() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setMediaJornada(true);
		
		return factEsquemaOperativo;
	}
	
}

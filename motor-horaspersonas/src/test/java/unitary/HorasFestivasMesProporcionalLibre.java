package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class HorasFestivasMesProporcionalLibre extends JUnitBase {

	private final static String rulesFile = "rules/horaspersonas/BRA/Horas Festivas al mes proporcional libres.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		//Rule 1
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_servicioNoRIF_meses1();
		ksession.insert(factResponse);
		
		ksession.fireAllRules();
		
		assertEquals(0, factResponse.getNumeroHorasFestivosMesProporcionalLibres(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		//Rule 2
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_Rule2();
		ksession.insert(factResponse);
		ksession.insert(getEscala());
		ksession.insert(getEsquema());
		
		ksession.fireAllRules();
		
		assertEquals(20, factResponse.getNumeroHorasFestivosMesProporcionalLibres(), delta);
    }
	
	
@Test
public void comprobarAccion3() {
	//Rule 3
	logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
	
	FactResponse factResponse = getResponse_Rule3();
	ksession.insert(factResponse);
	ksession.insert(getEscala());
	ksession.insert(getEsquema());
	
	ksession.fireAllRules();
	
	assertEquals(15, factResponse.getNumeroHorasFestivosMesProporcionalLibres(), delta);
}
	
	
	
	
	private FactResponse getResponse_servicioNoRIF_meses1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(false);
		factResponse.setNumeroMesesServicio(1);
		
		return factResponse;
	}
	
	private FactResponse getResponse_Rule2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(true);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(28f);
		
		return factResponse;
	}
	
	private FactResponse getResponse_Rule3() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setServicioRif(false);
		factResponse.setNumeroHorasFestivosMesProporcionalEscala(21f);
		
		return factResponse;
	}

	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes (22f);
				
		return factResponse;
	}
	
	
	private FactEscala getEscala() {
		FactEscala escala = new FactEscala();
		escala.setDiasTrabajadosXsemana(5);
		escala.setDiasLibresXsemana(2);
		 
		return escala;
	}	
	
	private FactEsquemaOperativo getEsquema() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setPuestoSinCobertura(true);
		
		return esquema;
	}	
}

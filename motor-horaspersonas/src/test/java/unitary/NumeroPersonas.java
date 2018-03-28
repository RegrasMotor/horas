package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;

public class NumeroPersonas extends JUnitBase{
	private final static String rulesFile = "rules/horaspersonas/BRA/Cantidad de personas.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion" );
		
		FactResponse factResponse = getResponse_1();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_1());
		
		ksession.fireAllRules();
		
		assertEquals(2.0952, factResponse.getNumeroPersonas(), delta);
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse_1();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_2());

		
		ksession.fireAllRules();
		
		assertEquals(15.7143, factResponse.getNumeroPersonas(), delta);		
    }	

	@Test
    public void comprobarAccion3() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse_2();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_1());

		
		ksession.fireAllRules();
		
		assertEquals(2.1143, factResponse.getNumeroPersonas(), delta);		
    }
	
	@Test
    public void comprobarAccion4() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse_2();
		ksession.insert(factResponse);		
		ksession.insert(getEsqOp_2());

		
		ksession.fireAllRules();
		
		assertEquals(15.8571, factResponse.getNumeroPersonas(), delta);		
    }
	
	private FactEsquemaOperativo getEsqOp_1() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,6,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,22,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(8);
		factEsquemaOperativo.setNumeroPuestos(2);
		
		return factEsquemaOperativo;
	}
	
	private FactEsquemaOperativo getEsqOp_2() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,6,0).getTime());
		factEsquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,6,0).getTime());
		factEsquemaOperativo.setHorasJornadaXpersona(8);
		factEsquemaOperativo.setNumeroPuestos(5);
		
		return factEsquemaOperativo;
	}
	
	private FactResponse getResponse_1() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes(22f);
		factResponse.setMediaDiasEscalaMes(21f);
		
		return factResponse;
	}	

	private FactResponse getResponse_2() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes(22.2f);
		factResponse.setMediaDiasEscalaMes(21f);
		
		return factResponse;
	}	
}

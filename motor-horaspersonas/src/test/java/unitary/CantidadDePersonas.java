package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class CantidadDePersonas extends JUnitBase {
	
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
		
		FactResponse factResponse = getResponse();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo());
		
		ksession.fireAllRules();
		
		assertEquals(7.3499, factResponse.getNumeroPersonas(), delta);
    }
	
	
	private FactResponse getResponse() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes(21f);
		factResponse.setMediaDiasEscalaMes (20f);
		
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo() {
		FactEsquemaOperativo esquemaOperativo = new FactEsquemaOperativo();
		esquemaOperativo.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquemaOperativo.setHoraInicioJornada(new GregorianCalendar(2000,1,1,18,0).getTime());
		esquemaOperativo.setHorasJornadaXpersona(8);
		esquemaOperativo.setNumeroPuestos(4);
		
		return esquemaOperativo;
	}	
}

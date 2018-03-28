package unitary;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;


public class HorasVendidas extends JUnitBase {

	
	private final static String rulesFile = "rules/horaspersonas/BRA/Horas vendidas.drl;" +
										"rules/horaspersonas/BRA/functions/auxiliares.function;" + 
										"rules/horaspersonas/BRA/Horas jornada por puesto.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		//Horas vendidas - Caso general
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);		
		ksession.insert(getEsquemaOperativo3());
		
		ksession.fireAllRules();		
		
		assertEquals(704, factResponse.getHorasVendidas(), delta);

    }
	
	@Test
	 public void comprobarAccion2() {
			//Horas vendidas - Almuerzo T o N
			logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
			
			FactResponse factResponse = getResponse1();
			ksession.insert(factResponse);		
			ksession.insert(getEsquemaOperativo2());
			
			ksession.fireAllRules();		
			
			assertEquals(572, factResponse.getHorasVendidas(), delta);

	    }
	 
	@Test
	 public void comprobarAccion3() {
			//Horas vendidas - Almuerzo T o N
			logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
			
			FactResponse factResponse = getResponse1();
			ksession.insert(factResponse);		
			ksession.insert(getEsquemaOperativo1());
			
			ksession.fireAllRules();		
			
			assertEquals(572, factResponse.getHorasVendidas(), delta);

	    }
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasEfectivosMes(22f);
				
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setHorasAlmuerzoJornadaXpersona(2f);
		factResponse.setNumeroTurnosDia(3);
		
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setCoberturaAlmuerzo ("T");
		esquema.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquema.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		esquema.setNumeroPuestos(2);
				
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setCoberturaAlmuerzo ("N");
		esquema.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquema.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		esquema.setNumeroPuestos(2);
				
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo3() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setCoberturaAlmuerzo ("X");
		esquema.setHoraFinJornada(new GregorianCalendar(2000,1,1,8,0).getTime());
		esquema.setHoraInicioJornada(new GregorianCalendar(2000,1,1,16,0).getTime());
		esquema.setNumeroPuestos(2);
				
		return esquema;
	}	
}

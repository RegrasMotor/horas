package unitary;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;



public class ReconfiguracionDiasTrabajoYLibresEscala extends JUnitBase {

	
private final static String rulesFile = "rules/horaspersonas/BRA/Reconfiguracion dias de trabajo y libres de la escala.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);
	}
	
	@Test
    public void comprobarAccion1() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = new FactResponse();
		factResponse.setDiasTrabajadosXsemana(4);
		ksession.insert(factResponse);
		
		FactEscala factEscala = getEscala();
		ksession.insert(factEscala);
		ksession.insert(getEscalaXCatD());
		ksession.insert(getEsquemaOperativo());		
		
		ksession.fireAllRules();
		
		assertEquals(4, factEscala.getDiasTrabajadosXsemana());
		assertEquals(3, factEscala.getDiasLibresXsemana());
    }
	
	@Test
    public void comprobarAccion2() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactEscala factEscala = getEscala();
		ksession.insert(factEscala);
		ksession.insert(getEscalaXCatS());
		ksession.insert(getEsquemaOperativo());		
		
		ksession.fireAllRules();
		
		assertEquals(6, factEscala.getDiasTrabajadosXsemana());
		assertEquals(1, factEscala.getDiasLibresXsemana());
    }
	
	
	private FactEscalaXCategoria getEscalaXCatD() {
		FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
		factEscalaXCategoria.setTipoCalculo("D");
		
		return factEscalaXCategoria;
	}	
	
	private FactEscalaXCategoria getEscalaXCatS() {
		FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
		factEscalaXCategoria.setTipoCalculo("S");
		
		return factEscalaXCategoria;
	}	
	
	private FactEscala getEscala() {
		FactEscala escala = new FactEscala();
		escala.setDiasTrabajadosXsemana(6);
		escala.setDiasLibresXsemana(1);
		
		return escala;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setTrabajaLunes(true);
		esquema.setTrabajaMartes(true);
		esquema.setTrabajaMiercoles(true);
		esquema.setTrabajaJueves(true);
				
		return esquema;
	}	
}

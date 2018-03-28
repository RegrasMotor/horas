package unitary;

import org.junit.BeforeClass;
import org.junit.Test;

import base.JUnitBase;

public class HorasAdicionalNocturno extends JUnitBase {

	private final static String rulesFile = "rules/horaspersonas/BRA/Conversion datos QA.drl;" + 
										"rules/horaspersonas/BRA/Horas Adicional nocturno.drl";
	
	@BeforeClass
	public static void initialize() {
		initialize (rulesFile);		
	}
	
	@Test
    public void comprobarAccion1() {
		
	}
	
	/**
	 * Pruebas de 1 a 15 -> Para la primera regla
	 * Pruebas de 16 a 30 -> Para la segunda
	 * Prueba 31 -> La jornada no entra en ningun momento en el adicional nocturno. Resultado igual a cero
	 * 
	 * Pruebas 1 al 4: Fechas -> Ambas distintos días
	 * Pruebas del 5 al 8 - Jornada mismo dia, Adic distinto dia
	 * Pruebas 9 y 10 con jornada distintos días y adicional mismo
	 * Pruebas 11 a 15 ambos mismo dia
	 * 
	 * Para las pruebas del 16 al 30 igual las fechas que para las del 1 al 15
	 */
	
	/*
	@Test
    public void comprobarAccion1() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion1" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo1());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(24, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion2() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion2" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo2());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion3() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion3" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo3());
		ksession.insert(getEscalaXCategoria3());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(21, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion4() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion4" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo4());
		ksession.insert(getEscalaXCategoria4());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(6, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion5() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion5" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo5());
		ksession.insert(getEscalaXCategoria5());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(15, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion6() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion6" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo6());
		ksession.insert(getEscalaXCategoria6());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(9, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion7() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion7" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo7());
		ksession.insert(getEscalaXCategoria7());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(3, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion8() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion8" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo8());
		ksession.insert(getEscalaXCategoria8());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion9() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion9" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo9());
		ksession.insert(getEscalaXCategoria9());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(12, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion10() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion10" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo10());
		ksession.insert(getEscalaXCategoria10());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion11() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion11" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo11());
		ksession.insert(getEscalaXCategoria11());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion12() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion12" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo12());
		ksession.insert(getEscalaXCategoria12());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion13() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion13" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo13());
		ksession.insert(getEscalaXCategoria13());
		ksession.insert(getEscala());	
	
		ksession.fireAllRules();		
		
		assertEquals(15, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion14() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion14" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo14());
		ksession.insert(getEscalaXCategoria14());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(12, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion15() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion15" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo15());
		ksession.insert(getEscalaXCategoria15());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(3, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
  public void comprobarAccion16() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion16" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo1b());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(480, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion17() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion17" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo2b());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(360, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion18() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion18" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo3b());
		ksession.insert(getEscalaXCategoria3());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(420, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion19() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion19" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo4b());
		ksession.insert(getEscalaXCategoria4());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(120, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion20() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion20" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo5b());
		ksession.insert(getEscalaXCategoria5());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(300, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion21() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion21" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo6b());
		ksession.insert(getEscalaXCategoria6());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(180, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion22() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion22" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo7b());
		ksession.insert(getEscalaXCategoria7());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(60, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion23() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion23" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo8b());
		ksession.insert(getEscalaXCategoria8());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(360, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion24() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion24" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo9b());
		ksession.insert(getEscalaXCategoria9());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(240, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion25() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion25" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo10b());
		ksession.insert(getEscalaXCategoria10());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(360, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion26() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion26" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo11b());
		ksession.insert(getEscalaXCategoria11());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(360, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion27() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion27" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo12b());
		ksession.insert(getEscalaXCategoria12());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(360, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion28() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion28" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo13b());
		ksession.insert(getEscalaXCategoria13());
		ksession.insert(getEscala());	
	
		ksession.fireAllRules();		
		
		assertEquals(300, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion29() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion29" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo14b());
		ksession.insert(getEscalaXCategoria14());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(240, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion30() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion30" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo15b());
		ksession.insert(getEscalaXCategoria15());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(60, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
    public void comprobarAccion31() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion31" );
		
		FactResponse factResponse = getResponse1();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo16());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(0, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion32() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion32" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo1());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(30, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion33() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion33" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo2());
		ksession.insert(getEscalaXCategoria2());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
    public void comprobarAccion34() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion34" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo3());
		ksession.insert(getEscalaXCategoria3());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(27, factResponse.getHorasAdicNocturno(), delta);

    }
	
	@Test
  public void comprobarAccion35() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion35" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo4b());
		ksession.insert(getEscalaXCategoria4());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(120, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion36() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion36" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo5());
		ksession.insert(getEscalaXCategoria5());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(21, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion37() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion37" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo6());
		ksession.insert(getEscalaXCategoria6());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(9, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion38() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion38" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo7b());
		ksession.insert(getEscalaXCategoria7());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(60, factResponse.getHorasAdicNocturno(), delta);

  }
	
	/*
	 * Caso que me genera dudas. Hablarlo.
	 */
	
//	@Test
//  public void comprobarAccion39() {
//		
//		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion39" );
//		
//		FactResponse factResponse = getResponse2();
//		ksession.insert(factResponse);
//		
//		ksession.insert(getEsquemaOperativo8());
//		ksession.insert(getEscalaXCategoria8());
//		ksession.insert(getEscala());
//		
//		ksession.fireAllRules();		
//		
//		assertEquals(18, factResponse.getHorasAdicNocturno(), delta);
//
//  }
	/*
	@Test
	  public void comprobarAccion40() {
			
			logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion40" );
			
			FactResponse factResponse = getResponse2();
			ksession.insert(factResponse);
			
			ksession.insert(getEsquemaOperativo9());
			ksession.insert(getEscalaXCategoria9());
			ksession.insert(getEscala());
			
			ksession.fireAllRules();		
			
			assertEquals(12, factResponse.getHorasAdicNocturno(), delta);

	  }
		
		@Test
	  public void comprobarAccion41() {
			
			logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion41" );
			
			FactResponse factResponse = getResponse2();
			ksession.insert(factResponse);
			
			ksession.insert(getEsquemaOperativo10b());
			ksession.insert(getEscalaXCategoria10());
			ksession.insert(getEscala());
			
			ksession.fireAllRules();		
			
			assertEquals(540, factResponse.getHorasAdicNocturno(), delta);

	  }
	
	@Test
  public void comprobarAccion42() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion42" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo11());
		ksession.insert(getEscalaXCategoria11());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(27, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion43() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion43" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo12());
		ksession.insert(getEscalaXCategoria12());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(27, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion44() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion44" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo13b());
		ksession.insert(getEscalaXCategoria13());
		ksession.insert(getEscala());	
	
		ksession.fireAllRules();		
		
		assertEquals(300, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion45() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion45" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo14());
		ksession.insert(getEscalaXCategoria14());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(21, factResponse.getHorasAdicNocturno(), delta);

  }
	
	@Test
  public void comprobarAccion46() {
		
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion46" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo15b());
		ksession.insert(getEscalaXCategoria15());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(60, factResponse.getHorasAdicNocturno(), delta);

  }
	
	/**
	 * 
	 * Las siguientes dos pruebas han sido realizadas por el error en las pruebas de integración
	 * En ambos casos la hora de fin de la jornada coincide con el inicio del periodo de adicional nocturno
	 * El primero sin extensión, el segundo con ella
	 * Debería devolver cero en ambos casos
	 * 
	 * Hora inicio adic nocturno 22h, fin adic nocturno 6h
	 * Hora inicio jornada 10h, fin jornada 22h
	 */
/*
	@Test
	  public void comprobarAccion47() {
			
			logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion47" );
			
			FactResponse factResponse = getResponse1();
			ksession.insert(factResponse);
			
			ksession.insert(getEsquemaOperativo17());
			ksession.insert(getEscalaXCategoria1());
			ksession.insert(getEscala());
			
			ksession.fireAllRules();		
			
			assertEquals(0, factResponse.getHorasAdicNocturno(), delta);

	  }
	
	@Test
	  public void comprobarAccion48() {
			
			logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion48" );
			
			FactResponse factResponse = getResponse2();
			ksession.insert(factResponse);
			
			ksession.insert(getEsquemaOperativo17());
			ksession.insert(getEscalaXCategoria1());
			ksession.insert(getEscala());
			
			ksession.fireAllRules();		
			
			assertEquals(0, factResponse.getHorasAdicNocturno(), delta);

	  }
	
	//Comprobación turno excede adic. nocturno, pero cambia de trabajador tras el adic. nocturno
	@Test
	public void comprobarAccion49() {
		logger.setFileName( logsDir + this.getClass().getSimpleName() + ".comprobarAccion49" );
		
		FactResponse factResponse = getResponse2();
		ksession.insert(factResponse);
		
		ksession.insert(getEsquemaOperativo18());
		ksession.insert(getEscalaXCategoria1());
		ksession.insert(getEscala());
		
		ksession.fireAllRules();		
		
		assertEquals(27, factResponse.getHorasAdicNocturno(), delta);
	}
	
	
	private FactResponse getResponse_datosComunes() {
		FactResponse factResponse = new FactResponse();
		factResponse.setMediaDiasTrabajoMes(20f);
						
		return factResponse;
	}
	
	private FactResponse getResponse1() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setExtensionAdicNocturno(false);
				
		return factResponse;
	}
	
	private FactResponse getResponse2() {
		FactResponse factResponse = getResponse_datosComunes();
		factResponse.setExtensionAdicNocturno(true);
				
		return factResponse;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo1() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,8,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,21,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo1b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,8,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,21,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria1() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
//		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
//		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		escalaXCat.setHoraFinAdicNocturnoQA("6:00");
		escalaXCat.setHoraInicioAdicNocturnoQA("22:00");
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,4,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,20,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
		
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo2b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,4,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,20,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria2() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo3() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,8,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,23,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo3b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,8,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,23,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria3() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo4() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,1,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,23,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo4b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,1,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,23,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria4() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo5() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,8,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo5b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,8,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria5() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo6() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,4,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo6b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,4,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria6() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo7() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,23,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,9,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo7b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,23,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,9,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria7() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo8() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,23,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo8b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,23,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria8() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,6,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,22,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo9() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,5,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,21,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo9b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,5,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,21,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria9() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo10() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,22,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo10b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,22,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}
	
	private FactEscalaXCategoria getEscalaXCategoria10() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo11() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,0,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}
	
	private FactEsquemaOperativo getEsquemaOperativo11b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,0,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria11() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo12() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo12b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,1,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria12() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo13() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,6,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,0,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo13b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,6,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,0,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria13() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo14() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,3,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo14b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,10,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,3,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria14() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo15() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,4,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,3,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo15b() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,4,0));
		esquema.setHoraInicioJornada(new Date(2000,1,1,3,0));
		esquema.setTipoJornada ("M");
		esquema.setNumeroPuestos(3);
							
		return esquema;
	}	
	
	private FactEscalaXCategoria getEscalaXCategoria15() {
		FactEscalaXCategoria escalaXCat = new FactEscalaXCategoria();
		escalaXCat.setHoraFinAdicNocturno(new Date(2000,1,1,7,0));
		escalaXCat.setHoraInicioAdicNocturno(new Date(2000,1,1,1,0));
		
		return escalaXCat;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo16() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
		esquema.setHoraFinJornada(new Date(2000,1,1,18,0));
		esquema.setHoraInicioJornada(new Date(2000,1,9,21,0));
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo17() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
//		esquema.setHoraFinJornada(new Date(2000,1,1,22,0));
//		esquema.setHoraInicioJornada(new Date(2000,1,1,10,0));
		esquema.setHoraFinJornadaQA("22:00");
		esquema.setHoraInicioJornadaQA("10:00");
		
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
		esquema.setHorasJornadaXpersona(12);
						
		return esquema;
	}	
	
	private FactEsquemaOperativo getEsquemaOperativo18() {
		FactEsquemaOperativo esquema = new FactEsquemaOperativo();
//		esquema.setHoraFinJornada(new Date(2000,1,1,16,0));
//		esquema.setHoraInicioJornada(new Date(2000,1,22,10,0));
		esquema.setHoraFinJornadaQA("17:00");
		esquema.setHoraInicioJornadaQA("21:00");
		
		esquema.setTipoJornada ("F");
		esquema.setNumeroPuestos(3);
		esquema.setHorasJornadaXpersona(10);
						
		return esquema;
	}	
	
	
	private FactEscala getEscala() {
		FactEscala escala = new FactEscala();
		escala.setId("CHNIF");
		
		return escala;
	}
*/		
}

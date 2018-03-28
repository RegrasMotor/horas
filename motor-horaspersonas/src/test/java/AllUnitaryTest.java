import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import unitary.CalcularServicioComoRif;
import unitary.CantidadDePersonas;
import unitary.CantidadRealDePersonas;
import unitary.ConversionDatosQA;
import unitary.DiasEscalaDescontandoFestivos;
import unitary.DiasFestivosProporcionalEscala;
import unitary.ExtensionAdicNocturno;
import unitary.HoraExtrasMayor2horas;
import unitary.HorasAdicionalNocturno;
import unitary.HorasAdicionalesIntrajornada;
import unitary.HorasEfectivasJornadaXpersona;
import unitary.HorasExtras50Xpersona;
import unitary.HorasExtrasEfetivas;
import unitary.HorasExtrasEspeciales;
import unitary.HorasExtrasFestivo;
import unitary.HorasExtrasLibreTrabajado;
import unitary.HorasExtrasXpersona;
import unitary.HorasFestivasMesProporcionalEscala;
import unitary.HorasFestivasMesProporcionalLibre;
import unitary.HorasFestivasProporcionalEscala;
import unitary.HorasFestivasProporcionalLibres;
import unitary.HorasNormales;
import unitary.HorasNormalesPorPersona;
import unitary.HorasTrabajadas;
import unitary.HorasVendidas;
import unitary.NumeroDiasEscalaDescFestivos;
import unitary.NumeroDiasFestivosPropEscala;
import unitary.NumeroFestivosAnuales;
import unitary.NumeroFestivosMensuales;
import unitary.NumeroHorasAlmuerzoXJornada;
import unitary.NumeroHorasEfectivasTrabajarCadaJornada;
import unitary.NumeroHorasEscalaXpersona;
import unitary.NumeroMesesDuracionServicio;
import unitary.NumeroPersonas;
import unitary.NumeroRealPersonas;
import unitary.NumeroTotalHorasEscala;
import unitary.NumeroTurnosDia;
import unitary.NumeroTurnosMes;
import unitary.PromedioDiasEfectivosTrabajadosAlMes;
import unitary.PromedioDiasTrabajadosMesXdiasTrabajadosSemana;
import unitary.PromedioDiasTrabajadosMesXescala;
import unitary.ReconfMaximoHorasExtrasXpersona;
import unitary.ReconfiguracionDiasTrabajoYLibresEscala;
import unitary.ReconfiguracionHorasPeriodoEscalaXCategoria;
import unitary.RedondearValoresFinales;
import unitary.TotalHorasEscala;

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
	CalcularServicioComoRif.class, 
	CantidadDePersonas.class, 
	CantidadRealDePersonas.class,
	ConversionDatosQA.class,
	DiasEscalaDescontandoFestivos.class,
	DiasFestivosProporcionalEscala.class,
	ExtensionAdicNocturno.class,
	HoraExtrasMayor2horas.class,
	HorasAdicionalesIntrajornada.class,
	HorasAdicionalNocturno.class,
	HorasEfectivasJornadaXpersona.class,
	HorasExtras50Xpersona.class,
	HorasExtrasEfetivas.class,
	HorasExtrasEspeciales.class,
	HorasExtrasFestivo.class,
	HorasExtrasLibreTrabajado.class,
	HorasExtrasXpersona.class,
	HorasFestivasMesProporcionalEscala.class, 
	HorasFestivasMesProporcionalLibre.class, 
	HorasFestivasProporcionalEscala.class,
	HorasFestivasProporcionalLibres.class,
	HorasNormales.class,
	HorasNormalesPorPersona.class,
	HorasTrabajadas.class,
	HorasVendidas.class,
	NumeroDiasEscalaDescFestivos.class,
	NumeroDiasFestivosPropEscala.class,
	NumeroFestivosAnuales.class,
	NumeroFestivosMensuales.class,
	NumeroHorasAlmuerzoXJornada.class,
	NumeroHorasEfectivasTrabajarCadaJornada.class,
	NumeroHorasEscalaXpersona.class,
	NumeroMesesDuracionServicio.class,
	NumeroPersonas.class,
	NumeroRealPersonas.class,
	NumeroTotalHorasEscala.class,
	NumeroTurnosDia.class,
	NumeroTurnosMes.class,  
	PromedioDiasEfectivosTrabajadosAlMes.class,
	PromedioDiasTrabajadosMesXdiasTrabajadosSemana.class,
	PromedioDiasTrabajadosMesXescala.class,
	ReconfiguracionDiasTrabajoYLibresEscala.class,
	ReconfiguracionHorasPeriodoEscalaXCategoria.class,
	ReconfMaximoHorasExtrasXpersona.class,
	RedondearValoresFinales.class,
	TotalHorasEscala.class}
)

// the actual class is empty
public class AllUnitaryTest {
}
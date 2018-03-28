package com.prosegur.rulesEngine.services.soapService.model.horaspersonas.factsformat;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactCategoriaSalarial;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscala;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEscalaXCategoria;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactOT;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactParams;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactResponse;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactSubcliente;
import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactTipoPuesto;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.CategoriaSalarial;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.Escala;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.EscalaXCategoria;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.EsquemaOperativo;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.Hora.TipoHora;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.OT;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.Params;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.RequestHoraspersonas;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.ResponseHoraspersonas;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.Subcliente;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.TipoPuesto;

public class FactsFormat {
	
	public static FactRequest parse(RequestHoraspersonas request) {
		
		FactRequest factRequest = new FactRequest();
		factRequest.setParams(FactsFormat.parse(request.getParams()));
		factRequest.setOt(FactsFormat.parse(request.getOt()));
		factRequest.setSubcliente(factRequest.getOt().getSubcliente());
		factRequest.setEsquemaOperativo(FactsFormat.parse(request.getEsquemaOperativo()));
		factRequest.setEscala(FactsFormat.parse(request.getEscala()));
		factRequest.setTipoPuesto(FactsFormat.parse(request.getTipoPuesto()));
		factRequest.setCategoriaSalarial(FactsFormat.parse(request.getCategoriaSalarial()));
		factRequest.setEscalaXcategoria(FactsFormat.parse(request.getEscalaXcategoria()));
				
		return factRequest;
	}

    public static FactParams parse(Params params) {
    	FactParams factParams = new FactParams();
    	
    	factParams.setNumeroDiasMes(params.getNumeroDiasMes());
    	factParams.setCoeficienteStdDiasXsemana(params.getCoeficienteStdDiasXsemana());
    	factParams.setAceptaPuestosSinCobertura(params.isAceptaPuestosSinCobertura());
    	factParams.setNumeroFestivosAno(params.getNumeroFestivosAno());
    	
    	return factParams;
    }
    
    public static FactOT parse(OT ot) {
    	FactOT factOT = new FactOT();
    	
    	factOT.setId(ot.getUid());
    	factOT.setEmpresa(ot.getEmpresa());
    	factOT.setDelegacion(ot.getDelegacion());
    	factOT.setTipoServicio((ot.getTipoServicio()==null)?null:ot.getTipoServicio().value());
    	factOT.setSubcliente(FactsFormat.parse(ot.getSubcliente()));
    	
    	return factOT;
    }
    
    public static FactSubcliente parse(Subcliente subcliente) {
    	FactSubcliente factSubcliente = new FactSubcliente();
    	
    	factSubcliente.setId(subcliente.getId());
    	factSubcliente.setNumeroFestivosSubcliente(subcliente.getNumeroFestivosSubcliente());
    	
    	return factSubcliente;
    }    
    
    public static FactEscala parse(Escala escala) {
    	FactEscala factEscala = new FactEscala();
    	
    	factEscala.setId(escala.getId());
    	factEscala.setDiasTrabajadosXsemana(escala.getDiasTrabajadosXsemana());
    	factEscala.setDiasLibresXsemana(escala.getDiasLibresXsemana());
    	factEscala.setMediaJornada(escala.isMediaJornada());
    	
    	return factEscala;
    }
    
    public static FactCategoriaSalarial parse(CategoriaSalarial categoriaSalarial) {
    	FactCategoriaSalarial factCategoriaSalarial = new FactCategoriaSalarial();
    	
    	factCategoriaSalarial.setId(categoriaSalarial.getId());
    	
    	return factCategoriaSalarial;
    }
    
    public static FactEscalaXCategoria parse(EscalaXCategoria escalaXCategoria) {
    	FactEscalaXCategoria factEscalaXCategoria = new FactEscalaXCategoria();
    	
    	factEscalaXCategoria.setIdEscala(escalaXCategoria.getEscala().getId());
    	factEscalaXCategoria.setIdTipoPuesto(escalaXCategoria.getTipoPuesto().getId());
    	factEscalaXCategoria.setIdCategoriaSalarial(escalaXCategoria.getCategoriaSalarial().getId());
    	factEscalaXCategoria.setTiempoMinimoAlmuerzo(escalaXCategoria.getTiempoMinimoAlmuerzo());
    	factEscalaXCategoria.setTipoCalculo((escalaXCategoria.getTipoCalculo()==null)?null:escalaXCategoria.getTipoCalculo().value());
    	factEscalaXCategoria.setHorasPeriodo(escalaXCategoria.getHorasPeriodo());
    	factEscalaXCategoria.setHoraInicioAdicNocturno(escalaXCategoria.getHoraInicioAdicNocturno());
    	factEscalaXCategoria.setHoraFinAdicNocturno(escalaXCategoria.getHoraFinAdicNocturno());
    	
    	return factEscalaXCategoria;
    }
    
    public static FactTipoPuesto parse(TipoPuesto tipoPuesto) {
    	FactTipoPuesto factTipoPuesto = new FactTipoPuesto();
    	
    	factTipoPuesto.setId(tipoPuesto.getId());

    	return factTipoPuesto;
    }

    public static FactEsquemaOperativo parse(EsquemaOperativo esquemaOperativo) {
    	FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
    	
    	factEsquemaOperativo.setId(esquemaOperativo.getId());
    	factEsquemaOperativo.setNumeroPuestos(esquemaOperativo.getNumeroPuestos());
    	factEsquemaOperativo.setIdEscala(esquemaOperativo.getEscala().getId());
    	factEsquemaOperativo.setIdTipoPuesto(esquemaOperativo.getTipoPuesto().getId());
    	factEsquemaOperativo.setMediaJornada(esquemaOperativo.isMediaJornada());
    	factEsquemaOperativo.setFrecuenciaMediaJornada((esquemaOperativo.getFrecuenciaMediaJornada()==null)?null:esquemaOperativo.getFrecuenciaMediaJornada().value());
    	factEsquemaOperativo.setHorasJornadaXpersona(esquemaOperativo.getHorasJornadaXpersona());
    	factEsquemaOperativo.setPuestoSinCobertura(esquemaOperativo.isPuestoSinCobertura());
    	factEsquemaOperativo.setIdCategoriaSalarial(esquemaOperativo.getCategoriaSalarial().getId());
    	factEsquemaOperativo.setFechaInicioServicio(esquemaOperativo.getFechaInicioServicio());
    	factEsquemaOperativo.setFechaFinServicio(esquemaOperativo.getFechaFinServicio());
    	factEsquemaOperativo.setHoraInicioJornada(esquemaOperativo.getHoraInicioJornada());
    	factEsquemaOperativo.setHoraFinJornada(esquemaOperativo.getHoraFinJornada());
    	factEsquemaOperativo.setCoberturaAlmuerzo((esquemaOperativo.getCoberturaAlmuerzo()==null)?null:esquemaOperativo.getCoberturaAlmuerzo().value());
    	factEsquemaOperativo.setHorasAlmuerzo(esquemaOperativo.getHorasAlmuerzo());
    	factEsquemaOperativo.setNumeroRealPersonasInf(esquemaOperativo.getNumeroRealPersonas());
    	factEsquemaOperativo.setTipoJornada((esquemaOperativo.getTipoJornada()==null)?null:esquemaOperativo.getTipoJornada().value());
    	factEsquemaOperativo.setTrabajaLunes(esquemaOperativo.isTrabajaLunes());
    	factEsquemaOperativo.setTrabajaMartes(esquemaOperativo.isTrabajaMartes());
    	factEsquemaOperativo.setTrabajaMiercoles(esquemaOperativo.isTrabajaMiercoles());
    	factEsquemaOperativo.setTrabajaJueves(esquemaOperativo.isTrabajaJueves());
    	factEsquemaOperativo.setTrabajaViernes(esquemaOperativo.isTrabajaViernes());
    	factEsquemaOperativo.setTrabajaSabado(esquemaOperativo.isTrabajaSabado());
    	factEsquemaOperativo.setTrabajaDomingo(esquemaOperativo.isTrabajaDomingo());
    	
    	return factEsquemaOperativo;
    }

    public static ResponseHoraspersonas format(FactResponse factResponse) {
    	ResponseHoraspersonas response = new ResponseHoraspersonas();
    	
    	response.setNumeroPersonas(factResponse.getNumeroPersonas());
    	response.setNumeroRealPersonas(factResponse.getNumeroRealPersonas());
    	response.setNumeroTurnosMes(factResponse.getNumeroTurnosMes());
    	response.setHorasVendidas(factResponse.getHorasVendidas());
    	response.setHorasTrabajadas(factResponse.getHorasTrabajadas());
    	
    	response.addHora(TipoHora.HORANORMAL, factResponse.getHorasNormales());
    	response.addHora(TipoHora.HORAEXTRAEFETIVA, factResponse.getHorasExtrasEfetivas());
    	response.addHora(TipoHora.HORAEXTRALIBRETRABAJADO, factResponse.getHorasExtrasLibreTrabajado());
    	response.addHora(TipoHora.HORAINTRAJORNADA, factResponse.getHorasAdicIntrajornada());
    	response.addHora(TipoHora.HORANOCTURNO, factResponse.getHorasAdicNocturno());
    	response.addHora(TipoHora.HORAEXTRAFESTIVO, factResponse.getHorasExtrasFestivo());
    	response.addHora(TipoHora.HORAEXTRAESPECIAL, factResponse.getHorasExtrasEspeciales());
    	
    	return response;
    }
}

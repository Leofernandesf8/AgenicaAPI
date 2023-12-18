package com.agenciaapi.service;

import java.util.List;

import com.agenciaapi.model.Destino;


public interface DestinoService {

	
	List<Destino> getAllDestinos();
	Destino getDestinoById(Long id);
	Destino saveDestino(Destino destino);
	Destino updateDestino(Long id, Destino destinoUpdate);
	void deleteById(Long id);
}

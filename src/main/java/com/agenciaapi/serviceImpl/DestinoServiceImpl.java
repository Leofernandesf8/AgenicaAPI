package com.agenciaapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciaapi.model.Destino;
import com.agenciaapi.repository.DestinoRepository;
import com.agenciaapi.service.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;

	
	
	@Override
	public List<Destino> getAllDestinos() {
		return destinoRepository.findAll();
	}

	@Override
	public Destino getDestinoById(Long id) {
		return destinoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id: " + id + "Not Found"));
	}

	@Override
	public Destino saveDestino(Destino destino) {
		return destinoRepository.save(destino);
	}

	@Override
	public Destino updateDestino(Long id, Destino destinoUpdate) {
		Destino destinoExists = destinoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id: " + id + "Not Found"));
		destinoExists.setDestino(destinoUpdate.getDestino());
		destinoExists.setDescricao(destinoUpdate.getDescricao());
		destinoExists.setLocalizacao(destinoUpdate.getLocalizacao());
		destinoExists.setPreco(destinoUpdate.getPreco());
		return destinoRepository.save(destinoExists);
	}

	@Override
	public void deleteById(Long id) {
		destinoRepository.deleteById(id);
		
	}
}

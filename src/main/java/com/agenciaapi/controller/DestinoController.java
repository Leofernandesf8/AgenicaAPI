package com.agenciaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenciaapi.model.Destino;
import com.agenciaapi.service.DestinoService;

@RestController
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;
	
	
	@PostMapping("/savedestino")
	public Destino criar(@RequestBody Destino destino) {
		return destinoService.saveDestino(destino);
	}
	
	
	@GetMapping("/alldestinos")
	public List<Destino> Listar() {
		return destinoService.getAllDestinos();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Destino> Buscar(@PathVariable Long id) {
		Destino destino = destinoService.getDestinoById(id);
		return ResponseEntity.ok(destino);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Destino> Atualizar(@PathVariable Long id, @RequestBody Destino destinoUpdate) {
		Destino destino = destinoService.getDestinoById(id);
		destino.setDestino(destinoUpdate.getDestino());
		destino.setPreco(destinoUpdate.getPreco());
		destino.setLocalizacao(destinoUpdate.getLocalizacao());
		destino.setDescricao(destinoUpdate.getDescricao());
		destinoService.saveDestino(destino);
		return ResponseEntity.ok(destino);
	}
	
	
	@DeleteMapping("{id}")
	public void Deletar(@PathVariable Long id) {
		destinoService.deleteById(id);
	}
}

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

import com.agenciaapi.model.Usuario;
import com.agenciaapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/saveusuario")
	public Usuario criar(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}
	
	
	@GetMapping("/allusuarios")
	public List<Usuario> Listar() {
		return usuarioService.getAllUsuarios();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> Buscar(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		return ResponseEntity.ok(usuario);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> Atualizar(@PathVariable Long id, @RequestBody Usuario usuarioUpdate) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		usuario.setNome(usuarioUpdate.getNome());
		usuario.setEmail(usuarioUpdate.getEmail());
		usuario.setSenha(usuarioUpdate.getSenha());
		usuarioService.saveUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
}

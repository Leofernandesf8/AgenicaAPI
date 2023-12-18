package com.agenciaapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciaapi.model.Usuario;
import com.agenciaapi.repository.UsuarioRepository;
import com.agenciaapi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Id: " + id + "Not Found"));
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuarioUpdate) {
		Usuario usuarioExists = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Id: " + id + "Not Found"));
		usuarioExists.setNome(usuarioUpdate.getNome());
		usuarioExists.setEmail(usuarioUpdate.getEmail());
		usuarioExists.setSenha(usuarioUpdate.getSenha());
		return usuarioRepository.save(usuarioExists);
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
		
	}
}

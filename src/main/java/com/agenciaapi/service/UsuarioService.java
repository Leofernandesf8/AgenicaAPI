package com.agenciaapi.service;

import java.util.List;

import com.agenciaapi.model.Usuario;

public interface UsuarioService {

	
	List<Usuario> getAllUsuarios();
	Usuario getUsuarioById(Long id);
	Usuario saveUsuario(Usuario usuario);
	Usuario updateUsuario(Long id, Usuario usuarioUpdate);
	void deleteById(Long id);
}

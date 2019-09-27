package com.maog.springboot.app.models.service;

import java.util.List;

import com.maog.springboot.app.models.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listar();
	public Usuario registar(Usuario usuario);
	
}

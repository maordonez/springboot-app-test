package com.maog.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maog.springboot.app.models.dao.UsuarioDAO;
import com.maog.springboot.app.models.entity.Usuario;
import com.maog.springboot.app.models.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public List<Usuario> listar() {
		return usuarioDao.findAll();
	}

	@Override
	public Usuario registar(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

}

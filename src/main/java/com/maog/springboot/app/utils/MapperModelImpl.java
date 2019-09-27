package com.maog.springboot.app.utils;

import org.springframework.stereotype.Component;

import com.maog.springboot.app.models.entity.Usuario;

@Component
public class MapperModelImpl implements MapperModel {

	public UsuarioApi getUsuarioResponse(Usuario usuario) {
		UsuarioApi response = new UsuarioApi();
		response.setCodigo(usuario.getCodigo());
		response.setNombre(usuario.getNombre());
		response.setApellido(usuario.getApellido());
		response.setDireccion(usuario.getDireccion());
		response.setTelefono(usuario.getTelefono());
		return response;
	}

	@Override
	public Usuario getUsuarioEntity(UsuarioApi usuario) {
		Usuario entity = new Usuario();
		entity.setCodigo(usuario.getCodigo());
		entity.setNombre(usuario.getNombre());
		entity.setApellido(usuario.getApellido());
		entity.setDireccion(usuario.getDireccion());
		entity.setTelefono(usuario.getTelefono());
		return entity;
	}

}

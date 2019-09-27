package com.maog.springboot.app.utils;

import com.maog.springboot.app.models.entity.Usuario;

public interface MapperModel {
	
	public UsuarioApi getUsuarioResponse(Usuario usuario);
	public Usuario getUsuarioEntity(UsuarioApi usuario);

}

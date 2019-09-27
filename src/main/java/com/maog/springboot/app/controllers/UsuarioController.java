package com.maog.springboot.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maog.springboot.app.models.entity.Usuario;
import com.maog.springboot.app.models.service.UsuarioService;
import com.maog.springboot.app.utils.MapperModel;
import com.maog.springboot.app.utils.MapperModelImpl;
import com.maog.springboot.app.utils.UsuarioApi;

@RestController
@RequestMapping("${app.endpoint.usuarios}")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private MapperModel model;
	
	@PostConstruct
	private void postConstrut() {
		model = new MapperModelImpl();
	}
	
	@GetMapping({"","/"})
	public List<UsuarioApi> getUsuarios(){
		return usuarioService.listar()
				.stream()
				.map( usuario -> model.getUsuarioResponse(usuario))
				.collect(Collectors.toList());
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping({"","/"})
	public UsuarioApi getUsuario(@RequestBody UsuarioApi request) {
		Usuario usuario = model.getUsuarioEntity(request);
		return model.getUsuarioResponse(usuarioService.registar(usuario));
	}

}

package com.maog.springboot.app.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maog.springboot.app.controllers.UsuarioController;
import com.maog.springboot.app.models.entity.Usuario;
import com.maog.springboot.app.models.service.UsuarioService;
import com.maog.springboot.app.utils.MapperModel;
import com.maog.springboot.app.utils.MapperModelImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

	private final String JSON_FILE_GET_USUARIOS = "classpath:controllers/usuarioController/getAllUsuarios.json";
	private final String JSON_FILE_POST_USUARIO = "classpath:controllers/usuarioController/postUsuario.json";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsuarioService usuarioService;

	private List<Usuario> usuarios;

	private MapperModel model;
	private ObjectMapper mapperJson;

	@Before
	public void setup() {
		mapperJson = new ObjectMapper();
		model = new MapperModelImpl();

		// emular servicio usuario
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario(1l, "1145634", "pepito", "perez", "calle falsa", "3142747308", new Date(), null));
		usuarios.add(new Usuario(2l, "1145635", "juanito", "rojas", "calle falsa", "3142747322", new Date(), null));
	}

	@Test
	public void getUsuarios() throws Exception {

		when(usuarioService.listar()).thenReturn(usuarios);

	    String jsonData = getJson(JSON_FILE_GET_USUARIOS);

		final ResultActions result = this.mockMvc
				.perform(get("/api/usuarios").accept(MediaType.APPLICATION_JSON_UTF8_VALUE));

		result.andExpect(status().isOk());
		result.andExpect(content().json(jsonData));

	}

	@Test
	public void postUsuario() throws Exception {
		
		when(usuarioService.registar(Mockito.anyObject()))
		.thenReturn(new Usuario(3l, "1151178", "marianito", "contreras", 
				"calle falsa", "314274347578", new Date(), null));
		
	    String jsonData = getJson(JSON_FILE_POST_USUARIO);
		
		final ResultActions result = this.mockMvc
				.perform(post("/api/usuarios")
			    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
			    .content(jsonData)
			    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE));
		
		result.andExpect(status().isCreated());
		result.andExpect(content().json(jsonData));

	}

	public String getJson(String path) {
		File file = null;
		try {
			file = ResourceUtils.getFile(path);
			// Read File Content
			String content = new String(Files.readAllBytes(file.toPath()));
			return content;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

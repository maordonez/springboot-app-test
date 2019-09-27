package com.maog.springboot.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.maog.springboot.app.controllers.UsuarioController;
import com.maog.springboot.app.models.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
	
	@MockBean
	private UsuarioService usuarioService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void shouldReturnUserProfile() throws Exception {
		
	}

}

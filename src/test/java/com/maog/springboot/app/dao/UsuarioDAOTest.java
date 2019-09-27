package com.maog.springboot.app.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.maog.springboot.app.models.dao.UsuarioDAO;
import com.maog.springboot.app.models.entity.Usuario;

@Sql(scripts = {"/import_usuarios.sql"})
@DataJpaTest
@RunWith(SpringRunner.class)
public class UsuarioDAOTest {
	
	@Autowired
    private  UsuarioDAO usuarioDao;
	
	
	@Test
    public void shouldSaveAndFetchUsuario() throws Exception {
        Usuario user = new Usuario();
        user.setCodigo("228541");
        user.setNombre("Pepito");
        user.setApellido("pepito");
        user.setDireccion("avenida falsa");
        user.setTelefono("54792146");
        
        usuarioDao.save(user);

        Optional<Usuario> findUser = usuarioDao.findByCodigo("228541");

        assertThat(findUser.get())
        .isEqualToComparingFieldByFieldRecursively(user);
    }
	
	@Test
	public void shouldFetchAllUsuarios() {
		List<Usuario> lista = usuarioDao.findAll();
		assertThat(lista.size()).isEqualTo(2);
	}
	
	
	

	

}

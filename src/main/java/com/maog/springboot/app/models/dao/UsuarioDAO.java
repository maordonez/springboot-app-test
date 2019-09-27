package com.maog.springboot.app.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maog.springboot.app.models.entity.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByCodigo(String codigo);
}

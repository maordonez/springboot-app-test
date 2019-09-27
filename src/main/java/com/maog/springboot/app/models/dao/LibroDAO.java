package com.maog.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maog.springboot.app.models.entity.Libro;

@Repository
public interface LibroDAO extends JpaRepository<Libro, Long> {
	
	
}

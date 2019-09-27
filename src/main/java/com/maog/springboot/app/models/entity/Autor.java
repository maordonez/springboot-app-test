package com.maog.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "autores")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auto_id")
	private Long id;
	
	@Column(name = "auto_nombre")
	private String nombre;
	
	@Column(name = "auto_apellido")
	private String apellido;
	
	@Column(name = "auto_nacionalidad")
	private String nacionalidad;
	
	@Column(name = "auto_fecharegistro")
	private Date fechaRegistro;
	
	@Column(name = "auto_fechamodificacion" , nullable = true)
	private Date fechaModificacion;

}

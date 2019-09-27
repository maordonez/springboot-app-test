package com.maog.springboot.app.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name= "libros" )
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libr_id")
	private Long id;
	
	@Column(name = "libr_codigo", unique = true)
	private String codigo;
	
	@Column(name = "libr_titulo")
	private String titulo;
	
	@Column(name = "libr_isbn")
	private String isbn;
	
	@Column(name = "libr_editorial")
	private String editorial;
	
	@Column(name = "libr_numeropaginas")
	private Integer numeroPaginas;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "libr_fecharegistro")
	private Date fechaRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "libr_fechamodificacion" , nullable = true)
	private Date fechaModificacion;
	
	@OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	@JoinColumn(name = "auto_id")
	private List<Autor> autores;
	
	
	
}

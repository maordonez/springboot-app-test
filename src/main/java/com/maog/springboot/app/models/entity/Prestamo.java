package com.maog.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "prestamos")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pres_id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pres_fecharegistro")
	private Date fechaRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pres_fechamodificacion" , nullable = true)
	private Date fechaModificacion;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "libr_id")
	private Libro libro;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "usua_id")
	private Usuario usuario;
	
	

}

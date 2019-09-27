package com.maog.springboot.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usua_id")
	private Long id;
	
	@Column(name = "usua_codigo", unique = true)
	private String codigo;
	
	@Column(name = "usua_nombre")
	private String nombre;
	
	@Column(name = "usua_apellido")
	private String apellido;
	
	@Column(name = "usua_direccion")
	private String direccion;
	
	@Column(name = "usua_telefono")
	private String telefono;
	
	@Column(name = "usua_fecharegistro")
	private Date fechaRegistro;
	
	@Column(name = "usua_fechamodificacion" , nullable = true)
	private Date fechaModificacion;
	
	@PrePersist()
	public void prePersist() {
		this.fechaRegistro = new Date();
	}
	
	@PreUpdate()
	public void preUpdate() {
		this.fechaModificacion = new Date();
	}

}

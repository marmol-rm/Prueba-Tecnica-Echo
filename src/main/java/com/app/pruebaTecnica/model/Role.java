package com.app.pruebaTecnica.model;

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

@Entity
@Table(name="role")
public class Role {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id_rol;
	@Column(length=25, nullable = false)
	private String nombre;
	@Column(length=255)
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permiso")
	private List<Permiso> permisos;
	
	public Role() {
		super();
	}

	public Role(String nombre, String descripcion) {
		super();
		//this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_direccion;
	@Column(length = 255)
	private String direccion;
	@Column(length = 25)
	private String telefono;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio", nullable = false)
	private Municipio municipio;
	@OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	public Direccion() {
		super();
	}


	public Direccion(String direccion, String telefono, Municipio municipio) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		this.municipio = municipio;
	}
	

	public Integer getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Integer id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}

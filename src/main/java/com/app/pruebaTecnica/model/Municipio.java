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
@Table(name = "municipio")
public class Municipio {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_municipio;
	@Column(length = 50)
	private String nom_municipio;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento", nullable = false)
	private Departamento departamento;
	@OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Direccion> direcciones;
	
	public Municipio() {
		super();
	}
	

	public Municipio(String nom_municipio, Departamento departamento, List<Direccion> direcciones) {
		super();
		this.nom_municipio = nom_municipio;
		this.departamento = departamento;
		this.direcciones = direcciones;
	}


	public Integer getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getNom_municipio() {
		return nom_municipio;
	}

	public void setNom_municipio(String nom_municipio) {
		this.nom_municipio = nom_municipio;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<Direccion> getDirecciones() {
		return direcciones;
	}


	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
}

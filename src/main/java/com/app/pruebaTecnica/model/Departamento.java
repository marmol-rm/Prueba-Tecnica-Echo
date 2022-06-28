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
@Table(name = "departamento")
public class Departamento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_departamento;
	@Column(length = 50)
	private String nom_departamento;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false)
	private Pais pais;
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Municipio> municipios;
	
	public Departamento() {
		super();
	}
	
	
	public Departamento(String nom_departamento, Pais pais) {
		super();
		this.nom_departamento = nom_departamento;
		this.pais = pais;
	}


	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Integer getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Integer id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNom_departamento() {
		return nom_departamento;
	}

	public void setNom_departamento(String nom_departamento) {
		this.nom_departamento = nom_departamento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}

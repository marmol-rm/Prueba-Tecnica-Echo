package com.app.pruebaTecnica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pais;
	@Column(length = 50)
	private String nom_pais;
	@Column(length = 3)
	private String cod_pais;
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Departamento> departamentos;
	
	public Pais() {
		super();
	}

	public Pais(String nom_pais, String cod_pais) {
		super();
		this.nom_pais = nom_pais;
		this.cod_pais = cod_pais;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public String getNom_pais() {
		return nom_pais;
	}

	public void setNom_pais(String nom_pais) {
		this.nom_pais = nom_pais;
	}

	public String getCod_pais() {
		return cod_pais;
	}

	public void setCod_pais(String cod_pais) {
		this.cod_pais = cod_pais;
	}
	
}

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
@Table(name = "permisos")
public class Permiso {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Integer id_permiso;
	@Column(length = 50, nullable = false)
	private String 	permiso;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "permiso", fetch = FetchType.LAZY)
	private List<PermisoPorRol> roles;
	
	
	public Permiso() {
		super();
	}

	
	public Permiso(String permiso, List<PermisoPorRol> roles) {
		super();
		this.permiso = permiso;
		this.roles = roles;
	}


	public Integer getId_permiso() {
		return id_permiso;
	}

	public void setId_permiso(Integer id_permiso) {
		this.id_permiso = id_permiso;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

}

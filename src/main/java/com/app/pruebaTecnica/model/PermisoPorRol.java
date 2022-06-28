package com.app.pruebaTecnica.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permisosporrol")
public class PermisoPorRol {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_permisoporrol;
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Role rol;
	@JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Permiso permiso;
	

	public PermisoPorRol() {
		super();
	}


	public PermisoPorRol(Role rol, Permiso permiso) {
		super();
		this.rol = rol;
		this.permiso = permiso;
	}


	public Role getRol() {
		return rol;
	}


	public void setRol(Role rol) {
		this.rol = rol;
	}


	public Permiso getPermiso() {
		return permiso;
	}


	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}


	public Integer getId_permisoporrol() {
		return id_permisoporrol;
	}


	public void setId_permisoporrol(Integer id_permisoporrol) {
		this.id_permisoporrol = id_permisoporrol;
	}
	
}

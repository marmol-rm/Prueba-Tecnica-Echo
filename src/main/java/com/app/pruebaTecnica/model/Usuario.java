package com.app.pruebaTecnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Integer id_user;
	@Column(nullable=true, length=50)
	private String nombres;
	@Column(nullable=true, length=50)
	private String apellidos;
	@Column(nullable=false, length=50)
	private String email;
	@Column(length=60)
	private String password;
	private boolean activo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Role role;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_direccion")
	private Direccion direccion;
	
	public Usuario() {
		super();
	}
	

	public Usuario(String nombres, String apellidos, String email, String password, boolean activo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.activo = activo;
	}


	public String getNombre_completo() {
		String completo = this.getNombres() + " " + this.getApellidos();
		return completo;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}

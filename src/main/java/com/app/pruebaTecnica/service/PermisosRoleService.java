package com.app.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.PermisoPorRol;
import com.app.pruebaTecnica.repo.PermisosRoleRepository;

@Service
public class PermisosRoleService {
	
	@Autowired
	private PermisosRoleRepository data;
	
	public List<PermisoPorRol> listar() {
		return data.findAll();
	}
	
	public PermisoPorRol listarId(Integer id) {
		return data.findById(id).orElse(null);
	}
	
	public PermisoPorRol guardar(PermisoPorRol p) {
		return data.save(p);
	}
}

package com.app.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.Role;
import com.app.pruebaTecnica.repo.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository data;

	
	public List<Role> listar() {

		return data.findAll();
	}

	
	public Role listarId(int id) {
		
		return data.findById(id).orElse(null);
	}
	
	public Role guardar(Role r) {
		
		return data.save(r);
	}
	
	public void eliminar(int id) {
		
		data.deleteById(id);
	}
}

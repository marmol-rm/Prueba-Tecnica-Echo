package com.app.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.Permiso;
import com.app.pruebaTecnica.repo.PermisoRepository;

@Service
public class PermisoService {
	
	@Autowired
	private PermisoRepository data;
	
	public List<Permiso> listar() {
		return data.findAll();
	}
	
	public Permiso listarId(Integer id) {
		return data.findById(id).orElse(null);
	}
	
	public Permiso guardar(Permiso p) {
		return data.save(p);
	}
	
	public Permiso actualizar(Permiso p) {
		if(data.existsById(p.getId_permiso()))
			return data.save(p);
		else return null;
	}
	
	public void eliminar(Integer id) {
		data.deleteById(id);
	}
}

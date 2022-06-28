package com.app.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.Direccion;
import com.app.pruebaTecnica.repo.DireccionRepository;

@Service
public class DireccionService {
	
	@Autowired
	private DireccionRepository data;
	
	public List<Direccion> listar() {
		return data.findAll();
	}
	
	public Direccion listarId(Integer id) {
		return data.findById(id).orElse(null);
	}
	
	public Direccion guardar(Direccion d) {
		return data.save(d);
	}
	
	public Direccion actualizar(Direccion d) {
		if(data.existsById(d.getId_direccion()))
			return data.save(d);
		else return null;
	}
	
	public void eliminar(Integer id) {
		data.deleteById(id);
	}
}

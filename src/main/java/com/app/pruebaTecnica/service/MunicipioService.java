package com.app.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.Municipio;
import com.app.pruebaTecnica.repo.MunicipioRepository;

@Service
public class MunicipioService {
	
	@Autowired
	private MunicipioRepository data;
	
	public List<Municipio> listar() {
		return data.findAll();
	}
	
	public Municipio listarId(Integer id) {
		return data.findById(id).orElse(null);
	}
}

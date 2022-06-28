package com.app.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.pruebaTecnica.service.UsuarioServ;

@Controller
public class MainConrtoller {
	
	@Autowired
	private UsuarioServ service;
	
	@GetMapping("/")
	public void valoresIniciales() {
		service.inicializar();
	}
}

package com.app.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pruebaTecnica.model.Permiso;
import com.app.pruebaTecnica.service.PermisoService;

@Controller
@RequestMapping("/permisos")
public class PermisoRoleController {
	
	@Autowired
	private PermisoService permisos;
	
	@GetMapping("/all")
	public String form_consultar(@RequestParam(value="buscar", required=false) 
	String palabra, Model model) {
		
		model.addAttribute("per");
		
		return "listaUsuarios";
	}
	
	@GetMapping("/registro")
	public String form_registro(Model model) {
		model.addAttribute("per", new Permiso());
		
		return "registroPermisos";
	}
	
	@PostMapping("/save")
	public String registro(@Validated Permiso per) {		
		permisos.guardar(per);
		
		return "redirect:/usuarios/all";
	}
}

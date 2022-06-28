package com.app.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pruebaTecnica.model.Role;
import com.app.pruebaTecnica.service.PermisoService;
import com.app.pruebaTecnica.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService role_service;
	@Autowired
	private PermisoService permiso_service;
	
	
	@GetMapping("/all")
	public String form_consultar(@RequestParam(value="buscar",
	required=false) String palabra, Model model) {
		
		model.addAttribute("rol");
		
		return "listaRoles";
	}
	
	@GetMapping("/registro")
	public String form_registro(Model model) {
		model.addAttribute("rol", new Role());
		model.addAttribute("permisos", permiso_service.listar());
		
		return "registroRoles";
	}
	
	@PostMapping("/save")
	public String registro(@Validated Role rol) {		
		role_service.guardar(rol);
		
		return "redirect:/usuarios/all";
	}
}

package com.app.pruebaTecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pruebaTecnica.model.Direccion;
import com.app.pruebaTecnica.model.Usuario;
import com.app.pruebaTecnica.service.DireccionService;
import com.app.pruebaTecnica.service.MunicipioService;
import com.app.pruebaTecnica.service.RoleService;
import com.app.pruebaTecnica.service.UsuarioServ;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServ usuarios;
	@Autowired
	private RoleService roles;
	@Autowired
	private MunicipioService municipios;
	@Autowired
	private DireccionService direcciones;
	
	
	@GetMapping("/all")
	public String form_consultar(Model model) {

		model.addAttribute("usuarios", usuarios.listar());
		
		return "listaUsuarios";
	}
	
	@GetMapping("/registro")
	public String form_registro(Model model) {
		model.addAttribute("user", new Usuario());
		model.addAttribute("dir", new Direccion());
		model.addAttribute("roles", roles.listar());
		model.addAttribute("municipios", municipios.listar());
		
		return "registroUsuario";
	}
	
	@GetMapping("/editar/{id}")
	public String form_editar(@PathVariable Integer id, Model model) {
		Usuario user = usuarios.listarId(id);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles.listar());
		model.addAttribute("municipios", municipios.listar());
		
		return "editarUsuario";
	}
	
	
	@PostMapping("/save")
	public String registro(@Validated Usuario user) {
		direcciones.guardar(user.getDireccion());
		usuarios.guardar(user);
		
		return "redirect:/usuarios/all";
	}
	
	@PostMapping("/edit")
	public String editar(@Validated Usuario user) {		
		usuarios.actualizar(user);
		
		return "redirect:/usuarios/all";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		usuarios.eliminar(id);
		
		return "redirect:/usuarios/all";
	}
}

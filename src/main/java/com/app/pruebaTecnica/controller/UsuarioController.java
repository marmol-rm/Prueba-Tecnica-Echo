package com.app.pruebaTecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pruebaTecnica.model.Municipio;
import com.app.pruebaTecnica.model.Role;
import com.app.pruebaTecnica.model.Usuario;
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
	
	private List<Municipio> listaMuni = municipios.listar();
	private List<Role> listaRoles = roles.listar();
	
	@GetMapping("/all")
	public String form_consultar(@RequestParam(value="buscar",
	required=false) String palabra, Model model) {
		
		model.addAttribute("usuarios");
		
		return "listaUsuarios";
	}
	
	@GetMapping("/registro")
	public String form_registro(Model model) {
		model.addAttribute("user", new Usuario());
		model.addAttribute("roles", listaRoles);
		model.addAttribute("municipios", listaMuni);
		
		return "agregarUsuario";
	}
	
	@GetMapping("/editar/{id}")
	public String form_editar(@PathVariable Integer id, Model model) {
		Usuario user = usuarios.listarId(id);
		model.addAttribute("user", user);
		model.addAttribute("roles", listaRoles);
		model.addAttribute("municipios", listaMuni);
		
		return "editarUsuario";
	}
	
	
	@PostMapping("/save")
	public String registro(@Validated Usuario user) {		
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

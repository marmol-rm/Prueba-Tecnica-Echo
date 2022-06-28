package com.app.pruebaTecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.Direccion;
import com.app.pruebaTecnica.model.Usuario;
import com.app.pruebaTecnica.repo.UsuarioRepository;


@Service
public class UsuarioServ {
	
	@Autowired
	private UsuarioRepository data;
	@Autowired
	private DireccionService direcciones;
	@Autowired
	private MunicipioService municipios;
	
	public List<Usuario> listar() {
		return data.findAll();
	}


	public Usuario listarId(Integer id) {

		return data.findById(id).orElse(null);
	}
	
	
	public String encriptar(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPass = encoder.encode(password);
		
		return encodedPass;
	}

	
	public Usuario listarEmail(String email) {
		
		return data.findByEmail(email);
	}

	
	public Usuario guardar(Usuario user) {
		String encodedPass = encriptar(user.getPassword());
		user.setPassword(encodedPass); //Se guarda el password encriptado
		
		return data.save(user);
	}
	
	public Usuario actualizar(Usuario user) {
		if(data.existsById(user.getId_user())) {
			int r = user.getRole().getId_rol();
			if(r != 0)
				return data.save(user);
			else return null;
		}
		else return null;
	}

	
	public void eliminar(Integer id) {
		data.deleteById(id);
	}

}

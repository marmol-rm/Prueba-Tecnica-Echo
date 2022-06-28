package com.app.pruebaTecnica.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.pruebaTecnica.model.Departamento;
import com.app.pruebaTecnica.model.Municipio;
import com.app.pruebaTecnica.model.Pais;
import com.app.pruebaTecnica.model.Usuario;
import com.app.pruebaTecnica.repo.DepartamentoRepository;
import com.app.pruebaTecnica.repo.MunicipioRepository;
import com.app.pruebaTecnica.repo.PaisRepository;
import com.app.pruebaTecnica.repo.UsuarioRepository;

import net.bytebuddy.utility.RandomString;


@Service
public class UsuarioServ {
	
	@Autowired
	private UsuarioRepository data;
	@Autowired
	private PaisRepository pais_data;
	@Autowired
	private DepartamentoRepository dep_data;
	@Autowired
	private MunicipioRepository mun_data;
	@Autowired
    private JavaMailSender mailsender;
	
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
		String otp = RandomString.make(8);
		user.setPassword(encriptar(otp));
		
		Usuario u = data.save(user);
		try {
			permitirAcceso(u.getId_user(), otp);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
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

	//Envia correo de acceso
    public void permitirAcceso(Integer id, String otp) throws UnsupportedEncodingException, MessagingException {
    	MimeMessage mensaje = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mensaje);
		Usuario user = listarId(id);
    	helper.setFrom("mr14015@clases.edu.sv","Marcelo Molina");
    	helper.setTo(user.getEmail());
    	helper.setSubject("Token de acceso");
    	helper.setText("<p>Usted ha creado su cuenta exitosamente.<br>" +
    	"Su nueva clave de acceso es: <b>"+ otp +"</b></p>", true);
    	
    	mailsender.send(mensaje);
    }
    
    public void inicializar() {
		long n;
		
		n = data.count();
		if(n == 0) { //Crea el usuario admin
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String pass = encoder.encode("sysadmin");
			Usuario admin = new Usuario("Admin","Admin","admin",pass,true);
			data.save(admin);
		}

		
    	n = pais_data.count();
		if(n == 0) { //Crea tipos de solicitud
			Pais slv = new Pais("El Salvador","SLV");
			
			pais_data.save(slv);
		}
		
		n = dep_data.count();
		if(n == 0) { //Crea tipos de solicitud
			Departamento d1 = new Departamento("San Salvador", pais_data.findById(1).orElse(null));
			Departamento d2 = new Departamento("Santa Ana", pais_data.findById(1).orElse(null));
			Departamento d3 = new Departamento("La Libertad", pais_data.findById(1).orElse(null));
			
			dep_data.save(d1);
			dep_data.save(d2);
			dep_data.save(d3);
		}
		
		n = mun_data.count();
		if(n == 0) { //Crea tipos de solicitud
			Municipio m1 = new Municipio("San Salvador", dep_data.findById(1).orElse(null));
			Municipio m2 = new Municipio("Santa Tecla", dep_data.findById(1).orElse(null));
		}
	}
}

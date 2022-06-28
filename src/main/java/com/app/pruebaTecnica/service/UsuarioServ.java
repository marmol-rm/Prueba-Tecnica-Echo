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

import com.app.pruebaTecnica.model.Usuario;
import com.app.pruebaTecnica.repo.UsuarioRepository;

import net.bytebuddy.utility.RandomString;


@Service
public class UsuarioServ {
	
	@Autowired
	private UsuarioRepository data;
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
}

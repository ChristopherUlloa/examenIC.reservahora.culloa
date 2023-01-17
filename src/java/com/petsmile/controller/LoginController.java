package com.petsmile.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.petsmile.model.Usuario;
import com.petsmile.service.SesionService;
import com.petsmile.util.SesionUtil;

import java.util.Objects;
import java.util.logging.Logger;


@RequestScoped
@Named(value  = "loginController")
public class LoginController {

	@Inject
	private SesionService sesionService;
	
	private String password;
	private String usuario;
	private String mensaje;

	private final static Logger LOG = Logger.getLogger(LoginController.class.getName());
	
	public String login() {	
		try {
		Usuario usuario = sesionService.validarUsuario(this.usuario, this.password);
		if(Objects.isNull(usuario)) {
			this.mensaje = "Usuario o contraseña invalidos";
		}else {
			HttpSession session = SesionUtil.getSession();
			session.setAttribute("username", usuario);
			return "admin";
		}
		} catch (Exception e) {
		     System.out.println("Problem creating session factory");
		     e.printStackTrace();
		}
		return "index";
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
}

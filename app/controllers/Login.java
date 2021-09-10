package controllers;

import models.Paciente;
import play.libs.Crypto;
import play.mvc.Controller;
import play.mvc.With;

//@With(Seguranca.class)
public class Login extends Controller {
	
	public static void formdelogin() {
		render();
	}
	
	public static void logar(String email, String senha) {
		
		Paciente paciente = Paciente.find("email = ? and senha = ? ", email, Crypto.passwordHash(senha)).first();
		
		if (paciente == null) {
			flash.error("Email e/ou Senha Incorreta!");
			formdelogin();
			
		}else {
			session.put("paciente.nome", paciente.nome);
			session.put("paciente.email", paciente.email);
			session.put("paciente.tipoUsuario", paciente.tipoUsuario);
			//Administrador.adm();		
			
			if (paciente.tipoUsuario == 1){
				Administrador.adm();
			}else {
				UsuarioPadrao.padrao();
			}
		}
	}
	
	public static void logout() {
		session.clear();
		formdelogin();
	}
	
}

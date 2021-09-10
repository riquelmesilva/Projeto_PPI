package controllers;

import play.mvc.After;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
	
	
	@Before(unless={"Pacientes.salvar"})
	static void autenticador() {
		if (session.contains("paciente.email") == false) {
			Login.formdelogin();
		}
	}
	
	@Before(unless={"Pacientes.salvar", "UsuarioPadrao.padrao", "UsuarioPadrao.edicao", "Administrador.salvar", "UsuarioPadrao.salvar"})
	static void permissoes() {
		if (session.get("paciente.tipoUsuario").equals("1") == false) {
			renderText("Acesso Negado!");
	
		}
		
	}
	
	/*@After(unless={"Login.logar"})
    static void permissao() {
        if(session.get("paciente.tipoUsuario").equals("1") == true) {
        	//Application.index();
        	Administrador.adm();
        }
    }*/
	
}

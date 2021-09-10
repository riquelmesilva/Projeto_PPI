package controllers;

import java.util.List;

import models.Agenda;
import models.Paciente;
import models.Vacina;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class UsuarioPadrao extends Controller{

	public static void padrao() {
		List<Paciente> pacientes = Paciente.findAll();
		List<Agenda> agendas = Agenda.findAll();
		render(pacientes, agendas);	
	}
	
	public static void paCadastrados() {
		List<Paciente> pacientes = Paciente.findAll();
		render(pacientes);
	}
	
	/*public static void usuarioeditar(Long id) {
		Paciente paciente = Paciente.findById(id);
		List<Agenda> agendas = Agenda.findAll();
		render(paciente, agendas);
		
	}*/
	
	public static void edicao(Long id) {
		Paciente paciente = Paciente.findById(id);
		//render(paciente);
		List<Agenda> agendas = Agenda.findAll();
		render(paciente, agendas);
		//renderTemplate("Pacientes/formulario.html", paciente, agendas);
	}
	
	/*public static void salvar(@Valid Paciente paciente) {
		//Paciente p = Paciente.findById(pacienteid);
		//paciente.agendas.add(p);
		
		if(validation.hasErrors()) {
			Cache.add("paciente", paciente);
			validation.keep();
			//UsuarioPadrao.padrao();
		}
		
		paciente.save();
		flash.success("Dados Atualizados Com Sucesso!");
		//Administrador.cadastrar();
		UsuarioPadrao.padrao();
		//Pacientes.listar();
		
	}*/
	
	public static void salvar(@Valid Paciente paciente) {
		//Paciente p = Paciente.findById(pacienteid);
		//paciente.agendas.add(p);
		
		if(validation.hasErrors()) {
			Cache.add("paciente", paciente);
			validation.keep();
			UsuarioPadrao.padrao();
			
		}
		
		paciente.save();
		flash.success("Dados Atualizados Com Sucesso!");
		UsuarioPadrao.padrao();
	}
	
}

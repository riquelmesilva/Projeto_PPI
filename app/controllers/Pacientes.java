package controllers;

import java.util.Date;
import java.util.List;

import models.Agenda;
import models.Paciente;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;


@With(Seguranca.class)
public class Pacientes extends Controller {
	
	/* - Renderização do Formulário de Cadastro*/
	
	public static void formulario() {
		//render();
    	
    	Paciente paciente = (Paciente) Cache.get("paciente");
    	Cache.clear();
    	
    	List<Agenda> agendas = Agenda.findAll();
		render(agendas, paciente);
	}
	
	public static void listagem() {
		render();
	}
	
	/* - CRUD da entidade Paciente */
	
	public static void salvar(@Valid Paciente paciente) {
		//Paciente p = Paciente.findById(pacienteid);
		//paciente.agendas.add(p);
		
		if(validation.hasErrors()) {
			Cache.add("paciente", paciente);
			validation.keep();
			Application.index();
			
		}
		
		paciente.save();
		flash.success("Cadastrado com Sucesso!");
		Login.formdelogin();
	}
	
	public static void listar() {
		List<Paciente> pacientes = Paciente.findAll();
		render(pacientes);
	}
	
	public static void remover(Long id) {
		Paciente paciente = Paciente.findById(id);
		paciente.delete();
		listar();
	}
	
	public static void editar(Long id) {
		Paciente paciente = Paciente.findById(id);
		//render(paciente);
		List<Agenda> agendas = Agenda.findAll();
		render(paciente, agendas);
		//renderTemplate("Pacientes/formulario.html", paciente, agendas);
	}
	
	public static void renderFotoPaciente(Long idPaciente) {
		Paciente paciente = Paciente.findById(idPaciente);
		response.setContentTypeIfNotSet(paciente.foto.type());
		renderBinary(paciente.foto.get());
	}
	
}

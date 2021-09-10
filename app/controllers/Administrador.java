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
public class Administrador extends Controller{
	
	public static void adm() {
		long totalPacientes = Paciente.count();
    	long totalVacinas = Vacina.count();    	    	    	
        render(totalPacientes, totalVacinas);
		//render();
	}
	
	public static void cadastrados() {
		List<Paciente> pacientes = Paciente.findAll();
		render(pacientes);
	}
	
	public static void cadastrar() {
		//render();
    	
    	Paciente paciente = (Paciente) Cache.get("paciente");
    	Cache.clear();
    	
    	List<Agenda> agendas = Agenda.findAll();
		render(agendas, paciente);
	}
	
	public static void salvar(@Valid Paciente paciente) {
		//Paciente p = Paciente.findById(pacienteid);
		//paciente.agendas.add(p);
		
		if(validation.hasErrors()) {
			Cache.add("paciente", paciente);
			validation.keep();
			//Pacientes.formulario();
			Administrador.cadastrar();
		}
		
		paciente.save();
		flash.success("Cadastrado com Sucesso!");
		Administrador.cadastrar();
		//Pacientes.listar();
		
	}
	
	public static void remover(Long id) {
		Paciente paciente = Paciente.findById(id);
		paciente.delete();
		flash.success("Removido com Sucesso!");
		cadastrados();
	}
	
	public static void edicao(Long id) {
		Paciente paciente = Paciente.findById(id);
		//render(paciente);
		List<Agenda> agendas = Agenda.findAll();
		render(paciente, agendas);
		//renderTemplate("Pacientes/formulario.html", paciente, agendas);
	}
}

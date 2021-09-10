package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Agenda extends Model {
	
	public String diaSemana;
	
	/*@OneToMany(mappedBy="agenda")
	public List<Paciente> pacientes;
	
	public Agenda(String diaSemana) {
		this.diaSemana = diaSemana;
	}*/
	
	@OneToMany
	@JoinColumn(name="agenda_id")
	public List<Paciente> pacientes;
	
}

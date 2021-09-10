package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Vacina extends Model {
	
	public String fabricante;
	public String dose;
	public String validade_meses;
	public String qtd;
	
	@OneToMany
	@JoinColumn(name="vacina_id")
	public List<Paciente> pacientes;
		
}

package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Email;
import play.data.validation.InPast;
import play.data.validation.Match;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Phone;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Paciente extends Model {
	
	@Required
	@MinSize(value=3, message="O nome deve ter no mínimo 3 caracteres")
	public String nome;
	
	@Required
	@Match(value="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}", message="CPF inválido")
	public String cpf;
	
	@Required
	@InPast(message="A data deve estar no passado")
	public Date dataNasc;
	
	public String nomeMae;
	
	@Required
	@Email(message="Email inválido")
	public String email;
	
	@Required
	//@Match(value="[0-9]{2}[0-9]{4}-[0-9]{4}", message="Telefone inválido")
	public String telefone;
	
	//public String agda;
	//public Agenda agenda;
	
	@Required
	public String endereco;
	
	@Required
	//@MinSize(value=8, message="A senha deve ter no mínimo 8 caracteres")
	public String senha;
	
	public int tipoUsuario = 0;
	
	public Blob foto;
	
// Qualquer pessoa que se cadastrar vai estar como Usuario Padrâo = 0
// Administradores = 1
//------------------------------------------------------------------------------
	
	// Metodo para Criptografar as senhas
	public void setSenha(String s) {
		senha = Crypto.passwordHash(s);
	}
	
	/*@OneToOne
	@JoinColumn(name="vacina_id")
	public Vacina vacina;*/
	
	@ManyToOne
	@JoinColumn(name="agenda_id")
	public Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name="vacina_id")
	public Vacina vacina;
	
		
}

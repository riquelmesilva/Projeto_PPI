package jobs;

import java.util.Date;

import models.Agenda;
import models.Paciente;
import models.Vacina;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;

@OnApplicationStart
public class Inicializador extends Job {
	
		@Override
		public void doJob() throws Exception {
			if(Paciente.count() == 0) {
				Paciente adm = new Paciente();
				adm.nome = "Administrador";
				adm.email = "adm@gmail.com";
				adm.senha = "123";
				adm.tipoUsuario = 1;
				adm.save();
				
				Paciente usuario = new Paciente();
				usuario.nome = "João";
				usuario.cpf = "111.111.111-11";
				Date date = new Date("01/01/2001");
				usuario.dataNasc = date;
				usuario.nomeMae = "Joana";
				usuario.email = "joao@gmail.com";
				usuario.telefone = "(11) 1111-1111";
				usuario.endereco = "Rua das Limeiras";
				//usuario.agenda.diaSemana = "Segunda-Feira";
				usuario.senha = "12345678";
				usuario.tipoUsuario = 0;
				usuario.save();
				
				Paciente usuario2 = new Paciente();
				usuario2.nome = "Maria";
				usuario2.cpf = "222.222.222-22";
				Date date2 = new Date("02/02/2002");
				usuario2.dataNasc = date2;
				usuario2.nomeMae = "Renata";
				usuario2.email = "maria@gmail.com";
				usuario2.telefone = "(22) 2222-2222";
				usuario2.endereco = "Rua do Centro";
				//usuario2.agenda.diaSemana = "Terca-Feira";
				usuario2.senha = "abcdefgh";
				usuario2.tipoUsuario = 0;
				usuario2.save();
				
				Paciente usuario3 = new Paciente();
				usuario3.nome = "Enzo";
				usuario3.cpf = "333.333.333-33";
				Date date3 = new Date("03/03/2003");
				usuario3.dataNasc = date3;
				usuario3.nomeMae = "Valentina";
				usuario3.email = "enzo@gmail.com";
				usuario3.telefone = "(33) 3333-3333";
				usuario3.endereco = "Rua Pereira";
				//usuario3.agenda.diaSemana = "Terca-Feira";
				usuario3.senha = "1a2b3c4d";
				usuario3.tipoUsuario = 0;
				usuario3.save();
				
			}
			
			if(Agenda.count() == 0) {
				Agenda agenda = new Agenda();
				agenda.diaSemana = "Segunda-Feira";
				agenda.save();
				
				Agenda agenda2 = new Agenda();
				agenda2.diaSemana = "Terca-Feira";
				agenda2.save();
				
				Agenda agenda3 = new Agenda();
				agenda3.diaSemana = "Quarta-Feira";
				agenda3.save();
				
				Agenda agenda4 = new Agenda();
				agenda4.diaSemana = "Quinta-Feira";
				agenda4.save();
				
				Agenda agenda5 = new Agenda();
				agenda5.diaSemana = "Sexta-Feira";
				agenda5.save();
				
				Agenda agenda6 = new Agenda();
				agenda6.diaSemana = "Sábado";
				agenda6.save();
				
			}
			
			if(Vacina.count() == 0) {
				Vacina vacina = new Vacina();
				vacina.fabricante = "CoronaVac";
				vacina.dose = "D1";
				vacina.validade_meses = "8";
				vacina.qtd = "1022";
				vacina.save();
				
				Vacina vacina2 = new Vacina();
				vacina2.fabricante = "AstraZeneca";
				vacina2.dose = "D2";
				vacina2.validade_meses = "5";
				vacina2.qtd = "230";
				vacina2.save();
				
				Vacina vacina3 = new Vacina();
				vacina3.fabricante = "Oxford";
				vacina3.dose = "D1";
				vacina3.validade_meses = "6";
				vacina3.qtd = "100";
				vacina3.save();
				
				Vacina vacina4 = new Vacina();
				vacina4.fabricante = "Pfizer";
				vacina4.dose = "D1";
				vacina4.validade_meses = "12";
				vacina4.qtd = "876";
				vacina4.save();
				
				Vacina vacina5 = new Vacina();
				vacina5.fabricante = "Janssen";
				vacina5.dose = "DU";
				vacina5.validade_meses = "4";
				vacina5.qtd = "490";
				vacina5.save();
				
			}
			
			
	   }
		
}

package controllers;

import play.*;
import play.cache.Cache;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        //render();
    	
    	Paciente paciente = (Paciente) Cache.get("paciente");
    	Cache.clear();
    	
    	List<Agenda> agendas = Agenda.findAll();
		render(agendas, paciente);	
    }

}
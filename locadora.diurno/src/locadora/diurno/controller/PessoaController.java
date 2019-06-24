package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.IPessoaEJB;
import locadora.diurno.dal.entidade.Pessoa;

@Named
@RequestScoped
public class PessoaController {


	
	@EJB
	private IPessoaEJB pessoaEJB;

	public List<Pessoa> todos(){
		return pessoaEJB.listar();
	}
	
	
	
	
}

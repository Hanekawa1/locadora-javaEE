package locadora.diurno.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.IPessoaDAO;
import locadora.diurno.dal.entidade.Pessoa;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class PessoaDAO 
	extends JPAGenericDAO<Pessoa, Integer>
	implements IPessoaDAO{


	
}

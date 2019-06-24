package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.IPessoaEJB;
import locadora.diurno.dal.dao.interfaces.IPessoaDAO;
import locadora.diurno.dal.entidade.Pessoa;

@Stateless
public class PessoaEJB implements IPessoaEJB{

	@Inject
	private IPessoaDAO pessoaDAO;
	
	@Override
	public List<Pessoa> listar() {
		return pessoaDAO.findAll();
	}

}

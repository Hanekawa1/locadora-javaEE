package locadora.diurno.bll.interfaces;

import java.util.*;
import locadora.diurno.dal.entidade.*;
import locadora.diurno.bll.util.*;


public interface IFuncionarioEJB {

	public Mensagem salvar(Funcionario funcionario);
	public Mensagem excluir(Integer idPessoa);
	public List<Funcionario> listar();
	
}

package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Combustivel;

public interface ICombustivelEJB {

	public Mensagem salvar(Combustivel combustivel);
	public Mensagem excluir(Short idCombustivel);
	public List<Combustivel> listar();
	
}

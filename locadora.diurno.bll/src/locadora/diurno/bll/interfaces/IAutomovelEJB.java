package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Automovel;

public interface IAutomovelEJB {

	public Mensagem salvar(Automovel automovel);
	public Mensagem excluir(Integer idAutomovel);
	public List<Automovel> listar();
	
}

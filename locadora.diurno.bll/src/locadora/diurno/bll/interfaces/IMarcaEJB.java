package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Marca;

public interface IMarcaEJB {

	public Mensagem salvar(Marca marca);
	public Mensagem excluir(Short idMarca);
	public List<Marca> listar();
	
}

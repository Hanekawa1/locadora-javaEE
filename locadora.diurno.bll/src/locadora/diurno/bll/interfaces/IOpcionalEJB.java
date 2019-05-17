package locadora.diurno.bll.interfaces;

import java.util.List;

import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Opcional;

public interface IOpcionalEJB {

	public Mensagem salvar(Opcional opcional);
	public Mensagem excluir(Short idOpcional);
	public List<Opcional> listar();
	
}

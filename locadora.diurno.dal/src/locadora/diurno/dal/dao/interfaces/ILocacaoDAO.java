package locadora.diurno.dal.dao.interfaces;

import java.util.Date;
import java.util.List;

import locadora.diurno.dal.entidade.Locacao;
import locadora.diurno.dal.generics.IGenericDAO;

public interface ILocacaoDAO
		extends IGenericDAO<Locacao,Integer>{

	List<Locacao> listar(Date data);
	List<?> listar(int ano);
}

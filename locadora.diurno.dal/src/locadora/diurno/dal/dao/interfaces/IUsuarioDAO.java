package locadora.diurno.dal.dao.interfaces;

import locadora.diurno.dal.entidade.*;
import locadora.diurno.dal.generics.IGenericDAO;

public interface IUsuarioDAO 
	extends IGenericDAO<Usuario, Integer> {

	
	public Usuario porLoginSenha(String login, String senha);
	
}

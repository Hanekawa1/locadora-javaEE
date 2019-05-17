package locadora.diurno.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.IAutomovelDAO;
import locadora.diurno.dal.entidade.Automovel;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class AutomovelDAO 
	extends JPAGenericDAO<Automovel, Integer>
	implements IAutomovelDAO{


	
}

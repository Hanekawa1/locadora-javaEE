package locadora.diurno.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.ICombustivelDAO;
import locadora.diurno.dal.entidade.Combustivel;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class CombustivelDAO 
	extends JPAGenericDAO<Combustivel, Short>
	implements ICombustivelDAO{


	
}

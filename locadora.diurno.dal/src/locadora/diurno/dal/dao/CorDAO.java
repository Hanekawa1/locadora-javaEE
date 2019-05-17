package locadora.diurno.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.ICorDAO;
import locadora.diurno.dal.entidade.Cor;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class CorDAO 
	extends JPAGenericDAO<Cor, Short>
	implements ICorDAO{


	
}

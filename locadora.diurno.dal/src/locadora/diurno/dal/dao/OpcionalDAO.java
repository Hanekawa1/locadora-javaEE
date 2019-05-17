package locadora.diurno.dal.dao;

import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.IOpcionalDAO;
import locadora.diurno.dal.entidade.Opcional;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class OpcionalDAO 
	extends JPAGenericDAO<Opcional, Short>
	implements IOpcionalDAO{


	
}

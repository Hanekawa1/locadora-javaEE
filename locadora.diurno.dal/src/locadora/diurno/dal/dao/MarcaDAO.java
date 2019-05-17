package locadora.diurno.dal.dao;


import javax.enterprise.context.RequestScoped;

import locadora.diurno.dal.dao.interfaces.IMarcaDAO;
import locadora.diurno.dal.entidade.Marca;
import locadora.diurno.dal.generics.JPAGenericDAO;

@RequestScoped
public class MarcaDAO 
	extends JPAGenericDAO<Marca, Short>
	implements IMarcaDAO{


	
}

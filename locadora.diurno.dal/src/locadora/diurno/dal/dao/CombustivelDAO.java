package locadora.diurno.dal.dao;

import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.entidade.*;
import locadora.diurno.dal.generics.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.*;
import javax.persistence.TypedQuery;

@SuppressWarnings("unused")
@RequestScoped
public class CombustivelDAO 
extends JPAGenericDAO<Combustivel, Short> 
implements ICombustivelDAO {

	@Override
	public List<Combustivel> findCombustiveis() {
		TypedQuery<Combustivel> query = 
				em.createQuery("select c from Combustivel as c", Combustivel.class);
		return query.getResultList();
	}

}

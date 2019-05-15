package locadora.diurno.dal.dao;

import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.entidade.*;
import locadora.diurno.dal.generics.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.*;
import javax.persistence.TypedQuery;

@SuppressWarnings("unused")
@Stateless
public class AutomovelDAO 	
	extends JPAGenericDAO<Marca, Short>
	implements IAutomovelDAO {

	@Override
	public List<Automovel> findAutomoveis() {
		TypedQuery<Automovel> query = 
				em.createQuery("select a from Automovel as a order by a.modelo.marca asc, a.modelo asc", Automovel.class);
		return query.getResultList();
	}

	@Override
	public List<Automovel> findAutomovelByMarca(String marca) {
		TypedQuery<Automovel> query = 
				em.createQuery
				("select a from Automovel as a where a.modelo.marca.descricao = :marca order by a.modelo.marca.descricao",
						Automovel.class);
		
		query.setParameter("marca", marca);
		
		return query.getResultList();
	}

	@Override
	public List<Automovel> findAutomoveisOpcional() {
		TypedQuery<Automovel> query =
				em.createQuery("select a from Automovel as a where a.idAutomovel = a.opcional.idAutomovel" , Automovel.class);
		return query.getResultList();
	}
	
	
	
}

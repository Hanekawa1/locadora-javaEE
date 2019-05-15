package locadora.diurno.dal.dao;

import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.generics.*;
import locadora.diurno.dal.entidade.*;

import java.util.List;
import javax.enterprise.context.*;
import javax.persistence.*;

import javax.ejb.Stateless;
//@RequestScoped
@SuppressWarnings("unused")
@Stateless
public class ModeloDAO
		extends JPAGenericDAO<Modelo, Short>
		implements IModeloDAO {

	@Override
	public List<Modelo> findByMarca(String nomeMarca) {
		TypedQuery<Modelo> query = 
				em.createQuery
				("select m from Modelo as m  where m.marca.descricao = :nomeMarca order by m.marca.descricao",
						Modelo.class);
		
		query.setParameter("nomeMarca", nomeMarca);
		
		return query.getResultList();//Se for retornar apenas um SingleResult
	}
	@Override
	public List<Modelo> findMarca() {
		TypedQuery<Modelo> query =
				em.createQuery("select m from Modelo as m order by m.marca.descricao", Modelo.class);
		
		return query.getResultList();
	}

	
}

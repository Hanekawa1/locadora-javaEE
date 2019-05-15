package locadora.diurno.dal.dao.interfaces;

import locadora.diurno.dal.generics.*;

import java.util.List;

import locadora.diurno.dal.entidade.*;


public interface IAutomovelDAO 
	extends IGenericDAO<Marca,Short> {

	public List<Automovel> findAutomoveis();
	public List<Automovel> findAutomovelByMarca(String marca);
	public List<Automovel> findAutomoveisOpcional();
}

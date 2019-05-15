package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.CombustivelDAO;
import locadora.diurno.dal.dao.interfaces.ICombustivelDAO;
import locadora.diurno.dal.dao.interfaces.IMarcaDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@SuppressWarnings("unused")
@Stateless
public class CombustivelEJB {
	
	@Inject
	private ICombustivelDAO combustivelDAO;
	
	public List<Combustivel> obterTodos(){
		return combustivelDAO.findAll();
	}
	
	public Combustivel obterPorID(Short idCombustivel) {
		return combustivelDAO.findById(idCombustivel);
	}
	
	public Mensagem salvar(Combustivel combustivel) {
		try {
			combustivelDAO.insertOrUpdate(combustivel);
		} catch(Exception ex) {
			return new Mensagem("Não foi possivel salvar. " +ex.getMessage(), MensagemStatus.erro);
		}
		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}
	
	public Mensagem excluir(Short idCombustivel) {
		try {
			combustivelDAO.deleteById(idCombustivel);
			
		} catch (Exception ex) {
			return new Mensagem("Erro na exclusão. " + ex.getMessage(), MensagemStatus.erro);
		}
		
		return new Mensagem("Excluído com sucesso.", MensagemStatus.sucesso);
	}
}

package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.ICombustivelEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.ICombustivelDAO;
import locadora.diurno.dal.entidade.Combustivel;

@Stateless
public class CombustivelEJB implements ICombustivelEJB{

	@Inject
	private ICombustivelDAO combustivelDAO;
	
	@Override
	public Mensagem salvar(Combustivel combustivel) {
		
		try {
			
			combustivelDAO.insertOrUpdate(combustivel);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Short idCombustivel) {
		
		try {
			
			Combustivel combustivel = combustivelDAO.findById(idCombustivel);
			
			if(combustivel == null) {
				throw new Exception("Combustivel já foi excluído.");
			}
			
			if(combustivel.getAutomoveis().size() > 0) {
				throw new Exception("Essa combustivel possui autmoveis vinculados");
			}
			
			combustivelDAO.delete(combustivel);
			
			return new Mensagem("Combustivel excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Combustivel> listar() {
		return combustivelDAO.findAll();
	}

}

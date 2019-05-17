package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.IAutomovelEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.IAutomovelDAO;
import locadora.diurno.dal.entidade.Automovel;

@Stateless
public class AutomovelEJB implements IAutomovelEJB{

	@Inject
	private IAutomovelDAO automovelDAO;
	
	@Override
	public Mensagem salvar(Automovel automovel) {
		
		try {
		
			automovelDAO.insertOrUpdate(automovel);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Integer idAutomovel) {
		
		try {
			
			Automovel automovel = automovelDAO.findById(idAutomovel);
			
			if(automovel == null) {
				throw new Exception("Automovel já foi excluído.");
			}
			
	
			
			automovelDAO.delete(automovel);
			
			return new Mensagem("Automovel excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Automovel> listar() {
		return automovelDAO.findAll();
	}

}

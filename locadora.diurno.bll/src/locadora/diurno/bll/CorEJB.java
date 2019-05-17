package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.ICorEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.ICorDAO;
import locadora.diurno.dal.entidade.Cor;

@Stateless
public class CorEJB implements ICorEJB{

	@Inject
	private ICorDAO corDAO;
	
	@Override
	public Mensagem salvar(Cor cor) {
		
		try {
			
			corDAO.insertOrUpdate(cor);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}
	}

	@Override
	public Mensagem excluir(Short idCor) {
		
		try {
			
			Cor cor = corDAO.findById(idCor);
			
			if(cor == null) {
				throw new Exception("Cor já foi excluída.");
			}
			
			if(cor.getAutomoveis().size() > 0) {
				throw new Exception("Essa cor possui automoveis vinculados");
			}
			
			corDAO.delete(cor);
			
			return new Mensagem("Cor excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Cor> listar() {
		return corDAO.findAll();
	}

}

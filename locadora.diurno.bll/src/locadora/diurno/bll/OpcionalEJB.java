package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.IOpcionalEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.IOpcionalDAO;
import locadora.diurno.dal.entidade.Opcional;;

@Stateless
public class OpcionalEJB implements IOpcionalEJB{

	@Inject
	private IOpcionalDAO opcionalDAO;
	
	@Override
	public Mensagem salvar(Opcional opcional) {
		
		try {
			
			opcionalDAO.insertOrUpdate(opcional);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
		}
	}

	@Override
	public Mensagem excluir(Short idOpcional) {
		
		try {
			
			Opcional opcional = opcionalDAO.findById(idOpcional);
			
			if(opcional == null) {
				throw new Exception("Opcional já foi excluída.");
			}
			
			if(opcional.getAutomoveis().size() > 0) {
				throw new Exception("Esse opcional possui automoveis vinculados");
			}
			
			opcionalDAO.delete(opcional);
			
			return new Mensagem("Opcional excluído.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Opcional> listar() {
		return opcionalDAO.findAll();
	}

}

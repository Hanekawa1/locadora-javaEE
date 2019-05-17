package locadora.diurno.bll;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.IMarcaEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.IMarcaDAO;
import locadora.diurno.dal.entidade.Marca;

@Stateless
public class MarcaEJB implements IMarcaEJB{

	@Inject
	private IMarcaDAO marcaDAO;
	
	@Override
	public Mensagem salvar(Marca marca) {
		
		try {
			
			//abre a conexão
			marcaDAO.insertOrUpdate(marca);
			
			return new Mensagem("Salvo com sucesso.",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			
			return new Mensagem("Erro inesperado: " 
					+ ex.getMessage(), TipoMensagem.erro);
			
		}finally {
			//fecha a conexão
		}
	}

	@Override
	public Mensagem excluir(Short idMarca) {
		
		try {
			
			Marca marca = marcaDAO.findById(idMarca);
			
			if(marca == null) {
				throw new Exception("Marca já foi excluída.");
			}
			
			if(marca.getModelos().size() > 0) {
				throw new Exception("Essa marca possui modelos vinculados");
			}
			
			marcaDAO.delete(marca);
			
			return new Mensagem("Marca excluída.", TipoMensagem.sucesso);
		}catch(Exception ex) {
			return new Mensagem("Erro inesperado: "
					+ ex.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public List<Marca> listar() {
		return marcaDAO.findAll();
	}

}

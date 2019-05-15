package locadora.diurno.bll;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.*;
import locadora.diurno.dal.dao.interfaces.IMarcaDAO;
import locadora.diurno.dal.entidade.*;
import java.util.*;

import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class MarcaEJB implements IMarcaEJB {

	@Inject
	private IMarcaDAO marcaDAO;
	
	@Override
	public Mensagem salvar(Marca marca) {

		try {
			marcaDAO.insertOrUpdate(marca);
	
		} catch(Exception ex) {
			return new Mensagem("Ocorreu um erro inesperado: " 
						+ ex.getMessage(),MensagemStatus.erro);
		} finally {
			//Executado independente de erro
		}

		return new Mensagem("Salvo com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Mensagem excluir(Short idMarca) {

		try {
			Marca marca = obterPorId(idMarca);
			
			if(marca == null) {
				//Vai lançar uma exceção para o catch
				throw new Exception("Marca inexistente.");
			}
			if(marca.getModelos().size() > 0) {
				throw new Exception("Existem modelos vinculados a essa marca.");
			}
			marcaDAO.delete(marca);
		} catch (Exception ex) {
			return new Mensagem("Não foi possível excluir: " + ex.getMessage(), MensagemStatus.erro);
		}
		return new Mensagem("Excluído com sucesso.", MensagemStatus.sucesso);
	}

	@Override
	public Marca obterPorId(Short idMarca) {
		return marcaDAO.findById(idMarca);
	}

	@Override
	public List<Marca> obterTodos() {
		return marcaDAO.findAll();
	}

}

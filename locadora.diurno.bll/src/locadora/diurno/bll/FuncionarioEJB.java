package locadora.diurno.bll;

import java.util.*;
import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.SHA1;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.*;
import locadora.diurno.dal.entidade.*;
import javax.ejb.*;
import javax.inject.*;

@Stateless
public class FuncionarioEJB implements IFuncionarioEJB {

	@Inject
	private IFuncionarioDAO funcionarioDAO;
	
	@Override
	public Mensagem salvar(Funcionario funcionario) {

		try {
			
			String cpfSemMascara = funcionario.getCpfMascara()
				.replace(".", "")
				.replace("-", "");
			
			funcionario.setCpf(Long.parseLong(cpfSemMascara));
			
			Usuario usuario = funcionario.getUsuario();
			usuario.setFuncionario(funcionario);
			
			String senha = SHA1.encryptPassword(usuario.getSenha());
			usuario.setSenha(senha);
			
			funcionarioDAO.insertOrUpdate(funcionario);
			
			return new Mensagem("Funcionário salvo.",
					TipoMensagem.sucesso);
			
		}catch (Exception e) {
			return new Mensagem(e.getMessage(), TipoMensagem.erro);
		}
		
	}

	@Override
	public Mensagem excluir(Integer idPessoa) {
		
		try {
			
			Funcionario funcionario = funcionarioDAO.findById(idPessoa);
			
			if(funcionario == null) {
				return new Mensagem("Funcionário não existe.",
						TipoMensagem.erro);
			}
			
			if(funcionario.getLocacoes().size() > 0) {
				return new Mensagem("Funcionário já realizou locações.",
						TipoMensagem.erro);
			}
			
			funcionarioDAO.delete(funcionario);
			
			return new Mensagem("Funcionário excluído",
					TipoMensagem.sucesso);
			
		}catch(Exception ex) {
			return new Mensagem(ex.getMessage(),
					TipoMensagem.erro);
			
		}
		
	}

	@Override
	public List<Funcionario> listar() {
		return funcionarioDAO.findAll();
	}

}

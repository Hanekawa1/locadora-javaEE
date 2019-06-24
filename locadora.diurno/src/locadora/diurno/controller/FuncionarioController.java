package locadora.diurno.controller;

import javax.enterprise.context.*;
import javax.inject.*;
import locadora.diurno.dal.entidade.*;

import javax.ejb.*;
import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;

import java.util.*;
import locadora.diurno.util.*;

@Named
@RequestScoped
public class FuncionarioController {

	private Funcionario funcionario;
	
	@EJB
	private IFuncionarioEJB funcionarioEJB;
	
	@Inject
	private FacesUtil facesUtil;
	
	public FuncionarioController() {
		novoFuncionario();
	}
	
	public void salvar() {
		Mensagem mensagem = funcionarioEJB.salvar(funcionario);
		if(mensagem.getTipo() == TipoMensagem.sucesso) {
			novoFuncionario();
		}
		
		facesUtil.addMessage(mensagem);
	}
	
	public List<Funcionario> listar(){
		return funcionarioEJB.listar();
	}
	
	private void novoFuncionario() {
		this.funcionario = new Funcionario();
		this.funcionario.setUsuario(new Usuario());
	}
	
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}

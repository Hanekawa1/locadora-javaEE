package locadora.diurno.controller;

import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ejb.*;
import java.util.*;

import locadora.diurno.bll.interfaces.*;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.MensagemStatus;
import locadora.diurno.dal.entidade.*;
import javax.inject.*;

@Named
@RequestScoped
public class CombustivelController {
	
	@EJB
	private ICombustivelEJB combustivelEJB;
	
	@Inject
	private FacesContext context;
	

	private Combustivel combustivel;
	
	public CombustivelController() {
		this.combustivel = new Combustivel();
	}
	
	public List<Combustivel> listarCombustiveis(){
		return combustivelEJB.obterTodos();
	}
	
	public void editar(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	public void excluir(Short idCombustivel) {
		Mensagem msg = combustivelEJB.excluir(idCombustivel);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}
	
	public void salvar() {
		Mensagem msg = combustivelEJB.salvar(combustivel);
		if(msg.getStatus() == MensagemStatus.sucesso) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg.getTexto(), null));
			this.combustivel = new Combustivel();
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg.getTexto(), null));
		}
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	
}

package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.ICombustivelEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Combustivel;

@Named
@RequestScoped
public class CombustivelController {

	private Combustivel combustivel;
	
	@EJB
	private ICombustivelEJB combustivelEJB;
	
	@Inject
	private FacesContext context;
	
	public CombustivelController() {
		this.combustivel = new Combustivel();
	}
	
	public void salvar() {
		
		Mensagem msg = combustivelEJB.salvar(combustivel);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.combustivel = new Combustivel();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Combustivel> todos(){
		return combustivelEJB.listar();
	}
	
	public void editar(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	
	public void excluir(Short idCombustivel) {
		
		Mensagem msg = combustivelEJB.excluir(idCombustivel);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
		
	}

	
	
	
	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	
	
}

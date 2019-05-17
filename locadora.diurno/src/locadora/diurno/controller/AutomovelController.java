package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.IAutomovelEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Automovel;

@Named
@RequestScoped
public class AutomovelController {

	private Automovel automovel;
	
	@EJB
	private IAutomovelEJB automovelEJB;
	
	@Inject
	private FacesContext context;
	
	public AutomovelController() {
		this.automovel = new Automovel();
	}
	
	public void salvar() {
		
		Mensagem msg = automovelEJB.salvar(automovel);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.automovel = new Automovel();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Automovel> todos(){
		return automovelEJB.listar();
	}
	
	public void editar(Automovel automovel) {
		this.automovel = automovel;
	}
	
	
	public void excluir(Integer idAutomovel) {
		
		Mensagem msg = automovelEJB.excluir(idAutomovel);
		
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

	
	
	
	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	
	
	
}

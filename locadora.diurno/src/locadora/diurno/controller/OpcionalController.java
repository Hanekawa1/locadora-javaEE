package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.IOpcionalEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Opcional;

@Named
@RequestScoped
public class OpcionalController {

	private Opcional opcional;
	
	@EJB
	private IOpcionalEJB opcionalEJB;
	
	@Inject
	private FacesContext context;
	
	public OpcionalController() {
		this.opcional = new Opcional();
	}
	
	public void salvar() {
		
		Mensagem msg = opcionalEJB.salvar(opcional);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.opcional = new Opcional();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Opcional> todos(){
		return opcionalEJB.listar();
	}
	
	public void editar(Opcional opcional) {
		this.opcional = opcional;
	}
	
	
	public void excluir(Short idOpcional) {
		
		Mensagem msg = opcionalEJB.excluir(idOpcional);
		
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

	
	
	
	public Opcional getOpcional() {
		return opcional;
	}

	public void setOpcional(Opcional opcional) {
		this.opcional = opcional;
	}
	
	
	
}

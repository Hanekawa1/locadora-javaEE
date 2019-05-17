package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.ICorEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Cor;

@Named
@RequestScoped
public class CorController {

	private Cor cor;
	
	@EJB
	private ICorEJB corEJB;
	
	@Inject
	private FacesContext context;
	
	public CorController() {
		this.cor = new Cor();
	}
	
	public void salvar() {
		
		Mensagem msg = corEJB.salvar(cor);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.cor = new Cor();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Cor> todos(){
		return corEJB.listar();
	}
	
	public void editar(Cor cor) {
		this.cor = cor;
	}
	
	
	public void excluir(Short idCor) {
		
		Mensagem msg = corEJB.excluir(idCor);
		
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

	
	
	
	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	
	
}

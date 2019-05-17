package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.IModeloEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Modelo;

@Named
@RequestScoped
public class ModeloController {

	private Modelo modelo;
	
	@EJB
	private IModeloEJB modeloEJB;
	
	@Inject
	private FacesContext context;
	
	public ModeloController() {
		this.modelo = new Modelo();
	}
	
	public void salvar() {
		
		Mensagem msg = modeloEJB.salvar(modelo);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.modelo = new Modelo();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Modelo> todos(){
		return modeloEJB.listar();
	}
	
	public void editar(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	public void excluir(Short idModelo) {
		
		Mensagem msg = modeloEJB.excluir(idModelo);
		
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

	
	
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	
}

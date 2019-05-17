package locadora.diurno.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import locadora.diurno.bll.interfaces.IMarcaEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.Marca;

@Named
@RequestScoped
public class MarcaController {

	private Marca marca;
	
	@EJB
	private IMarcaEJB marcaEJB;
	
	@Inject
	private FacesContext context;
	
	public MarcaController() {
		this.marca = new Marca();
	}
	
	public void salvar() {
		
		Mensagem msg = marcaEJB.salvar(marca);
		
		if(msg.getTipo() == TipoMensagem.sucesso) {
			
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							msg.getTexto(),null) );
			
			this.marca = new Marca();
			
		}else {
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							msg.getTexto(),null) );
		}
		
	}

	public List<Marca> todos(){
		return marcaEJB.listar();
	}
	
	public void editar(Marca marca) {
		this.marca = marca;
	}
	
	
	public void excluir(Short idMarca) {
		
		Mensagem msg = marcaEJB.excluir(idMarca);
		
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

	
	
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}

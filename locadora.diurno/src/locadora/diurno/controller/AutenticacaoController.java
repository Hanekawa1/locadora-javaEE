package locadora.diurno.controller;

import javax.inject.*;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;

import locadora.diurno.bll.interfaces.IUsuarioEJB;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.entidade.*;
import locadora.diurno.util.FacesUtil;

@Named
@SessionScoped
public class AutenticacaoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private boolean usuarioAutenticado;
	
	@EJB
	private IUsuarioEJB usuarioEJB;
	
	@Inject
	private FacesUtil facesUtil;
	
	@Inject
	private FacesContext facesContext;
	
	public AutenticacaoController() {
		this.usuario = new Usuario();
	}
	
	public void autenticar() throws IOException {
		
		Mensagem mensagem = usuarioEJB.autenticar(usuario);
		
		if(mensagem.getTipo() == TipoMensagem.erro) {
			facesUtil.addMessage(mensagem);
		}else {
			usuarioAutenticado = true;
			facesContext
				.getExternalContext()
				.redirect("index.xhtml");
		}
	}
	
	public void sair() throws IOException {
		
		this.usuarioAutenticado = false;
		
		facesContext
		.getExternalContext()
		.redirect(facesContext
				.getExternalContext().getRequestContextPath() +"/login.xhtml");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(boolean usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}
	
	
	
	
	
}

package locadora.diurno.bll.util;

public class Mensagem {

	private String texto;
	private TipoMensagem tipo;
	
	
	public Mensagem(String texto,
			TipoMensagem tipo) {
		this.texto = texto;
		this.tipo = tipo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public TipoMensagem getTipo() {
		return tipo;
	}


	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}


	
	
	
}

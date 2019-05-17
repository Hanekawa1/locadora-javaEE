package locadora.diurno.dal.entidade;

import javax.persistence.*;

@Entity
public class LocacaoAutomovel {

	@EmbeddedId
	private LocacaoAutomovelPk id;
	
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "idAutomovel")
	@MapsId("idAutomovel")
	private Automovel automovel;
	
	@ManyToOne
	@JoinColumn(name = "idLocacao")
	@MapsId("idLocacao")
	private Locacao locacao;

	public LocacaoAutomovelPk getId() {
		return id;
	}

	public void setId(LocacaoAutomovelPk id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocacaoAutomovel other = (LocacaoAutomovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

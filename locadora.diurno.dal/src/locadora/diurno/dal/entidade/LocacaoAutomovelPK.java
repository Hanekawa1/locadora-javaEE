package locadora.diurno.dal.entidade;

import javax.persistence.*;

@Embeddable
public class LocacaoAutomovelPk {

	private Integer idLocacao;
	private Integer idAutomovel;
	
	public Integer getIdLocacao() {
		return idLocacao;
	}
	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}
	public Integer getIdAutomovel() {
		return idAutomovel;
	}
	public void setIdAutomovel(Integer idAutomovel) {
		this.idAutomovel = idAutomovel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutomovel == null) ? 0 : idAutomovel.hashCode());
		result = prime * result + ((idLocacao == null) ? 0 : idLocacao.hashCode());
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
		LocacaoAutomovelPk other = (LocacaoAutomovelPk) obj;
		if (idAutomovel == null) {
			if (other.idAutomovel != null)
				return false;
		} else if (!idAutomovel.equals(other.idAutomovel))
			return false;
		if (idLocacao == null) {
			if (other.idLocacao != null)
				return false;
		} else if (!idLocacao.equals(other.idLocacao))
			return false;
		return true;
	}
	
	
	
}

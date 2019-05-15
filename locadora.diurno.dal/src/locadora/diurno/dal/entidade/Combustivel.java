package locadora.diurno.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
public class Combustivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idCombustivel;
	
	@NotNull(message = "Campo descrição é obrigatório")
	@Size(max = 50, message = "O campo descrição pode ter no máximo 50 caracteres")
	private String descricao;

	
	@OneToMany(mappedBy = "combustivel", fetch = FetchType.LAZY)
	private List<Automovel> automoveis;
	
	//Getters, Setters, Hashcode & Equals
	public Short getIdCombustivel() {
		return idCombustivel;
	}

	public void setIdCombustivel(Short idCombustivel) {
		this.idCombustivel = idCombustivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCombustivel == null) ? 0 : idCombustivel.hashCode());
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
		Combustivel other = (Combustivel) obj;
		if (idCombustivel == null) {
			if (other.idCombustivel != null)
				return false;
		} else if (!idCombustivel.equals(other.idCombustivel))
			return false;
		return true;
	}
}

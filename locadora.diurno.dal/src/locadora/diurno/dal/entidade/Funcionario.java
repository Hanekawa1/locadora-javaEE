package locadora.diurno.dal.entidade;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "F")
@PrimaryKeyJoinColumn(name = "idPessoaFuncionario",
		referencedColumnName="idPessoa")
public class Funcionario extends Pessoa {

	private Double salario;
	
	@OneToOne(mappedBy = "funcionario",
			cascade = CascadeType.ALL)
	private Usuario usuario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}

package locadora.diurno.dal.entidade;

import javax.persistence.*;

@Entity
public class Usuario {

	
	@Id
	@Column(name="idPessoaUsuario",
		insertable = false, updatable = false)
	private Integer idPessoaUsuario;
	
	private String login;
	
	private String senha;
	
	@OneToOne
	@JoinColumn(name="idPessoaUsuario",
			referencedColumnName="idPessoaFuncionario")
	private Funcionario funcionario;

	public Integer getIdPessoaUsuario() {
		return idPessoaUsuario;
	}

	public void setIdPessoaUsuario(Integer idPessoaUsuario) {
		this.idPessoaUsuario = idPessoaUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}

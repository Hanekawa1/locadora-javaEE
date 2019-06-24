package locadora.diurno.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo", 
		discriminatorType = DiscriminatorType.CHAR)
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	
	private String nome;
	
	private Long cpf;
	
	@Transient
	@NotNull(message = "Informe o CPF")
	private String cpfMascara;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@OneToMany(mappedBy="pessoa")
	private List<Locacao> locacoes;

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public String getCpfMascara() {
		
		if(cpfMascara == null && cpf != null) {
			
			cpfMascara = cpf.toString();
			
			while(cpfMascara.length() != 11) {	
				cpfMascara = "0" + cpfMascara;	
			}
			
			cpfMascara = cpfMascara.substring(0, 3)
						+ "." 
						+ cpfMascara.substring(3,6)
						+ "."
						+ cpfMascara.substring(6, 9)
						+ "-"
						+ cpfMascara.substring(9, 11);
						
		}
		
		return cpfMascara;
	}

	public void setCpfMascara(String cpfMascara) {
		this.cpfMascara = cpfMascara;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}
	
	
}

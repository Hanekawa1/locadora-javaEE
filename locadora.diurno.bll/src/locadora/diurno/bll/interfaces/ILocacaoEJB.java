package locadora.diurno.bll.interfaces;

import java.util.Date;
import java.util.List;

import locadora.diurno.bll.relatorio.GraficoLinha;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.dal.entidade.Locacao;

public interface ILocacaoEJB {

	public Mensagem salvar(Locacao locacao);
	public List<Locacao> listar(Date data);
	List<GraficoLinha> listar(int ano);
}

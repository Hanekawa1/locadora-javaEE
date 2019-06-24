package locadora.diurno.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import locadora.diurno.bll.interfaces.ILocacaoEJB;
import locadora.diurno.bll.relatorio.GraficoLinha;
import locadora.diurno.bll.util.Mensagem;
import locadora.diurno.bll.util.TipoMensagem;
import locadora.diurno.dal.dao.interfaces.ILocacaoDAO;
import locadora.diurno.dal.entidade.Locacao;
import locadora.diurno.dal.entidade.LocacaoAutomovel;

@Stateless
public class LocacaoEJB implements ILocacaoEJB{

	@Inject
	private ILocacaoDAO locadoraDAO;
	
    @Override
    public Mensagem salvar(Locacao locacao) {
        try {
            for (LocacaoAutomovel lv : locacao.getLocacaoAutomoveis()) {
                lv.setLocacao(locacao);
            }

            locadoraDAO.insertOrUpdate(locacao);
            return new Mensagem("Locação salva.",
					TipoMensagem.sucesso);
        } catch (Exception ex) {
        	return new Mensagem(ex.getMessage(), TipoMensagem.erro);
        }
    }

    public List<Locacao> listar(Date data) {
        return locadoraDAO.listar(data);
    }
    
    
    public List<GraficoLinha> listar(int ano) {

        List<GraficoLinha> locacoes = new ArrayList<>();

		List<?> list =  locadoraDAO.listar(ano);
		
		for (Object object : list) {
			Object[] objects = (Object[])object;
			locacoes.add(new GraficoLinha((Integer) objects[0], (Double) objects[1]));
		}

        return locacoes;
    }
}

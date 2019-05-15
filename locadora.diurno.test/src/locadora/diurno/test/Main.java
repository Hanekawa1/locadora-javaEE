package locadora.diurno.test;

import java.util.*;
import javax.ejb.embeddable.*;
import javax.naming.*;

import locadora.diurno.dal.entidade.*;

import locadora.diurno.dal.dao.*;
import locadora.diurno.dal.dao.interfaces.*;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		p.put("locadoraDB", "new://Resource?type=DataSource");
		p.put("locadoraDB.JdbcDriver", "com.mysql.jdbc.Driver");
		p.put("locadoraDB.JdbcUrl","jdbc:mysql://localhost:3306/concessionaria");
		p.put("locadoraDB.userName","root");
		p.put("locadoraDB.password","");
		
		
		Context context = EJBContainer.createEJBContainer(p).getContext();
		
		IModeloDAO modeloDAO = (IModeloDAO) context
				.lookup("java:global/locadora.diurno.dal/ModeloDAO");
		IAutomovelDAO automovelDAO = (IAutomovelDAO) context
				.lookup("java:global/locadora.diurno.dal/AutomovelDAO");
		ICombustivelDAO combustivelDAO = (ICombustivelDAO) context
				.lookup("java:global/locadora.diurno.dal/CombustivelDAO");
	
		
		//Marca marca = new Marca();
		//marca.setDescricao("Ford");
		
		//marcaDAO.insert(marca);
		

		
		List<Modelo> modelos = modeloDAO.findByMarca("Fiat");
		
		for (Modelo modelo : modelos) {
			System.out.println(modelo.getDescricao());
		}
		
		// 1) Apresente todos os modelos ordenados pela marca
		
		List<Modelo> modelosMarca = modeloDAO.findMarca();
		
		for(Modelo modelo: modelosMarca) {
			System.out.println(modelo.getMarca().getDescricao() + " - " + modelo.getDescricao());
		}
	
		// 2) Apresente todos os automóveis ordenados pela marca e em seguida pelo modelo. 
		
		List<Automovel> automoveis = automovelDAO.findAutomoveis();
		
		for(Automovel automovel : automoveis) {
			System.out.println(automovel.getModelo().getMarca().getDescricao() + " - " + automovel.getModelo().getDescricao());
		}
		
		// 3) Crie uma consulta parametrizada em que o usuário irá passar um nome de uma marca e você retornará todos os automóveis da marca repassada.
		
		List<Automovel> automoveisPorMarca = automovelDAO.findAutomovelByMarca("Fiat");
		
		for(Automovel automovel : automoveisPorMarca) {
			System.out.println(automovel.getModelo().getMarca().getDescricao() + " - " + automovel.getModelo().getDescricao());
		}
		
		// 4) Apresente todos os combustíveis e a quantidade de automóveis em cada combustível.
		
		List<Combustivel> combustiveis = combustivelDAO.findCombustiveis();
		
		for(Combustivel combustivel: combustiveis) {
			System.out.println(combustivel.getDescricao() + " - " + combustivel.getAutomoveis().size());
		}
		
		// 5) Apresente todos os automóveis que tenha pelo menos um opcional.

		List<Automovel> automoveisOpcional = automovelDAO.findAutomoveisOpcional();
		
		for(Automovel automovel: automoveisOpcional) {
			System.out.println(automovel.getModelo().getMarca().getDescricao() + " - " + automovel.getModelo().getDescricao() + " - " + automovel.getOpcionais());
		}
	}
}

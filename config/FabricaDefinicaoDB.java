package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FabricaDefinicaoDB {

	public DefinicaoDB criarDefinicaoDB() {
		return new DefinicaoDB(criarUsuarioDB(), "livraria");
	}

	private List<UsuarioDB> criarUsuarioDB() {

		List<UsuarioDB> usuarios = new ArrayList<>();

		Map<String, AtorDB> atores = criarAtoresDB();

		// Cliente
		List<AtorDB> papeisCliente = new ArrayList<>(2);

		papeisCliente.add(atores.get("usuario"));
		papeisCliente.add(atores.get("cliente"));

		usuarios.add(new UsuarioDB("cliente", "%", "3reaix", papeisCliente));

		// Gerente

		List<AtorDB> papeisGerente = new ArrayList<>(3);

		papeisGerente.add(atores.get("usuario"));
		papeisGerente.add(atores.get("funcionario"));
		papeisGerente.add(atores.get("gerente"));

		usuarios.add(new UsuarioDB("gerente", "%", "reporepo", papeisGerente));

		// Vendedor

		List<AtorDB> papeisVendedor = new ArrayList<>(3);

		papeisVendedor.add(atores.get("usuario"));
		papeisVendedor.add(atores.get("funcionario"));
		papeisVendedor.add(atores.get("vendedor"));

		usuarios.add(new UsuarioDB("vendedor", "%", "38964", papeisVendedor));
		// Caixa

		List<AtorDB> papeisCaixa = new ArrayList<>(3);

		papeisCaixa.add(atores.get("usuario"));
		papeisCaixa.add(atores.get("funcionario"));
		papeisCaixa.add(atores.get("caixa"));

		usuarios.add(new UsuarioDB("caixa", "%", "comsono", papeisCaixa));

		return usuarios;
	}

	private Map<String, AtorDB> criarAtoresDB() {

		List<AtorDB> atores = criarListasDeAtores();

		Map<String, AtorDB> mapaDeAtores = new HashMap();

		for (AtorDB ator : atores) {

			mapaDeAtores.put(ator.getNome(), ator);
		}

		atribuiCasosDeUsoAtores(mapaDeAtores);

		return mapaDeAtores;

	}

	private List<AtorDB> criarListasDeAtores() {

		List<AtorDB> atores = new ArrayList<>();

		atores.add(new AtorDB("caixa"));
		atores.add(new AtorDB("gerente"));
		atores.add(new AtorDB("vendedor"));
		atores.add(new AtorDB("cliente"));
		atores.add(new AtorDB("funcionario"));
		atores.add(new AtorDB("usuario"));

		return atores;
	}

	private void atribuiCasosDeUsoAtores(Map<String, AtorDB> atores) {

		CasoDeUsoDB uc = new CasoDeUsoDB(1, "CR Cliente");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "perfilCliente"));
		atores.get("funcionario").atribuirCasoDeUso(uc);

		uc = new CasoDeUsoDB(1, "CR Usuario");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "Usuario"));
		atores.get("funcionario").atribuirCasoDeUso(uc);

		uc = new CasoDeUsoDB(1, "CR Produto");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "produto"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		uc = new CasoDeUsoDB(1, "CR ProdutoLivro");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "produtoLivro"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		uc = new CasoDeUsoDB(1, "CRU Fornecedor");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT, UPDATE", "fornecedor"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		uc = new CasoDeUsoDB(1, "CR Plano VIP");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "planoVip"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		uc = new CasoDeUsoDB(2, "CR Venda");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "venda"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
//		uc = new CasoDeUsoDB(3, "CR Estornar");
//		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "estorno"));
//		atores.get("gerente").atribuirCasoDeUso(uc);
//		
//		uc = new CasoDeUsoDB(4, "CR Devolver");
//		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "devolver"));
//		atores.get("gerente").atribuirCasoDeUso(uc);
		
		uc = new CasoDeUsoDB(5, "CR PagamentoEmCheque");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "venda"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		uc = new CasoDeUsoDB(7,  "CR Funcionario");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT, UPDATE", "funcionario"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		//naylane
		uc = new CasoDeUsoDB(13, "Estorno Assinatura Vip");
		uc.adicionarPermicao(new PermissoesDB("UPDATE", "assinaturaVip"));
		atores.get("gerente").atribuirCasoDeUso(uc);
        //sameul
		uc = new CasoDeUsoDB(6, "CR PagamentoEmDinheiro");
		uc.adicionarPermicao(new PermissoesDB("INSERT, SELECT", "venda"));
		atores.get("gerente").atribuirCasoDeUso(uc);
		
		
	}

}

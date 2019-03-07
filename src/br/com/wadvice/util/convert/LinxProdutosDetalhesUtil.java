package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.ProdutosDetalhesDao;
import br.com.wadvice.rest.model.linx.ProdutosDetalhesModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxProdutosDetalhesUtil extends ConvertUtil {
	
	public void gravar(String cnpjEmpresa, List<ProdutosDetalhesModel> produtos) throws SQLException {
		ProdutosDetalhesDao dao = new ProdutosDetalhesDao();
		dao.gravarLista(cnpjEmpresa, produtos);
	}
	
	public List<ProdutosDetalhesModel> convertStringXmlToObjects(String xml) throws Exception {
		List<ProdutosDetalhesModel> produtos = new ArrayList<>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		
		for (DadosXml dadosXml : registros) {
			ProdutosDetalhesModel produto = new ProdutosDetalhesModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					produto.setPortal(valor);
					continue;
				case "cnpj_emp":
					produto.setCnpjEmpresa(valor);
					continue;
				case "cod_produto":
					produto.setCodProduto(valor);
					continue;
				case "cod_barra":
					produto.setCodBarra(valor);
					continue;
				case "quantidade":
					produto.setQuantidade(valor);
					continue;
				case "preco_custo":
					produto.setPrecoCusto(valor);
					continue;
				case "preco_venda":
					produto.setPrecoVenda(valor);
					continue;
				case "custo_medio":
					produto.setCustoMedio(valor);
					continue;
				case "id_config_tributaria":
					produto.setIdConfigTributaria(valor);
					continue;
				case "desc_config_tributaria":
					produto.setDescConfigTributaria(valor);
					continue;
				case "despesas1":
					produto.setDespesas1(valor);
					continue;
				default:
					break;
				}
			}
			produtos.add(produto);
		}
		return produtos;
	}
	
}

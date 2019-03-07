package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.ProdutoDao;
import br.com.wadvice.rest.model.linx.ProdutoModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxProdutoUtil extends ConvertUtil {

	public void gravar(List<ProdutoModel> produtos) throws SQLException {
		ProdutoDao dao = new ProdutoDao();
		dao.gravarLista(produtos);
	}

	public List<ProdutoModel> convertStringXmlToObjects(String xml) throws Exception {
		List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			ProdutoModel produto = new ProdutoModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					produto.setPortal(valor);
					continue;
				case "cod_produto":
					produto.setCodProduto(valor);
					continue;
				case "cod_barra":
					produto.setCodBarra(valor);
					continue;
				case "nome":
					produto.setNome(valor);
					continue;
				case "ncm":
					produto.setNcm(valor);
					continue;
				case "cest":
					produto.setCest(valor);
					continue;
				case "referencia":
					produto.setReferencia(valor);
					continue;
				case "cod_auxiliar":
					produto.setCodAuxiliar(valor);
					continue;
				case "unidade":
					produto.setUnidade(valor);
					continue;
				case "desc_cor":
					produto.setDescCor(valor);
					continue;
				case "desc_tamanho":
					produto.setDescTamanho(valor);
					continue;
				case "desc_setor":
					produto.setDescSetor(valor);
					continue;
				case "desc_linha":
					produto.setDescLinha(valor);
					continue;
				case "desc_marca":
					produto.setDescMarca(valor);
					continue;
				case "desc_colecao":
					produto.setDescColecao(valor);
					continue;
				case "dt_update":
					produto.setDataUpdate(valor);
					continue;
				case "cod_fornecedor":
					produto.setCodFornecedor(valor);
					continue;
				case "desativado":
					produto.setDesativado(valor);
					continue;
				case "desc_espessura":
					produto.setDescEspessura(valor);
					continue;
				case "id_espessura":
					produto.setIdEspessura(valor);
					continue;
				case "id_classificacao":
					produto.setIdClassificacao(valor);
					continue;
				case "desc_classificacao":
					produto.setDescClassificacao(valor);
					continue;
				case "origem_mercadoria":
					produto.setOrigemMercadoria(valor);
					continue;
				case "peso_liquido":
					produto.setPesoLiquido(valor);
					continue;
				case "peso_bruto":
					produto.setPesoBruto(valor);
					continue;
				case "id_cor":
					produto.setIdCor(valor);
					continue;
				case "id_tamanho":
					produto.setIdTamanho(valor);
					continue;
				case "id_setor":
					produto.setIdSetor(valor);
					continue;
				case "id_linha":
					produto.setIdLinha(valor);
					continue;
				case "id_marca":
					produto.setIdMarca(valor);
					continue;
				case "id_colecao":
					produto.setIdColecao(valor);
					continue;
				case "dt_inclusao":
					produto.setDataInclusao(valor);
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

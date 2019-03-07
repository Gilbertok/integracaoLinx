package br.com.wadvice.rest;

import java.util.List;

import br.com.wadvice.rest.model.linx.ProdutoModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxProdutoUtil;

public class SincProduto extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxProdutos.xml";
	private static final String INTEGRACAO = "LinxProdutos";
	private LinxProdutoUtil util;

	public SincProduto() {
		super(INTEGRACAO, URL_FILE_XML, SincProduto.class);
		util = new LinxProdutoUtil();
	}

	public void getData(String cnpjEmpresa) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ProdutoModel> produtos = this.postData(config.getUrlWebService(), cnpjEmpresa);
			logger.debug(produtos.toString());
			util.gravar(produtos);
			logger.info("Produtos syncronizados ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Produtos erro: "+e.getMessage());
		}
	}

	private List<ProdutoModel> postData(String url, String cnpjEmpresa) throws Exception {
		String dados = super.post(url, cnpjEmpresa, null);
		return util.convertStringXmlToObjects(dados);
	}

}

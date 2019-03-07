package br.com.wadvice.rest;

import java.util.List;

import br.com.wadvice.rest.model.linx.ProdutosDetalhesModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxProdutosDetalhesUtil;

public class SincProdutoDetalhe extends SyncRest {

	private static final String URL_FILE_XML = "resources/linx/linxProdutosDetalhes.xml";
	private static final String INTEGRACAO = "linxProdutosDetalhes";
	private LinxProdutosDetalhesUtil util;
	
	public SincProdutoDetalhe() {
		super(INTEGRACAO, URL_FILE_XML, SincProdutoDetalhe.class);
		util = new LinxProdutosDetalhesUtil();
	}

	public void getData(String cnpjEmpresa) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ProdutosDetalhesModel> produtos = this.postData(config.getUrlWebService(), cnpjEmpresa);
			logger.debug(produtos.toString());
			util.gravar(cnpjEmpresa, produtos);
			logger.info("Produtos Detalhe syncronizados");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Produtos Detalhe erro: "+e.getMessage());
		}
	}
	
	private List<ProdutosDetalhesModel> postData(String url, String cnpjEmpresa) throws Exception {
		String dados = super.post(url, cnpjEmpresa, null);
		return util.convertStringXmlToObjects(dados);
	}
	
}

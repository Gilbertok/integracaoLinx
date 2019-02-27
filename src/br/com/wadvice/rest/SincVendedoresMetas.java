package br.com.wadvice.rest;

import java.util.List;

import br.com.wadvice.rest.model.linx.VendedorMetasModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxVendedorMetasUtil;

public class SincVendedoresMetas extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxVendedoresMetas.xml";
	private static final String INTEGRACAO = "LinxVendedoresMetas";
	private LinxVendedorMetasUtil util;
	
	public SincVendedoresMetas() {
		super(INTEGRACAO, URL_FILE_XML, SincVendedoresMetas.class);
		util = new LinxVendedorMetasUtil();
	}
	
	public void getData(String cnpjEmpresa) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<VendedorMetasModel> metas = this.postData(config.getUrlWebService(), cnpjEmpresa);
			logger.debug(metas.toString());
			util.gravar(metas);
			logger.info("Vendedores Metas syncronizados ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Vendedores Metas erro: "+e.getMessage());
		}
	}

	private List<VendedorMetasModel> postData(String url, String cnpjEmpresa) throws Exception {
		String dados = super.post(url, cnpjEmpresa, null);
		return util.convertStringXmlToObjects(dados);
	}

}

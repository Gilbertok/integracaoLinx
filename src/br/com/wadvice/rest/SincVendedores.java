package br.com.wadvice.rest;

import java.util.List;

import br.com.wadvice.rest.model.linx.VendedoresModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxVendedoresUtil;

public class SincVendedores extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxVendedores.xml";
	private static final String INTEGRACAO = "LinxVendedores";
	private LinxVendedoresUtil util;

	public SincVendedores() {
		super(INTEGRACAO, URL_FILE_XML, SincVendedores.class);
		util = new LinxVendedoresUtil();
	}
	
	public void getData(String cnpjEmpresa) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<VendedoresModel> vendedores = this.postData(config.getUrlWebService(), cnpjEmpresa);
			logger.debug(vendedores.toString());
			util.gravar(cnpjEmpresa, vendedores);
			logger.info("Vendedores syncronizados ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Vendedores erro: "+e.getMessage());
		}
	}

	private List<VendedoresModel> postData(String url, String cnpjEmpresa) throws Exception {
		String dados = super.post(url, cnpjEmpresa, null);
		return util.convertStringXmlToObjects(cnpjEmpresa, dados);
	}

}

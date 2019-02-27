package br.com.wadvice.rest;

import java.util.List;

import br.com.wadvice.rest.model.linx.ClientesFornecModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxClientesFornecUtil;

public class SincClientesFornec extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxDefault.xml";
	private static final String INTEGRACAO = "LinxClientesFornec";
	private LinxClientesFornecUtil util;
	
	public SincClientesFornec() {
		super(INTEGRACAO, URL_FILE_XML, SincClientesFornec.class);
		util = new LinxClientesFornecUtil();
	}

	public void getData(String cnpjEmpresa) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ClientesFornecModel> clientes = this.postData(config.getUrlWebService(), cnpjEmpresa);
			logger.debug(clientes.toString());
			util.gravar(clientes);
			logger.info("Cliente/Fornecedores syncronizados ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Cliente/Fornecedores erro: "+e.getMessage());
		}
	}

	private List<ClientesFornecModel> postData(String url, String cnpjEmpresa) throws Exception {
		String dados = super.post(url, cnpjEmpresa, null);
		return util.convertStringXmlToObjects(dados);
	}

}

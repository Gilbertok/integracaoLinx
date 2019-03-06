package br.com.wadvice.rest;

import java.util.Calendar;
import java.util.List;

import br.com.wadvice.rest.model.linx.ClientesFornecContatosModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxClientesFornecContatosUtil;

public class SincClientesFornecContatos extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxDefault.xml";
	private static final String INTEGRACAO = "LinxClientesFornecContatos";
	private LinxClientesFornecContatosUtil util;

	public SincClientesFornecContatos() {
		super(INTEGRACAO, URL_FILE_XML, SincClientesFornecContatos.class);
		util = new LinxClientesFornecContatosUtil();
	}

	public void getData(String cnpjEmpresa, Calendar data) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ClientesFornecContatosModel> contatos = this.postData(config.getUrlWebService(), cnpjEmpresa, data);
			logger.debug(contatos.toString());
			util.gravar(cnpjEmpresa, contatos);
			logger.info("Cliente/Fornecedores - Contatos syncronizados ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Cliente/Fornecedores - Contatos erro: "+e.getMessage());
		}
	}

	private List<ClientesFornecContatosModel> postData(String url, String cnpjEmpresa, Calendar data) throws Exception {
		String dados = super.post(url, cnpjEmpresa, data);
		return util.convertStringXmlToObjects(dados);
	}

}

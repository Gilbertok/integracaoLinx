package br.com.wadvice.rest;

import java.util.Calendar;
import java.util.List;

import br.com.wadvice.rest.model.linx.MovimentosNfModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxMovimentosNfUtil;

public class SincMovimentosNF extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxDefault.xml";
	private static final String INTEGRACAO = "LinxMovimento";
	private LinxMovimentosNfUtil util;
	
	public SincMovimentosNF() {
		super(INTEGRACAO, URL_FILE_XML, SincClientesFornec.class);
		util = new LinxMovimentosNfUtil();
	}
	
	public void getData(String cnpjEmpresa, Calendar data) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<MovimentosNfModel> movimentos = this.postData(config.getUrlWebService(), cnpjEmpresa, data);
			logger.debug(movimentos.toString());
			util.gravar(movimentos);
			logger.info("Movimentos NF syncronizados - "+this.logData(data));
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Movimentos NF erro: "+e.getMessage());
		}
	}
	
	public List<MovimentosNfModel> postData(String url, String cnpjEmpresa, Calendar data) throws Exception {
		String dados = super.post(url, cnpjEmpresa, data);
		return util.convertStringXmlToObjects(dados);
	}

}

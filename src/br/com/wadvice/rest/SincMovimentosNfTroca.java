package br.com.wadvice.rest;

import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.wadvice.rest.model.linx.MovimentosNfTrocaModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxMovimentosNfTrocaUtil;

public class SincMovimentosNfTroca extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxDefault.xml";
	private static final String INTEGRACAO = "LinxMovimentoTrocas";
	private LinxMovimentosNfTrocaUtil util;
	
	public SincMovimentosNfTroca() {
		super(INTEGRACAO, URL_FILE_XML, SincMovimentosNfTroca.class);
		util = new LinxMovimentosNfTrocaUtil();
	}

	public void getData(String cnpjEmpresa, Calendar data) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<MovimentosNfTrocaModel> trocas = this.postData(config.getUrlWebService(), cnpjEmpresa, data);
			logger.debug(trocas.toString());
			util.gravar(trocas);
			logger.info("Movimentos NF Troca syncronizados - "+this.logData(data));
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Movimentos NF Troca erro: "+e.getMessage());
		}
	}

	private List<MovimentosNfTrocaModel> postData(String url, String cnpjEmpresa, Calendar data) throws JAXBException {
		String dados = super.post(url, cnpjEmpresa, null);
		return util.convertStringXmlToObjects(dados);
	}

}

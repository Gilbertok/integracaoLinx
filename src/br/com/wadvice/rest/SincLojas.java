package br.com.wadvice.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.wadvice.rest.model.linx.GrupoLojasModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.convert.LinxGrupoLojasUtil;

public class SincLojas extends SyncRest {
	
	private static final String URL_FILE_XML = "resources/linx/LinxGrupoLojas.xml";
	private static final String INTEGRACAO = "LinxGrupoLojas";
	private LinxGrupoLojasUtil util;

	public SincLojas() {
		super(INTEGRACAO, URL_FILE_XML, SincLojas.class);
		util = new LinxGrupoLojasUtil();
	}
	
	public List<GrupoLojasModel> getData() {
		List<GrupoLojasModel> lojas = new ArrayList<>();
		try {
			ConfigXml config = ConfigUtils.getInstance();
			lojas = this.postData(config.getUrlWebService());
			logger.debug(lojas.toString());
			logger.info("Lojas ");
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Lojas erro: "+e.getMessage());
		}
		return lojas;
	}

	private List<GrupoLojasModel> postData(String url) throws JAXBException {
		String dados = super.post(url, null, null);
		return util.convertStringXmlToObjects(dados);
	}

}

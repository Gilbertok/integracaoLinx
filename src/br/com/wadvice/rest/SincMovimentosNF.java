package br.com.wadvice.rest;

import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.wadvice.rest.model.linx.MovimentosNfModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.DateUtils;
import br.com.wadvice.util.XmlUtils;
import br.com.wadvice.util.convert.LinxMovimentosNf;

public class SincMovimentosNF {
	
	private static final String URL_FILE_XML = "resources/LinxMovimento.xml";
	private static final Logger logger = LoggerFactory.getLogger(SincMovimentosNF.class);
	
	public void getData(String cnpjEmpresa, Calendar data) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<MovimentosNfModel> movimentos = this.postData(config.getUrlWebService(), cnpjEmpresa, data);
			logger.debug(movimentos.toString());
			LinxMovimentosNf.gravar(movimentos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MovimentosNfModel> postData(String url, String cnpjEmpresa, Calendar data) {
		HttpClient client = HttpClientBuilder.create().build();
	    try {
	    	DateUtils dateUtils = new DateUtils();
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader("Content-type", "application/xml");
	        String xmlEntity = XmlUtils.getXml(URL_FILE_XML);
	        xmlEntity = xmlEntity.replaceAll("#CNPJ_EMPRESA", cnpjEmpresa);
	        xmlEntity = xmlEntity.replaceAll("#DATA_INICIAL", dateUtils.getHoraInicial(data));
	        xmlEntity = xmlEntity.replaceAll("#DATA_FIM", dateUtils.getHoraFim(data));
			StringEntity se = new StringEntity(xmlEntity);
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));
			httppost.setEntity(se); 
			HttpResponse response = client.execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {
				return LinxMovimentosNf.convertStringXmlToObjects(EntityUtils.toString(response.getEntity()));
			} else {
				System.out.println("Erro");
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println("IntegracaoLinx.postData()");
	    }
	    return null;
	}

}

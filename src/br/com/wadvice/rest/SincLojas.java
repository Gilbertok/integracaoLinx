package br.com.wadvice.rest;

import java.util.ArrayList;
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

import br.com.wadvice.rest.model.linx.GrupoLojasModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.XmlUtils;
import br.com.wadvice.util.convert.LinxGrupoLojas;

public class SincLojas {
	
	private static final String URL_FILE_XML = "resources/LinxGrupoLojas.xml";
	private static final Logger logger = LoggerFactory.getLogger(SincLojas.class);
	
	public List<GrupoLojasModel> getData() {
		List<GrupoLojasModel> lojas = new ArrayList<>();
		try {
			ConfigXml config = ConfigUtils.getInstance();
			lojas = this.postData(config.getUrlWebService());
			logger.debug(lojas.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lojas;
	}

	private List<GrupoLojasModel> postData(String url) {
		HttpClient client = HttpClientBuilder.create().build();
	    try {
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader("Content-type", "application/xml");
			StringEntity se = new StringEntity(XmlUtils.getXml(URL_FILE_XML));
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));
			httppost.setEntity(se); 
			HttpResponse response = client.execute(httppost);
			
			if (response.getStatusLine().getStatusCode() == 200) {
				return LinxGrupoLojas.convertStringXmlToObjects(EntityUtils.toString(response.getEntity()));
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

package br.com.wadvice.rest;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import br.com.wadvice.util.DateUtils;
import br.com.wadvice.util.XmlUtils;

public class SyncRest {
	
	protected String URL_FILE_XML;
	protected String INTEGRACAO;
	protected Logger logger;
	protected SimpleDateFormat dtFormatterLog = new SimpleDateFormat("dd/MM/yyyy");
	
	public SyncRest(String urlFileXml, Class<?> class1) {
		this.URL_FILE_XML = urlFileXml;
		this.logger = LoggerFactory.getLogger(class1);
	}
	
	public SyncRest(String integracao, String urlFileXml, Class<?> class1) {
		this(urlFileXml, class1);
		this.INTEGRACAO = integracao;
	}

	protected String post(String url, String cnpjEmpresa, Calendar data) {
		HttpClient client = HttpClientBuilder.create().build();
	    try {
	    	DateUtils dateUtils = new DateUtils();
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader(new BasicHeader(HTTP.CONTENT_TYPE, "text/xml"));
	        
	        String xmlEntity = XmlUtils.getXml(URL_FILE_XML);
	        if (cnpjEmpresa != null) {
	        	xmlEntity = xmlEntity.replaceAll("#CNPJ_EMPRESA", cnpjEmpresa);
	        }
	        if (INTEGRACAO != null) {
	        	xmlEntity = xmlEntity.replaceAll("#INTEGRACAO", INTEGRACAO);
	        }
	        if (data == null) {
	        	xmlEntity = xmlEntity.replaceAll("#DATA_INICIAL", dateUtils.getInicioConfig());
	        	xmlEntity = xmlEntity.replaceAll("#DATA_FIM", dateUtils.getFimMes(null));
	        } else {
	        	xmlEntity = xmlEntity.replaceAll("#DATA_INICIAL", dateUtils.getInicioMes(data));
	        	xmlEntity = xmlEntity.replaceAll("#DATA_FIM", dateUtils.getFimMes(data));
	        }
			StringEntity se = new StringEntity(xmlEntity);
			se.setChunked(true);
			httppost.setEntity(se); 
			HttpResponse response = client.execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity(), StandardCharsets.ISO_8859_1);
			} else {
				logger.warn("Erro ao buscar "+URL_FILE_XML+" "+response.getStatusLine().getStatusCode());
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	logger.warn("Erro ao buscar "+URL_FILE_XML+" "+e.getMessage());
	    }
	    return null;
	}
	
	
	protected String logData(Calendar data) {
		DateUtils dateUtils = new DateUtils();
		return dtFormatterLog.format(dateUtils.getInicioMesDate(data)) +" a "+dtFormatterLog.format(dateUtils.getFimMesDate(data));
	}
	

}

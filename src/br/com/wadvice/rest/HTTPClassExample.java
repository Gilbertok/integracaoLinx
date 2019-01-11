package br.com.wadvice.rest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import br.com.wadvice.rest.model.ConfigXml;
import br.com.wadvice.rest.model.ProdutosDetalhes;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.LinxProdutosDetalhes;
import br.com.wadvice.util.XmlUtils;

@SuppressWarnings("deprecation")
public class HTTPClassExample {

	private static final String URL_FILE_XML = "resources/linxProdutosDetalhes.xml";

	public static void main(String[] args) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ProdutosDetalhes> produtos = postData(config.getUrlWebService());
			LinxProdutosDetalhes.gravarProdutosDetalhes(produtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({"resource"})
	public static List<ProdutosDetalhes> postData(String url) {
	    HttpParams myParams = new BasicHttpParams();
	    HttpConnectionParams.setConnectionTimeout(myParams, 10000);
	    HttpConnectionParams.setSoTimeout(myParams, 10000);

	    try {
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader("Content-type", "application/xml");
			StringEntity se = new StringEntity(XmlUtils.getXml(URL_FILE_XML));
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));
			httppost.setEntity(se); 
			HttpResponse response = new DefaultHttpClient(myParams).execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {
				return LinxProdutosDetalhes.convertStringXmlToObjects(EntityUtils.toString(response.getEntity()));
			} else {
				System.out.println("Erro");
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return null;
	}

}

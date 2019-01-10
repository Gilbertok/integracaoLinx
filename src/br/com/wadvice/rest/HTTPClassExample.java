package br.com.wadvice.rest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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

import br.com.wadvice.rest.model.ProdutosDetalhes;
import br.com.wadvice.util.LinxProdutosDetalhes;

@SuppressWarnings("deprecation")
public class HTTPClassExample {

	private static final String URL_WEBSERVICE = "https://webapi.microvix.com.br/1.0/api/integracao";
	private static final String URL_FILE_XML = "resources/linxProdutosDetalhes.xml";

	public static void main(String[] args) {
		try {
			postData(URL_WEBSERVICE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getXml() throws IOException {
		StringBuilder xml = new StringBuilder();
		FileReader arq;
		try {
			arq = new FileReader(URL_FILE_XML);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				xml.append(linha);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de xml Linx nao encontrado! ");
			e.printStackTrace();
		}
		return xml.toString();
	}
	
	@SuppressWarnings({"resource"})
	public static void postData(String url) {
	    HttpParams myParams = new BasicHttpParams();
	    HttpConnectionParams.setConnectionTimeout(myParams, 10000);
	    HttpConnectionParams.setSoTimeout(myParams, 10000);

	    try {
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader("Content-type", "application/xml");
			StringEntity se = new StringEntity(getXml());
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));
			httppost.setEntity(se); 
			HttpResponse response = new DefaultHttpClient(myParams).execute(httppost);
			if (response.getStatusLine().getStatusCode() == 200) {
				List<ProdutosDetalhes> produtos = LinxProdutosDetalhes.convertStringXmlToObjects(EntityUtils.toString(response.getEntity()));
				LinxProdutosDetalhes.gravarProdutosDetalhes(produtos);
			} else {
				System.out.println("Erro");
			}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}

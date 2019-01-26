package br.com.wadvice.rest;

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

import br.com.wadvice.rest.model.ConfigXml;
import br.com.wadvice.rest.model.ProdutosDetalhes;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.LinxProdutosDetalhes;
import br.com.wadvice.util.XmlUtils;

public class IntegracaoLinx {

	private static final String URL_FILE_XML = "resources/linxProdutosDetalhes.xml";
	private static final Logger logger = LoggerFactory.getLogger(IntegracaoLinx.class);

	public static void main(String[] args) {
		try {
			System.out.println("INICIO");
			new IntegracaoLinx().getProdutoDetalhe();
			System.out.println("FIM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getProdutoDetalhe() {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ProdutosDetalhes> produtos = postData(config.getUrlWebService());
			logger.debug(produtos.toString());
			LinxProdutosDetalhes.gravarProdutosDetalhes(produtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ProdutosDetalhes> postData(String url) {
		HttpClient client = HttpClientBuilder.create().build();
	    try {
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader("Content-type", "application/xml");
			StringEntity se = new StringEntity(XmlUtils.getXml(URL_FILE_XML));
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/xml"));
			httppost.setEntity(se); 
			HttpResponse response = client.execute(httppost);
			
			if (response.getStatusLine().getStatusCode() == 200) {
				return LinxProdutosDetalhes.convertStringXmlToObjects(EntityUtils.toString(response.getEntity()));
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

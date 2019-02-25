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

import br.com.wadvice.rest.model.linx.ProdutosDetalhesModel;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import br.com.wadvice.util.XmlUtils;
import br.com.wadvice.util.convert.LinxProdutosDetalhes;

public class SincProdutoDetalhe {

	private static final String URL_FILE_XML = "resources/linxProdutosDetalhes.xml";
	private static final Logger logger = LoggerFactory.getLogger(SincProdutoDetalhe.class);

	public void getData(String cnpjEmpresa) {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			List<ProdutosDetalhesModel> produtos = this.postData(config.getUrlWebService(), cnpjEmpresa);
			logger.debug(produtos.toString());
			LinxProdutosDetalhes.gravarProdutosDetalhes(produtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ProdutosDetalhesModel> postData(String url, String cnpjEmpresa) {
		HttpClient client = HttpClientBuilder.create().build();
	    try {
	        HttpPost httppost = new HttpPost(url.toString());
	        httppost.setHeader("Content-type", "application/xml");
	        String xmlEntity = XmlUtils.getXml(URL_FILE_XML);
	        xmlEntity = xmlEntity.replaceAll("#CNPJ_EMPRESA", cnpjEmpresa);
			StringEntity se = new StringEntity(xmlEntity);
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

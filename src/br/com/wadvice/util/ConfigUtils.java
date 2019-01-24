package br.com.wadvice.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.wadvice.rest.model.ConfigXml;

public class ConfigUtils {
	
	private static final String URL_CONFIG_XML = "resources/config.xml";
	
	private static ConfigXml config;
	
	private ConfigUtils() {}
	
	public static ConfigXml getInstance() {
		if(config == null) {
			config = new ConfigUtils().getConfig();
		}
		return config;
	}
	
	private ConfigXml getConfig() {
		try {
			StringReader reader = new StringReader(XmlUtils.getXml(URL_CONFIG_XML));
			JAXBContext context = JAXBContext.newInstance(ConfigXml.class);
			config = (ConfigXml) context.createUnmarshaller().unmarshal(reader);
			System.out.println("--- Arquivo de configuraçãp OK -----");
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return config;
	}

}

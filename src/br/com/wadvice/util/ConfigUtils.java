package br.com.wadvice.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.wadvice.rest.model.xml.ConfigXml;

public class ConfigUtils {
	
	private static final String URL_CONFIG_XML = "resources/config.xml";
	private static final Logger logger = LoggerFactory.getLogger(ConfigUtils.class);
	
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
			logger.info("--- Arquivo de configuraçãp OK -----");
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.error("Erro ao buscar arquivo de configuração "+e.getMessage());
		} catch (IOException e2) {
			e2.printStackTrace();
			logger.error("Erro ao buscar arquivo de configuração "+e2.getMessage());
		}
		return config;
	}

}

package br.com.wadvice.util.convert;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.wadvice.rest.model.xml.Microvix;

public class ConvertUtil {
	
	protected Microvix parseXml(String xml) throws JAXBException {
		xml = xml.replaceAll("﻿", "");
		xml = new String(xml.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		StringReader reader = new StringReader(xml);
		JAXBContext context = JAXBContext.newInstance(Microvix.class);
		return (Microvix) context.createUnmarshaller().unmarshal(reader);
	}

}

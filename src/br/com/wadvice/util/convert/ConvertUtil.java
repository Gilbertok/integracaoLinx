package br.com.wadvice.util.convert;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import br.com.wadvice.rest.model.xml.Microvix;

public class ConvertUtil {
	
	protected Microvix parseXml(String xml) throws JAXBException {
		try {
			xml = xml.replaceAll("﻿", "");
			xml = new String(xml.getBytes(), "UTF-8");
			StringReader reader = new StringReader(xml);
			JAXBContext context = JAXBContext.newInstance(Microvix.class);
			return (Microvix) context.createUnmarshaller().unmarshal(reader);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}

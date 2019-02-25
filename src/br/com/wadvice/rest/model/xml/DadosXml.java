package br.com.wadvice.rest.model.xml;

import javax.xml.bind.annotation.XmlElement;

public class DadosXml {
	
	private String[] valores;

	@XmlElement(name="D")
	public String[] getValor() {
		return valores;
	}

	public void setValor(String[] valores) {
		this.valores = valores;
	}

}

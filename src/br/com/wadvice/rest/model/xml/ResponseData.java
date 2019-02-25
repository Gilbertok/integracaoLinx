package br.com.wadvice.rest.model.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ResponseData {
	
	private DadosXml cabecalho;
	private List<DadosXml> registros = new ArrayList<DadosXml>();

	@XmlElement(name="C")
	public DadosXml getChave() {
		return cabecalho;
	}

	public void setChave(DadosXml chave) {
		this.cabecalho = chave;
	}

	@XmlElement(name="R")
	public List<DadosXml> getResultados() {
		return registros;
	}

	public void setResultados(List<DadosXml> resultados) {
		this.registros = resultados;
	}
}

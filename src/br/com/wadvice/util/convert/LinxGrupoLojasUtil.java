package br.com.wadvice.util.convert;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.wadvice.rest.model.linx.GrupoLojasModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxGrupoLojasUtil extends ConvertUtil {

	public List<GrupoLojasModel> convertStringXmlToObjects(String xml) throws JAXBException {
		List<GrupoLojasModel> lojas = new ArrayList<GrupoLojasModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		
		for (DadosXml dadosXml : registros) {
			GrupoLojasModel loja = new GrupoLojasModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				switch (cabecalhos[i]) {
				case "portal":
					loja.setPortal(dadosXml.getValor()[i]);
					continue;
				case "CNPJ":
					loja.setCnpjEmpresa(dadosXml.getValor()[i]);
					continue;
				case "nome_empresa":
					loja.setNomeEmpresa(dadosXml.getValor()[i]);
					continue;
				case "id_empresas_rede":
					loja.setIdEmpresasRede(dadosXml.getValor()[i]);
					continue;
				case "rede":
					loja.setRede(dadosXml.getValor()[i]);
					continue;
				case "nome_portal":
					loja.setNomePortal(dadosXml.getValor()[i]);
					continue;
				default:
					break;
				}
			}
			lojas.add(loja);
		}
	
		return lojas;
	}

}

package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.wadvice.db.dao.MovimentosNfTrocaDao;
import br.com.wadvice.rest.model.linx.MovimentosNfTrocaModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxMovimentosNfTrocaUtil extends ConvertUtil {

	public List<MovimentosNfTrocaModel> convertStringXmlToObjects(String xml) throws JAXBException {
		List<MovimentosNfTrocaModel> trocas = new ArrayList<MovimentosNfTrocaModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			MovimentosNfTrocaModel troca = new MovimentosNfTrocaModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					troca.setPortal(valor);
					continue;
				case "cnpj_emp":
					troca.setCnpjEmpresa(valor);
					continue;
				case "identificador":
					troca.setIdentificador(valor);
					continue;
				case "num_vale":
					troca.setNumVale(valor);;
					continue;
				case "valor_vale":
					troca.setValorVale(valor);
					continue;
				case "motivo":
					troca.setMotivo(valor);
					continue;
				case "doc_origem":
					troca.setDocOrigem(valor);
					continue;
				case "serie_origem":
					troca.setSerieOrigem(valor);
					continue;
				case "doc_venda":
					troca.setDocVenda(valor);
					continue;
				case "serie_venda":
					troca.setSerieVenda(valor);
					continue;
				default:
					break;
				}
			}
			trocas.add(troca);
		}
		return trocas;
	}

	public void gravar(List<MovimentosNfTrocaModel> trocas) throws SQLException {
		MovimentosNfTrocaDao dao = new MovimentosNfTrocaDao();
		dao.gravarLista(trocas);
	}

}

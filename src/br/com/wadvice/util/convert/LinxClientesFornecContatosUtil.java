package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.ClientesFornecContatosDao;
import br.com.wadvice.rest.model.linx.ClientesFornecContatosModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxClientesFornecContatosUtil extends ConvertUtil {

	public void gravar(String cnpjEmpresa, List<ClientesFornecContatosModel> contatos) throws SQLException {
		ClientesFornecContatosDao dao = new ClientesFornecContatosDao();
		dao.gravarLista(cnpjEmpresa, contatos);
	}

	public List<ClientesFornecContatosModel> convertStringXmlToObjects(String xml) throws Exception {
		List<ClientesFornecContatosModel> contatos = new ArrayList<ClientesFornecContatosModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			ClientesFornecContatosModel contato = new ClientesFornecContatosModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					contato.setPortal(valor);
					continue;
				case "cod_cliente":
					contato.setCodigoCliente(valor);
					continue;
				case "nome_contato":
					contato.setNomeContato(valor);
					continue;
				case "sexo_contato":
					contato.setSexo(valor);
					continue;
				case "contatos_clientes_parentesco":
					contato.setParentesco(valor);
					continue;
				case "fone1_contato":
					contato.setTelefone1(valor);
					continue;
				case "fone2_contato":
					contato.setTelefone2(valor);
					continue;
				case "celular_contato":
					contato.setCelular(valor);
					continue;
				case "email_contato":
					contato.setEmail(valor);
					continue;
				case "data_nasc_contato":
					contato.setDataNascimento(valor);
					continue;
				case "tipo_contato":
					contato.setTipo(valor);
					continue;
				default:
					break;
				}
			}
			contatos.add(contato);
		}
		return contatos;
	}

}

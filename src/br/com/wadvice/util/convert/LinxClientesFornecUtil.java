package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.ClientesFornecDao;
import br.com.wadvice.rest.model.linx.ClientesFornecModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxClientesFornecUtil extends ConvertUtil {
	
	public List<ClientesFornecModel> convertStringXmlToObjects(String xml) throws Exception {
		List<ClientesFornecModel> clientes = new ArrayList<ClientesFornecModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			ClientesFornecModel cliente = new ClientesFornecModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					cliente.setPortal(valor);
					continue;
				case "cod_cliente":
					cliente.setCodigoCliente(valor.trim());
					continue;
				case "razao_cliente":
					cliente.setRazao(valor);
					continue;
				case "nome_cliente":
					cliente.setNome(valor);
					continue;
				case "doc_cliente":
					cliente.setCpfCnpj(valor.trim());
					continue;
				case "tipo_cliente":
					cliente.setTipoCliente(valor);
					continue;
				case "endereco_cliente":
					cliente.setEndereco(valor);
					continue;
				case "numero_rua_cliente":
					cliente.setNumero(valor);
					continue;
				case "complement_end_cli":
					cliente.setComplemento(valor);
					continue;
				case "bairro_cliente":
					cliente.setBairro(valor);
					continue;
				case "cep_cliente":
					cliente.setCep(valor);
					continue;
				case "cidade_cliente":
					cliente.setCidade(valor);
					continue;
				case "uf_cliente":
					cliente.setUf(valor);
					continue;
				case "pais":
					cliente.setPais(valor);
					continue;
				case "fone_cliente":
					cliente.setTelefone(valor);
					continue;
				case "email_cliente":
					cliente.setEmail(valor);
					continue;
				case "sexo":
					cliente.setSexo(valor);
					continue;
				case "data_cadastro":
					cliente.setDataCadastro(valor);
					continue;
				case "data_nascimento":
					cliente.setDataNasciemnto(valor);
					continue;
				case "cel_cliente":
					cliente.setCelular(valor);
					continue;
				case "ativo":
					cliente.setAtivo(valor);
					continue;
				case "dt_update":
					cliente.setDataUpdate(valor);
					continue;
				case "inscricao_estadual":
					cliente.setInscricaoEstadual(valor);
					continue;
				case "incricao_municipal":
					cliente.setInscricaoMunicipal(valor);
					continue;
				case "identidade_cliente":
					cliente.setIdEstadoCivil(valor);
					continue;
				case "cartao_fidelidade":
					cliente.setCartaoFidelidade(valor);
					continue;
				case "cod_ibge_municipio":
					cliente.setCodigoIbgeMunicipio(valor);
					continue;
				case "classe_cliente":
					cliente.setClasse(valor);
					continue;
				case "matricula_conveniado":
					cliente.setMatricula(valor);
					continue;
				case "tipo_cadastro":
					cliente.setTipoCadastro(valor);
					continue;
				case "empresa_cadastro":
					cliente.setEmpresa(valor);
					continue;
				case "id_estado_civil":
					cliente.setIdEstadoCivil(valor);
					continue;
				case "fax_cliente":
					cliente.setFax(valor);
					continue;
				case "site_cliente":
					cliente.setSite(valor);
					continue;
				default:
					break;
				}
			}
			clientes.add(cliente);
		}

		return clientes;
	}

	public void gravar(List<ClientesFornecModel> clientes) throws SQLException {
		ClientesFornecDao dao = new ClientesFornecDao();
		dao.gravarLista(clientes);
	}

}

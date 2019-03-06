package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.VendedorDao;
import br.com.wadvice.rest.model.linx.VendedoresModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxVendedoresUtil extends ConvertUtil {
	
	public void gravar(String cnpjEmpresa, List<VendedoresModel> vendedores) throws SQLException {
		VendedorDao dao = new VendedorDao();
		dao.gravarLista(cnpjEmpresa, vendedores);
	}

	public List<VendedoresModel> convertStringXmlToObjects(String cnpjEmpresa, String xml) throws Exception {
		List<VendedoresModel> vendedores = new ArrayList<VendedoresModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			VendedoresModel vendedor = new VendedoresModel();
			vendedor.setCnpjEmpresa(cnpjEmpresa);
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					vendedor.setPortal(valor);
					continue;
				case "cod_vendedor":
					vendedor.setCodigoVendedor(valor);;
					continue;
				case "nome_vendedor":
					vendedor.setNome(valor);
					continue;
				case "tipo_vendedor":
					vendedor.setTipo(valor);
					continue;
				case "end_vend_rua":
					vendedor.setEndereco(valor);
					continue;
				case "end_vend_numero":
					vendedor.setEndNumero(valor);
					continue;
				case "end_vend_complemento":
					vendedor.setEndComplemento(valor);
					continue;
				case "end_vend_bairro":
					vendedor.setBairro(valor);
					continue;
				case "end_vend_cep":
					vendedor.setCep(valor);
					continue;
				case "end_vend_cidade":
					vendedor.setCidade(valor);
					continue;
				case "end_vend_uf":
					vendedor.setUf(valor);
					continue;
				case "fone_vendedor":
					vendedor.setTelefone(valor);
					continue;
				case "mail_vendedor":
					vendedor.setEmail(valor);
					continue;
				case "dt_upd":
					vendedor.setDataUpdate(valor);
				case "cpf_vendedor":
					vendedor.setCpf(valor);
					continue;
				case "ativo":
					vendedor.setAtivo(valor);
					continue;
				case "data_admissao":
					vendedor.setDataAdminissao(valor);
					continue;
				case "data_saida":
					vendedor.setDataSaida(valor);
					continue;
				default:
					break;
				}
			}
			vendedores.add(vendedor);
		}
		return vendedores;
	}

}

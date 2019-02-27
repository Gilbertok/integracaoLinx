package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.VendedorMetasDao;
import br.com.wadvice.rest.model.linx.VendedorMetasModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxVendedorMetasUtil extends ConvertUtil {

	public void gravar(List<VendedorMetasModel> metas) throws SQLException {
		VendedorMetasDao dao = new VendedorMetasDao();
		dao.gravarLista(metas);
	}

	public List<VendedorMetasModel> convertStringXmlToObjects(String xml) throws Exception {
		List<VendedorMetasModel> vendedores = new ArrayList<VendedorMetasModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			VendedorMetasModel vendedor = new VendedorMetasModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					vendedor.setPortal(valor);
					continue;
				case "cnpj_emp":
					vendedor.setCnpjEmpresa(valor);
					continue;
				case "id_meta":
					vendedor.setIdMeta(valor);
					continue;
				case "descricao_meta":
					vendedor.setDescricao(valor);
					continue;
				case "data_inicial_meta":
					vendedor.setDataInicial(valor);
					continue;
				case "data_final_meta":
					vendedor.setDataFinal(valor);
					continue;
				case "valor_meta_loja":
					vendedor.setValorLoja(valor);
					continue;
				case "valor_meta_vendedor":
					vendedor.setValorVendedor(valor);
					continue;
				case "cod_vendedor":
					vendedor.setCodigoVendedor(valor);
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

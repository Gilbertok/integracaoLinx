package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.VendedorMetasDao;
import br.com.wadvice.rest.model.linx.VendedorMetasModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxVendedorMetasUtil extends ConvertUtil {

	public void gravar(String cnpjEmpresa, List<VendedorMetasModel> metas) throws SQLException {
		VendedorMetasDao dao = new VendedorMetasDao();
		dao.gravarLista(cnpjEmpresa, metas);
	}

	public List<VendedorMetasModel> convertStringXmlToObjects(String cnpjEmpresa, String xml) throws Exception {
		List<VendedorMetasModel> metas = new ArrayList<VendedorMetasModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		for (DadosXml dadosXml : registros) {
			VendedorMetasModel meta = new VendedorMetasModel();
			meta.setCnpjEmpresa(cnpjEmpresa);
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					meta.setPortal(valor);
					continue;
				case "cnpj_emp":
					meta.setCnpjEmpresa(valor);
					continue;
				case "id_meta":
					meta.setIdMeta(valor);
					continue;
				case "descricao_meta":
					meta.setDescricao(valor);
					continue;
				case "data_inicial_meta":
					meta.setDataInicial(valor);
					continue;
				case "data_final_meta":
					meta.setDataFinal(valor);
					continue;
				case "valor_meta_loja":
					meta.setValorLoja(valor);
					continue;
				case "valor_meta_vendedor":
					meta.setValorVendedor(valor);
					continue;
				case "cod_vendedor":
					meta.setCodigoVendedor(valor);
					continue;
				default:
					break;
				}
			}
			metas.add(meta);
		}
		return metas;
	}

}

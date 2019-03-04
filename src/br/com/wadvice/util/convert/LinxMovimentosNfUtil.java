package br.com.wadvice.util.convert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wadvice.db.dao.MovimentosNfDao;
import br.com.wadvice.rest.model.linx.MovimentosNfModel;
import br.com.wadvice.rest.model.xml.DadosXml;
import br.com.wadvice.rest.model.xml.Microvix;

public class LinxMovimentosNfUtil extends ConvertUtil {
	
	public void gravar(List<MovimentosNfModel> movimentos) throws SQLException {
		MovimentosNfDao dao = new MovimentosNfDao();
		dao.gravarLista(movimentos);
	}

	public List<MovimentosNfModel> convertStringXmlToObjects(String xml) throws Exception {
		List<MovimentosNfModel> movimentos = new ArrayList<MovimentosNfModel>();
		Microvix result = super.parseXml(xml);
		String[] cabecalhos = result.getResponseData().getChave().getValor();
		List<DadosXml> registros = result.getResponseData().getResultados();
		
		for (DadosXml dadosXml : registros) {
			MovimentosNfModel movimento = new MovimentosNfModel();
			for (int i = 0; i < cabecalhos.length; i++) {
				String valor = dadosXml.getValor()[i];
				switch (cabecalhos[i]) {
				case "portal":
					movimento.setPortal(valor);
					continue;
				case "cnpj_emp":
					movimento.setCnpjEmpresa(valor);
					continue;
				case "transacao":
					movimento.setTransacao(valor);
					continue;
				case "usuario":
					movimento.setUsuario(valor);
					continue;
				case "documento":
					movimento.setDocumento(valor);;
					continue;
				case "chave_nf":
					movimento.setChaveNf(valor);;
					continue;
				case "ecf":
					movimento.setEcf(valor);;
					continue;
				case "numero_serie_ecf":
					movimento.setNrSerEcf(valor);
					continue;
				case "modelo_nf":
					movimento.setModeloNf(valor);
					continue;
				case "data_documento":
					movimento.setDataDocuemnto(valor);
					continue;
				case "data_lancamento":
					movimento.setDataLancamento(valor);
					continue;
				case "codigo_cliente":
					movimento.setCodigoCliente(valor);
					continue;
				case "serie":
					movimento.setSerie(valor);
					continue;
				case "desc_cfop":
					movimento.setDescCfop(valor);
					continue;
				case "id_cfop":
					movimento.setIdCfop(valor);
					continue;
				case "cod_vendedor":
					movimento.setCodigoVendedor(valor);
					continue;
				case "quantidade":
					movimento.setQuantidade(valor);
					continue;
				case "preco_custo":
					movimento.setPrecoCusto(valor);
					continue;
				case "valor_liquido":
					movimento.setValorLiquido(valor);
					continue;
				case "desconto":
					movimento.setDesconto(valor);
					continue;
				case "cst_icms":
					movimento.setCstIcms(valor);
					continue;
				case "cst_pis":
					movimento.setCstPis(valor);
					continue;
				case "cst_cofins":
					movimento.setCstCofins(valor);
					continue;
				case "cst_ipi":
					movimento.setCstIpi(valor);
					continue;
				case "valor_icms":
					movimento.setValorIcms(valor);
					continue;
				case "aliquota_icms":
					movimento.setAliquotaIcms(valor);
					continue;
				case "base_icms":
					movimento.setBaseIcms(valor);
					continue;
				case "valor_pis":
					movimento.setValorPis(valor);
					continue;
				case "aliquota_pis":
					movimento.setAliquotaPis(valor);
					continue;
				case "base_pis":
					movimento.setBasePis(valor);
					continue;
				case "valor_cofins":
					movimento.setValorCofins(valor);
					continue;
				case "aliquota_cofins":
					movimento.setAliquotaCofins(valor);
					continue;
				case "base_cofins":
					movimento.setBaseCofins(valor);
					continue;
				case "valor_icms_st":
					movimento.setValorIcmsSt(valor);
					continue;
				case "aliquota_icms_st":
					movimento.setAliquotaIcmsSt(valor);
					continue;
				case "base_icms_st":
					movimento.setBaseIcmsSt(valor);
					continue;
				case "valor_ipi":
					movimento.setValorIPI(valor);
					continue;
				case "aliquota_ipi":
					movimento.setAliquotaIPI(valor);
					continue;
				case "base_ipi":
					movimento.setBaseIPI(valor);
					continue;
				case "valor_total":
					movimento.setValorTotal(valor);
					continue;
				case "forma_dinheiro":
					movimento.setFormaDinheiro(valor);
					continue;
				case "total_dinheiro":
					movimento.setTotalDinheiro(valor);
					continue;
				case "forma_cheque":
					movimento.setFormaCheque(valor);
					continue;
				case "total_cheque":
					movimento.setTotalCheque(valor);
					continue;
				case "forma_cartao":
					movimento.setFormaCartao(valor);
					continue;
				case "total_cartao":
					movimento.setTotalCartao(valor);
					continue;
				case "forma_crediario":
					movimento.setFormaCrediario(valor);
					continue;
				case "total_crediario":
					movimento.setTotalCrediario(valor);
					continue;
				case "forma_convenio":
					movimento.setFormaConvenio(valor);
					continue;
				case "total_convenio":
					movimento.setTotalConvenio(valor);
					continue;
				case "frete":
					movimento.setFrete(valor);
					continue;
				case "operacao":
					movimento.setOperacao(valor);
					continue;
				case "tipo_transacao":
					movimento.setTipoTransacao(valor);
					continue;
				case "cod_produto":
					movimento.setCodigoProduto(valor);
					continue;
				case "cod_barra":
					movimento.setCodigoBarra(valor);
					continue;
				case "cancelado":
					movimento.setCancelado(valor);
					continue;
				case "excluido":
					movimento.setExcluido(valor);
					continue;
				case "soma_relatorio":
					movimento.setSomaRelatorio(valor);
					continue;
				case "identificador":
					movimento.setIdentificador(valor);
					continue;
				case "deposito":
					movimento.setDeposito(valor);
					continue;
				case "obs":
					movimento.setObservacao(valor);
					continue;
				case "preco_unitario":
					movimento.setPrecoUnitario(valor);
					continue;
				case "hora_lancamento":
					movimento.setHoraLancamento(valor);
					continue;
				case "natureza_operacao":
					movimento.setNaturezaOperacao(valor);
					continue;
				case "tabela_preco":
					movimento.setTabelaPreco(valor);
					continue;
				case "nome_tabela_preco":
					movimento.setNomeTabelaPreco(valor);
					continue;
				case "cod_sefaz_situacao":
					movimento.setCodigoSefazSituacao(valor);
					continue;
				case "desc_sefaz_situacao":
					movimento.setDescSefazSituacao(valor);
					continue;
				case "protocolo_aut_nfe":
					movimento.setProtocoloAutNfe(valor);
					continue;
				case "dt_update":
					movimento.setDataUpdate(valor);
					continue;
				case "forma_cheque_prazo":
					movimento.setFormaChequePrazo(valor);
					continue;
				case "total_cheque_prazo":
					movimento.setTotalChequePrazo(valor);
					continue;
				case "cod_natureza_operacao":
					movimento.setCodigoNaturezaOperacao(valor);
					continue;
				case "preco_tabela_epoca":
					movimento.setPrecoTabelaEpoca(valor);
					continue;
				case "desconto_total_item":
					movimento.setDescontoTotalItem(valor);
					continue;
				case "conferido":
					movimento.setConferido(valor);
					continue;
				default:
					break;
				}
			}
			movimentos.add(movimento);
		}
		return movimentos;
	}

}

package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.MovimentosNfModel;

public class MovimentosNfDao extends DefaultDao {
	
	private String sqlCreate = "CREATE TABLE WAD_LINX_MOV_NF (" + 
								"   PORTAL NUMBER, " + 
								"	CNPJ_EMP VARCHAR2(14 BYTE), " + 
								"	TRANSACAO NUMBER(*,0), " + 
								"	USUARIO NUMBER(*,0), " + 
								"	DOCUMENTO NUMBER(*,0), " + 
								"	CHAVE_NF VARCHAR2(44 BYTE), " + 
								"	ECF NUMBER(*,0), " + 
								"	NUMERO_SERIE_ECF VARCHAR2(30 BYTE), " + 
								"	MODELO_NF NUMBER(*,0), " + 
								"	DATA_DOCUMENTO DATE, " + 
								"	DATA_LANCAMENTO DATE, " + 
								"	CODIGO_CLIENTE NUMBER(*,0), " + 
								"	SERIE VARCHAR2(10 BYTE), " + 
								"	DESC_CFOP VARCHAR2(200 BYTE), " + 
								"	ID_CFOP VARCHAR2(5 BYTE), " + 
								"	COD_VENDEDOR NUMBER(*,0), " + 
								"	QUANTIDADE FLOAT(126), " + 
								"	PRECO_CUSTO FLOAT(126), " + 
								"	VALOR_LIQUIDO FLOAT(126), " + 
								"	DESCONTO FLOAT(126), " + 
								"	CST_ICMS VARCHAR2(5 BYTE), " + 
								"	CST_PIS VARCHAR2(5 BYTE), " + 
								"	CST_COFINS VARCHAR2(5 BYTE), " + 
								"	CST_IPI VARCHAR2(5 BYTE), " + 
								"	VALOR_ICMS FLOAT(126), " + 
								"	ALIQUOTA_ICMS FLOAT(126), " + 
								"	BASE_ICMS FLOAT(126), " + 
								"	VALOR_PIS FLOAT(126), " + 
								"	ALIQUOTA_PIS FLOAT(126), " + 
								"	BASE_PIS FLOAT(126), " + 
								"	VALOR_COFINS FLOAT(126), " + 
								"	ALIQUOTA_COFINS FLOAT(126), " + 
								"	BASE_COFINS FLOAT(126), " + 
								"	VALOR_ICMS_ST FLOAT(126), " + 
								"	ALIQUOTA_ICMS_ST FLOAT(126), " + 
								"	BASE_ICMS_ST FLOAT(126), " + 
								"	VALOR_IPI FLOAT(126), " + 
								"	ALIQUOTA_IPI FLOAT(126), " + 
								"	BASE_IPI FLOAT(126), " + 
								"	VALOR_TOTAL FLOAT(126), " + 
								"	FORMA_DINHEIRO NUMBER(*,0), " + 
								"	TOTAL_DINHEIRO FLOAT(126), " + 
								"	FORMA_CHEQUE NUMBER(*,0), " + 
								"	TOTAL_CHEQUE FLOAT(126), " + 
								"	FORMA_CARTAO NUMBER(*,0), " + 
								"	TOTAL_CARTAO FLOAT(126), " + 
								"	FORMA_CREDIARIO NUMBER, " + 
								"	TOTAL_CREDIARIO FLOAT(126), " + 
								"	FORMA_CONVENIO NUMBER, " + 
								"	TOTAL_CONVENIO FLOAT(126), " + 
								"	FRETE FLOAT(126), " + 
								"	OPERACAO VARCHAR2(2 BYTE), " + 
								"	TIPO_TRANSACAO VARCHAR2(1 BYTE), " + 
								"	COD_PRODUTO VARCHAR2(20 BYTE), " + 
								"	COD_BARRA VARCHAR2(20 BYTE), " + 
								"	CANCELADO VARCHAR2(1 BYTE), " + 
								"	EXCLUIDO VARCHAR2(1 BYTE), " + 
								"	SOMA_RELATORIO VARCHAR2(1 BYTE), " + 
								"	IDENTIFICADOR VARCHAR2(40 BYTE) NOT NULL ENABLE, " + 
								"	DEPOSITO VARCHAR2(100 BYTE), " + 
								"	OBS VARCHAR2(400 BYTE), " + 
								"	PRECO_UNITARIO FLOAT(126), " + 
								"	HORA_LANCAMENTO DATE, " + 
								"	NATUREZA_OPERACAO VARCHAR2(100 BYTE), " + 
								"	TABELA_PRECO NUMBER, " + 
								"	NOME_TABELA_PRECO VARCHAR2(50 BYTE), " + 
								"	COD_SEFAZ_SITUACAO NUMBER, " + 
								"	DESC_SEFAZ_SITUACAO VARCHAR2(30 BYTE), " + 
								"	PROTOCOLO_AUT_NFE VARCHAR2(15 BYTE), " + 
								"	DT_UPDATE DATE, " + 
								"	FORMA_CHEQUE_PRAZO NUMBER(1,0), " + 
								"	TOTAL_CHEQUE_PRAZO FLOAT(126), " + 
								"	COD_NATUREZA_OPERACAO FLOAT(126), " + 
								"	PRECO_TABELA_EPOCA FLOAT(126), " + 
								"	DESCONTO_TOTAL_ITEM FLOAT(126), " + 
								"	CONFERIDO VARCHAR2(1 BYTE), " + 
								"	CONSTRAINT WAD_LINX_MOV_NF_PK PRIMARY KEY (TRANSACAO),"+
								"	CONSTRAINT WAD_LINX_MOV_NF_UK1 UNIQUE (CNPJ_EMP, TRANSACAO))";
	private String nomeTabela = "WAD_LINX_MOV_NF";

	public MovimentosNfDao() {
		super();
		this.setNomeTabela(nomeTabela);
		this.setSqlCreate(sqlCreate);
	}

	public void gravarLista(List<MovimentosNfModel> movimentos) throws SQLException {
		this.criaCasoNaoExista();
		for (MovimentosNfModel movimento : movimentos) {
			if(movimento.getIdentificador() != null && !movimento.getIdentificador().isEmpty()) {
				if (this.exists(movimento.getCnpjEmpresa(), movimento.getTransacao())) {
					this.update(movimento);
				} else {
					this.insert(movimento);
				}
			}
		}
	}
	
	private Boolean exists(String cnpj, Integer transacao) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_MOV_NF MOV WHERE MOV.CNPJ_EMP = ? AND MOV.TRANSACAO = ? ";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setString(1, cnpj);
			stmt.setInt(2, transacao);
			stmt.setMaxRows(1);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				exists = true;
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	private void insert(MovimentosNfModel movimento) throws SQLException {
		String query = "INSERT INTO WAD_LINX_MOV_NF " + 
						"    (PORTAL, CNPJ_EMP, TRANSACAO, USUARIO, DOCUMENTO, " +
						"	CHAVE_NF, ECF, NUMERO_SERIE_ECF, MODELO_NF, DATA_DOCUMENTO, " +
						"	DATA_LANCAMENTO, CODIGO_CLIENTE, SERIE, DESC_CFOP, ID_CFOP, " +
						"	COD_VENDEDOR, QUANTIDADE, PRECO_CUSTO, VALOR_LIQUIDO, DESCONTO, " +
						"	CST_ICMS, CST_PIS, CST_COFINS, CST_IPI, VALOR_ICMS, " +
						"	ALIQUOTA_ICMS, BASE_ICMS, VALOR_PIS, ALIQUOTA_PIS, BASE_PIS, " +
						"	VALOR_COFINS, ALIQUOTA_COFINS, BASE_COFINS, VALOR_ICMS_ST, ALIQUOTA_ICMS_ST, " +
						"	BASE_ICMS_ST, VALOR_IPI, ALIQUOTA_IPI, BASE_IPI, VALOR_TOTAL, " +
						"	FORMA_DINHEIRO, TOTAL_DINHEIRO, FORMA_CHEQUE, TOTAL_CHEQUE, FORMA_CARTAO, " +
						"	TOTAL_CARTAO, FORMA_CREDIARIO, TOTAL_CREDIARIO, FORMA_CONVENIO, TOTAL_CONVENIO, " +
						"	FRETE, OPERACAO, TIPO_TRANSACAO, COD_PRODUTO, COD_BARRA, " +
						"	CANCELADO, EXCLUIDO, SOMA_RELATORIO, IDENTIFICADOR, DEPOSITO, " +
						"	OBS, PRECO_UNITARIO, HORA_LANCAMENTO, NATUREZA_OPERACAO, TABELA_PRECO," +
						"	NOME_TABELA_PRECO, COD_SEFAZ_SITUACAO, DESC_SEFAZ_SITUACAO, PROTOCOLO_AUT_NFE, DT_UPDATE, " +
						"	FORMA_CHEQUE_PRAZO, TOTAL_CHEQUE_PRAZO, COD_NATUREZA_OPERACAO, PRECO_TABELA_EPOCA, DESCONTO_TOTAL_ITEM, " +
						"	CONFERIDO) " + 
						"VALUES " + 
						"    (?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, movimento.getPortal());
		stmt.setString(2, movimento.getCnpjEmpresa());
		stmt.setInt(3, movimento.getTransacao());
		stmt.setInt(4, movimento.getUsuario());
		stmt.setInt(5, movimento.getDocumento());
		stmt.setString(6, movimento.getChaveNf());
		stmt.setInt(7, movimento.getEcf());
		stmt.setString(8, movimento.getNrSerEcf());
		stmt.setInt(9, movimento.getModeloNf());
		stmt.setDate(10, new Date(movimento.getDataDocuemnto().getTime()));
		stmt.setDate(11, new Date(movimento.getDataLancamento().getTime()));
		stmt.setInt(12, movimento.getCodigoCliente());
		stmt.setString(13, movimento.getSerie());
		stmt.setString(14, movimento.getDescCfop());
		stmt.setString(15, movimento.getIdCfop());
		stmt.setInt(16, movimento.getCodigoVendedor());
		stmt.setFloat(17, movimento.getQuantidade());
		stmt.setFloat(18, movimento.getPrecoCusto());
		stmt.setFloat(19, movimento.getValorLiquido());
		stmt.setFloat(20, movimento.getDesconto());
		stmt.setString(21, movimento.getCstIcms());
		stmt.setString(22, movimento.getCstPis());
		stmt.setString(23, movimento.getCstCofins());
		stmt.setString(24, movimento.getCstIpi());
		stmt.setFloat(25, movimento.getValorIcms());
		stmt.setFloat(26, movimento.getAliquotaIcms());
		stmt.setFloat(27, movimento.getBaseIcms());
		stmt.setFloat(28, movimento.getValorPis());
		stmt.setFloat(29, movimento.getAliquotaPis());
		stmt.setFloat(30, movimento.getBasePis());
		stmt.setFloat(31, movimento.getValorCofins());
		stmt.setFloat(32, movimento.getAliquotaCofins());
		stmt.setFloat(33, movimento.getBaseCofins());
		stmt.setFloat(34, movimento.getValorIcmsSt());
		stmt.setFloat(35, movimento.getAliquotaIcmsSt());
		stmt.setFloat(36, movimento.getBaseIcmsSt());
		stmt.setFloat(37, movimento.getValorIPI());
		stmt.setFloat(38, movimento.getAliquotaIPI());
		stmt.setFloat(39, movimento.getBaseIPI());
		stmt.setFloat(40, movimento.getValorTotal());
		stmt.setInt(41, movimento.getFormaDinheiro());
		stmt.setFloat(42, movimento.getTotalDinheiro());
		stmt.setInt(43, movimento.getFormaCheque());
		stmt.setFloat(44, movimento.getTotalCheque());
		stmt.setInt(45, movimento.getFormaCartao());
		stmt.setFloat(46, movimento.getTotalCartao());
		stmt.setInt(47, movimento.getFormaCrediario());
		stmt.setFloat(48, movimento.getTotalCrediario());
		stmt.setInt(49, movimento.getFormaConvenio());
		stmt.setFloat(50, movimento.getTotalConvenio());
		stmt.setFloat(51, movimento.getFrete());
		stmt.setString(52, movimento.getOperacao());
		stmt.setString(53, movimento.getTipoTransacao());
		stmt.setString(54, movimento.getCodigoProduto());
		stmt.setString(55, movimento.getCodigoBarra());
		stmt.setString(56, movimento.getCancelado());
		stmt.setString(57, movimento.getExcluido());
		stmt.setString(58, movimento.getSomaRelatorio());
		stmt.setString(59, movimento.getIdentificador());
		stmt.setString(60, movimento.getDeposito());
		stmt.setString(61, movimento.getObservacao());
		stmt.setFloat(62, movimento.getPrecoUnitario());
		stmt.setDate(63, new Date(movimento.getHoraLancamento().getTime()));
		stmt.setString(64, movimento.getNaturezaOperacao());
		stmt.setInt(65, movimento.getTabelaPreco());
		stmt.setString(66, movimento.getNomeTabelaPreco());
		stmt.setInt(67, movimento.getCodigoSefazSituacao());
		stmt.setString(68, movimento.getDescSefazSituacao());
		stmt.setString(69, movimento.getProtocoloAutNfe());
		stmt.setDate(70, new Date(movimento.getDataUpdate().getTime()));
		stmt.setInt(71, movimento.getFormaChequePrazo());
		stmt.setFloat(72, movimento.getTotalChequePrazo());
		stmt.setFloat(73, movimento.getCodigoNaturezaOperacao());
		stmt.setFloat(74, movimento.getPrecoTabelaEpoca());
		stmt.setFloat(75, movimento.getDescontoTotalItem());
		stmt.setString(76, movimento.getConferido());
		stmt.execute();
		stmt.close();
	}

	private void update(MovimentosNfModel movimento) throws SQLException {
		String query = "UPDATE WAD_LINX_MOV_NF SET " + 
						"USUARIO = ?, DOCUMENTO = ?, CHAVE_NF = ?, ECF = ?, NUMERO_SERIE_ECF = ?, "+
						"MODELO_NF = ?, DATA_DOCUMENTO = ?, DATA_LANCAMENTO = ?, CODIGO_CLIENTE = ?, SERIE = ?, "+
						"DESC_CFOP = ?, ID_CFOP = ?, COD_VENDEDOR = ?, QUANTIDADE = ?, PRECO_CUSTO = ?, "+
						"VALOR_LIQUIDO = ?, DESCONTO = ?, CST_ICMS = ?, CST_PIS = ?, CST_COFINS = ?, "+
						"CST_IPI = ?, VALOR_ICMS = ?, ALIQUOTA_ICMS = ?, BASE_ICMS = ?, VALOR_PIS = ?, "+
						"ALIQUOTA_PIS = ?, BASE_PIS = ?, VALOR_COFINS = ?, ALIQUOTA_COFINS = ?, BASE_COFINS = ?, "+
						"VALOR_ICMS_ST = ?, ALIQUOTA_ICMS_ST = ?, BASE_ICMS_ST = ?, VALOR_IPI = ?, ALIQUOTA_IPI = ?, "+
						"BASE_IPI = ?, VALOR_TOTAL = ?, FORMA_DINHEIRO = ?, TOTAL_DINHEIRO = ?, FORMA_CHEQUE = ?, "+
						"TOTAL_CHEQUE = ?, FORMA_CARTAO = ?, TOTAL_CARTAO = ?, FORMA_CREDIARIO = ?, TOTAL_CREDIARIO = ?, "+
						"FORMA_CONVENIO = ?, TOTAL_CONVENIO = ?, FRETE = ?, OPERACAO = ?, TIPO_TRANSACAO = ?, "+
						"COD_PRODUTO = ?, COD_BARRA = ?, CANCELADO = ?, EXCLUIDO = ?, SOMA_RELATORIO = ?, "+
						"IDENTIFICADOR = ?, DEPOSITO = ?, OBS = ?, PRECO_UNITARIO = ?, HORA_LANCAMENTO = ?, "+
						"NATUREZA_OPERACAO = ?, TABELA_PRECO = ?, NOME_TABELA_PRECO = ?, COD_SEFAZ_SITUACAO = ?, DESC_SEFAZ_SITUACAO = ?, "+
						"PROTOCOLO_AUT_NFE = ?, DT_UPDATE = ?, FORMA_CHEQUE_PRAZO = ?, TOTAL_CHEQUE_PRAZO = ?, COD_NATUREZA_OPERACAO = ?, "+
						"PRECO_TABELA_EPOCA = ?, DESCONTO_TOTAL_ITEM = ?, CONFERIDO = ?" +
				"WHERE CNPJ_EMP = ? AND TRANSACAO = ?";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, movimento.getUsuario());
		stmt.setInt(2, movimento.getDocumento());
		stmt.setString(3, movimento.getChaveNf());
		stmt.setInt(4, movimento.getEcf());
		stmt.setString(5, movimento.getNrSerEcf());
		stmt.setInt(6, movimento.getModeloNf());
		stmt.setDate(7, new Date(movimento.getDataDocuemnto().getTime()));
		stmt.setDate(8, new Date(movimento.getDataLancamento().getTime()));
		stmt.setInt(9, movimento.getCodigoCliente());
		stmt.setString(10, movimento.getSerie());
		stmt.setString(11, movimento.getDescCfop());
		stmt.setString(12, movimento.getIdCfop());
		stmt.setInt(13, movimento.getCodigoVendedor());
		stmt.setFloat(14, movimento.getQuantidade());
		stmt.setFloat(15, movimento.getPrecoCusto());
		stmt.setFloat(16, movimento.getValorLiquido());
		stmt.setFloat(17, movimento.getDesconto());
		stmt.setString(18, movimento.getCstIcms());
		stmt.setString(19, movimento.getCstPis());
		stmt.setString(20, movimento.getCstCofins());
		stmt.setString(21, movimento.getCstIpi());
		stmt.setFloat(22, movimento.getValorIcms());
		stmt.setFloat(23, movimento.getAliquotaIcms());
		stmt.setFloat(24, movimento.getBaseIcms());
		stmt.setFloat(25, movimento.getValorPis());
		stmt.setFloat(26, movimento.getAliquotaPis());
		stmt.setFloat(27, movimento.getBasePis());
		stmt.setFloat(28, movimento.getValorCofins());
		stmt.setFloat(29, movimento.getAliquotaCofins());
		stmt.setFloat(30, movimento.getBaseCofins());
		stmt.setFloat(31, movimento.getValorIcmsSt());
		stmt.setFloat(32, movimento.getAliquotaIcmsSt());
		stmt.setFloat(33, movimento.getBaseIcmsSt());
		stmt.setFloat(34, movimento.getValorIPI());
		stmt.setFloat(35, movimento.getAliquotaIPI());
		stmt.setFloat(36, movimento.getBaseIPI());
		stmt.setFloat(37, movimento.getValorTotal());
		stmt.setInt(38, movimento.getFormaDinheiro());
		stmt.setFloat(39, movimento.getTotalDinheiro());
		stmt.setInt(40, movimento.getFormaCheque());
		stmt.setFloat(41, movimento.getTotalCheque());
		stmt.setInt(42, movimento.getFormaCartao());
		stmt.setFloat(43, movimento.getTotalCartao());
		stmt.setInt(44, movimento.getFormaCrediario());
		stmt.setFloat(45, movimento.getTotalCrediario());
		stmt.setInt(46, movimento.getFormaConvenio());
		stmt.setFloat(47, movimento.getTotalConvenio());
		stmt.setFloat(48, movimento.getFrete());
		stmt.setString(49, movimento.getOperacao());
		stmt.setString(50, movimento.getTipoTransacao());
		stmt.setString(51, movimento.getCodigoProduto());
		stmt.setString(52, movimento.getCodigoBarra());
		stmt.setString(53, movimento.getCancelado());
		stmt.setString(54, movimento.getExcluido());
		stmt.setString(55, movimento.getSomaRelatorio());
		stmt.setString(56, movimento.getIdentificador());
		stmt.setString(57, movimento.getDeposito());
		stmt.setString(58, movimento.getObservacao());
		stmt.setFloat(59, movimento.getPrecoUnitario());
		stmt.setDate(60, new Date(movimento.getHoraLancamento().getTime()));
		stmt.setString(61, movimento.getNaturezaOperacao());
		stmt.setInt(62, movimento.getTabelaPreco());
		stmt.setString(63, movimento.getNomeTabelaPreco());
		stmt.setInt(64, movimento.getCodigoSefazSituacao());
		stmt.setString(65, movimento.getDescSefazSituacao());
		stmt.setString(66, movimento.getProtocoloAutNfe());
		stmt.setDate(67, new Date(movimento.getDataUpdate().getTime()));
		stmt.setInt(68, movimento.getFormaChequePrazo());
		stmt.setFloat(69, movimento.getTotalChequePrazo());
		stmt.setFloat(70, movimento.getCodigoNaturezaOperacao());
		stmt.setFloat(71, movimento.getPrecoTabelaEpoca());
		stmt.setFloat(72, movimento.getDescontoTotalItem());
		stmt.setString(73, movimento.getConferido());
		stmt.setString(74, movimento.getCnpjEmpresa());
		stmt.setInt(75, movimento.getTransacao());
		stmt.executeUpdate();
		stmt.close();
	}

}

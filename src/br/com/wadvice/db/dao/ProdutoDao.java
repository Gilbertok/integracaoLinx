package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.ProdutoModel;

public class ProdutoDao extends DefaultDao {
	
	private static String sqlCreate = "CREATE TABLE WAD_LINX_PROD ( "+
										"  PORTAL NUMBER NOT NULL, "+
										"  COD_PRODUTO VARCHAR2(20 BYTE) NOT NULL, "+
										"  COD_BARRA VARCHAR2(20 BYTE) NOT NULL, "+
										"  NOME VARCHAR2(250 BYTE), "+
										"  NCM VARCHAR2(20 BYTE), "+
										"  CEST VARCHAR2(10 BYTE), "+
										"  REFERENCIA VARCHAR2(20 BYTE), "+
										"  COD_AUXILIAR VARCHAR2(40 BYTE), "+
										"  UNIDADE VARCHAR2(50 BYTE), "+
										"  DESC_COR VARCHAR2(50 BYTE), "+
										"  DESC_TAMANHO VARCHAR2(50 BYTE), "+
										"  DESC_SETOR VARCHAR2(50 BYTE), "+
										"  DESC_LINHA VARCHAR2(50 BYTE), "+
										"  DESC_MARCA VARCHAR2(50 BYTE), "+
										"  DESC_COLECAO VARCHAR2(50 BYTE), "+
										"  DT_UPDATE DATE, "+
										"  COD_FORNECEDOR NUMBER, "+
										"  DESATIVADO VARCHAR2(1 BYTE), "+
										"  DESC_ESPESSURA VARCHAR2(50 BYTE), "+
										"  ID_ESPESSURA NUMBER, "+
										"  DESC_CLASSIFICACAO VARCHAR2(50 BYTE), "+
										"  ORIGEM_MERCADORIA NUMBER, "+
										"  PESO_LIQUIDO FLOAT(126), "+
										"  PESO_BRUTO FLOAT(126), "+
										"  ID_COR NUMBER, "+
										"  ID_TAMANHO NUMBER, "+
										"  ID_SETOR NUMBER, "+
										"  ID_LINHA NUMBER, "+
										"  ID_MARCA NUMBER, "+
										"  ID_COLECAO NUMBER, "+
										"  DT_INCLUSAO DATE, "+
										"  ID_CLASSIFICACAO NUMBER, "+
										"  DATA_ATUALIZACAO DATE NOT NULL," +
										"  CONSTRAINT WAD_LINX_PROD_PK PRIMARY KEY (COD_BARRA )) ";
	private static String nomeTabela = "WAD_LINX_PROD";
	
	public ProdutoDao() {
		super(nomeTabela, sqlCreate);
	}

	public void gravarLista(List<ProdutoModel> produtos) throws SQLException {
		this.criaCasoNaoExista();
		for (ProdutoModel produto : produtos) {
			if(produto.getCodBarra() != null && !produto.getCodBarra().isEmpty()) {
				if (this.exists(produto)) {
					this.update(produto);
				} else {
					this.insert(produto);
				}
			}
		}
	}

	private void insert(ProdutoModel produto) throws SQLException {
		String query = "INSERT INTO WAD_LINX_PROD (" + 
						"   PORTAL, COD_PRODUTO, COD_BARRA, NOME, NCM, "+
						"   CEST, REFERENCIA, COD_AUXILIAR, UNIDADE, DESC_COR, "+
						"   DESC_TAMANHO, DESC_SETOR, DESC_LINHA, DESC_MARCA, DESC_COLECAO, "+
						"   DT_UPDATE, COD_FORNECEDOR, DESATIVADO, DESC_ESPESSURA, ID_ESPESSURA, "+
						"   DESC_CLASSIFICACAO, ORIGEM_MERCADORIA, PESO_LIQUIDO, PESO_BRUTO, ID_COR, "+
						"   ID_TAMANHO, ID_SETOR, ID_LINHA, ID_MARCA, ID_COLECAO, "+
						"   ID_CLASSIFICACAO, DT_INCLUSAO, DATA_ATUALIZACAO "+
						" ) VALUES ( " + 
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, produto.getPortal());
		stmt.setString(2, produto.getCodProduto());
		stmt.setString(3, produto.getCodBarra());
		stmt.setString(4, produto.getNome());
		stmt.setString(5, produto.getNcm());
		
		stmt.setString(6, produto.getCest());
		stmt.setString(7, produto.getReferencia());
		stmt.setString(8, produto.getCodAuxiliar());
		stmt.setString(9, produto.getUnidade());
		stmt.setString(10, produto.getDescCor());
		
		stmt.setString(11, produto.getDescTamanho());
		stmt.setString(12, produto.getDescSetor());
		stmt.setString(13, produto.getDescLinha());
		stmt.setString(14, produto.getDescMarca());
		stmt.setString(15, produto.getDescColecao());
		
		stmt.setDate(16, produto.getDataUpdate() != null ? new Date(produto.getDataUpdate().getTime()) : null);
		stmt.setInt(17, produto.getCodFornecedor());
		stmt.setString(18, produto.getDesativado());
		stmt.setString(19, produto.getDescEspessura());
		stmt.setInt(20, produto.getIdEspessura());
		
		stmt.setString(21, produto.getDescClassificacao());
		stmt.setInt(22, produto.getOrigemMercadoria());
		stmt.setFloat(23, produto.getPesoLiquido());
		stmt.setFloat(24, produto.getPesoBruto());
		stmt.setInt(25, produto.getIdCor());
		
		stmt.setInt(26, produto.getIdTamanho());
		stmt.setInt(27, produto.getIdSetor());
		stmt.setInt(28, produto.getIdLinha());
		stmt.setInt(29, produto.getIdMarca());
		stmt.setInt(30, produto.getIdColecao());
		
		stmt.setInt(31, produto.getIdClassificacao());
		stmt.setDate(32, produto.getDataInclusao() != null ? new Date(produto.getDataInclusao().getTime()) : null);
		stmt.setDate(33, new Date(new java.util.Date().getTime()));
		stmt.execute();
		stmt.close();
	}

	private void update(ProdutoModel produto) throws SQLException {
		String query = "UPDATE WAD_LINX_PROD SET " + 
						"   NOME = ?, NCM = ?, CEST = ?, REFERENCIA = ?, COD_AUXILIAR = ?,  "+
						"   UNIDADE = ?, DESC_COR = ?, DESC_TAMANHO = ?, DESC_SETOR = ?, DESC_LINHA = ?,    "+
						"   DESC_MARCA = ?, DESC_COLECAO = ?, DT_UPDATE = ?, COD_FORNECEDOR = ?, DESATIVADO = ?,    "+
						"   DESC_ESPESSURA = ?, ID_ESPESSURA = ?, DESC_CLASSIFICACAO = ?, ORIGEM_MERCADORIA = ?, PESO_LIQUIDO = ?,  "+
						"   PESO_BRUTO = ?, ID_COR = ?, ID_TAMANHO = ?, ID_SETOR = ?, ID_LINHA = ?,     "+
						"   ID_MARCA = ?, ID_COLECAO = ?, ID_CLASSIFICACAO = ?, DT_INCLUSAO = ?, DATA_ATUALIZACAO = ? "+
						"WHERE COD_BARRA = ? ";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getNcm());
		stmt.setString(3, produto.getCest());
		stmt.setString(4, produto.getReferencia());
		stmt.setString(5, produto.getCodAuxiliar());
		
		stmt.setString(6, produto.getUnidade());
		stmt.setString(7, produto.getDescCor());
		stmt.setString(8, produto.getDescTamanho());
		stmt.setString(9, produto.getDescSetor());
		stmt.setString(10, produto.getDescLinha());
		
		stmt.setString(11, produto.getDescMarca());
		stmt.setString(12, produto.getDescColecao());
		stmt.setDate(13, produto.getDataUpdate() != null ? new Date(produto.getDataUpdate().getTime()) : null);
		stmt.setInt(14, produto.getCodFornecedor());
		stmt.setString(15, produto.getDesativado());
		
		stmt.setString(16, produto.getDescEspessura());
		stmt.setInt(17, produto.getIdEspessura());
		stmt.setString(18, produto.getDescClassificacao());
		stmt.setInt(19, produto.getOrigemMercadoria());
		stmt.setFloat(20, produto.getPesoLiquido());
		
		stmt.setFloat(21, produto.getPesoBruto());
		stmt.setInt(22, produto.getIdCor());
		stmt.setInt(23, produto.getIdTamanho());
		stmt.setInt(24, produto.getIdSetor());
		stmt.setInt(25, produto.getIdLinha());
		
		stmt.setInt(26, produto.getIdMarca());
		stmt.setInt(27, produto.getIdColecao());
		stmt.setInt(28, produto.getIdClassificacao());
		stmt.setDate(29, produto.getDataInclusao() != null ? new Date(produto.getDataInclusao().getTime()) : null);
		stmt.setDate(30, new Date(new java.util.Date().getTime()));
		
		stmt.setString(31, produto.getCodBarra());
		stmt.executeUpdate();
		stmt.close();
	}

	private boolean exists(ProdutoModel produto) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_PROD WHERE COD_BARRA = ? ";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setString(1, produto.getCodBarra());
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

}

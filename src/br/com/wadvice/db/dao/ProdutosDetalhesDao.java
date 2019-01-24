package br.com.wadvice.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.db.DBConnectERP;
import br.com.wadvice.rest.model.ProdutosDetalhes;

public class ProdutosDetalhesDao {
	
	private Connection instance;
	
	public ProdutosDetalhesDao() {
		instance = DBConnectERP.getInstance();
	}
	
	private void createIfNoExists() {
		try {
			String query = "SELECT * FROM WAD_LINX_PROD_DET";
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.executeQuery();
			stmt.close();
		} catch (SQLException e) {
			if(e.getErrorCode() == 942) {
				this.criaTabela();
			} else {
				e.printStackTrace();
			}
		}
	}
	
	private void criaTabela() {
		try {
			String query = "CREATE TABLE WAD_LINX_PROD_DET (" + 
							"   PORTAL NUMBER(*,0) NOT NULL ENABLE, " + 
							"	CNPJ_EMP VARCHAR2(14 BYTE) NOT NULL ENABLE, " + 
							"	COD_PRODUTO VARCHAR2(20 BYTE), " + 
							"	COD_BARRA VARCHAR2(20 BYTE) NOT NULL ENABLE, " + 
							"	QUANTIDADE FLOAT(126), " + 
							"	PRECO_CUSTO FLOAT(126), " + 
							"	PRECO_VENDA FLOAT(126), " + 
							"	CUSTO_MEDIO FLOAT(126), " + 
							"	ID_CONFIG_TRIBUTARIA NUMBER(*,0), " + 
							"	DESC_CONFIG_TRIBUTARIA VARCHAR2(30 BYTE), " + 
							"	DESPESAS1 FLOAT(126), " + 
							"	DATA_ATUALIZACAO DATE NOT NULL," +
							"	CONSTRAINT WAD_LINX_PROD_DET_PK PRIMARY KEY (COD_BARRA, CNPJ_EMP)" + 
							")";
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.executeQuery();
			instance.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private Boolean exists(String cnpj, String codBarra) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_PROD_DET DET WHERE DET.CNPJ_EMP = ? AND DET.COD_BARRA = ?";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setString(1, cnpj);
			stmt.setString(2, codBarra);
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

	public void gravarLista(List<ProdutosDetalhes> produtos) {
		this.createIfNoExists();
		for (ProdutosDetalhes produto : produtos) {
			if(produto.getCodBarra() != null && !produto.getCodBarra().isEmpty()) {
				if (this.exists(produto.getCnpjEmpresa(), produto.getCodBarra())) {
					try {
						this.update(produto);
					} catch (SQLException e) {
						System.out.println("Produto: "+ produto.getCodProduto());
						e.printStackTrace();
					}
				} else {
					try {
						this.insert(produto);
					} catch (SQLException e) {
						System.out.println("Produto: "+ produto.getCodProduto());
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void update(ProdutosDetalhes produto) throws SQLException {
		String query = "UPDATE WAD_LINX_PROD_DET DET " + 
						"	SET DET.PORTAL = ?, DET.COD_PRODUTO = ?, DET.ID_CONFIG_TRIBUTARIA = ?, DET.DESC_CONFIG_TRIBUTARIA = ?, DET.DESPESAS1 = ?, DET.CUSTO_MEDIO = ?, DET.PRECO_CUSTO = ?, DET.PRECO_VENDA = ?, DET.QUANTIDADE = ?, DET.DATA_ATUALIZACAO = SYSDATE " + 
						"WHERE DET.CNPJ_EMP = ? AND DET.COD_BARRA = ?";
		PreparedStatement prepareStatement = instance.prepareStatement(query);
		prepareStatement.setInt(1, produto.getPortal());
		prepareStatement.setString(2, produto.getCodProduto());
		prepareStatement.setInt(3, produto.getIdConfigTributaria());
		prepareStatement.setString(4, produto.getDescConfigTributaria());
		prepareStatement.setFloat(5, produto.getDespesas1());
		prepareStatement.setFloat(6, produto.getCustoMedio());
		prepareStatement.setFloat(7, produto.getPrecoCusto());
		prepareStatement.setFloat(8, produto.getPrecoVenda());
		prepareStatement.setFloat(9, produto.getQuantidade());
		prepareStatement.setString(10, produto.getCodBarra());
		prepareStatement.setString(11, produto.getCnpjEmpresa());
        prepareStatement.execute();
        prepareStatement.close();
	}

	private void insert(ProdutosDetalhes produto) throws SQLException {
		String query = "INSERT INTO WAD_LINX_PROD_DET " + 
						"    (PORTAL, CNPJ_EMP, COD_BARRA, COD_PRODUTO, ID_CONFIG_TRIBUTARIA, DESC_CONFIG_TRIBUTARIA, DESPESAS1, CUSTO_MEDIO, PRECO_CUSTO, PRECO_VENDA, QUANTIDADE, DATA_ATUALIZACAO) " + 
						"VALUES " + 
						"    (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		PreparedStatement prepareStatement = instance.prepareStatement(query);
		prepareStatement.setInt(1, produto.getPortal());
		prepareStatement.setString(2, produto.getCnpjEmpresa());
		prepareStatement.setString(3, produto.getCodBarra());
		prepareStatement.setString(4, produto.getCodProduto());
		prepareStatement.setInt(5, produto.getIdConfigTributaria());
		prepareStatement.setString(6, produto.getDescConfigTributaria());
		prepareStatement.setFloat(7, produto.getDespesas1());
		prepareStatement.setFloat(8, produto.getCustoMedio());
		prepareStatement.setFloat(9, produto.getPrecoCusto());
		prepareStatement.setFloat(10, produto.getPrecoVenda());
		prepareStatement.setFloat(11, produto.getQuantidade());
        prepareStatement.execute();
        prepareStatement.close();
	}

}

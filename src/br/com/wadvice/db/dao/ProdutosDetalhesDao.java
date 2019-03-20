package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.ProdutosDetalhesModel;

public class ProdutosDetalhesDao extends DefaultDao {
	
	private String sqlCreateProdutosDetalhesDao = "CREATE TABLE WAD_LINX_PROD_DET (" + 
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
													"   DATA_ATUALIZACAO DATE NOT NULL," +
													"	CONSTRAINT WAD_LINX_PROD_DET_PK PRIMARY KEY (COD_BARRA, CNPJ_EMP)" + 
													")";
	private String nomeTabelaProdutosDetalhesDao = "WAD_LINX_PROD_DET";
	
	public ProdutosDetalhesDao() {
		super();
		this.setNomeTabela(nomeTabelaProdutosDetalhesDao);
		this.setSqlCreate(sqlCreateProdutosDetalhesDao);
	}
	
	public void gravarLista(String cnpjEmpresa, List<ProdutosDetalhesModel> produtos) throws SQLException {
		this.limparTabela(cnpjEmpresa);
		for (ProdutosDetalhesModel produto : produtos) {
			if(produto.getCodBarra() != null && !produto.getCodBarra().isEmpty()) {
				this.insert(produto);
			}
		}
	}

	private void insert(ProdutosDetalhesModel produto) throws SQLException {
		String query = "INSERT INTO WAD_LINX_PROD_DET " + 
						"    (PORTAL, CNPJ_EMP, COD_BARRA, COD_PRODUTO, ID_CONFIG_TRIBUTARIA, DESC_CONFIG_TRIBUTARIA, DESPESAS1, CUSTO_MEDIO, PRECO_CUSTO, PRECO_VENDA, QUANTIDADE, DATA_ATUALIZACAO) " + 
						"VALUES " + 
						"    (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, produto.getPortal());
		stmt.setString(2, produto.getCnpjEmpresa());
		stmt.setString(3, produto.getCodBarra());
		stmt.setString(4, produto.getCodProduto());
		stmt.setInt(5, produto.getIdConfigTributaria());
		stmt.setString(6, produto.getDescConfigTributaria());
		stmt.setFloat(7, produto.getDespesas1());
		stmt.setFloat(8, produto.getCustoMedio());
		stmt.setFloat(9, produto.getPrecoCusto());
		stmt.setFloat(10, produto.getPrecoVenda());
		stmt.setFloat(11, produto.getQuantidade());
		stmt.setDate(12, new Date(new java.util.Date().getTime()));
        stmt.execute();
        stmt.close();
	}

}

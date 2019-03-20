package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.VendedorMetasModel;

public class VendedorMetasDao extends DefaultDao {
	
	private static String sqlCreate = "CREATE TABLE WAD_LINX_VENDEDOR_METAS ( "+
									"   PORTAL NUMBER, "+
									"	CNPJ_EMP VARCHAR2(14 BYTE) NOT NULL ENABLE, "+
									"	ID_META NUMBER NOT NULL ENABLE, "+
									"	DESCRICAO_META VARCHAR2(50 BYTE), "+
									"	DATA_INICIAL_META DATE, "+
									"	DATA_FINAL_META DATE, "+
									"	VALOR_META_LOJA FLOAT(126), "+
									"	VALOR_META_VENDEDOR FLOAT(126), "+
									"	COD_VENDEDOR NUMBER NOT NULL ENABLE, "+
									"   DATA_ATUALIZACAO DATE NOT NULL," +
									"	CONSTRAINT WAD_LINX_VENDEDOR_METAS_UK1 UNIQUE (CNPJ_EMP, COD_VENDEDOR, ID_META))";
	private static String nomeTabela = "WAD_LINX_VENDEDOR_METAS";

	public VendedorMetasDao() {
		super(nomeTabela, sqlCreate);
	}

	public void gravarLista(String cnpjEmpresa, List<VendedorMetasModel> metas) throws SQLException {
		this.limparTabela(cnpjEmpresa);
		for (VendedorMetasModel meta : metas) {
			if(meta.getCodigoVendedor() != null) {
				this.insert(meta);
			}
		}
	}

	private void insert(VendedorMetasModel meta) throws SQLException {
		String query = "INSERT INTO WAD_LINX_VENDEDOR (" + 
				 		"	PORTAL, CNPJ_EMP, ID_META, DESCRICAO_META, DATA_INICIAL_META, "+
				 		"	DATA_FINAL_META, VALOR_META_LOJA, VALOR_META_VENDEDOR, COD_VENDEDOR, CNPJ_EMP"+
						" ) VALUES ( " + 
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, meta.getPortal());
		stmt.setString(2, meta.getCnpjEmpresa());
		stmt.setInt(3, meta.getIdMeta());
		stmt.setString(4, meta.getDescricao());
		stmt.setDate(5, meta.getDataInicial() != null ? new Date(meta.getDataInicial().getTime()) : null);
		
		stmt.setDate(6, meta.getDataFinal() != null ? new Date(meta.getDataFinal().getTime()) : null);
		stmt.setFloat(7, meta.getValorLoja());
		stmt.setFloat(8, meta.getValorVendedor());
		stmt.setInt(9, meta.getCodigoVendedor());
		stmt.setString(10, meta.getCnpjEmpresa());
		stmt.execute();
		stmt.close();
	}

}

package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.VendedoresModel;

public class VendedorDao extends DefaultDao {
	
	private static String sqlCreate = "CREATE TABLE WAD_LINX_VENDEDOR (	"+
										"   PORTAL VARCHAR2(20 BYTE), "+
										"	CNPJ_EMP VARCHAR2(14 BYTE) NOT NULL ENABLE, "+
										"	COD_VENDEDOR VARCHAR2(20 BYTE) NOT NULL ENABLE, "+
										"	NOME_VENDEDOR VARCHAR2(50 BYTE), "+
										"	TIPO_VENDEDOR VARCHAR2(1 BYTE), "+
										"	END_VEND_RUA VARCHAR2(250 BYTE), "+
										"	END_VEND_NUMERO NUMBER, "+
										"	END_VEND_COMPLEMENTO VARCHAR2(60 BYTE), "+
										"	END_VEND_BAIRRO VARCHAR2(60 BYTE), "+
										"	END_VEND_CEP VARCHAR2(9 BYTE), "+
										"	END_VEND_CIDADE VARCHAR2(60 BYTE), "+
										"	END_VEND_UF VARCHAR2(2 BYTE), "+
										"	FONE_VENDEDOR VARCHAR2(30 BYTE), "+
										"	MAIL_VENDEDOR VARCHAR2(50 BYTE), "+
										"	DT_UPD DATE, "+
										"	CPF_VENDEDOR VARCHAR2(14 BYTE), "+
										"	ATIVO VARCHAR2(1 BYTE), "+
										"	DATA_ADMISSAO DATE, "+
										"	DATA_SAIDA DATE, "+
										"	CONSTRAINT WAD_LINX_VENDEDOR_PK PRIMARY KEY (CNPJ_EMP, COD_VENDEDOR))";
	private static String nomeTabela = "WAD_LINX_VENDEDOR";

	public VendedorDao() {
		super(nomeTabela, sqlCreate);
	}

	public void gravarLista(String cnpjEmpresa, List<VendedoresModel> vendedores) throws SQLException {
		this.limparTabela(cnpjEmpresa);
		for (VendedoresModel vendedor : vendedores) {
			if(vendedor.getCodigoVendedor() != null) {
				this.insert(vendedor);
			}
		}
	}

	private void insert(VendedoresModel vendedor) throws SQLException {
		String query = "INSERT INTO WAD_LINX_VENDEDOR (" + 
						"	PORTAL, COD_VENDEDOR, NOME_VENDEDOR, TIPO_VENDEDOR, END_VEND_RUA, "+
						"	END_VEND_NUMERO, END_VEND_COMPLEMENTO, END_VEND_BAIRRO, END_VEND_CEP, END_VEND_CIDADE, "+
						"	END_VEND_UF, FONE_VENDEDOR, MAIL_VENDEDOR, DT_UPD, CPF_VENDEDOR, "+
						"	ATIVO, DATA_ADMISSAO, DATA_SAIDA, CNPJ_EMP "+
						" ) VALUES ( " + 
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, vendedor.getPortal());
		stmt.setInt(2, vendedor.getCodigoVendedor());
		stmt.setString(3, vendedor.getNome());
		stmt.setString(4, vendedor.getTipo());
		stmt.setString(5, vendedor.getEndereco());
		
		stmt.setInt(6, vendedor.getEndNumero());
		stmt.setString(7, vendedor.getEndComplemento());
		stmt.setString(8, vendedor.getBairro());
		stmt.setString(9, vendedor.getCep());
		stmt.setString(10, vendedor.getCidade());
		
		stmt.setString(11, vendedor.getUf());
		stmt.setString(12, vendedor.getTelefone());
		stmt.setString(13, vendedor.getEmail());
		stmt.setDate(14, vendedor.getDataUpdate() != null ? new Date(vendedor.getDataUpdate().getTime()) : null);
		stmt.setString(15, vendedor.getCpf());
		
		stmt.setString(16, vendedor.getAtivo());
		stmt.setDate(17, vendedor.getDataAdminissao() != null ? new Date(vendedor.getDataAdminissao().getTime()) : null);
		stmt.setDate(18, vendedor.getDataSaida() != null ? new Date(vendedor.getDataSaida().getTime()) : null);
		stmt.setString(19, vendedor.getCnpjEmpresa());
		stmt.execute();
		stmt.close();
	}

}

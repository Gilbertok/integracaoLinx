package br.com.wadvice.db.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.ClientesFornecContatosModel;

public class ClientesFornecContatosDao extends DefaultDao {
	
	private static String sqlCreate = "CREATE TABLE WAD_LINX_CLI_FORN_CONT ("+
										"   PORTAL VARCHAR2(20 BYTE), "+
										"	COD_CLIENTE VARCHAR2(20 BYTE), "+
										"	NOME_CONTATO VARCHAR2(20 BYTE), "+
										"	SEXO_CONTATO VARCHAR2(1 BYTE), "+
										"	CONT_PARENTESCO NUMBER(1,0), "+
										"	FONE1_CONTATO VARCHAR2(20 BYTE), "+
										"	FONE2_CONTATO VARCHAR2(20 BYTE), "+
										"	CELULAR_CONTATO VARCHAR2(20 BYTE), "+
										"	EMAIL_CONTATO VARCHAR2(50 BYTE), "+
										"	DATA_NASC_CONTATO DATE, "+
										"	TIPO_CONTATO VARCHAR2(20 BYTE))";
	private static String nomeTabela = "WAD_LINX_CLI_FORN_CONT";
	
	public ClientesFornecContatosDao() {
		super(nomeTabela, sqlCreate);
	}

	public void gravarLista(List<ClientesFornecContatosModel> contatos) throws SQLException {
		this.criaCasoNaoExista();
		for (ClientesFornecContatosModel contato : contatos) {
			if(contato.getCodigoCliente() != null && !contato.getCodigoCliente().isEmpty()) {
				if (!this.exists(contato)) {
					this.insert(contato);
				}
			}
		}
	}

	private boolean exists(ClientesFornecContatosModel contato) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_CLI_FORN WHERE COD_CLIENTE = ? AND FONE1_CONTATO = ? ";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setString(1, contato.getCodigoCliente());
			stmt.setString(2, contato.getTelefone1());
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

	private void insert(ClientesFornecContatosModel contato) throws SQLException {
		String query = "INSERT INTO WAD_LINX_CLI_FORN_CONT " + 
						"	PORTAL, COD_CLIENTE, NOME_CONTATO, SEXO_CONTATO, CONT_PARENTESCO, "+
						"	FONE1_CONTATO, FONE2_CONTATO, CELULAR_CONTATO, EMAIL_CONTATO, DATA_NASC_CONTATO, "+
						"	TIPO_CONTATO "+
						"VALUES " + 
						"    (?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?,"+
						"    ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, contato.getPortal());
		stmt.setString(2, contato.getCodigoCliente());
		stmt.setString(3, contato.getNomeContato());
		stmt.setString(4, contato.getSexo());
		stmt.setInt(5, contato.getParentesco());
		
		stmt.setString(6, contato.getTelefone1());
		stmt.setString(7, contato.getTelefone2());
		stmt.setString(8, contato.getCelular());
		stmt.setString(9, contato.getEmail());
		stmt.setDate(10, contato.getDataNascimento() != null ? new Date(contato.getDataNascimento().getTime()) : null);
		
		stmt.setString(11, contato.getTipo());
		stmt.execute();
		stmt.close();
	}

}

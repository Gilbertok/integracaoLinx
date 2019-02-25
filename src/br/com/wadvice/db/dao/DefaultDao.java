package br.com.wadvice.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.wadvice.db.DBConnectERP;

public class DefaultDao {
	
	protected Connection instance;
	private String sqlCreate;
	private String nomeTabela;
	
	public DefaultDao() {
		this.instance = DBConnectERP.getInstance();
	}
	
	protected void criaCasoNaoExista() {
		try {
			String query = "SELECT * FROM " +nomeTabela;
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
	
	protected void limparTabela() {
		try {
			String query = "DELETE FROM " +nomeTabela;
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
	
	protected void criaTabela() {
		try {
			PreparedStatement stmt = instance.prepareStatement(sqlCreate);
			stmt.executeQuery();
			if(!instance.getAutoCommit()) {
				instance.commit();
			}
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected String getSqlCreate() {
		return sqlCreate;
	}

	protected void setSqlCreate(String sqlCreate) {
		this.sqlCreate = sqlCreate;
	}

	protected String getNomeTabela() {
		return nomeTabela;
	}

	protected void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

}

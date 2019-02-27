package br.com.wadvice.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.wadvice.rest.model.linx.MovimentosNfTrocaModel;

public class MovimentosNfTrocaDao extends DefaultDao {
	
	private String sqlCreate = "CREATE TABLE WAD_LINX_MOV_NF_TROCA (	"+
								"   PORTAL NUMBER, "+
								"	CNPJ_EMP VARCHAR2(14 BYTE), "+
								"	IDENTIFICADOR VARCHAR2(40 BYTE), "+
								"	NUM_VALE NUMBER, "+
								"	VALOR_VALE FLOAT(126), "+
								"	MOTIVO VARCHAR2(50 BYTE), "+
								"	DOC_ORIGEM NUMBER, "+
								"	SERIE_ORIGEM VARCHAR2(10 BYTE), "+
								"	DOC_VENDA NUMBER, "+
								"	SERIE_VENDA VARCHAR2(10 BYTE), "+
								"	CONSTRAINT WAD_LINX_MOV_NF_TROCA_UK1 UNIQUE (NUM_VALE, DOC_ORIGEM, SERIE_ORIGEM, DOC_VENDA, SERIE_VENDA))";
	private String nomeTabela = "WAD_LINX_MOV_NF_TROCA";
	
	public MovimentosNfTrocaDao() {
		super();
		this.setNomeTabela(nomeTabela);
		this.setSqlCreate(sqlCreate);
	}

	public void gravarLista(List<MovimentosNfTrocaModel> trocas) throws SQLException {
		this.criaCasoNaoExista();
		for (MovimentosNfTrocaModel troca : trocas) {
			if(troca.getIdentificador() != null && !troca.getIdentificador().isEmpty()) {
				if (this.exists(troca)) {
					this.update(troca);
				} else {
					this.insert(troca);
				}
			}
		}
	}

	private void update(MovimentosNfTrocaModel troca) throws SQLException {
		String query = "UPDATE WAD_LINX_MOV_NF_TROCA SET " + 
						"	IDENTIFICADOR = ?, VALOR_VALE = ?, MOTIVO = ? " +
						"WHERE CNPJ_EMP = ? AND NUM_VALE = ? AND DOC_ORIGEM = ? " +
						"	AND SERIE_ORIGEM = ? AND DOC_VENDA = ? AND SERIE_VENDA = ? ";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setString(1, troca.getIdentificador());
		stmt.setFloat(2, troca.getValorVale());
		stmt.setString(3, troca.getMotivo());
		
		stmt.setString(4, troca.getCnpjEmpresa());
		stmt.setInt(5, troca.getNumVale());
		stmt.setInt(6, troca.getDocOrigem());
		stmt.setString(7, troca.getSerieOrigem());
		stmt.setInt(8, troca.getDocVenda());
		stmt.setString(9, troca.getSerieVenda());
		stmt.executeUpdate();
		stmt.close();
	}

	private void insert(MovimentosNfTrocaModel troca) throws SQLException {
		String query = "INSERT INTO WAD_LINX_MOV_NF_TROCA " + 
						"    (PORTAL, CNPJ_EMP, IDENTIFICADOR, NUM_VALE, VALOR_VALE, " +
						"	MOTIVO, DOC_ORIGEM, SERIE_ORIGEM, DOC_VENDA, SERIE_VENDA) " +
						"VALUES " + 
						"    (?, ?, ?, ?, ?,"+
						"    ?, ?, ?, ?, ?)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, troca.getPortal());
		stmt.setString(2, troca.getCnpjEmpresa());
		stmt.setString(3, troca.getIdentificador());
		stmt.setInt(4, troca.getNumVale());
		stmt.setFloat(5, troca.getValorVale());
		stmt.setString(6, troca.getMotivo());
		stmt.setInt(7, troca.getDocOrigem());
		stmt.setString(8, troca.getSerieOrigem());
		stmt.setInt(9, troca.getDocVenda());
		stmt.setString(10, troca.getSerieVenda());
		stmt.execute();
		stmt.close();
	}

	private boolean exists(MovimentosNfTrocaModel troca) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_MOV_NF_TROCA WHERE CNPJ_EMP = ? AND NUM_VALE = ? AND DOC_ORIGEM = ? AND SERIE_ORIGEM = ? AND DOC_VENDA = ? AND SERIE_VENDA = ?";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setString(1, troca.getCnpjEmpresa());
			stmt.setInt(2, troca.getNumVale());
			stmt.setInt(3, troca.getDocOrigem());
			stmt.setString(4, troca.getSerieOrigem());
			stmt.setInt(5, troca.getDocVenda());
			stmt.setString(6, troca.getSerieVenda());
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

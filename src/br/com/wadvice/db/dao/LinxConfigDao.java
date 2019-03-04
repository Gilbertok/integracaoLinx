package br.com.wadvice.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;

public class LinxConfigDao extends DefaultDao {
	
	private String sqlCreateLinxConfigDao = "CREATE TABLE WAD_LINX_CONFIG( " + 
											"    PORTAL NUMBER NOT NULL ENABLE, " + 
											"	 CNPJ_EMP VARCHAR2(14 BYTE) NOT NULL ENABLE, " + 
											"	 DATA_ULT_SINC DATE NOT NULL ENABLE, " + 
											"	 CONSTRAINT WAD_LINX_CONFIG_PK PRIMARY KEY (CNPJ_EMP, PORTAL) " + 
											")";
	private String nomeTabelaLinxConfigDao = "WAD_LINX_CONFIG";
	protected SimpleDateFormat dtFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public LinxConfigDao() {
		super();
		this.setNomeTabela(nomeTabelaLinxConfigDao);
		this.setSqlCreate(sqlCreateLinxConfigDao);
	}
	
	private Boolean exists(Integer portal, String cnpj) {
		Boolean exists = false;
		String query = "SELECT 1 FROM WAD_LINX_CONFIG CONF WHERE CONF.PORTAL = ? AND CONF.CNPJ_EMP = ?";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setInt(1, portal);
			stmt.setString(2, cnpj);
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
	
	public void atualizaDataSinc(Integer portal, String cnpj) {
		this.criaCasoNaoExista();
		try {
			if (this.exists(portal, cnpj)) {
				this.update(portal, cnpj);
			} else {
				this.insert(portal, cnpj);
			}
		} catch (SQLException e) {
			System.out.println("Conf: "+ cnpj);
			e.printStackTrace();
		}
	}

	private void insert(Integer portal, String cnpj) throws SQLException {
		String query = "INSERT INTO WAD_LINX_CONFIG " + 
						"    (PORTAL, CNPJ_EMP, DATA_ULT_SINC) " + 
						"VALUES " + 
						"    (?, ?, SYSDATE)";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, portal);
		stmt.setString(2, cnpj);
		stmt.execute();
		stmt.close();
	}

	private void update(Integer portal, String cnpj) throws SQLException {
		String query = "UPDATE WAD_LINX_CONFIG CONF " + 
						"	SET CONF.DATA_ULT_SINC = SYSDATE " + 
						"WHERE CONF.PORTAL = ? AND CONF.CNPJ_EMP = ?";
		PreparedStatement stmt = instance.prepareStatement(query);
		stmt.setInt(1, portal);
		stmt.setString(2, cnpj);
		stmt.executeUpdate();
		stmt.close();
	}

	public Calendar getDataUltSinc(Integer portal, String cnpj) {
		this.criaCasoNaoExista();
		ConfigXml config = ConfigUtils.getInstance();
		Calendar dataUltSinc = Calendar.getInstance();
		dataUltSinc.setTime(config.getDataBaseSync());
		String query = "SELECT CONF.DATA_ULT_SINC FROM WAD_LINX_CONFIG CONF WHERE CONF.PORTAL = ? AND CONF.CNPJ_EMP = ?";
		try {
			PreparedStatement stmt = instance.prepareStatement(query);
			stmt.setInt(1, portal);
			stmt.setString(2, cnpj);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				dataUltSinc.setTime(result.getDate("DATA_ULT_SINC"));
			}
			result.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataUltSinc;
	}
	
}

package br.com.wadvice.db;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.wadvice.rest.model.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import oracle.jdbc.pool.OracleDataSource;

public class DBConnectERP {
	
    private static Connection instance;
	
	private DBConnectERP() {}
	
	public static Connection getInstance() {
		if(instance == null) {
			instance = new DBConnectERP().criaConexao();
		}
		return instance;
	}
	
	private Connection criaConexao() {
		try {
			ConfigXml config = ConfigUtils.getInstance();
			OracleDataSource ods = new OracleDataSource();
			ods.setUser(config.getDbUser());
			ods.setPassword(config.getDbPassword());
			ods.setServerName(config.getDbServer());
			ods.setPortNumber(1521);
			ods.setServiceName(config.getDbDatabase());
			ods.setDriverType("thin");
			instance = ods.getConnection();
		} catch (SQLException e) {
			System.out.println("Erro ao criar conexao com o banco de dados!");
			e.printStackTrace();
		}
		return instance;
	}
	
}

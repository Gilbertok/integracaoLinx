package br.com.wadvice.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.wadvice.rest.SincProdutoDetalhe;
import br.com.wadvice.rest.model.xml.ConfigXml;
import br.com.wadvice.util.ConfigUtils;
import oracle.jdbc.pool.OracleDataSource;

public class DBConnectERP {
	
    private static Connection instance;
    private static final Logger logger = LoggerFactory.getLogger(SincProdutoDetalhe.class);
	
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
			logger.error("----> Erro ao criar conexao com o banco de dados! --- "+e.getMessage());
			e.printStackTrace();
		}
		return instance;
	}
	
}

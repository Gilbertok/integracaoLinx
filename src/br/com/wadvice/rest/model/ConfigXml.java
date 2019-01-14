package br.com.wadvice.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Config")
public class ConfigXml {
	
	private String urlWebService;
	private String dbUser;
	private String dbPassword;
	private String dbServer;
	private String dbDatabase;
	private Integer tempoAtualizacao;
	
	@XmlElement(name="url_web_service")
	public String getUrlWebService() {
		return urlWebService;
	}
	
	@XmlElement(name="db_user")
	public String getDbUser() {
		return dbUser;
	}
	
	@XmlElement(name="db_password")
	public String getDbPassword() {
		return dbPassword;
	}

	public void setUrlWebService(String urlWebService) {
		this.urlWebService = urlWebService;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	@XmlElement(name="db_server")
	public String getDbServer() {
		return dbServer;
	}

	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}

	@XmlElement(name="db_database")
	public String getDbDatabase() {
		return dbDatabase;
	}

	public void setDbDatabase(String dbDatabase) {
		this.dbDatabase = dbDatabase;
	}

	@XmlElement(name="srv_tempo")
	public Integer getTempoAtualizacao() {
		return tempoAtualizacao;
	}

	public void setTempoAtualizacao(Integer tempoAtualizacao) {
		this.tempoAtualizacao = tempoAtualizacao;
	}
	
}

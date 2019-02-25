package br.com.wadvice.rest.model.linx;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LinxModel {
	
	protected Integer portal;
	protected String cnpjEmpresa;
	private Date ultimaSincronizacao;
	protected SimpleDateFormat dtFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	protected SimpleDateFormat hrFormatter = new SimpleDateFormat("HH:mm");
	
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public Integer getPortal() {
		return portal;
	}
	public void setPortal(Integer portal) {
		this.portal = portal;
	}
	
	public void setPortal(String portal) {
		this.portal = portal != null ? Integer.parseInt(portal) : 0;
	}
	public Date getUltimaSincronizacao() {
		return ultimaSincronizacao;
	}
	public void setUltimaSincronizacao(Date ultimaSincronizacao) {
		this.ultimaSincronizacao = ultimaSincronizacao;
	}
	
}

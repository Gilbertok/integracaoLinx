package br.com.wadvice.rest.model.linx;

public class GrupoLojasModel extends LinxModel {
	
	private String nomeEmpresa;
	private String idEmpresasRede;
	private String rede;
	private String nomePortal;
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getIdEmpresasRede() {
		return idEmpresasRede;
	}
	public void setIdEmpresasRede(String idEmpresasRede) {
		this.idEmpresasRede = idEmpresasRede != null ? idEmpresasRede : new String();
	}
	public String getRede() {
		return rede;
	}
	public void setRede(String rede) {
		this.rede = rede;
	}
	public String getNomePortal() {
		return nomePortal;
	}
	public void setNomePortal(String nomePortal) {
		this.nomePortal = nomePortal;
	}
	
	@Override
	public String toString() {
		return "GrupoLojasModel [cnpjEmpresa=" + cnpjEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", idEmpresasRede="
				+ idEmpresasRede + ", portal=" + portal + ", rede=" + rede + ", nomePortal=" + nomePortal + "]";
	}
	
}

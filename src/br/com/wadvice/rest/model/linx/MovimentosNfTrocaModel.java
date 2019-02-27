package br.com.wadvice.rest.model.linx;

public class MovimentosNfTrocaModel extends LinxModel {
	
	private String identificador;
	private Integer docOrigem;
	private String serieOrigem;
	private Integer docVenda;
	private String serieVenda;
	private Integer numVale;
	private Float valorVale;
	private String motivo;
	
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Integer getDocOrigem() {
		return docOrigem;
	}
	public void setDocOrigem(Integer docOrigem) {
		this.docOrigem = docOrigem;
	}
	public void setDocOrigem(String docOrigem) {
		this.docOrigem = docOrigem.isEmpty() ? 0 : Integer.parseInt(docOrigem);
	}
	public String getSerieOrigem() {
		return serieOrigem;
	}
	public void setSerieOrigem(String serieOrigem) {
		this.serieOrigem = serieOrigem;
	}
	public Integer getDocVenda() {
		return docVenda;
	}
	public void setDocVenda(Integer docVenda) {
		this.docVenda = docVenda;
	}
	public void setDocVenda(String docVenda) {
		this.docVenda = docVenda.isEmpty() ? 0 : Integer.parseInt(docVenda);
	}
	public String getSerieVenda() {
		return serieVenda;
	}
	public void setSerieVenda(String serieVenda) {
		this.serieVenda = serieVenda;
	}
	public Integer getNumVale() {
		return numVale;
	}
	public void setNumVale(Integer numVale) {
		this.numVale = numVale;
	}
	public void setNumVale(String numVale) {
		this.numVale = numVale.isEmpty() ? 0 : Integer.parseInt(numVale);
	}
	public Float getValorVale() {
		return valorVale;
	}
	public void setValorVale(Float valorVale) {
		this.valorVale = valorVale;
	}
	public void setValorVale(String valorVale) {
		this.valorVale = valorVale.isEmpty() ? 0 : Float.parseFloat(valorVale);
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	@Override
	public String toString() {
		return "MovimentosNfTrocaModel [identificador=" + identificador + ", docOrigem=" + docOrigem + ", serieOrigem="
				+ serieOrigem + ", docVenda=" + docVenda + ", serieVenda=" + serieVenda + ", numVale=" + numVale
				+ ", ValorVale=" + valorVale + ", motivo=" + motivo + "]";
	}
	
}

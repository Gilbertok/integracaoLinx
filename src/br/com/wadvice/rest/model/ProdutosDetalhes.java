package br.com.wadvice.rest.model;

public class ProdutosDetalhes {
	
	private Integer portal;
	private String cnpjEmpresa;
	private String codProduto;
	private String codBarra;
	private Float quantidade;
	private Float precoCusto;
	private Float precoVenda;
	private Float custoMedio;
	private Integer idConfigTributaria;
	private String descConfigTributaria;
	private Float despesas1;
	
	
	public Integer getPortal() {
		return portal;
	}
	public void setPortal(Integer portal) {
		this.portal = portal;
	}
	public void setPortal(String portal) {
		this.portal = portal != null ? Integer.parseInt(portal) : 0;
	}
	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}
	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade != null ? Float.parseFloat(quantidade) : 0;
	}
	public Float getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(Float precoCusto) {
		this.precoCusto = precoCusto;
	}
	public void setPrecoCusto(String precoCusto) {
		this.precoCusto = precoCusto != null ? Float.parseFloat(precoCusto) : 0;
	}
	public Float getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}
	public void setPrecoVenda(String precoVenda) {
		this.precoVenda = precoVenda != null ? Float.parseFloat(precoVenda) : 0;
	}
	public Float getCustoMedio() {
		return custoMedio;
	}
	public void setCustoMedio(Float custoMedio) {
		this.custoMedio = custoMedio;
	}
	public void setCustoMedio(String custoMedio) {
		this.custoMedio = custoMedio != null ? Float.parseFloat(custoMedio) : 0;
	}
	public Integer getIdConfigTributaria() {
		return idConfigTributaria;
	}
	public void setIdConfigTributaria(Integer idConfigTributaria) {
		this.idConfigTributaria = idConfigTributaria;
	}
	public void setIdConfigTributaria(String idConfigTributaria) {
		this.idConfigTributaria = idConfigTributaria != null ? Integer.parseInt(idConfigTributaria) : 0;
	}
	public String getDescConfigTributaria() {
		return descConfigTributaria;
	}
	public void setDescConfigTributaria(String descConfigTributaria) {
		this.descConfigTributaria = descConfigTributaria;
	}
	public Float getDespesas1() {
		return despesas1;
	}
	public void setDespesas1(Float despesas1) {
		this.despesas1 = despesas1;
	}
	public void setDespesas1(String despesas1) {
		this.despesas1 = despesas1 != null ? Float.parseFloat(despesas1) : 0;
	}
	
	@Override
	public String toString() {
		return "ProdutosDetalhes [portal=" + portal + ", cnpjEmpresa=" + cnpjEmpresa + ", codProduto=" + codProduto
				+ ", codBarra=" + codBarra + ", quantidade=" + quantidade + ", precoCusto=" + precoCusto
				+ ", precoVenda=" + precoVenda + ", custoMedio=" + custoMedio + ", idConfigTributaria="
				+ idConfigTributaria + ", descConfigTributaria=" + descConfigTributaria + ", despesas1=" + despesas1
				+ "]";
	}
	
}

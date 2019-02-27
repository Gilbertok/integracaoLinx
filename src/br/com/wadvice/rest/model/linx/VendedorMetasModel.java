package br.com.wadvice.rest.model.linx;

import java.text.ParseException;
import java.util.Date;

public class VendedorMetasModel extends LinxModel {
	
	private Integer idMeta;
	private String descricao;
	private Date dataInicial;
	private Date dataFinal;
	private Float valorLoja;
	private Float valorVendedor;
	private Integer codigoVendedor;
	
	public Integer getIdMeta() {
		return idMeta;
	}
	public void setIdMeta(Integer idMeta) {
		this.idMeta = idMeta;
	}
	public void setIdMeta(String idMeta) {
		this.idMeta = idMeta.isEmpty() ? 0 : Integer.parseInt(idMeta);
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public void setDataInicial(String dataInicial) throws ParseException {
		if (dataInicial.isEmpty()) {
			this.dataInicial = null;
		} else {
			this.dataInicial = dtFormatter.parse(dataInicial);
		}
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public void setDataFinal(String dataFinal) throws ParseException {
		if (dataFinal.isEmpty()) {
			this.dataFinal = null;
		} else {
			this.dataFinal = dtFormatter.parse(dataFinal);
		}
	}
	public Float getValorLoja() {
		return valorLoja;
	}
	public void setValorLoja(Float valorLoja) {
		this.valorLoja = valorLoja;
	}
	public void setValorLoja(String valorLoja) {
		this.valorLoja = valorLoja.isEmpty() ? 0 : Float.parseFloat(valorLoja);
	}
	public Float getValorVendedor() {
		return valorVendedor;
	}
	public void setValorVendedor(Float valorVendedor) {
		this.valorVendedor = valorVendedor;
	}
	public void setValorVendedor(String valorVendedor) {
		this.valorVendedor = valorVendedor.isEmpty() ? 0 : Float.parseFloat(valorVendedor);
	}
	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor.isEmpty() ? 0 : Integer.parseInt(codigoVendedor);
	}
	@Override
	public String toString() {
		return "VendedorMetasModel [idMeta=" + idMeta + ", descric=" + descricao + ", dataInicial=" + dataInicial
				+ ", dataFinal=" + dataFinal + ", valorLoja=" + valorLoja + ", valorVendedor=" + valorVendedor
				+ ", codigoVendedor=" + codigoVendedor + "]";
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

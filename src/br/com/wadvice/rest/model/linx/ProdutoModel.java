package br.com.wadvice.rest.model.linx;

import java.text.ParseException;
import java.util.Date;

public class ProdutoModel extends LinxModel {
	
	private String codProduto;
	private String codBarra;
	private String nome;
	private String ncm;
	private String cest;
	private String referencia;
	private String codAuxiliar;
	private String unidade;
	private String descCor;
	private String descTamanho;
	private String descSetor;
	private String descLinha;
	private String descMarca;
	private String descColecao;
	private Date dataUpdate;
	private Integer codFornecedor;
	private String desativado;
	private String descEspessura;
	private Integer idEspessura;
	private String descClassificacao;
	private Integer idClassificacao;
	private Integer origemMercadoria;
	private Float pesoLiquido;
	private Float pesoBruto;
	private Integer idCor;
	private Integer idTamanho;
	private Integer idSetor;
	private Integer idLinha;
	private Integer idMarca;
	private Integer idColecao;
	private Date dataInclusao;
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	public String getCest() {
		return cest;
	}
	public void setCest(String cest) {
		this.cest = cest;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCodAuxiliar() {
		return codAuxiliar;
	}
	public void setCodAuxiliar(String codAuxiliar) {
		this.codAuxiliar = codAuxiliar;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getDescCor() {
		return descCor;
	}
	public void setDescCor(String descCor) {
		this.descCor = descCor;
	}
	public String getDescTamanho() {
		return descTamanho;
	}
	public void setDescTamanho(String descTamanho) {
		this.descTamanho = descTamanho;
	}
	public String getDescSetor() {
		return descSetor;
	}
	public void setDescSetor(String descSetor) {
		this.descSetor = descSetor;
	}
	public String getDescLinha() {
		return descLinha;
	}
	public void setDescLinha(String descLinha) {
		this.descLinha = descLinha;
	}
	public String getDescMarca() {
		return descMarca;
	}
	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
	}
	public String getDescColecao() {
		return descColecao;
	}
	public void setDescColecao(String descColecao) {
		this.descColecao = descColecao;
	}
	public Date getDataUpdate() {
		return dataUpdate;
	}
	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}
	public void setDataUpdate(String dataUpdate) throws ParseException {
		if (dataUpdate.isEmpty()) {
			this.dataUpdate = null;
		} else {
			this.dataUpdate = dtFormatter.parse(dataUpdate);
		}
	}
	public Integer getCodFornecedor() {
		return codFornecedor;
	}
	public void setCodFornecedor(Integer codFornecedor) {
		this.codFornecedor = codFornecedor;
	}
	public void setCodFornecedor(String codFornecedor) {
		this.codFornecedor = codFornecedor.isEmpty() ? 0 : Integer.parseInt(codFornecedor);
	}
	public String getDesativado() {
		return desativado;
	}
	public void setDesativado(String desativado) {
		this.desativado = desativado;
	}
	public String getDescEspessura() {
		return descEspessura;
	}
	public void setDescEspessura(String descEspessura) {
		this.descEspessura = descEspessura;
	}
	public Integer getIdEspessura() {
		return idEspessura;
	}
	public void setIdEspessura(Integer idEspessura) {
		this.idEspessura = idEspessura;
	}
	public void setIdEspessura(String idEspessura) {
		this.idEspessura = idEspessura.isEmpty() ? 0 : Integer.parseInt(idEspessura);
	}
	public String getDescClassificacao() {
		return descClassificacao;
	}
	public void setDescClassificacao(String descClassificacao) {
		this.descClassificacao = descClassificacao;
	}
	public Integer getIdClassificacao() {
		return idClassificacao;
	}
	public void setIdClassificacao(Integer idClassificacao) {
		this.idClassificacao = idClassificacao;
	}
	public void setIdClassificacao(String idClassificacao) {
		this.idClassificacao = idClassificacao.isEmpty() ? 0 : Integer.parseInt(idClassificacao);
	}
	public Integer getOrigemMercadoria() {
		return origemMercadoria;
	}
	public void setOrigemMercadoria(Integer origemMercadoria) {
		this.origemMercadoria = origemMercadoria;
	}
	public void setOrigemMercadoria(String origemMercadoria) {
		this.origemMercadoria = origemMercadoria.isEmpty() ? 0 : Integer.parseInt(origemMercadoria);
	}
	public Float getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(Float pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public void setPesoLiquido(String pesoLiquido) {
		this.pesoLiquido = pesoLiquido.isEmpty() ? 0 : Float.parseFloat(pesoLiquido);
	}
	public Float getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public void setPesoBruto(String pesoBruto) {
		this.pesoBruto = pesoBruto.isEmpty() ? 0 : Float.parseFloat(pesoBruto);
	}
	public Integer getIdCor() {
		return idCor;
	}
	public void setIdCor(Integer idCor) {
		this.idCor = idCor;
	}
	public void setIdCor(String idCor) {
		this.idCor = idCor.isEmpty() ? 0 : Integer.parseInt(idCor);
	}
	public Integer getIdTamanho() {
		return idTamanho;
	}
	public void setIdTamanho(Integer idTamanho) {
		this.idTamanho = idTamanho;
	}
	public void setIdTamanho(String idTamanho) {
		this.idTamanho = idTamanho.isEmpty() ? 0 : Integer.parseInt(idTamanho);
	}
	public Integer getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}
	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor.isEmpty() ? 0 : Integer.parseInt(idSetor);
	}
	public Integer getIdLinha() {
		return idLinha;
	}
	public void setIdLinha(Integer idLinha) {
		this.idLinha = idLinha;
	}
	public void setIdLinha(String idLinha) {
		this.idLinha = idLinha.isEmpty() ? 0 : Integer.parseInt(idLinha);
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca.isEmpty() ? 0 : Integer.parseInt(idMarca);
	}
	public Integer getIdColecao() {
		return idColecao;
	}
	public void setIdColecao(Integer idColecao) {
		this.idColecao = idColecao;
	}
	public void setIdColecao(String idColecao) {
		this.idColecao = idColecao.isEmpty() ? 0 : Integer.parseInt(idColecao);
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public void setDataInclusao(String dataInclusao) throws ParseException {
		if (dataInclusao.isEmpty()) {
			this.dataInclusao = null;
		} else {
			this.dataInclusao = dtFormatter.parse(dataInclusao);
		}
	}
	
	@Override
	public String toString() {
		return "ProdutoModel [codProduto=" + codProduto + ", codBarra=" + codBarra + ", nome=" + nome + ", ncm=" + ncm
				+ ", cest=" + cest + ", referencia=" + referencia + ", codAuxiliar=" + codAuxiliar + ", unidade="
				+ unidade + ", descCor=" + descCor + ", descTamanho=" + descTamanho + ", descSetor=" + descSetor
				+ ", descLinha=" + descLinha + ", descMarca=" + descMarca + ", descColecao=" + descColecao
				+ ", dataUpdate=" + dataUpdate + ", codFornecedor=" + codFornecedor + ", desativado=" + desativado
				+ ", descEspessura=" + descEspessura + ", idEspessura=" + idEspessura + ", descClassificacao="
				+ descClassificacao + ", idClassificacao=" + idClassificacao + ", origemMercadoria=" + origemMercadoria
				+ ", pesoLiquido=" + pesoLiquido + ", pesoBruto=" + pesoBruto + ", idCor=" + idCor + ", idTamanho="
				+ idTamanho + ", idSetor=" + idSetor + ", idLinha=" + idLinha + ", idMarca=" + idMarca + ", idColecao="
				+ idColecao + ", dataInclusao=" + dataInclusao + "]";
	}
	
	
}

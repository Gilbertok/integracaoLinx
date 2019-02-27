package br.com.wadvice.rest.model.linx;

import java.text.ParseException;
import java.util.Date;

public class VendedoresModel extends LinxModel {
	
	private Integer codigoVendedor;
	private String nome;
	private String tipo;
	private String endereco;
	private Integer endNumero;
	private String endComplemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String telefone;
	private String email;
	private Date dataUpdate;
	private String cpf;
	private String ativo;
	private Date dataAdminissao;
	private Date dataSaida;
	
	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor.isEmpty() ? 0 : Integer.parseInt(codigoVendedor);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getEndNumero() {
		return endNumero;
	}
	public void setEndNumero(Integer endNumero) {
		this.endNumero = endNumero;
	}
	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero.isEmpty() ? 0 : Integer.parseInt(endNumero);
	}
	public String getEndComplemento() {
		return endComplemento;
	}
	public void setEndComplemento(String endComplemento) {
		this.endComplemento = endComplemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public Date getDataAdminissao() {
		return dataAdminissao;
	}
	public void setDataAdminissao(Date dataAdminissao) {
		this.dataAdminissao = dataAdminissao;
	}
	public void setDataAdminissao(String dataAdminissao) throws ParseException {
		if (dataAdminissao.isEmpty()) {
			this.dataAdminissao = null;
		} else {
			this.dataAdminissao = dtFormatter.parse(dataAdminissao);
		}
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public void setDataSaida(String dataSaida) throws ParseException {
		if (dataSaida.isEmpty()) {
			this.dataSaida = null;
		} else {
			this.dataSaida = dtFormatter.parse(dataSaida);
		}
	}
	
	@Override
	public String toString() {
		return "VendedoresModel [codigoVendedor=" + codigoVendedor + ", nome=" + nome + ", tipo=" + tipo + ", endereco="
				+ endereco + ", endNumero=" + endNumero + ", endComplemento=" + endComplemento + ", bairro=" + bairro
				+ ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + ", telefone=" + telefone + ", email=" + email
				+ ", dataUpdate=" + dataUpdate + ", cpf=" + cpf + ", ativo=" + ativo + ", dataAdminissao="
				+ dataAdminissao + ", dataSaida=" + dataSaida + "]";
	}
	
}

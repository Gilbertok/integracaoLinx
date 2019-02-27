package br.com.wadvice.rest.model.linx;

import java.text.ParseException;
import java.util.Date;

public class ClientesFornecContatosModel extends LinxModel {
	
	private String codigoCliente;
	private String nomeContato;
	private String sexo;
	private Integer parentesco;
	private String telefone1;
	private String telefone2;
	private String celular;
	private Date dataNascimento;
	private String tipo;
	private String email;
	
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getParentesco() {
		return parentesco;
	}
	public void setParentesco(Integer parentesco) {
		this.parentesco = parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco.isEmpty() ? 0 : Integer.parseInt(parentesco);
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) throws ParseException {
		if (dataNascimento.isEmpty()) {
			this.dataNascimento = null;
		} else {
			this.dataNascimento = dtFormatter.parse(dataNascimento);
		}
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "ClientesFornecContatosModel [codigoCliente=" + codigoCliente + ", nomeContato=" + nomeContato
				+ ", sexo=" + sexo + ", parentesco=" + parentesco + ", telefone1=" + telefone1 + ", telefone2="
				+ telefone2 + ", celular=" + celular + ", dataNascimento=" + dataNascimento + ", tipo=" + tipo + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

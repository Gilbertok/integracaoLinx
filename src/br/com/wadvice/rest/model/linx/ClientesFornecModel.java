package br.com.wadvice.rest.model.linx;

import java.text.ParseException;
import java.util.Date;

public class ClientesFornecModel extends LinxModel {
	
	private String codigoCliente;
	private String razao;
	private String nome;
	private String cpfCnpj;
	private String tipoCliente;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String pais;
	private String telefone;
	private String email;
	private String sexo;
	private Date dataCadastro;
	private Date dataNasciemnto;
	private String celular;
	private String ativo;
	private Date dataUpdate;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String identidade;
	private String cartaoFidelidade;
	private Integer codigoIbgeMunicipio;
	private String classe;
	private String matricula;
	private String tipoCadastro;
	private String idEstadoCivil;
	private String fax;
	private String site;
	private Integer empresa;
	
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) throws ParseException {
		if (dataCadastro.isEmpty()) {
			this.dataCadastro = null;
		} else {
			this.dataCadastro = dtFormatter.parse(dataCadastro);
		}
	}
	public Date getDataNasciemnto() {
		return dataNasciemnto;
	}
	public void setDataNasciemnto(Date dataNasciemnto) {
		this.dataNasciemnto = dataNasciemnto;
	}
	public void setDataNasciemnto(String dataNasciemnto) throws ParseException {
		if (dataNasciemnto.isEmpty()) {
			this.dataNasciemnto = null;
		} else {
			this.dataNasciemnto = dtFormatter.parse(dataNasciemnto);
		}
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
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
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public String getCartaoFidelidade() {
		return cartaoFidelidade;
	}
	public void setCartaoFidelidade(String cartaoFidelidade) {
		this.cartaoFidelidade = cartaoFidelidade;
	}
	public Integer getCodigoIbgeMunicipio() {
		return codigoIbgeMunicipio;
	}
	public void setCodigoIbgeMunicipio(Integer codigoIbgeMunicipio) {
		this.codigoIbgeMunicipio = codigoIbgeMunicipio;
	}
	public void setCodigoIbgeMunicipio(String codigoIbgeMunicipio) {
		this.codigoIbgeMunicipio = codigoIbgeMunicipio.isEmpty() ? 0 : Integer.parseInt(codigoIbgeMunicipio);
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getTipoCadastro() {
		return tipoCadastro;
	}
	public void setTipoCadastro(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
	public String getIdEstadoCivil() {
		return idEstadoCivil;
	}
	public void setIdEstadoCivil(String idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa.isEmpty() ? 0 : Integer.parseInt(empresa);
	}
	
	@Override
	public String toString() {
		return "ClientesFornecModel [codigoCliente=" + codigoCliente + ", razao=" + razao + ", nome=" + nome
				+ ", cpfCnpj=" + cpfCnpj + ", tipoCliente=" + tipoCliente + ", endereco=" + endereco + ", numero="
				+ numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade
				+ ", uf=" + uf + ", pais=" + pais + ", telefone=" + telefone + ", email=" + email + ", sexo=" + sexo
				+ ", dataCadastro=" + dataCadastro + ", dataNasciemnto=" + dataNasciemnto + ", celular=" + celular
				+ ", ativo=" + ativo + ", dataUpdate=" + dataUpdate + ", inscricaoEstadual=" + inscricaoEstadual
				+ ", inscricaoMunicipal=" + inscricaoMunicipal + ", cartaoFidelidade=" + cartaoFidelidade
				+ ", codigoIbgeMunicipio=" + codigoIbgeMunicipio + ", classe=" + classe + ", matricula=" + matricula
				+ ", tipoCadastro=" + tipoCadastro + ", idEstadoCivil=" + idEstadoCivil + ", fax=" + fax + ", site="
				+ site + ", empresa=" + empresa + "]";
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	
}

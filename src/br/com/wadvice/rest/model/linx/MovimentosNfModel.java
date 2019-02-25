package br.com.wadvice.rest.model.linx;

import java.text.ParseException;
import java.util.Date;

public class MovimentosNfModel extends LinxModel {
	
	private Integer transacao;
	private Integer usuario;
	private Integer documento;
	private String chaveNf;
	private Integer ecf;
	private String nrSerEcf;
	private Integer modeloNf;
	private Date dataDocuemnto;
	private Date dataLancamento;
	private Integer codigoCliente;
	private String serie;
	private String descCfop;
	private String idCfop;
	private Integer codigoVendedor;
	private Float quantidade;
	private Float precoCusto;
	private Float valorLiquido;
	private Float desconto;
	private String cstIcms;
	private String cstPis;
	private String cstCofins;
	private String cstIpi;
	private Float valorIcms;
	private Float aliquotaIcms;
	private Float baseIcms;
	private Float valorPis;
	private Float aliquotaPis;
	private Float basePis;
	private Float valorCofins;
	private Float aliquotaCofins;
	private Float baseCofins;
	private Float valorIcmsSt;
	private Float aliquotaIcmsSt;
	private Float baseIcmsSt;
	private Float valorIPI;
	private Float aliquotaIPI;
	private Float baseIPI;
	private Float valorTotal;
	private int formaDinheiro;
	private Float totalDinheiro;
	private int formaCheque;
	private Float totalCheque;
	private int formaCartao;
	private Float totalCartao;
	private int formaCrediario;
	private Float totalCrediario;
	private int formaConvenio;
	private Float totalConvenio;
	private Float frete;
	private String operacao;
	private String tipoTransacao;
	private String codigoProduto;
	private String codigoBarra;
	private String cancelado;
	private String excluido;
	private String somaRelatorio;
	private String identificador;
	private String deposito;
	private String observacao;
	private Float precoUnitario;
	private Date horaLancamento;
	private String naturezaOperacao;
	private Integer tabelaPreco;
	private String nomeTabelaPreco;
	private Integer codigoSefazSituacao;
	private String descSefazSituacao;
	private String protocoloAutNfe;
	private Date dataUpdate;
	private Integer formaChequePrazo;
	private Float totalChequePrazo;
	private Float codigoNaturezaOperacao;
	private Float precoTabelaEpoca;
	private Float descontoTotalItem;
	private String conferido;
	public Integer getTransacao() {
		return transacao;
	}
	public void setTransacao(Integer transacao) {
		this.transacao = transacao;
	}
	public void setTransacao(String transacao) {
		this.transacao = transacao != null ? Integer.parseInt(transacao) : 0;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario != null ? Integer.parseInt(usuario) : 0;
	}
	public Integer getDocumento() {
		return documento;
	}
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento != null ? Integer.parseInt(documento) : 0;
	}
	public String getChaveNf() {
		return chaveNf;
	}
	public void setChaveNf(String chaveNf) {
		this.chaveNf = chaveNf;
	}
	public Integer getEcf() {
		return ecf;
	}
	public void setEcf(Integer ecf) {
		this.ecf = ecf;
	}
	public void setEcf(String ecf) {
		this.ecf = ecf != null ? Integer.parseInt(ecf) : 0;
	}
	public String getNrSerEcf() {
		return nrSerEcf;
	}
	public void setNrSerEcf(String nrSerEcf) {
		this.nrSerEcf = nrSerEcf;
	}
	public Integer getModeloNf() {
		return modeloNf;
	}
	public void setModeloNf(Integer modeloNf) {
		this.modeloNf = modeloNf;
	}
	public void setModeloNf(String modeloNf) {
		this.modeloNf = modeloNf != null ? Integer.parseInt(modeloNf) : 0;
	}
	public Date getDataDocuemnto() {
		return dataDocuemnto;
	}
	public void setDataDocuemnto(Date dataDocuemnto) {
		this.dataDocuemnto = dataDocuemnto;
	}
	public void setDataDocuemnto(String dataDocuemnto) {
		try {
			this.dataDocuemnto = dtFormatter.parse(dataDocuemnto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		try {
			this.dataLancamento = dtFormatter.parse(dataLancamento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente != null ? Integer.parseInt(codigoCliente) : 0;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getDescCfop() {
		return descCfop;
	}
	public void setDescCfop(String descCfop) {
		this.descCfop = descCfop;
	}
	public String getIdCfop() {
		return idCfop;
	}
	public void setIdCfop(String idCfop) {
		this.idCfop = idCfop;
	}
	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor != null ? Integer.parseInt(codigoVendedor) : 0;
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
	public Float getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(Float valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public void setValorLiquido(String valorLiquido) {
		this.valorLiquido = valorLiquido != null ? Float.parseFloat(valorLiquido) : 0;
	}
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto != null ? Float.parseFloat(desconto) : 0;
	}
	public String getCstIcms() {
		return cstIcms;
	}
	public void setCstIcms(String cstIcms) {
		this.cstIcms = cstIcms;
	}
	public String getCstPis() {
		return cstPis;
	}
	public void setCstPis(String cstPis) {
		this.cstPis = cstPis;
	}
	public String getCstCofins() {
		return cstCofins;
	}
	public void setCstCofins(String cstCofins) {
		this.cstCofins = cstCofins;
	}
	public String getCstIpi() {
		return cstIpi;
	}
	public void setCstIpi(String cstIpi) {
		this.cstIpi = cstIpi;
	}
	public Float getValorIcms() {
		return valorIcms;
	}
	public void setValorIcms(Float valorIcms) {
		this.valorIcms = valorIcms;
	}
	public void setValorIcms(String valorIcms) {
		this.valorIcms = valorIcms != null ? Float.parseFloat(valorIcms) : 0;
	}
	public Float getAliquotaIcms() {
		return aliquotaIcms;
	}
	public void setAliquotaIcms(Float aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}
	public void setAliquotaIcms(String aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms != null ? Float.parseFloat(aliquotaIcms) : 0;
	}
	public Float getBaseIcms() {
		return baseIcms;
	}
	public void setBaseIcms(Float baseIcms) {
		this.baseIcms = baseIcms;
	}
	public void setBaseIcms(String baseIcms) {
		this.baseIcms = baseIcms != null ? Float.parseFloat(baseIcms) : 0;
	}
	public Float getValorPis() {
		return valorPis;
	}
	public void setValorPis(Float valorPis) {
		this.valorPis = valorPis;
	}
	public void setValorPis(String valorPis) {
		this.valorPis = valorPis != null ? Float.parseFloat(valorPis) : 0;
	}
	public Float getAliquotaPis() {
		return aliquotaPis;
	}
	public void setAliquotaPis(Float aliquotaPis) {
		this.aliquotaPis = aliquotaPis;
	}
	public void setAliquotaPis(String aliquotaPis) {
		this.aliquotaPis = aliquotaPis != null ? Float.parseFloat(aliquotaPis) : 0;
	}
	public Float getBasePis() {
		return basePis;
	}
	public void setBasePis(Float basePis) {
		this.basePis = basePis;
	}
	public void setBasePis(String basePis) {
		this.basePis = basePis != null ? Float.parseFloat(basePis) : 0;
	}
	public Float getValorCofins() {
		return valorCofins;
	}
	public void setValorCofins(Float valorCofins) {
		this.valorCofins = valorCofins;
	}
	public void setValorCofins(String valorCofins) {
		this.valorCofins = valorCofins != null ? Float.parseFloat(valorCofins) : 0;
	}
	public Float getAliquotaCofins() {
		return aliquotaCofins;
	}
	public void setAliquotaCofins(Float aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}
	public void setAliquotaCofins(String aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins != null ? Float.parseFloat(aliquotaCofins) : 0;
	}
	public Float getBaseCofins() {
		return baseCofins;
	}
	public void setBaseCofins(Float baseCofins) {
		this.baseCofins = baseCofins;
	}
	public void setBaseCofins(String baseCofins) {
		this.baseCofins = baseCofins != null ? Float.parseFloat(baseCofins) : 0;
	}
	public Float getValorIcmsSt() {
		return valorIcmsSt;
	}
	public void setValorIcmsSt(Float valorIcmsSt) {
		this.valorIcmsSt = valorIcmsSt;
	}
	public void setValorIcmsSt(String valorIcmsSt) {
		this.valorIcmsSt = valorIcmsSt != null ? Float.parseFloat(valorIcmsSt) : 0;
	}
	public Float getAliquotaIcmsSt() {
		return aliquotaIcmsSt;
	}
	public void setAliquotaIcmsSt(Float aliquotaIcmsSt) {
		this.aliquotaIcmsSt = aliquotaIcmsSt;
	}
	public void setAliquotaIcmsSt(String aliquotaIcmsSt) {
		this.aliquotaIcmsSt = aliquotaIcmsSt.isEmpty() ? 0 : Float.parseFloat(aliquotaIcmsSt);
	}
	public Float getBaseIcmsSt() {
		return baseIcmsSt;
	}
	public void setBaseIcmsSt(Float baseIcmsSt) {
		this.baseIcmsSt = baseIcmsSt;
	}
	public void setBaseIcmsSt(String baseIcmsSt) {
		this.baseIcmsSt = baseIcmsSt != null ? Float.parseFloat(baseIcmsSt) : 0;
	}
	public Float getValorIPI() {
		return valorIPI;
	}
	public void setValorIPI(Float valorIPI) {
		this.valorIPI = valorIPI;
	}
	public void setValorIPI(String valorIPI) {
		this.valorIPI = valorIPI != null ? Float.parseFloat(valorIPI) : 0;
	}
	public Float getAliquotaIPI() {
		return aliquotaIPI;
	}
	public void setAliquotaIPI(Float aliquotaIPI) {
		this.aliquotaIPI = aliquotaIPI;
	}
	public void setAliquotaIPI(String aliquotaIPI) {
		this.aliquotaIPI = aliquotaIPI != null ? Float.parseFloat(aliquotaIPI) : 0;
	}
	public Float getBaseIPI() {
		return baseIPI;
	}
	public void setBaseIPI(Float baseIPI) {
		this.baseIPI = baseIPI;
	}
	public void setBaseIPI(String baseIPI) {
		this.baseIPI = baseIPI != null ? Float.parseFloat(baseIPI) : 0;
	}
	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal != null ? Float.parseFloat(valorTotal) : 0;
	}
	public int getFormaDinheiro() {
		return formaDinheiro;
	}
	public void setFormaDinheiro(int formaDinheiro) {
		this.formaDinheiro = formaDinheiro;
	}
	public void setFormaDinheiro(String formaDinheiro) {
		this.formaDinheiro = formaDinheiro != null ? Integer.parseInt(formaDinheiro) : 0;
	}
	public Float getTotalDinheiro() {
		return totalDinheiro;
	}
	public void setTotalDinheiro(Float totalDinheiro) {
		this.totalDinheiro = totalDinheiro;
	}
	public void setTotalDinheiro(String totalDinheiro) {
		this.totalDinheiro = totalDinheiro != null ? Float.parseFloat(totalDinheiro) : 0;
	}
	public int getFormaCheque() {
		return formaCheque;
	}
	public void setFormaCheque(int formaCheque) {
		this.formaCheque = formaCheque;
	}
	public void setFormaCheque(String formaCheque) {
		this.formaCheque = formaCheque != null ? Integer.parseInt(formaCheque) : 0;
	}
	public Float getTotalCheque() {
		return totalCheque;
	}
	public void setTotalCheque(Float totalCheque) {
		this.totalCheque = totalCheque;
	}
	public void setTotalCheque(String totalCheque) {
		this.totalCheque = totalCheque != null ? Float.parseFloat(totalCheque) : 0;
	}
	public int getFormaCartao() {
		return formaCartao;
	}
	public void setFormaCartao(int formaCartao) {
		this.formaCartao = formaCartao;
	}
	public void setFormaCartao(String formaCartao) {
		this.formaCartao = formaCartao != null ? Integer.parseInt(formaCartao) : 0;
	}
	public Float getTotalCartao() {
		return totalCartao;
	}
	public void setTotalCartao(Float totalCartao) {
		this.totalCartao = totalCartao;
	}
	public void setTotalCartao(String totalCartao) {
		this.totalCartao = totalCartao != null ? Float.parseFloat(totalCartao) : 0;
	}
	public int getFormaCrediario() {
		return formaCrediario;
	}
	public void setFormaCrediario(int formaCrediario) {
		this.formaCrediario = formaCrediario;
	}
	public void setFormaCrediario(String formaCrediario) {
		this.formaCrediario = formaCrediario != null ? Integer.parseInt(formaCrediario) : 0;
	}
	public Float getTotalCrediario() {
		return totalCrediario;
	}
	public void setTotalCrediario(Float totalCrediario) {
		this.totalCrediario = totalCrediario;
	}
	public void setTotalCrediario(String totalCrediario) {
		this.totalCrediario = totalCrediario != null ? Float.parseFloat(totalCrediario) : 0;
	}
	public int getFormaConvenio() {
		return formaConvenio;
	}
	public void setFormaConvenio(int formaConvenio) {
		this.formaConvenio = formaConvenio;
	}
	public void setFormaConvenio(String formaConvenio) {
		this.formaConvenio = formaConvenio != null ? Integer.parseInt(formaConvenio) : 0;
	}
	public Float getTotalConvenio() {
		return totalConvenio;
	}
	public void setTotalConvenio(Float totalConvenio) {
		this.totalConvenio = totalConvenio;
	}
	public void setTotalConvenio(String totalConvenio) {
		this.totalConvenio = totalConvenio != null ? Float.parseFloat(totalConvenio) : 0;
	}
	public Float getFrete() {
		return frete;
	}
	public void setFrete(Float frete) {
		this.frete = frete;
	}
	public void setFrete(String frete) {
		this.frete = frete != null ? Float.parseFloat(frete) : 0;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getCancelado() {
		return cancelado;
	}
	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}
	public String getExcluido() {
		return excluido;
	}
	public void setExcluido(String excluido) {
		this.excluido = excluido;
	}
	public String getSomaRelatorio() {
		return somaRelatorio;
	}
	public void setSomaRelatorio(String somaRelatorio) {
		this.somaRelatorio = somaRelatorio;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getDeposito() {
		return deposito;
	}
	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Float getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(Float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public void setPrecoUnitario(String precoUnitario) {
		this.precoUnitario = precoUnitario != null ? Float.parseFloat(precoUnitario) : 0;
	}
	public Date getHoraLancamento() {
		return horaLancamento;
	}
	public void setHoraLancamento(Date horaLancamento) {
		this.horaLancamento = horaLancamento;
	}
	public void setHoraLancamento(String horaLancamento) {
		try {
			this.horaLancamento = hrFormatter.parse(horaLancamento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}
	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}
	public Integer getTabelaPreco() {
		return tabelaPreco;
	}
	public void setTabelaPreco(Integer tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}
	public void setTabelaPreco(String tabelaPreco) {
		this.tabelaPreco = tabelaPreco != null ? Integer.parseInt(tabelaPreco) : 0;
	}
	public String getNomeTabelaPreco() {
		return nomeTabelaPreco;
	}
	public void setNomeTabelaPreco(String nomeTabelaPreco) {
		this.nomeTabelaPreco = nomeTabelaPreco;
	}
	public Integer getCodigoSefazSituacao() {
		return codigoSefazSituacao;
	}
	public void setCodigoSefazSituacao(Integer codigoSefazSituacao) {
		this.codigoSefazSituacao = codigoSefazSituacao;
	}
	public void setCodigoSefazSituacao(String codigoSefazSituacao) {
		this.codigoSefazSituacao = codigoSefazSituacao.isEmpty() ? 0 : Integer.parseInt(codigoSefazSituacao);
	}
	public String getDescSefazSituacao() {
		return descSefazSituacao;
	}
	public void setDescSefazSituacao(String descSefazSituacao) {
		this.descSefazSituacao = descSefazSituacao;
	}
	public String getProtocoloAutNfe() {
		return protocoloAutNfe;
	}
	public void setProtocoloAutNfe(String protocoloAutNfe) {
		this.protocoloAutNfe = protocoloAutNfe;
	}
	public Date getDataUpdate() {
		return dataUpdate;
	}
	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}
	public void setDataUpdate(String dataUpdate) {
		try {
			this.dataUpdate = dtFormatter.parse(dataUpdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public int getFormaChequePrazo() {
		return formaChequePrazo;
	}
	public void setFormaChequePrazo(int formaChequePrazo) {
		this.formaChequePrazo = formaChequePrazo;
	}
	public void setFormaChequePrazo(String formaChequePrazo) {
		this.formaChequePrazo = formaChequePrazo != null ? Integer.parseInt(formaChequePrazo) : 0;
	}
	public Float getTotalChequePrazo() {
		return totalChequePrazo;
	}
	public void setTotalChequePrazo(Float totalChequePrazo) {
		this.totalChequePrazo = totalChequePrazo;
	}
	public void setTotalChequePrazo(String totalChequePrazo) {
		this.totalChequePrazo = totalChequePrazo != null ? Float.parseFloat(totalChequePrazo) : 0;
	}
	public Float getCodigoNaturezaOperacao() {
		return codigoNaturezaOperacao;
	}
	public void setCodigoNaturezaOperacao(Float codigoNaturezaOperacao) {
		this.codigoNaturezaOperacao = codigoNaturezaOperacao;
	}
	public void setCodigoNaturezaOperacao(String codigoNaturezaOperacao) {
		this.codigoNaturezaOperacao = codigoNaturezaOperacao != null ? Float.parseFloat(codigoNaturezaOperacao) : 0;
	}
	public Float getPrecoTabelaEpoca() {
		return precoTabelaEpoca;
	}
	public void setPrecoTabelaEpoca(Float precoTabelaEpoca) {
		this.precoTabelaEpoca = precoTabelaEpoca;
	}
	public void setPrecoTabelaEpoca(String precoTabelaEpoca) {
		this.precoTabelaEpoca = precoTabelaEpoca != null ? Float.parseFloat(precoTabelaEpoca) : 0;
	}
	public Float getDescontoTotalItem() {
		return descontoTotalItem;
	}
	public void setDescontoTotalItem(Float descontoTotalItem) {
		this.descontoTotalItem = descontoTotalItem;
	}
	public void setDescontoTotalItem(String descontoTotalItem) {
		this.descontoTotalItem = descontoTotalItem != null ? Float.parseFloat(descontoTotalItem) : 0;
	}
	public String getConferido() {
		return conferido;
	}
	public void setConferido(String conferido) {
		this.conferido = conferido;
	}
	
	@Override
	public String toString() {
		return "MovimentosNfModel [transacao=" + transacao + ", usuario=" + usuario + ", documento=" + documento
				+ ", chaveNf=" + chaveNf + ", ecf=" + ecf + ", nrSerEcf=" + nrSerEcf + ", modeloNf=" + modeloNf
				+ ", dataDocuemnto=" + dataDocuemnto + ", dataLancamento=" + dataLancamento + ", codigoCliente="
				+ codigoCliente + ", serie=" + serie + ", descCfop=" + descCfop + ", idCfop=" + idCfop
				+ ", codigoVendedor=" + codigoVendedor + ", quantidade=" + quantidade + ", precoCusto=" + precoCusto
				+ ", valorLiquido=" + valorLiquido + ", desconto=" + desconto + ", cstIcms=" + cstIcms + ", cstPis="
				+ cstPis + ", cstCofins=" + cstCofins + ", cstIpi=" + cstIpi + ", valorIcms=" + valorIcms
				+ ", aliquotaIcms=" + aliquotaIcms + ", baseIcms=" + baseIcms + ", valorPis=" + valorPis
				+ ", aliquotaPis=" + aliquotaPis + ", basePis=" + basePis + ", valorCofins=" + valorCofins
				+ ", aliquotaCofins=" + aliquotaCofins + ", baseCofins=" + baseCofins + ", valorIcmsSt=" + valorIcmsSt
				+ ", aliquotaIcmsSt=" + aliquotaIcmsSt + ", baseIcmsSt=" + baseIcmsSt + ", valorIPI=" + valorIPI
				+ ", aliquotaIPI=" + aliquotaIPI + ", baseIPI=" + baseIPI + ", valorTotal=" + valorTotal
				+ ", formaDinheiro=" + formaDinheiro + ", totalDinheiro=" + totalDinheiro + ", formaCheque="
				+ formaCheque + ", totalCheque=" + totalCheque + ", formaCartao=" + formaCartao + ", totalCartao="
				+ totalCartao + ", formaCrediario=" + formaCrediario + ", totalCrediario=" + totalCrediario
				+ ", formaConvenio=" + formaConvenio + ", totalConvenio=" + totalConvenio + ", frete=" + frete
				+ ", operacao=" + operacao + ", tipoTransacao=" + tipoTransacao + ", codigoProduto=" + codigoProduto
				+ ", codigoBarra=" + codigoBarra + ", cancelado=" + cancelado + ", excluido=" + excluido
				+ ", somaRelatorio=" + somaRelatorio + ", identificador=" + identificador + ", deposito=" + deposito
				+ ", observacao=" + observacao + ", precoUnitario=" + precoUnitario + ", horaLancamento="
				+ horaLancamento + ", naturezaOperacao=" + naturezaOperacao + ", tabelaPreco=" + tabelaPreco
				+ ", nomeTabelaPreco=" + nomeTabelaPreco + ", codigoSefazSituacao=" + codigoSefazSituacao
				+ ", descSefazSituacao=" + descSefazSituacao + ", protocoloAutNfe=" + protocoloAutNfe + ", dataUpdate="
				+ dataUpdate + ", formaChequePrazo=" + formaChequePrazo + ", totalChequePrazo=" + totalChequePrazo
				+ ", codigoNaturezaOperacao=" + codigoNaturezaOperacao + ", precoTabelaEpoca=" + precoTabelaEpoca
				+ ", descontoTotalItem=" + descontoTotalItem + ", conferido=" + conferido + "]";
	}
	
}

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
		this.transacao = transacao.isEmpty() ? 0 : Integer.parseInt(transacao);
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario.isEmpty() ? 0 : Integer.parseInt(usuario);
	}
	public Integer getDocumento() {
		return documento;
	}
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento.isEmpty() ? 0 : Integer.parseInt(documento);
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
		this.ecf = ecf.isEmpty() ? 0 : Integer.parseInt(ecf);
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
		this.modeloNf = modeloNf.isEmpty() ? 0 : Integer.parseInt(modeloNf);
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
		this.codigoCliente = codigoCliente.isEmpty() ? 0 : Integer.parseInt(codigoCliente);
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
		this.codigoVendedor = codigoVendedor.isEmpty() ? 0 : Integer.parseInt(codigoVendedor);
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade.isEmpty() ? 0 : Float.parseFloat(quantidade);
	}
	public Float getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(Float precoCusto) {
		this.precoCusto = precoCusto;
	}
	public void setPrecoCusto(String precoCusto) {
		this.precoCusto = precoCusto.isEmpty() ? 0 : Float.parseFloat(precoCusto);
	}
	public Float getValorLiquido() {
		return valorLiquido;
	}
	public void setValorLiquido(Float valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	public void setValorLiquido(String valorLiquido) {
		this.valorLiquido = valorLiquido.isEmpty() ? 0 : Float.parseFloat(valorLiquido);
	}
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto.isEmpty() ? 0 : Float.parseFloat(desconto);
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
		this.valorIcms = valorIcms.isEmpty() ? 0 : Float.parseFloat(valorIcms);
	}
	public Float getAliquotaIcms() {
		return aliquotaIcms;
	}
	public void setAliquotaIcms(Float aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}
	public void setAliquotaIcms(String aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms.isEmpty() ? 0 : Float.parseFloat(aliquotaIcms);
	}
	public Float getBaseIcms() {
		return baseIcms;
	}
	public void setBaseIcms(Float baseIcms) {
		this.baseIcms = baseIcms;
	}
	public void setBaseIcms(String baseIcms) {
		this.baseIcms = baseIcms.isEmpty() ? 0 : Float.parseFloat(baseIcms);
	}
	public Float getValorPis() {
		return valorPis;
	}
	public void setValorPis(Float valorPis) {
		this.valorPis = valorPis;
	}
	public void setValorPis(String valorPis) {
		this.valorPis = valorPis.isEmpty() ? 0 : Float.parseFloat(valorPis);
	}
	public Float getAliquotaPis() {
		return aliquotaPis;
	}
	public void setAliquotaPis(Float aliquotaPis) {
		this.aliquotaPis = aliquotaPis;
	}
	public void setAliquotaPis(String aliquotaPis) {
		this.aliquotaPis = aliquotaPis.isEmpty() ? 0 : Float.parseFloat(aliquotaPis);
	}
	public Float getBasePis() {
		return basePis;
	}
	public void setBasePis(Float basePis) {
		this.basePis = basePis;
	}
	public void setBasePis(String basePis) {
		this.basePis = basePis.isEmpty() ? 0 : Float.parseFloat(basePis);
	}
	public Float getValorCofins() {
		return valorCofins;
	}
	public void setValorCofins(Float valorCofins) {
		this.valorCofins = valorCofins;
	}
	public void setValorCofins(String valorCofins) {
		this.valorCofins = valorCofins.isEmpty() ? 0 : Float.parseFloat(valorCofins);
	}
	public Float getAliquotaCofins() {
		return aliquotaCofins;
	}
	public void setAliquotaCofins(Float aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins;
	}
	public void setAliquotaCofins(String aliquotaCofins) {
		this.aliquotaCofins = aliquotaCofins.isEmpty() ? 0 : Float.parseFloat(aliquotaCofins);
	}
	public Float getBaseCofins() {
		return baseCofins;
	}
	public void setBaseCofins(Float baseCofins) {
		this.baseCofins = baseCofins;
	}
	public void setBaseCofins(String baseCofins) {
		this.baseCofins = baseCofins.isEmpty() ? 0 : Float.parseFloat(baseCofins);
	}
	public Float getValorIcmsSt() {
		return valorIcmsSt;
	}
	public void setValorIcmsSt(Float valorIcmsSt) {
		this.valorIcmsSt = valorIcmsSt;
	}
	public void setValorIcmsSt(String valorIcmsSt) {
		this.valorIcmsSt = valorIcmsSt.isEmpty() ? 0 : Float.parseFloat(valorIcmsSt);
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
		this.baseIcmsSt = baseIcmsSt.isEmpty() ? 0 : Float.parseFloat(baseIcmsSt);
	}
	public Float getValorIPI() {
		return valorIPI;
	}
	public void setValorIPI(Float valorIPI) {
		this.valorIPI = valorIPI;
	}
	public void setValorIPI(String valorIPI) {
		this.valorIPI = valorIPI.isEmpty() ? 0 : Float.parseFloat(valorIPI);
	}
	public Float getAliquotaIPI() {
		return aliquotaIPI;
	}
	public void setAliquotaIPI(Float aliquotaIPI) {
		this.aliquotaIPI = aliquotaIPI;
	}
	public void setAliquotaIPI(String aliquotaIPI) {
		this.aliquotaIPI = aliquotaIPI.isEmpty() ? 0 : Float.parseFloat(aliquotaIPI);
	}
	public Float getBaseIPI() {
		return baseIPI;
	}
	public void setBaseIPI(Float baseIPI) {
		this.baseIPI = baseIPI;
	}
	public void setBaseIPI(String baseIPI) {
		this.baseIPI = baseIPI.isEmpty() ? 0 : Float.parseFloat(baseIPI);
	}
	public Float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal.isEmpty() ? 0 : Float.parseFloat(valorTotal);
	}
	public int getFormaDinheiro() {
		return formaDinheiro;
	}
	public void setFormaDinheiro(int formaDinheiro) {
		this.formaDinheiro = formaDinheiro;
	}
	public void setFormaDinheiro(String formaDinheiro) {
		this.formaDinheiro = formaDinheiro.isEmpty() ? 0 : Integer.parseInt(formaDinheiro);
	}
	public Float getTotalDinheiro() {
		return totalDinheiro;
	}
	public void setTotalDinheiro(Float totalDinheiro) {
		this.totalDinheiro = totalDinheiro;
	}
	public void setTotalDinheiro(String totalDinheiro) {
		this.totalDinheiro = totalDinheiro.isEmpty() ? 0 : Float.parseFloat(totalDinheiro);
	}
	public int getFormaCheque() {
		return formaCheque;
	}
	public void setFormaCheque(int formaCheque) {
		this.formaCheque = formaCheque;
	}
	public void setFormaCheque(String formaCheque) {
		this.formaCheque = formaCheque.isEmpty() ? 0 : Integer.parseInt(formaCheque);
	}
	public Float getTotalCheque() {
		return totalCheque;
	}
	public void setTotalCheque(Float totalCheque) {
		this.totalCheque = totalCheque;
	}
	public void setTotalCheque(String totalCheque) {
		this.totalCheque = totalCheque.isEmpty() ? 0 : Float.parseFloat(totalCheque);
	}
	public int getFormaCartao() {
		return formaCartao;
	}
	public void setFormaCartao(int formaCartao) {
		this.formaCartao = formaCartao;
	}
	public void setFormaCartao(String formaCartao) {
		this.formaCheque = formaCartao.isEmpty() ? 0 : Integer.parseInt(formaCartao);
	}
	public Float getTotalCartao() {
		return totalCartao;
	}
	public void setTotalCartao(Float totalCartao) {
		this.totalCartao = totalCartao;
	}
	public void setTotalCartao(String totalCartao) {
		this.totalCartao = totalCartao.isEmpty() ? 0 : Float.parseFloat(totalCartao);
	}
	public int getFormaCrediario() {
		return formaCrediario;
	}
	public void setFormaCrediario(int formaCrediario) {
		this.formaCrediario = formaCrediario;
	}
	public void setFormaCrediario(String formaCrediario) {
		this.formaCrediario = formaCrediario.isEmpty() ? 0 : Integer.parseInt(formaCrediario);
	}
	public Float getTotalCrediario() {
		return totalCrediario;
	}
	public void setTotalCrediario(Float totalCrediario) {
		this.totalCrediario = totalCrediario;
	}
	public void setTotalCrediario(String totalCrediario) {
		this.totalCrediario = totalCrediario.isEmpty() ? 0 : Float.parseFloat(totalCrediario);
	}
	public int getFormaConvenio() {
		return formaConvenio;
	}
	public void setFormaConvenio(int formaConvenio) {
		this.formaConvenio = formaConvenio;
	}
	public void setFormaConvenio(String formaConvenio) {
		this.formaConvenio = formaConvenio.isEmpty() ? 0 : Integer.parseInt(formaConvenio);
	}
	public Float getTotalConvenio() {
		return totalConvenio;
	}
	public void setTotalConvenio(Float totalConvenio) {
		this.totalConvenio = totalConvenio;
	}
	public void setTotalConvenio(String totalConvenio) {
		this.totalConvenio = totalConvenio.isEmpty() ? 0 : Float.parseFloat(totalConvenio);
	}
	public Float getFrete() {
		return frete;
	}
	public void setFrete(Float frete) {
		this.frete = frete;
	}
	public void setFrete(String frete) {
		this.frete = frete.isEmpty() ? 0 : Float.parseFloat(frete);
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
		this.precoUnitario = precoUnitario.isEmpty() ? 0 : Float.parseFloat(precoUnitario);
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
		this.tabelaPreco = tabelaPreco.isEmpty() ? 0 : Integer.parseInt(tabelaPreco);
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
	public void setDataUpdate(String dataUpdate) throws ParseException {
		if (dataUpdate.isEmpty()) {
			this.dataUpdate = null;
		} else {
			this.dataUpdate = dtFormatter.parse(dataUpdate);
		}
	}
	public int getFormaChequePrazo() {
		return formaChequePrazo;
	}
	public void setFormaChequePrazo(int formaChequePrazo) {
		this.formaChequePrazo = formaChequePrazo;
	}
	public void setFormaChequePrazo(String formaChequePrazo) {
		this.formaChequePrazo = formaChequePrazo.isEmpty() ? 0 : Integer.parseInt(formaChequePrazo);
	}
	public Float getTotalChequePrazo() {
		return totalChequePrazo;
	}
	public void setTotalChequePrazo(Float totalChequePrazo) {
		this.totalChequePrazo = totalChequePrazo;
	}
	public void setTotalChequePrazo(String totalChequePrazo) {
		this.totalChequePrazo = totalChequePrazo.isEmpty() ? 0 : Float.parseFloat(totalChequePrazo);
	}
	public Float getCodigoNaturezaOperacao() {
		return codigoNaturezaOperacao;
	}
	public void setCodigoNaturezaOperacao(Float codigoNaturezaOperacao) {
		this.codigoNaturezaOperacao = codigoNaturezaOperacao;
	}
	public void setCodigoNaturezaOperacao(String codigoNaturezaOperacao) {
		this.codigoNaturezaOperacao = codigoNaturezaOperacao.isEmpty() ? 0 : Float.parseFloat(codigoNaturezaOperacao);
	}
	public Float getPrecoTabelaEpoca() {
		return precoTabelaEpoca;
	}
	public void setPrecoTabelaEpoca(Float precoTabelaEpoca) {
		this.precoTabelaEpoca = precoTabelaEpoca;
	}
	public void setPrecoTabelaEpoca(String precoTabelaEpoca) {
		this.precoTabelaEpoca = precoTabelaEpoca.isEmpty() ? 0 : Float.parseFloat(precoTabelaEpoca);
	}
	public Float getDescontoTotalItem() {
		return descontoTotalItem;
	}
	public void setDescontoTotalItem(Float descontoTotalItem) {
		this.descontoTotalItem = descontoTotalItem;
	}
	public void setDescontoTotalItem(String descontoTotalItem) {
		this.descontoTotalItem = descontoTotalItem.isEmpty() ? 0 : Float.parseFloat(descontoTotalItem);
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

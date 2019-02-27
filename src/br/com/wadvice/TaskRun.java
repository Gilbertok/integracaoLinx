package br.com.wadvice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.wadvice.db.dao.LinxConfigDao;
import br.com.wadvice.rest.SincClientesFornec;
import br.com.wadvice.rest.SincClientesFornecContatos;
import br.com.wadvice.rest.SincLojas;
import br.com.wadvice.rest.SincMovimentosNF;
import br.com.wadvice.rest.SincMovimentosNfTroca;
import br.com.wadvice.rest.SincProdutoDetalhe;
import br.com.wadvice.rest.SincVendedores;
import br.com.wadvice.rest.SincVendedoresMetas;
import br.com.wadvice.rest.model.linx.GrupoLojasModel;
import br.com.wadvice.util.DateUtils;

public class TaskRun {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskRun.class);
	
	public static void main(String[] args) {
		logger.info("- Execucao Inicio -- "+ new Date());
		DateUtils dateUtils = new DateUtils();
		Calendar dataAtual = Calendar.getInstance();
		List<GrupoLojasModel> lojas = new SincLojas().getData();
		for (GrupoLojasModel loja : lojas) {
			logger.info(" Loja -------- "+ loja.getCnpjEmpresa()+ " - "+ loja.getNomeEmpresa());
			LinxConfigDao conf = new LinxConfigDao();
			new SincProdutoDetalhe().getData(loja.getCnpjEmpresa());
			new SincClientesFornec().getData(loja.getCnpjEmpresa());
			new SincClientesFornecContatos().getData(loja.getCnpjEmpresa());
			new SincVendedores().getData(loja.getCnpjEmpresa());
			new SincVendedoresMetas().getData(loja.getCnpjEmpresa());
			
			Calendar dataUltSinc = conf.getDataUltSinc(loja.getPortal(), loja.getCnpjEmpresa());
			while (dateUtils.before(dataUltSinc, dataAtual)) {
				new SincMovimentosNF().getData(loja.getCnpjEmpresa(), dataUltSinc);
				new SincMovimentosNfTroca().getData(loja.getCnpjEmpresa(), dataUltSinc);
				
				dataUltSinc = dateUtils.addDia(dataUltSinc);
			}
			conf.atualizaDataSinc(loja.getPortal(), loja.getCnpjEmpresa());
		}
		logger.info(" Execucao Fim -------- ");
	}

	

}

package br.com.wadvice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.wadvice.rest.IntegracaoLinx;

public class TaskRun {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskRun.class);
	
	public static void main(String[] args) {
		logger.info("- Execucao Inicio -- "+ new Date());
		new IntegracaoLinx().getProdutoDetalhe();
		logger.info(" Execucao Fim -------- ");
	}

	

}

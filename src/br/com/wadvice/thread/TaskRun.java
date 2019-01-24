package br.com.wadvice.thread;

import java.util.Date;

import br.com.wadvice.rest.IntegracaoLinx;

public class TaskRun {
	
	public static void main(String[] args) {
		System.out.println("Execucao Inicio -- "+ new Date());
		new IntegracaoLinx().getProdutoDetalhe();
		System.out.println("Execucao Fim -- "+ new Date());
	}

	

}

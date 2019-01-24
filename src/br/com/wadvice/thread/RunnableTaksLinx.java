package br.com.wadvice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTaksLinx {
	
	public static void main(String[] args) {
		TaskLinx task1 = new TaskLinx("Produtos Detalhes");
		System.out.println("Inicio...");
		ExecutorService threadExecutor = Executors.newFixedThreadPool(1);
		threadExecutor.execute(task1);
		threadExecutor.shutdown();
		System.out.println("Fim, main ends\n");
	}

}

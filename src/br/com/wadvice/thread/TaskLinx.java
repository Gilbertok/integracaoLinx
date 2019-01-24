package br.com.wadvice.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import br.com.wadvice.rest.IntegracaoLinx;
import br.com.wadvice.rest.model.ConfigXml;
import br.com.wadvice.util.ConfigUtils;

public class TaskLinx implements Runnable {
	
	// atualiza o site a cada 1 minuto
	public static final long MINUTO = (1000 * 60); 
	public static final long INICIO = (1000 * 10); 
	public static final long HORA = (MINUTO * 60);
	
	public TaskLinx(String name) {
	}

	@Override
	public void run() {
		Timer timer = null;
		if (timer == null) {
			ConfigXml config = ConfigUtils.getInstance();
			
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				public void run() {
					try {
						System.out.println("Execucao TaskLinx -- "+ new Date());
						new IntegracaoLinx().getProdutoDetalhe();
						System.out.println("Fim TaskLinx -- "+ new Date());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			long tempo = config.getTempoAtualizacao() * HORA;
			timer.scheduleAtFixedRate(tarefa, INICIO, tempo);
		}
	}

}

package br.com.wadvice.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	
	Calendar dataAtual;
	
	public DateUtils() {
		dataAtual = Calendar.getInstance();
	}
	
	public Boolean before(Calendar data1, Calendar data2) {
		if(data1.before(data2)) {
			return true;
		}
		return false;
	}

	public Calendar addDia(Calendar data) {
		data.add(Calendar.DATE, +1);
		Calendar dataRetorno = (Calendar) dataAtual.clone();
		dataRetorno.set(Calendar.DAY_OF_YEAR, data.get(Calendar.DAY_OF_YEAR));
		return dataRetorno;
	}

	public String getHoraInicial(Calendar data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Calendar dataRetorno = (Calendar) data.clone();
		dataRetorno.set(Calendar.HOUR_OF_DAY, 0);
		dataRetorno.set(Calendar.MINUTE, 0);
		dataRetorno.set(Calendar.SECOND, 0);
		return format.format(dataRetorno.getTime());
	}

	public String getHoraFim(Calendar data) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Calendar dataRetorno = (Calendar) data.clone();
		dataRetorno.set(Calendar.HOUR_OF_DAY, 23);
		dataRetorno.set(Calendar.MINUTE, 59);
		dataRetorno.set(Calendar.SECOND, 59);
		return format.format(dataRetorno.getTime());
	}

}

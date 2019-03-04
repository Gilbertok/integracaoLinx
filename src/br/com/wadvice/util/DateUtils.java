package br.com.wadvice.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.wadvice.rest.model.xml.ConfigXml;

public class DateUtils {
	
	Calendar dataAtual;
	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
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
	
	public Calendar addMes(Calendar data) {
		Calendar dataRetorno = (Calendar) (data != null ? data.clone() : Calendar.getInstance().clone());
		dataRetorno.set(Calendar.DAY_OF_MONTH, dataRetorno.getMinimum(Calendar.DAY_OF_MONTH));
		dataRetorno.add(Calendar.MONTH, +1);
		dataRetorno.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH));
		return dataRetorno;
	}

	public String getHoraInicial(Calendar data) {
		Calendar dataRetorno = (Calendar) data.clone();
		dataRetorno.set(Calendar.HOUR_OF_DAY, 0);
		dataRetorno.set(Calendar.MINUTE, 0);
		dataRetorno.set(Calendar.SECOND, 0);
		return formatDate.format(dataRetorno.getTime());
	}

	public String getHoraFim(Calendar data) {
		Calendar dataRetorno = (Calendar) (data != null ? data.clone() : Calendar.getInstance().clone());
		dataRetorno.set(Calendar.HOUR_OF_DAY, 23);
		dataRetorno.set(Calendar.MINUTE, 59);
		dataRetorno.set(Calendar.SECOND, 59);
		return formatDate.format(dataRetorno.getTime());
	}

	public String getInicioMes(Calendar data) {
		Calendar dataRetorno = (Calendar) data.clone();
		dataRetorno.set(Calendar.HOUR_OF_DAY, 0);
		dataRetorno.set(Calendar.MINUTE, 0);
		dataRetorno.set(Calendar.SECOND, 0);
		dataRetorno.set(Calendar.DAY_OF_MONTH, dataRetorno.getActualMinimum(Calendar.DAY_OF_MONTH));
		return formatDate.format(dataRetorno.getTime());
	}
	
	public Date getInicioMesDate(Calendar data) {
		Calendar dataRetorno = (Calendar) data.clone();
		dataRetorno.set(Calendar.HOUR_OF_DAY, 0);
		dataRetorno.set(Calendar.MINUTE, 0);
		dataRetorno.set(Calendar.SECOND, 0);
		dataRetorno.set(Calendar.DAY_OF_MONTH, dataRetorno.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dataRetorno.getTime();
	}
	
	public String getFimMes(Calendar data) {
		Calendar dataRetorno = (Calendar) (data != null ? data.clone() : Calendar.getInstance().clone());
		dataRetorno.set(Calendar.HOUR_OF_DAY, 23);
		dataRetorno.set(Calendar.MINUTE, 59);
		dataRetorno.set(Calendar.SECOND, 59);
		dataRetorno.set(Calendar.DAY_OF_MONTH, dataRetorno.getActualMaximum(Calendar.DAY_OF_MONTH));
		return formatDate.format(dataRetorno.getTime());
	}
	
	public Date getFimMesDate(Calendar data) {
		Calendar dataRetorno = (Calendar) (data != null ? data.clone() : Calendar.getInstance().clone());
		dataRetorno.set(Calendar.HOUR_OF_DAY, 23);
		dataRetorno.set(Calendar.MINUTE, 59);
		dataRetorno.set(Calendar.SECOND, 59);
		dataRetorno.set(Calendar.DAY_OF_MONTH, dataRetorno.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dataRetorno.getTime();
	}

	public String getInicioConfig() {
		ConfigXml config = ConfigUtils.getInstance();
		Calendar dataRetorno = Calendar.getInstance();
		dataRetorno.setTime(config.getDataBaseSync());
		return formatDate.format(dataRetorno.getTime());
	}

}

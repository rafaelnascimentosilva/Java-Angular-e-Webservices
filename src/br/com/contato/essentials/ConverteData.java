package br.com.contato.essentials;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class  ConverteData {
	public  Calendar convertStringInData(String data) throws ParseException{
		Calendar nova_data_convertida;
		Date data_convertida = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		nova_data_convertida = Calendar.getInstance();
		nova_data_convertida.setTime(data_convertida);
		return 	nova_data_convertida;
	}
}

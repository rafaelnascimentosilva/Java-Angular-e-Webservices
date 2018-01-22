package br.com.contato.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class ConverteData {
	public static Date convertStringInData(String data) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date formatado = dateFormat.parse(data);
		java.sql.Date sqlDate = new java.sql.Date(formatado.getTime());
		return sqlDate;
	}

}

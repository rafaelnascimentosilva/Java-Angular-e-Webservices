package br.com.contato.interfaces;

import java.sql.SQLException;
import java.text.ParseException;

import com.mysql.jdbc.Connection;

public interface TransactionCallback {

	void execute(Connection connection) throws SQLException, ParseException;

}

package br.com.contato.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnecticon() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			return DriverManager.getConnection("jdbc:mysql://localhost/banco_contatos", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}

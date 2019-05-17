package br.com.contato.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			return DriverManager.getConnection("jdbc:mysql://localhost/bdcontatos", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	/*public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			return DriverManager.getConnection("jdbc:sqlserver://192.168.44.151:1433;database=dbregisterAngular;integratedSecurity=true", "sa", "user");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	*/
}



package br.com.contato.api;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.contato.connection.ConnectionFactory;
import br.com.contato.interfaces.TransactionCallback;

public class TransactionManager {

	private ConnectionFactory factory = new ConnectionFactory();

	public void doInTransaction(TransactionCallback callback) {
		Connection connection = null;
		try {
			connection = (Connection) this.factory.getConnection(); // abre conex�o
			connection.setAutoCommit(false); // inicia a transa��o
			// --
			callback.execute(connection); // sua l�gica executada aqui
			// --
			connection.commit(); // comita transa��o
		} catch (Exception e) {
			if (connection != null) {
				// desfaz altera��es enviadas pro banco
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new RuntimeException(e); // relan�a exce��o
		} finally {
			if (connection != null) {
				// fecha conex�o e todos seus recursos
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}

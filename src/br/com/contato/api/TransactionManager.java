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
			connection = (Connection) this.factory.getConnection(); // abre conexão
			connection.setAutoCommit(false); // inicia a transação
			// --
			callback.execute(connection); // sua lógica executada aqui
			// --
			connection.commit(); // comita transação
		} catch (Exception e) {
			if (connection != null) {
				// desfaz alterações enviadas pro banco
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new RuntimeException(e); // relança exceção
		} finally {
			if (connection != null) {
				// fecha conexão e todos seus recursos
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}

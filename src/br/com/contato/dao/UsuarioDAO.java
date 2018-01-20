package br.com.contato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.contato.modelo.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public Usuario autentica(String login, String senha) {

		try {
			PreparedStatement statement = this.connection
					.prepareStatement("select * from tb_usuario where login =? and senha=?");
			statement.setString(1, login);
			statement.setString(2, senha);
			
			Usuario usuario = null;			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String uLogin = rs.getString("login");
				String uSenha = rs.getString("senha");

				usuario = new Usuario();

				usuario.setId(id);
				usuario.setNome(nome);
				usuario.setLogin(uLogin);
				usuario.setSenha(uSenha);
				rs.close();
				statement.close();
				return usuario;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}

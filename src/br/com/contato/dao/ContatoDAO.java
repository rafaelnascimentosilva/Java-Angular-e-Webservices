package br.com.contato.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.contato.api.TransactionManager;
import br.com.contato.interfaces.TransactionCallback;
import br.com.contato.modelo.Contato;
import br.com.contato.util.ConverteData;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}

	public void inserir(Contato contato) {

		TransactionManager manager = new TransactionManager();
		manager.doInTransaction(new TransactionCallback() {
			@Override
			public void execute(com.mysql.jdbc.Connection connection) throws SQLException, ParseException {

				String sql = "insert into tb_contato(nome,fone,nascimento)values(?,?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, contato.getNome());
				statement.setString(2, contato.getFone());
				statement.setDate(3, ConverteData.convertStringInData(contato.getNascimento()));
				statement.execute();

			}
		});
	}
//FALTA ADICIONAR TRANSACTION MANAGER
	public List<Contato> listaPaginada( int paginaLimite, int paginaInicio) throws SQLException {
		
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tb_contato ORDER by nome ASC LIMIT ? OFFSET ?");
			statement.setInt(1, paginaLimite);
			statement.setInt(2, paginaInicio);
			ResultSet rs = statement.executeQuery();
			List<Contato> paginacao = new ArrayList<Contato>();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(new Integer(rs.getString("id_contato")));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setNascimento(rs.getString("nascimento"));
				paginacao.add(contato);
			}

			rs.close();
			statement.close();
			return paginacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

	public List<Contato> getLista() {

		TransactionManager manager = new TransactionManager();
		List<Contato> listaDeContatos = new ArrayList<Contato>();

		manager.doInTransaction(new TransactionCallback() {

			@Override
			public void execute(com.mysql.jdbc.Connection connection) throws SQLException, ParseException {

				String sql = "select * from tb_contato";
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					Contato contato = new Contato();
					contato.setId(new Integer(rs.getString("id_contato")));
					contato.setNome(rs.getString("nome"));
					contato.setFone(rs.getString("fone"));
					contato.setNascimento(rs.getString("nascimento"));
					listaDeContatos.add(contato);
				}
			}
		});
		return listaDeContatos;
	}

	//FALTA ADICIONAR TRANSACTION MANAGER
	public Contato getContato(Integer id) throws SQLException {
		
		String sql = "select * from tb_contato where id_contato=?";
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			Contato contato = new Contato();
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				contato.setId(new Integer(rs.getString("id_contato")));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setNascimento(rs.getString("nascimento"));
			}
			rs.close();
			statement.close();
			return contato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

	public void deletar(Integer id) {

		TransactionManager manager = new TransactionManager();
		manager.doInTransaction(new TransactionCallback() {

			@Override
			public void execute(com.mysql.jdbc.Connection connection) throws SQLException, ParseException {
				String sql = "delete from tb_contato where id_contato=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, id);
				statement.execute();
			}
		});
	}

	public Contato alterar(Contato contato) {
		TransactionManager manager = new TransactionManager();
		manager.doInTransaction(new TransactionCallback() {

			@Override
			public void execute(com.mysql.jdbc.Connection connection) throws SQLException, ParseException {
				String sql = "update tb_contato set nome=?, fone=?, nascimento=? where id_contato=?";

				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, contato.getNome());
				statement.setString(2, contato.getFone());
				statement.setDate(3, ConverteData.convertStringInData(contato.getNascimento()));
				statement.setLong(4, contato.getId());
				statement.execute();
				statement.close();
			}
		});
		return contato;
	}

}

package br.com.contato.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.contato.modelo.Contato;

public class ContatoDAO {
	private Connection connection;

	public ContatoDAO(Connection connection) {
		this.connection = connection;
	}

	public void inserir(Contato contato) {
		String sql = "insert into tb_contato(nome,fone,nascimento)values(?,?,?)";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setDate(3, new Date(contato.getNascimento().getTimeInMillis()));
			statement.execute();
			statement.close();

		} catch (SQLException e) {
			System.out.println("erro ao conectar ao banco dao!!!");
			throw new RuntimeException(e);
		}
	}

	public List<Contato> listaPaginada(int paginaInicio, int paginaLimite) {
		try {
			PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tb_contato LIMIT ? OFFSET ?");
			statement.setInt(1, paginaLimite);
			statement.setInt(2, paginaInicio);
			ResultSet rs = statement.executeQuery();
			List<Contato> paginacao = new ArrayList<Contato>();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(new Integer(rs.getString("id_contato")));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(rs.getDate("nascimento"));
				contato.setNascimento(nascimento);
				paginacao.add(contato);
			}

			rs.close();
			statement.close();
			return paginacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Contato> getLista() {
		try {
			PreparedStatement statement = this.connection.prepareStatement("select * from tb_contato");

			ResultSet rs = statement.executeQuery();
			List<Contato> listaDeContatos = new ArrayList<Contato>();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(new Integer(rs.getString("id_contato")));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(rs.getDate("nascimento"));
				contato.setNascimento(nascimento);
				listaDeContatos.add(contato);
			}

			rs.close();
			statement.close();
			return listaDeContatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato getContato(Integer id) {
		String sql = "select * from tb_contato where id_contato=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1,id);
			Contato contato = new Contato();
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				contato.setId(new Integer(rs.getString("id_contato")));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(rs.getDate("nascimento"));
				contato.setNascimento(nascimento);
			}
			rs.close();
			statement.close();
			return contato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deletar(Integer id) {

		String sql = "delete from tb_contato where id_contato=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public Contato alterar(Contato contato) {
		String sql = "update tb_contato set nome=?, fone=?, nascimento=? where id_contato=?";
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setDate(3, new Date(contato.getNascimento().getTimeInMillis()));
			statement.setLong(4, contato.getId());
			statement.execute();
			statement.close();
			return contato;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}

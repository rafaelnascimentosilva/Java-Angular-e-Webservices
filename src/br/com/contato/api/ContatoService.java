package br.com.contato.api;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.mysql.jdbc.Connection;

import br.com.contato.connection.ConnectionFactory;
import br.com.contato.dao.ContatoDAO;
import br.com.contato.modelo.Contato;

@Path("/contato")
@Produces("application/json")

public class ContatoService {

	Connection connection = (Connection) new ConnectionFactory().getConnection();

	@GET
	@Path("/contatos")
	public List<Contato> contatos() {
		return new ContatoDAO(connection).getLista();
	}

	@POST
	public void Adiciona(Contato contato) throws ParseException, SQLException {
		new ContatoDAO(connection).inserir(contato);
	}

	@DELETE
	@Path("/{id}")
	public void Deleta(@PathParam("id") Integer id) {
		new ContatoDAO(connection).deletar(id);
	}

	@PUT
	@Consumes("application/json")
	@Path("{id}")
	public Contato Atualiza(@PathParam("id") Integer id, Contato contato) {
		return new ContatoDAO(connection).alterar(contato);
	}

	@GET
	@Path("{id}")
	public Contato getContato(@PathParam("id") Integer id) throws SQLException {
		return new ContatoDAO(connection).getContato(id);
	}
}

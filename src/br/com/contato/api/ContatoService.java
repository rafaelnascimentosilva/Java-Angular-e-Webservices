package br.com.contato.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mysql.jdbc.Connection;

import br.com.contato.connection.ConnectionFactory;
import br.com.contato.dao.ContatoDAO;
import br.com.contato.modelo.Contato;

@Path("/contato")
public class ContatoService {
	
	Connection connection = (Connection) new ConnectionFactory().getConnecticon();
	@GET
	@Path("/contatos")
	@Produces("application/json")
	public List<Contato> contatos(){
		return new ContatoDAO(connection).getLista();
	}
}

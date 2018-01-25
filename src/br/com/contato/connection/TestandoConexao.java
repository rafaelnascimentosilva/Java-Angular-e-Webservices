package br.com.contato.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.modelo.Contato;

public class TestandoConexao {
	public static void main(String[] args) throws SQLException, ParseException {
		Connection connection = new ConnectionFactory().getConnection();

		/*** CHAMANDO O METODO DE PAGINACAO ***/

		System.out.println(connection.toString());

		/*
		 * ContatoDAO dao = new ContatoDAO(connection); int inicio = 12; int
		 * paginaLimite = 3;
		 * 
		 * List<Contato> paginacao = dao.listaPaginada(inicio, paginaLimite);
		 * 
		 * for (Contato c : paginacao) {
		 * System.out.println("contatos: "+c.getNome()); }
		 */

		// System.out.println("conectado");
		// Contato contatos = new Contato();
		// contatos.setFone("988888888");
		// contatos.setNome("Prima");
		// contatos.setNascimento(Calendar.getInstance());
		// contatos.setId(2);

		ContatoDAO dao = new ContatoDAO(connection);
		Contato contato = new Contato();

		contato.setNome("Paulo");
		contato.setFone("988888888");
		String data = "6/10/2017";
		contato.setNascimento(data);
		
		dao.inserir(contato);
		
		
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		
		java.util.Date formatado = dateFormat.parse(data);		
		java.sql.Date sqlDate = new java.sql.Date(formatado.getTime());		
		System.out.println(sqlDate);
		*/
		
	

		// dao.inserir(contato);

		/*
		 * ContatoDAO dao = new ContatoDAO(connection); List<Contato> lista =
		 * dao.getLista(); for (Contato contatos2 : lista) {
		 * System.out.println("Nome: "+contatos2.getNome()); }
		 * connection.close();
		 */

		/*
		 * ContatoDAO dao = new ContatoDAO(connection); Contato contato = new
		 * Contato(); contato = dao.getContato(119);
		 * 
		 * System.out.print(contato.getId());
		 * System.out.print(contato.getNome());
		 * System.out.print(contato.getFone());
		 * System.out.print(contato.getNascimento().getTimeZone());
		 */
	}
}

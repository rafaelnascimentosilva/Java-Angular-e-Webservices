//package br.com.contato.connection;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.List;
//
//import br.com.contato.dao.ContatoDAO;
//import br.com.contato.modelo.Contato;
//
//public class TestandoConexao {
//public static void main(String[] args) throws SQLException {
//		Connection connection = new ConnectionFactory().getConnecticon();
//		
//		System.out.println("conectado");
//	Contato contatos = new Contato();
//	contatos.setFone("988888888");
//	contatos.setNome("Prima");
//	contatos.setNascimento(Calendar.getInstance());
//	contatos.setId(2);
//	
//	
//	ContatoDAO dao = new ContatoDAO();
//	dao.altera(contatos);
//	
////		contatos.setNome("Rafael");
////		contatos.setFone("988888888");
////		contatos.setNascimento(Calendar.getInstance());
//		
////		ContatoDAO dao = new ContatoDAO();
////		List<Contatos> lista = dao.getLista();
////		for (Contatos contatos2 : lista) {
////		 System.out.println("Nome: "+contatos2.getNome());
////		}
//		connection.close();
//		
//		
//	}
//}
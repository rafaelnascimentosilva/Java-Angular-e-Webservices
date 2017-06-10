package br.com.contato.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.modelo.Contato;

public class TestandoConexao {
public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnecticon();
		
		/*** CHAMANDO O METODO DE PAGINACAO ***/		
			
		/*
		 	ContatoDAO dao = new ContatoDAO(connection);		
			int inicio = 12;
			int paginaLimite = 3;
			
			List<Contato> paginacao = dao.listaPaginada(inicio, paginaLimite);
			
			for (Contato c : paginacao) {
				System.out.println("contatos: "+c.getNome());
			}
		*/
		
//		System.out.println("conectado");
//	Contato contatos = new Contato();
//	contatos.setFone("988888888");
//	contatos.setNome("Prima");
//	contatos.setNascimento(Calendar.getInstance());
//	contatos.setId(2);
	
		
	
	//ContatoDAO dao = new ContatoDAO();
	//dao.altera(contatos);
	
//		contatos.setNome("Rafael");
//		contatos.setFone("988888888");
//		contatos.setNascimento(Calendar.getInstance());
		
	
//		List<Contato> lista = dao.getLista();
//		for (Contato contatos2 : lista) {
//		 System.out.println("Nome: "+contatos2.getNome());
//		}
//		connection.close();
//		
		
		ContatoDAO dao = new ContatoDAO(connection);
		Contato contato = new Contato();
		 contato = dao.getContato(119);
		
		System.out.print(contato.getId());
		System.out.print(contato.getNome());
		System.out.print(contato.getFone());
		System.out.print(contato.getNascimento().getTimeZone());
	}
}

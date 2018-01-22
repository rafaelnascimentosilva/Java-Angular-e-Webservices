package br.com.contato.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.interfaces.Logica;
import br.com.contato.modelo.Contato;

public class ListarContatoLogica implements Logica {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("filtro_conexao");
		HttpSession sessionList = request.getSession();
		
		ContatoDAO dao = new ContatoDAO(connection);
		//List<Contato> listaContatos = dao.getLista();

		//sessionList.setAttribute("lista", listaContatos);
		response.sendRedirect("ListarContato.jsp");		
	}
}

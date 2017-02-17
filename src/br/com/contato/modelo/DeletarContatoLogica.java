package br.com.contato.modelo;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.contato.dao.ContatoDAO;

public class DeletarContatoLogica implements Logica {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Connection connection = (Connection) request.getAttribute("filtro_conexao");

		String id = request.getParameter("id");
		ContatoDAO dao = new ContatoDAO(connection);
		Contato contato = new Contato();
		contato.setId(new Integer(id));
		dao.deletar(contato);
		response.sendRedirect("sucesso.jsp");
	}
}

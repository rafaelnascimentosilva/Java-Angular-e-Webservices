package br.com.contato.modelo;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.essentials.ConverteData;

public class AtualizarContatoLogica implements Logica {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = (Connection) request.getAttribute("filtro_conexao");

		ConverteData dataConv = new ConverteData();
		Contato contato = new Contato();
		ContatoDAO dao = new ContatoDAO(connection);

		String id = request.getParameter("id");
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));

		String nascimento = request.getParameter("nascimento");
		contato.setId(new Integer(id));

		try {
			contato.setNascimento(dataConv.convertStringInData(nascimento));
		} catch (ParseException e) {
			e.printStackTrace();
		}	

		dao.alterar(contato);		
		response.sendRedirect("sucesso.jsp");		
	}
}

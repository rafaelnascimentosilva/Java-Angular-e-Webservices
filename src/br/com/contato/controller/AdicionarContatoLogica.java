package br.com.contato.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.contato.dao.ContatoDAO;
import br.com.contato.interfaces.Logica;
import br.com.contato.modelo.Contato;
import br.com.contato.util.ConverteData;

public class AdicionarContatoLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		Connection connection = (Connection) request.getAttribute("filtro_conexao");

		ContatoDAO dao = new ContatoDAO(connection);
		Contato contato = new Contato();

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		String nascimento = request.getParameter("nascimento");
		ConverteData data = new ConverteData();

		/*try {
			contato.setNascimento(data.convertStringInData(nascimento));
		} catch (ParseException e) {
			e.printStackTrace();
		}
*/
		dao.inserir(contato);
		session.setAttribute("contatoADD", contato);
		response.sendRedirect("adicionado.jsp");

	}

}

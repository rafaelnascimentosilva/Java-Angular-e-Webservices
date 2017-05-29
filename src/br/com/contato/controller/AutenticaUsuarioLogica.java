package br.com.contato.controller;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.contato.dao.UsuarioDAO;
import br.com.contato.interfaces.Logica;
import br.com.contato.modelo.Usuario;

public class AutenticaUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Connection connection = (Connection) request.getAttribute("filtro_conexao");
		Usuario usuarioAutenticado = null;

		UsuarioDAO dao = new UsuarioDAO(connection);
		usuarioAutenticado = dao.autentica(login, senha);

		if (usuarioAutenticado != null) {
			session.setAttribute("usuarioAutenticado", usuarioAutenticado);
			response.sendRedirect("Index.jsp");		
		}
		if (usuarioAutenticado == null) {
			session.setAttribute("msgUsuario", "Login ou Senha inválidos!!!");
			response.sendRedirect("Login.jsp");			
		}
	}

}

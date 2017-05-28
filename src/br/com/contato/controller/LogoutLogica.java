package br.com.contato.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.contato.interfaces.Logica;

public class LogoutLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.setAttribute("usuarioAutenticado", null);
		request.setAttribute("msgUsuario", "OLAPESSOA");
		response.sendRedirect("login2.jsp");
	}

}

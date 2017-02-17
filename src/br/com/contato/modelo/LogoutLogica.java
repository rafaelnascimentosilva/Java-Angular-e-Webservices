package br.com.contato.modelo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutLogica implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.setAttribute("usuarioAutenticado", null);
		response.sendRedirect("Login.jsp");
	}

}

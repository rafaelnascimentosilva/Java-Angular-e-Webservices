package br.com.contato.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.contato.modelo.Usuario;

//@WebFilter(filterName = "FiltroAutorizacao", urlPatterns = "/*")
public class FiltroAutorizacao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String logica = request.getParameter("acao");

		if (logica == null) {
			logica = "";
		}

		if (uri.equals("login2.jsp") || logica.endsWith("AutenticaUsuario") || uri.endsWith("png")
				|| uri.endsWith("css") || uri.endsWith("js") || uri.endsWith("woff2") || uri.endsWith("ttf")
				|| uri.endsWith("woff")) {
			chain.doFilter(request, response);

		} else {
			Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("usuarioAutenticado");
			if (usuarioLogado != null) {
				chain.doFilter(request, response);
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
				request.setAttribute("msgUsuario", "Você nao tem autorização");
				dispatcher.forward(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

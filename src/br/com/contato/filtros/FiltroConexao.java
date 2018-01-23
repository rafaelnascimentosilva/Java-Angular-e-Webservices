package br.com.contato.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.contato.connection.ConnectionFactory;

@WebFilter(filterName = "FiltroConexao", urlPatterns = "/crud-system")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("ABRINDO CONEXAO COM BANCO............");
		request.setAttribute("filtro_conexao", connection);
		chain.doFilter(request, response);

		try {
			System.out.println("FECHANDO CONEXAO COM BANCO............");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new RuntimeException("Erro ao tentar fechar o banco");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

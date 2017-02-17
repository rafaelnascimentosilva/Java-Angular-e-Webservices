<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Menu</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	Seja bem vindo ${usuarioAutenticado.nome} ao sistema de contatos
	<table>
		<tr>
			<td><h3>Menu</h3></td>
		</tr>
		<tr>
			<td><a href="crud-system?acao=ListarContato">Lista Contatos</a></td>
		</tr>
		<tr>
			<td><a href="AdicionarContato.jsp">Adiciona Contatos</a></td>
		</tr>
		<tr>
			<td><a href="crud-system?acao=Logout">Sair</a></td>
		</tr>
	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>
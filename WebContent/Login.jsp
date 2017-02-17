<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acessar Sistema Contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	${usuarioAutenticado.nome}
	<form action="crud-system?acao=AutenticaUsuario" method="post"
		id="formLogar">
		Login: <input type="text" name="login"> Senha: <input
			type="password" name="senha"> <input type="submit"
			value="Entrar no sistema">

	</form>
	<p>${msgUsuario}</p>
	<hr>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>
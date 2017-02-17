<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<form action="crud-system" method="get">
		<input type="hidden" name="acao" value="AtualizarContato"> id:<input
			type="text" name="id" value="${param.id}"><br> nome:<input
			type="text" name="nome" value="${param.nome}"><br> fone
		<input type="text" name="fone" value="${param.fone}"><br>
		nascimento<input type="text" name="nascimento"
			value="${param.nascimento}"><br> <input type="submit"
			value="Enviar">
	</form>
	<a href="Index.jsp">Voltar</a>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>
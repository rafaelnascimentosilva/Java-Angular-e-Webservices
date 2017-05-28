<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listando os Contatos</title>
</head>
<body>

	<form action="../../crud-system" method="get">
		<input type="hidden" name="acao" value="listar">
	</form>

	<table cellpadding="4" cellspacing="4">
		<c:forEach var="contato" items="${lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'a87e14' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td>${contato.fone}</td>
				<td><fmt:formatDate value="${contato.nascimento.time }"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="../../crud-system?acao=DeletarContato&id=${contato.id}">deletar</a>
				</td>
				<td><a
					href="edita.jsp?id=${contato.id}&nome=${contato.nome}&fone=${contato.fone}&nascimento=<fmt:formatDate value="${contato.nascimento.time}" pattern="dd/MM/yyyy"/>">editar</a>
				</td>
			</tr>
		</c:forEach>

	</table>
	<hr>
	<a href="novo.jsp"> Novo Contato</a>
	<a href="../../Index.jsp"> Início</a>

</body>
</html>
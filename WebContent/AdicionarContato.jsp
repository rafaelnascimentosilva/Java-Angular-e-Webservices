<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NOVO CONTATO</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.inputmask.js"></script>
<script type="text/javascript" src="js/mascara.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

</head>
<body>


	<form action="crud-system" method="get" id="formInserir">
		<input type="hidden" name="acao" value="AdicionarContato">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" required></td>
			</tr>
			<tr>
				<td>Fone:</td>
				<td><input id="telefone" type="text" name="fone" required></td>
			</tr>
			<tr>
				<td>Nascimento:</td>
				<td><input id="dataNascimento" type="text" name="nascimento"
					required></td>
			</tr>
			<tr align="right">
				<td></td>

				<td><input type="submit" value="Cadastar"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='crud-system?acao=ListarContato'">Voltar</button>
	
</body>
</html>
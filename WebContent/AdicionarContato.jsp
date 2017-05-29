<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">	
		
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
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NOVO CONTATO</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../js/jquery.inputmask.js"></script>
<script type="text/javascript" src="../../js/mascara.js"></script>
<script type="text/javascript" src="../../js/jquery.validate.min.js"></script>

</head>
<body>	
	<div class="container">
		<div class="jumbotron">
			
				<form class="form-signin" action="../../crud-system" method="get" id="formInserir">
					<input type="hidden" name="acao" value="AdicionarContato">
						<div class="form-group row ">					
								<div class="col-xs-3">
									<label for="nome">Nome:</label>
									<input id="nome" class="form-control" type="text" name="nome" required >
								</div>	
								<div class="col-xs-3">
									<label for="telefone">Fone:</label>
									<input id="telefone" class="form-control" type="text" name="fone" required>
								</div>		
								<div class="col-xs-3">
									<label for="dataNascimento">Nascimento:</label>
									<input id="dataNascimento" class="form-control" type="text" name="nascimento" required>			
								</div>						
						</div>
				</form>
				<button class="btn btn-lg btn-primary" type="submit" form="formInserir" value="Cadastrar"> Cadastrar</button>
				<button class="btn btn-lg btn-primary" onclick="location.href='../../crud-system?acao=ListarContato'">Voltar</button>	
			
		</div>
	</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Login Contatos</title>
	
	<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/estilo.css" rel="stylesheet">	
</head>
<body>
	 <div class="login-form col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
	 <div class="teste">
		 <header>
		 	<img class="img-responsive" alt="logo" src="resources/imagens/logo.png">
		 </header>
			<form action="crud-system?acao=AutenticaUsuario" method="post" id="formLogar" accept-charset="utf-8">			
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>				 
						</div>
							<input type="text" name="login" class="form-control" placeholder="Usuário" required>
					</div>
				</div>
				
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-option-horizontal"></span>				 
						</div>
							<input type="password" name="senha" class="form-control" placeholder="Senha" required>
					</div>
				</div>
									
			</form>
		<footer>
			<button type="submit" form="formLogar" class="btn btn-primary" >Entrar</button>
			<p>${msgUsuario}</p>
		</footer>	
		</div>
	</div>
	
	<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>
</body>
</html>
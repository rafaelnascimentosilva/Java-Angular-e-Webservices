<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Tela de Menu</title>
		<link rel="stylesheet" type="text/css"  href="resources/bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="resources/css/estilo.css">
		
	

		
	</head>
<body ng-app="listaDeContatos">

	<nav class="navbar navbar-inverse navbar-static-top ">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="#/" class="navbar-brand logotipo">
					<img alt="Logo" src="resources/imagens/logo.png">
				</a>
			</div>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav" id="menu_contato">
					<li><a class="linked" href="#list">Lista Contatos</a></li>
					<li><a class="linked" href="#add">Adiciona Contatos</a></li>
					
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
						 	Bem Vindo, ${usuarioAutenticado.nome} 
							<span class="caret"></span>
						 </a>
						 <div class="dropdown-menu perfil">
						 	<ul class="list-unstyled">
						 		<li>${usuarioAutenticado.nome}</li>
						 		<li><a href="">Alterar perfil</a></li>
						 		<li><a href="crud-system?acao=Logout">Sair</a></li>
						 	</ul>
						 </div>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div ng-view>	
		
	</div>

	Seja bem vindo ${usuarioAutenticado.nome} ao sistema de contatos

	 
	  <footer  class="navbar-fixed-bottom">
		  <div class="container">
		  		<span class="text-muted">Copyright 2010 - Todos os direitos reservados</span>
		  </div>
	  </footer>
	
	  <script  src="resources/lib/angular/angular.js"></script>
	  <script  src="resources/lib/angular/angular-route.js"></script>
	  <script  src="resources/js/app.js"></script>
	  <script  src="resources/js/config/routeConfig.js" ></script>
	  <script src="resources/js/jquery-2.2.4.min.js"></script>
	  <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
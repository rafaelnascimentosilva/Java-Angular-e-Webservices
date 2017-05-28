<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Tela de Menu</title>
		<link rel="stylesheet" type="text/css"  href="resources/bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="resources/css/estilo.css">
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>	
		  <script type="text/javascript">
            $(document).ready(function() {
            	$("#menu a").click(function(e){
            		e.preventDefault();
            		var href = $(this).attr('href');
            		$("#conteudo").load(href+"#conteudo");
            	});
            });
        </script>
	</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top ">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="Index.jsp" class="navbar-brand logotipo">
					<img alt="Logo" src="resources/imagens/logo.png">
				</a>
			</div>
			<div class="collapse navbar-collapse" >
				<ul class="nav navbar-nav" id="menu">
					<li><a href="crud-system?acao=ListarContato">Lista Contatos</a></li>
					<li><a href="AdicionarContato.jsp">Adiciona Contatos</a></li>
					<li><a href="crud-system?acao=Logout">Sair</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div id="conteudo">	
		
	</div>
	
	Seja bem vindo ${usuarioAutenticado.nome} ao sistema de contatos	
		
		
	

	 
	  <footer  class="navbar-fixed-bottom">
		  <div class="container">
		  		<span class="text-muted">Copyright 2010 - Todos os direitos reservados</span>
		  </div>
	  </footer>
	   <script src="resources/js/jquery-2.2.4.min.js"></script>
	  <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		<link rel="stylesheet" type="text/css"  href="resources/bootstrap/css/bootstrap.min.css">
		<link  rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	</head>	
<body>
	<form action="crud-system" method="get">
		<input type="hidden" name="acao" value="listar">
	</form>
	<div class="row cabecalho">
		<div class="col-xs-12 col-md-6">
			<h1>Contatos</h1>
		</div>		
		<div class="col-xs-12 col-md-4 col-md-offset-2 busca">
			<div class="input-group">
				<input type="text" name="busca" class="form-control" placeholder="Pesquisa por nome do contato" >
				<span class="input-group-btn">
				<button type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-search"></span>
				 </button>
				</span>
			</div>
		</div>
	</div>
		 	<div class="table-responsive">
		 			<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Data de Nascimento</th>
					<th class="text-center">Ações</th>
				</tr>
			</thead>		
			<c:forEach var="contato" items="${lista}" varStatus="id">
				<tbody>		
					<!-- <tr bgcolor="#${id.count % 2 == 0 ? 'A9A9A9' : 'ffffff' }">-->
						<tr>
							<td>${contato.nome}</td>
							<td>${contato.fone}</td>
							<td><fmt:formatDate value="${contato.nascimento.time }"	pattern="dd/MM/yyyy" /></td>
							<td class="text-center">
								<a href="crud-system?acao=DeletarContato&id=${contato.id}"><span class="glyphicon-pencil text-warning "></span></a>
								<a href="AtualizarContato.jsp?id=${contato.id}&nome=${contato.nome}&fone=${contato.fone}&nascimento=<fmt:formatDate value="${contato.nascimento.time}" pattern="dd/MM/yyyy"/>"><span class="glyphicon glyphicon-trash text-danger"></span></a>
							</td>
						</tr>
				</tbody>		
			</c:forEach>	
		</table>	 	
	 </div>	
</body>
</html>
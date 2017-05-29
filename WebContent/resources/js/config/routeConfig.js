angular.module("listaDeContatos").config(function($routeProvider){
	

	$routeProvider.when("/add",{
		templateUrl: "AdicionarContato.jsp"
		});

	$routeProvider.when("/list",{
		templateUrl: "crud-system?acao=ListarContato"
		});
});

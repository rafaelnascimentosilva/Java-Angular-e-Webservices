angular.module("listaDeContatos").config(function($routeProvider){
	
	$routeProvider.when("/",{
		templateUrl: "crud-system?acao=ListarContato"
		});
	
	$routeProvider.when("/add",{
		templateUrl: "AdicionarContato.jsp"
		});

	$routeProvider.when("/list",{
		templateUrl: "crud-system?acao=ListarContato"
		});
	$routeProvider.when("/delet",{
		templateUrl: "crud-system?acao=ListarContato"
		});
});

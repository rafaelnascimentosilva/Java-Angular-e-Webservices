angular.module("listaDeContatos",["ngRoute"]);
angular.module("listaDeContatos").controller("listaDeContatosCtrl",function($scope,$http){
	$scope.app = "LISTA DE CONTATOS";
	$scope.contatos = [];
	
	
	var carregaContatos = function(){		
		$http.get("http://localhost:8080/project-contatos/rest/contato/contatos").success(function (data) {
		$scope.contatos = data;
		
		});
	}
	carregaContatos();
});


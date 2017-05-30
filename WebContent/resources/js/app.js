angular.module("listaDeContatos",["ngRoute"]);
angular.module("listaDeContatos").controller("listaDeContatosCtrl",function($scope,$http){
	$scope.app = "LISTA DE CONTATOS";
	$scope.contatos = [];
	
	
	var carregaContatos = function(){	
		
		$http.get("http://localhost:8080/project-contatos/contato/contatos").then(function (response) {
			$scope.contatos = response.data;
			});
	}
	carregaContatos();
});


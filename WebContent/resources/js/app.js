var app = angular.module("listaDeContatos",["ngRoute"]);
app.controller("listaDeContatosCtrl",function($scope,ContatoService){
	$scope.app = "LISTA DE CONTATOS";
	
	ContatoService.listar().then(function (response) {//o then serve para dizer ao angular que só mostre quando todos os dados estiveren carregados
		$scope.contatos = response.data;
	});
	
});

app.service("ContatoService",function($http){
	
	this.listar = function(){
		return $http.get("http://localhost:8080/project-contatos/rest/contato/contatos?callback=JSON_CALLBACK");		
	}
	
});
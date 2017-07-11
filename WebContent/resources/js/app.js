var app = angular.module("listaDeContatos",["ngRoute"]);
app.controller("listaDeContatosCtrl",function($scope,ContatoService){
	$scope.app = "LISTA DE CONTATOS";
	$scope.contatos = {};	
	
	function listar(){
		ContatoService.listar().then(function (response) {//o then serve para dizer ao angular que só mostre quando todos os dados estiveren carregados
			$scope.contatos = response.data;
		});
	}
	
	$scope.salvar = function(contatos){
		ContatoService.salvar(contatos).then(listar);
		$scope.contatos = {};
	};
	
	$scope.deletar = function(contatos){
		if(confirm("Deseja Excluir?")){
			ContatoService.deletar(contatos).then(listar);
		}
	};
	
	$scope.atualizar = function(contatos){		
		$scope.contatos = angular.copy(contatos);			
	};
	
	listar();
});

app.service("ContatoService",function($http){
	
	this.listar = function(){
		return $http.get("http://localhost:8080/project-contatos/rest/contato/contatos");		
	};
	
	this.salvar = function(contatos){
		if (contatos.id) {
			return $http.put("http://localhost:8080/project-contatos/rest/contato/"+contatos.id,contatos);
		} else {
			return $http.post("http://localhost:8080/project-contatos/rest/contato",contatos);
		}		
	};
	
	this.deletar = function(contatos){
		return $http.delete("http://localhost:8080/project-contatos/rest/contato/"+contatos.id);
	};
	
});
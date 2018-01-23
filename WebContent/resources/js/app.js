var app = angular.module("listaDeContatos",['ngMask']);
app.controller("listaDeContatosCtrl",function($scope,ContatoService,$http){
	$scope.app = "Lista Telefônica";
	$scope.contatos={};	
	
	function listar(){
		ContatoService.listar().then(function (response) {//o then serve para dizer ao angular que só mostre quando todos os dados estiveren carregados
			$scope.contatos = response.data.contato;			
			//console.log($scope.contatos);			
		});
	}
	
	$scope.salvar = function(contato){			
		ContatoService.salvar(contato).then(listar);
		delete $scope.contato;
	};
	
	$scope.deletar = function(contato){
		console.log($scope.contato);
		if(confirm("Deseja Excluir?")){
			ContatoService.deletar(contato).then(listar);
		}
	};
	
	$scope.editar = function(contato){	
		$scope.contato = angular.copy(contato); 		
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
var app = angular.module("listaDeContatos",['ngMask']);
app.controller("listaDeContatosCtrl",function($scope,ContatoService,$http,$filter){
	$scope.app = "Lista Telefônica";	
	$scope.contatos = [];	
	
	$scope.listar = function(){
		ContatoService.listar().then(function (response) {
			$scope.contatos = response.data.contato;			
			 console.log($scope.contatos);		
		});
	}
	
	$scope.novo = function(contato){
		$scope.contato = {};
	};
	
	$scope.salvar = function(contato){			
		ContatoService.salvar(contato).then($scope.listar);		
		delete $scope.contato;
	};
	
	$scope.deletar = function(contato){
		console.log($scope.contato);
		if(confirm("Deseja Excluir?")){
			ContatoService.deletar(contato).then($scope.listar);
		}
	};
	
	$scope.editar = function(contato){	
		$scope.contato = angular.copy(contato); 
		$scope.contato.nascimento = $filter("date")($scope.contato.nascimento,"dd/MM/yyyy");
	};	
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


var app = angular.module("listaDeContatos",['ngMask','ngAnimate', 'ngSanitize', 'ui.bootstrap']);


app.controller("listaDeContatosCtrl",function($scope,ContatoService,$http,$filter){
	$scope.app = "Lista Telefônica";	
	$scope.contatos = [];
	$scope.maxSize = 5;
	$scope.pageDefault = 1;
	
	$scope.listar = function(){
		ContatoService.listar().then(function (response) {
			$scope.contatos = response.data.contato;		
			if($scope.contatos.length >= $scope.maxSize && $scope.pageDefault ==1){					
				//console.log( Math.trunc($scope.contatos.length/ 4));				
				$scope.paginar($scope.maxSize, 0);
			}				
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
	
	$scope.paginar = function(limit,attr){		
		ContatoService.paginado(limit,attr).then(function (response) {
			$scope.contatos = response.data.contato;				
		});
		
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
	
	this.paginado =  function(limit,attr){
		return $http.get("http://localhost:8080/project-contatos/rest/contato/"+limit+"/"+attr);
	};	
	
	this.qtdContatos = function(){
		return $http.get("http://localhost:8080/project-contatos/rest/contato/contatos"); 
	};	
});


app.controller("PaginationCtrl", function ($scope, $log,ContatoService) {	
	
	//$scope.totalItems = 14;
	//$scope.currentPage = 4;
	//$scope.maxSize = 5;
	$scope.bigTotalItems = 50;
	//$scope.numPages = 14;
	$scope.bigCurrentPage = 1;	

	  $scope.setPage = function (pageNo) {
		  $scope.currentPage = pageNo;
			 console.log($scope.currentPage * $scope.maxSize);		 
			 
			 if (pageNo== 1) {
				 this.paginar(5,0);
			}else{
				this.paginar(5,Math.round($scope.currentPage * $scope.maxSize ) -5);
			}	
		};

	  $scope.pageChanged = function() {
	    $log.log('Page changed to: ' + $scope.currentPage);
	  };
	  
	});

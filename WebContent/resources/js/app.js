var app = angular.module("listaDeContatos",['ngMask','ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.controller("listaDeContatosCtrl",function($scope,ContatoService,$http,$filter){
	
	$scope.app = "Lista Telefônica";	
	$scope.contatos = [];
	
	$scope.listar = function(){
		ContatoService.listar().then(function (response) {
			$scope.contatos = response.data.contato;			
			 $scope.totalItems = $scope.contatos.length;
			 
			/*if($scope.contatos.length >= $scope.maxSize && $scope.pageDefault ==1){					
				//console.log( Math.trunc($scope.contatos.length/ 4));				
				//$scope.paginar($scope.maxSize, 0);
			}	*/			
		});
	}
	
	
	
	$scope.novo = function(contato){
		$scope.contato = {};
	};
	
	$scope.salvar = function(contato){			
		ContatoService.salvar(contato).then($scope.listar);		
		//delete $scope.contato;
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


app.filter("startFrom", function(){
	return function(data, start){
		return data.slice(start);
	}
});

app.controller("PaginationCtrl", function ($scope, $log, ContatoService) {	
	
	  $scope.currentPage = 1;	  
	  $scope.pageSize = 3;	  
	  
	  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;	   
	  };

	  $scope.pageChanged = function() {
	    $log.log('Page changed to: ' + $scope.currentPage);
	    $log.log('Contatos length : ' + $scope.contatos.length);	    
	    for (var i = 0; i < $scope.contatos.length; i++) {
	    	  $log.log($scope.contatos[i].nome);
		}
	    
	    $scope.paginar($scope.pageSize,  ($scope.currentPage -1) );
	  };

	  $scope.bigCurrentPage = 1;
	  
	});

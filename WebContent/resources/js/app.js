var app = angular.module("listaDeContatos",['ngMask','ngAnimate', 'ngSanitize', 'ui.bootstrap']);


app.controller("listaDeContatosCtrl",function($scope,ContatoService,$http,$filter){
	$scope.app = "Lista Telefônica";	
	$scope.contatos = [];	
	
	
	 $scope.setPage = function (pageNo) {
		 $scope.currentPage = pageNo;
		 console.log($scope.currentPage);	
		 
		 if (pageNo == 1) {
			 this.paginar(5,0);
		}
		 if (pageNo == 2) {
			this.paginar(5,5);
		}
	 };
		  
		  
	$scope.listar = function(){
		ContatoService.listar().then(function (response) {
			$scope.contatos = response.data.contato;	
			$scope.bigTotalItems = response.data.contato.length;
			
			 console.log($scope.bigTotalItems);		
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
		return $http.get("http://localhost:8080/project-contatos/rest/contato/contatos").length; 
	};	
	
	
	
});


app.controller("PaginationCtrl", function ($scope, $log) {	
	
	  $scope.totalItems;
	  $scope.currentPage;

	 /* $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };
*/
	  $scope.pageChanged = function() {
	    $log.log('Page changed to: ' + $scope.currentPage);
	  };

	  $scope.maxSize = 5;
	  $scope.bigTotalItems = 14;
	  $scope.bigCurrentPage = 1;
	  
	});

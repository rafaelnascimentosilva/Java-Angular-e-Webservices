
angular.module('listaDeContatos').controller("PaginationCtrl", function ($scope, $log,ContatoService) {
	
  $scope.totalItems = 64;
  $scope.currentPage = 4;

  $scope.setPage = function (pageNo) {
    $scope.currentPage = pageNo;
  };

  $scope.pageChanged = function() {
    $log.log('Page changed to: ' + $scope.currentPage);
  };

  $scope.maxSize = 5;
  $scope.bigTotalItems = 100;
  $scope.bigCurrentPage = 1;
  
  $scope.paginacao = function(){
		ContatoService.listar().then(function (response) {
			//$scope.totalItems = response.data.contato.lengh;			
			 console.log("tamanho:"+response.data.contato.length);		
		});
	}
});
var confNodosModule = angular.module('confNodos', [])
.controller("nodosController", function($scope, $http){
	$scope.nodos = [];
	$scope.nodo;
	$scope.modulos = ['Solar', 'Eólico', 'Termotanque'];
	$scope.selectedModule;
	$scope.copia = [];
	  
	$scope.getNodos = function (){
		  $http.get('http://localhost:8080/trabajoFinal/nodos')
		  .then(onNodosCallback, errorCallback);
	  }
	  function onNodosCallback(response) {
	    $scope.nodos = response.data;
	  }
	  function errorCallback(err) {
		console.log(err);
	  }

	  $scope.getNodos();
	  
	$scope.editNodos = function(nodo) {
		nodo.$original = angular.copy(nodo);
		nodo.editMode = true;
	}
	
	$scope.cancel = function(nodo) {
	  angular.copy(nodo.$original, nodo);
      nodo.editMode = false;
    }
	
	$scope.updateNodo = function(nodo) {
	    $scope.nodo = nodo;
		$http.put('http://localhost:8080/trabajoFinal/nodo/', nodo)
			.then(onSuccessUpdateCallback, errorCallback);
		}
		function onSuccessUpdateCallback(response) {
			$scope.nodo.editMode = false;
		}
})
.controller("userController", function($scope) {
	
	$scope.nombre = "Juan Castagnola"
	
})
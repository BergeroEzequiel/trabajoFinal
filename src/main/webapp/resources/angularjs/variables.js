angular.module('variables', [])
.controller("umbralController", function($scope, $http){
	$scope.umbrales = [];
	$scope.copia = [];
	$scope.getUmbrales = function (){
		  $http.get('http://localhost:8080/trabajoFinal/umbrales')
		  .then(successCallback, errorCallback);
	  }
	  function successCallback(response) {
	    $scope.umbrales = response.data;
	  }

	  function errorCallback(err) {
	    console.log(err);
	  }
	  $scope.getUmbrales();
	  
	$scope.editUmbral = function(umbral) {
		umbral.$original = umbral.$original || angular.copy(umbral);
		umbral.editMode = true;
	}
	
	$scope.cancel = function(umbral) { debugger;
	  angular.copy(umbral.$original, umbral);
      umbral.editMode = false;
    }
	
	$scope.updateUmbral = function(umbral) { debugger;
		umbral.fechaUltimaModificacion = new Date();
		$http.put('http://localhost:8080/trabajoFinal/umbral/', umbral);
		umbral.editMode = false;
	}
	
})
.controller("userController", function($scope){
	
	$scope.nombre = "Juan Castagnola"
	
});
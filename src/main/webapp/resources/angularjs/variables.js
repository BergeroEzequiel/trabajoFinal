angular.module('variables', [])
.controller("umbralController", function($scope, $http){
	$scope.umbrales = [];
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
	  $scope.getUmbrales();debugger;
	
})
.controller("userController", function($scope){
	
	$scope.nombre = "Juan Castagnola"
	
});
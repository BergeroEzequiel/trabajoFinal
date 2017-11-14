angular.module('home', [])
.controller('homeController', function ($scope, $http, $interval) {
  $scope.tramas = [];
  $scope.potenciasTotales = null;
  
  $scope.getTramas = function (){
	  $scope.potenciasTotales = {
			  potenciaContinua:0,
			  potenciaRed:0,
			  potenciaInterna:0
	  }; 
	  $http.get('http://localhost:8080/trabajoFinal/potenciasNodos')
	  .then(successCallback, errorCallback);
  }

  function successCallback(response) {
    $scope.tramas = response.data;

    angular.forEach($scope.tramas, function(value, key){
 	   if(value.potenciaContinua != null && value.potenciaRed != null 
 			   && value.potenciaInterna != null){
 		   $scope.potenciasTotales.potenciaContinua += value.potenciaContinua;
 		   $scope.potenciasTotales.potenciaRed += value.potenciaRed;
 		   $scope.potenciasTotales.potenciaInterna += value.potenciaInterna;
 	   };
 	 });
  }

  function errorCallback(err) {
    console.log(err);
  }
  
  $scope.getTramas();
  
  $interval( function(){$scope.getTramas();}, 10000);
  
})

.controller("userController", function($scope){
	
	$scope.nombre = "Juan Castagnola"
	
});






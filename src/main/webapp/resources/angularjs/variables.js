var variablesModule = angular.module('variables', [])
variablesModule.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9\.]/g, '');

                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }            
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
})
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
	
	$scope.cancel = function(umbral) {
	  angular.copy(umbral.$original, umbral);
      umbral.editMode = false;
    }
	
	$scope.updateUmbral = function(umbral) {
		umbral.fechaUltimaModificacion = new Date();
		$http.put('http://localhost:8080/trabajoFinal/umbral/', umbral);
		umbral.editMode = false;
	}
	
	$scope.filterValue = function($event){
        if(isNaN(String.fromCharCode($event.keyCode))){
            $event.preventDefault();
        }
	}
	
})
.controller("userController", function($scope){
	
	$scope.nombre = "Juan Castagnola"
	
})
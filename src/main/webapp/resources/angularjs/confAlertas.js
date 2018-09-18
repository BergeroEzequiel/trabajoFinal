var alertasModule = angular.module('confAlertas', [])
alertasModule.directive('numbersOnly', function () {
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
.controller("criticidadController", function($scope, $http){
	$scope.criticidades = [];
	$scope.criticidad;
	  
	$scope.getCriticidades = function (){
		  $http.get('http://localhost:8080/trabajoFinal/criticidades')
		  .then(onCriticidadesCallback, errorCallback);
	  }
	  function onCriticidadesCallback(response) {
	    $scope.criticidades = response.data;
	  }
	  function errorCallback(err) {
		console.log(err);
	  }

	  $scope.getCriticidades();
	  
	$scope.editCriticidad = function(criticidad) {
		criticidad.$original = angular.copy(criticidad);
		criticidad.editMode = true;
	}
	
	$scope.cancel = function(criticidad) {
	  angular.copy(criticidad.$original, criticidad);
      criticidad.editMode = false;
    }
	
	$scope.updateCriticidad = function(criticidad) {
		$scope.criticidad = criticidad;
		$http.put('http://localhost:8080/trabajoFinal/criticidad/', criticidad)
			.then(onSuccessUpdateCallback, errorCallback);
		function onSuccessUpdateCallback(response) {
			$scope.criticidad.editMode = false;
		}
	}
	
})
.controller("userController", function($scope) {
	
	$scope.nombre = "Juan Castagnola"
	
})
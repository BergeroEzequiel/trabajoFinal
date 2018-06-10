var umbralesModule = angular.module('confAlertas', [])
umbralesModule.directive('numbersOnly', function () {
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
	$scope.copia = [];
	  
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
		criticidad.$original = criticidad.$original || angular.copy(criticidad);
		criticidad.editMode = true;
	}
	
	$scope.cancel = function(criticidad) {
	  angular.copy(criticidad.$original, criticidad);
      criticidad.editMode = false;
    }
	
	$scope.updateCriticidad = function(criticidad) {
		$http.put('http://localhost:8080/trabajoFinal/criticidad/', criticidad);
		criticidad.editMode = false;
	}
	
	$scope.getHumanRedableName = function(name) {
		var name = name.replace("_"," ");
		return name.charAt(0).toUpperCase() + name.slice(1);
	}
	
})
.controller("userController", function($scope) {
	
	$scope.nombre = "Juan Castagnola"
	
})
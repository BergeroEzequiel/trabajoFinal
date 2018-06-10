var umbralesModule = angular.module('confUmbrales', [])
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
.controller("umbralController", function($scope, $http){
	$scope.umbrales = [];
	$scope.medidas = [];
	$scope.selectedUm = {};
	$scope.criticidades = []
	$scope.selectedCrit = {};
	$scope.copia = [];
	$scope.getUmbrales = function (){
		  $http.get('http://localhost:8080/trabajoFinal/umbrales')
		  .then(onUmbralesCallback, errorCallback);
	  }
	  function onUmbralesCallback(response) {
	    $scope.umbrales = response.data;
	  }

	  function errorCallback(err) {
	    console.log(err);
	  }
	  $scope.getUmbrales();
	  
	$scope.getUnidadesMedida = function (){
		  $http.get('http://localhost:8080/trabajoFinal/unidades-medida')
		  .then(onUnidadesMedidaCallback, errorCallback);
	  }
	  function onUnidadesMedidaCallback(response) {
	    $scope.medidas = response.data;
	  }

	  $scope.getUnidadesMedida();
	  
	$scope.getCriticidades = function (){
		  $http.get('http://localhost:8080/trabajoFinal/criticidades')
		  .then(onCriticidadesCallback, errorCallback);
	  }
	  function onCriticidadesCallback(response) {
	    $scope.criticidades = response.data;
	  }

	  $scope.getCriticidades();
	  
	$scope.editUmbral = function(umbral) {
		umbral.$original = umbral.$original || angular.copy(umbral);
		$scope.selectedUm = umbral.unidadMedida;
		$scope.selectedCrit = umbral.criticidad;
		umbral.editMode = true;
	}
	
	$scope.cancel = function(umbral) {
	  angular.copy(umbral.$original, umbral);
      umbral.editMode = false;
    }
	
	$scope.updateUmbral = function(umbral, selectedUm, selectedCrit) {
		umbral.ultimaModificacion = $scope.getLocalISOTime();
		umbral.unidadMedida = selectedUm;
		umbral.criticidad = selectedCrit;
		$http.put('http://localhost:8080/trabajoFinal/umbral/', umbral);
		umbral.editMode = false;
	}
	
	$scope.getLocalISOTime = function() {
		var tzOffset = (new Date()).getTimezoneOffset() * 60000,
		    localISOTime = (new Date(Date.now() - tzOffset)).toISOString().slice(0, -1);
		return localISOTime.split('T')[0];
	}
	
	$scope.getHumanRedableName = function(name) {
		var name = name.replace("_"," ");
		return name.charAt(0).toUpperCase() + name.slice(1);
	}
	
})
.controller("userController", function($scope) {
	
	$scope.nombre = "Juan Castagnola"
	
})
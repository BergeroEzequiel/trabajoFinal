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
	
})
.controller("alertasController", function ($scope, $http, $interval, $filter) {
        $scope.alertasCriticas = [];
        $scope.alertasAltas = [];
        $scope.alertasMedias = [];
        $scope.alertasBajas = [];
        $scope.alertas = [];
        
        var MS_POR_SEGUNDOS = 60000;
        var INTERVALO_CRITICAS = 2;
        var INTERVALO_ALTAS = 10;
        var INTERVALO_MEDIAS = 30;
        var INTERVALO_BAJAS = 60;

        $scope.getAlertasCriticas = function () {
            var actual = new Date();
            $scope.horaHastaCritica = $filter('date')(new Date(), 'HH:mm:ss');
            $scope.horaDesdeCritica = $filter('date')(new Date(actual - INTERVALO_CRITICAS * MS_POR_SEGUNDOS), 'HH:mm:ss');
            console.log("hora hasta critica: " + $scope.horaHastaCritica);
            console.log("hora desde critica: " + $scope.horaDesdeCritica);
            
//            get para alertas con Criticidad Critica
            $http.get("http://localhost:8080/trabajoFinal/alertas?horaDesde="
                    + $scope.horaDesdeCritica + "&horaHasta=" + $scope.horaHastaCritica + "&prioridadCriticidad=Critica")
                    .then(successCallbackCriticas, errorCallback);
        }
        
        $scope.getAlertasAltas = function () {
            var actual = new Date();
            $scope.horaHastaAlta = $filter('date')(new Date(), 'HH:mm:ss');
            $scope.horaDesdeAlta = $filter('date')(new Date(actual - INTERVALO_ALTAS * MS_POR_SEGUNDOS), 'HH:mm:ss');
            console.log("hora hasta alta: " + $scope.horaHastaAlta);
            console.log("hora desde alta: " + $scope.horaDesdeAlta);
            
            $http.get("http://localhost:8080/trabajoFinal/alertas?horaDesde="
                    + $scope.horaDesdeAlta + "&horaHasta=" + $scope.horaHastaAlta + "&prioridadCriticidad=Alta")
                    .then(successCallbackAltas, errorCallback);
        }
        
        $scope.getAlertasMedias = function () {
            var actual = new Date();
            $scope.horaHastaMedia = $filter('date')(new Date(), 'HH:mm:ss');
            $scope.horaDesdeMedia = $filter('date')(new Date(actual - INTERVALO_MEDIAS * MS_POR_SEGUNDOS), 'HH:mm:ss');
            console.log("hora hasta media: " + $scope.horaHastaMedia);
            console.log("hora desde media: " + $scope.horaDesdeMedia);
            
            $http.get("http://localhost:8080/trabajoFinal/alertas?horaDesde="
                    + $scope.horaDesdeMedia + "&horaHasta=" + $scope.horaHastaMedia + "&prioridadCriticidad=Media")
                    .then(successCallbackMedias, errorCallback);
        }
        
        $scope.getAlertasBajas = function () {
            var actual = new Date();
            $scope.horaHastaBaja = $filter('date')(new Date(), 'HH:mm:ss');
            $scope.horaDesdeBaja = $filter('date')(new Date(actual - INTERVALO_BAJAS * MS_POR_SEGUNDOS), 'HH:mm:ss');
            console.log("hora hasta baja: " + $scope.horaHastaBaja);
            console.log("hora desde baja: " + $scope.horaDesdeBaja);
            
            $http.get("http://localhost:8080/trabajoFinal/alertas?horaDesde="
                    + $scope.horaDesdeBaja + "&horaHasta=" + $scope.horaHastaBaja + "&prioridadCriticidad=Baja")
                    .then(successCallbackBajas, errorCallback);
        }

        function successCallbackCriticas(response) {
            $scope.alertasCriticas = response.data;
            $scope.alertas = [];
            $scope.alertas = $scope.alertas.concat($scope.alertasCriticas, $scope.alertasAltas, $scope.alertasMedias, $scope.alertasBajas);
        }
        
        function successCallbackAltas(response) {
            $scope.alertasAltas = response.data;
        }
        
        function successCallbackMedias(response) {
            $scope.alertasMedias = response.data;
        }
        
        function successCallbackBajas(response) {
            $scope.alertasBajas = response.data;
        }

        function errorCallback(err) {
            console.log(err);
        }
        
        $scope.getAlertasAltas();
        $scope.getAlertasMedias();
        $scope.getAlertasBajas();
        $scope.getAlertasCriticas();

        $interval(function () {
            $scope.getAlertasCriticas();
        }, 120000);
        
        $interval(function () {
            $scope.getAlertasAltas();
        }, 600000);
        
        $interval(function () {
            $scope.getAlertasMedias();
        }, 1800000);
        
        $interval(function () {
            $scope.getAlertasBajas();
        }, 3600000);
	
});






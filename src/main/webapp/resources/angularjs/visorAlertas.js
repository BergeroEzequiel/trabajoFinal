angular.module('visorAlertas', [])
        .controller('visorAlertasController', function ($scope, $http, $interval, $filter) {
            $scope.alertas = [];

            var horaHasta = new Date();
            var MS_POR_SEGUNDOS = 60000;
            var INTERVALO = 2;
            var horaDesde = new Date(horaHasta - INTERVALO * MS_POR_SEGUNDOS);

            $scope.horaHasta = $filter('horaHasta')(new Date(), 'HH:mm:ss');
            $scope.horaDesde = $filter('horaDesde')(new Date(), 'HH:mm:ss');

            $scope.getAlertas = function () {
                $scope.horaHasta = $filter('horaHasta')(new Date(), 'HH:mm:ss');
                $scope.horaDesde = $filter('horaDesde')(new Date(), 'HH:mm:ss');
                $http.get("http://localhost:8080/trabajoFinal/alertas?horaDesde="
                        + $scope.horaDesde.toString() + "&horaHasta=" + $scope.horaHasta.toString())
                        .then(successCallback, errorCallback);
            }

            function successCallback(response) {
                $scope.alertas = response.data;
            }

            function errorCallback(err) {
                console.log(err);
            }

            $scope.getAlertas();

            $interval(function () {
                $scope.getTramas();
            }, 120000);

        })

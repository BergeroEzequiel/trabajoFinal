var detalleNodosModule = angular.module('nodos', [])
    .controller("detalleNodosController", function($scope, $http, $interval) {

        // TAB Detalle Nodo
        $scope.resp = null;
        $scope.frecuenciaCorriente = null;
        $scope.frecuenciaTension = null;
        $scope.frecuenciaReferencia = null;
        $scope.lineChart = null;
        $scope.nodos = [];
        $scope.nodoSeleccionado = null;

        $scope.getNodos = function () {
            $http.get('http://localhost:8080/trabajoFinal/nodos')
                .then(onNodosCallback, errorCallback);
        }
        function onNodosCallback(response) {
            $scope.nodos = response.data;
            $scope.nodoSeleccionado = $scope.nodos[0];
            $scope.onNodoChange();
        }
        $scope.getNodos();

        $scope.getUltimasTramas = function () {
            $http.get('http://localhost:8080/trabajoFinal/ultimasNTramasPorNodos/'+ $scope.nodoSeleccionado.id +'?limit=10')
                .then(successCallback, errorCallback);
        }

        function successCallback(response) {
            $scope.resp = response.data.reverse();
            $scope.frecuenciaCorriente = [];
            $scope.frecuenciaTension = [];
            $scope.frecuenciaReferencia = [];
            angular.forEach($scope.resp, function (resp) {
                $scope.frecuenciaCorriente.push(resp.frecuenciaCorriente);
                $scope.frecuenciaTension.push(resp.frecuenciaTension);
                $scope.frecuenciaReferencia.push(5);
            });
            $scope.buildLineChart();
        }

        function errorCallback(err) {
            console.log(err);
        }

        $interval( function(){$scope.getUltimasTramas();}, 30000);

        $scope.buildLineChart = function () {

            if (!$scope.lineChart) {
                $scope.lineChart = new Chart(document.getElementById("ultimas10"), {
                    type: 'line',
                    data: {
                        labels: [1,2,3,4,5,6,7,8,9,10],
                        datasets: [{
                            data: $scope.frecuenciaCorriente,
                            label: "Frecuencia Continua",
                            borderColor: "#119ae4",
                            fill: false
                        }, {
                            data: $scope.frecuenciaTension,
                            label: "Frecuencia Interna",
                            borderColor: "#0ebe69",
                            fill: false
                        }, {
                            data: $scope.frecuenciaReferencia,
                            label: "Frecuencia de Referencia",
                            borderColor: "#252525",
                            fill: false
                        }]
                    },
                    options: {
                        title: {
                            display: true,
                            text: 'Ultimas 10 mediciones de Frecuencia'
                        }
                    }
                })
            }
            else {
                $scope.lineChart.data.datasets[0].data = $scope.frecuenciaCorriente;
                $scope.lineChart.data.datasets[1].data = $scope.frecuenciaTension;
                $scope.lineChart.data.datasets[2].data = $scope.frecuenciaReferencia;
                $scope.lineChart.update();
            }
        }

        $scope.onNodoChange = function() {
            $scope.getUltimasTramas();
            $scope.getUmbrales();
        }

        // TAB Umbrales

        $scope.umbrales = [];
        $scope.umbral;
        $scope.medidas = [];
        $scope.criticidades = [];
        $scope.getUmbrales = function() {
            $http.get('http://localhost:8080/trabajoFinal/umbrales/' + $scope.nodoSeleccionado.id)
                .then(onUmbralesCallback, errorCallback);
        }
        function onUmbralesCallback(response) {
            $scope.umbrales = response.data;
        }

        function errorCallback(err) {
            console.log(err);
        }

        $scope.getUnidadesMedida = function() {
            $http.get('http://localhost:8080/trabajoFinal/unidades-medida')
                .then(onUnidadesMedidaCallback, errorCallback);
        }
        function onUnidadesMedidaCallback(response) {
            $scope.medidas = response.data;
        }

        $scope.getUnidadesMedida();

        $scope.getCriticidades = function() {
            $http.get('http://localhost:8080/trabajoFinal/criticidades')
                .then(onCriticidadesCallback, errorCallback);
        }
        function onCriticidadesCallback(response) {
            $scope.criticidades = response.data;
        }

        $scope.getCriticidades();

        $scope.editUmbral = function(umbral) {
            umbral.nodo = $scope.nodoSeleccionado;
            if (umbral.tipoUmbral == 'generico') {
                umbral.id = null;
            }
            umbral.$original = angular.copy(umbral);
            umbral.editMode = true;
        }

        $scope.cancel = function(umbral) {
            angular.copy(umbral.$original, umbral);
            umbral.editMode = false;
        }

        $scope.updateUmbral = function(umbral) {
            umbral.ultimaModificacion = $scope.getLocalISOTime();
            $scope.umbral = umbral;
            $http.put('http://localhost:8080/trabajoFinal/umbral/', umbral)
                .then(onSuccessUpdateCallback, errorCallback);
            function onSuccessUpdateCallback(response) {
                $scope.umbral.editMode = false;
                $scope.getUmbrales();
            }
        }

        $scope.revertUmbral = function(umbral) { debugger;
            $scope.umbral = umbral;
            $http.delete('http://localhost:8080/trabajoFinal/deleteUmbralEspecifico/' + $scope.umbral.id)
                .then(onSuccessUpdateCallback, errorCallback);
            function onSuccessUpdateCallback(response) {
                $scope.getUmbrales();
            }
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
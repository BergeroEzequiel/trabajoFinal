var alertasModule = angular.module('detalleAlerta', [])
.controller("detalleAlertaController", function($scope, $http) {
    $scope.criticidades = [];
    $scope.criticidadSeleccionada = null;
    $scope.nodos = [];
    $scope.nodoSeleccionado = null;
    $scope.alertas = [];
    $scope.detalleAlerta = [];
    $scope.showDetalles = false;
    $scope.alertaSeleccionada = null;
    $scope.fechaDesde = null;
    $scope.fechaHasta = null;
    $scope.startFilter = function() {
        $(function() {

            var start = moment().subtract(29, 'days');
            var end = moment();

            function cb(start, end) {
                $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
            }

            $('#reportrange').daterangepicker({
                startDate: start,
                endDate: end,
                ranges: {
                    'Hoy': [moment(), moment()],
                    'Ayer': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    'Ultimos 7 días': [moment().subtract(6, 'days'), moment()],
                    'Ultimos 30 días': [moment().subtract(29, 'days'), moment()],
                    'Este mes': [moment().startOf('month'), moment().endOf('month')],
                    'Mes pasado': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                locale: {
                    format: 'DD/MM/YYYY',
                    applyLabel: 'Aceptar',
                    cancelLabel: 'Borra3',
                    customRangeLabel: 'Personalizado',
                    daysOfWeek: [
                        'Do',
                        'Lu',
                        'Ma',
                        'Mi',
                        'Ju',
                        'Vi',
                        'Sa'
                    ],
                    monthNames: [
                        'Enero',
                        'Febrero',
                        'Marzo',
                        'Abril',
                        'Mayo',
                        'Junio',
                        'Julio',
                        'Agosto',
                        'Septiembre',
                        'Octubre',
                        'Noviembre',
                        'Diciembre'
                    ]
                }
            }, cb);

            cb(start, end);
            $scope.fechaDesde = start.format('YYYY-MM-DD');
            $scope.fechaHasta = end.format('YYYY-MM-DD');
            $scope.handleFilterEvents();
            $scope.getAlertas();
        });
    }

    $scope.startFilter();

     $scope.handleFilterEvents = function() {
        $('#reportrange').on('apply.daterangepicker', function (ev, picker) {
            $scope.fechaDesde = picker.startDate.format('YYYY-MM-DD');
            $scope.fechaHasta = picker.endDate.format('YYYY-MM-DD');
            $scope.getAlertas();
        });
    }
    
    $scope.getAlertas = function() {
        var url = 'http://localhost:8080/trabajoFinal/alertasPorFecha?',
            params = 'fechaDesde=' + $scope.fechaDesde + '&fechaHasta=' + $scope.fechaHasta;    
        params = ($scope.nodoSeleccionado) ? params + '&idNodo=' + $scope.nodoSeleccionado.id : params;
        params = ($scope.criticidadSeleccionada) ? params + '&criticidad=' + $scope.criticidadSeleccionada.prioridad : params;
        
        $http.get(url + params).then(onAlertasCallback, errorCallback);
    }

    function onAlertasCallback(response) {
        $scope.alertas = response.data;
    }

    function errorCallback(err) {
        console.log(err);
    }

    
    $scope.getCriticidades = function () {
        $http.get('http://localhost:8080/trabajoFinal/criticidades')
                .then(onCriticidadesCallback, errorCallback);
    }
    function onCriticidadesCallback(response) {
        $scope.criticidades = response.data;
    }

    $scope.getNodos = function () {
        $http.get('http://localhost:8080/trabajoFinal/nodos')
                .then(onNodosCallback, errorCallback);
    }
    function onNodosCallback(response) {
        $scope.nodos = response.data;
    }
    function errorCallback(err) {
        console.log(err);
    }
    
    $scope.getHumanRedableName = function(name) {
		var name = name.replace("_"," ");
		return name.charAt(0).toUpperCase() + name.slice(1);
	}

    $scope.getNodos();

    $scope.getCriticidades();

    $scope.getDetalleAlerta = function(alerta) {
        $scope.detalleAlerta = [];
        $scope.showDetalles = false;
        $scope.alertaSeleccionada = alerta;
        $http.get('http://localhost:8080/trabajoFinal/detalleAlerta/' + $scope.alertaSeleccionada.id)
            .then(onDetallesCallback, errorCallback)
    }

    function onDetallesCallback(response) {
        $scope.detalleAlerta = response.data;
        $scope.showDetalles = true;
    }

})
.controller("userController", function($scope) {

    $scope.nombre = "Juan Sarlan"

});
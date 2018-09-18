var alertasModule = angular.module('detalleAlerta', [])
.controller("detalleAlertaController", function($scope, $http) {
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
                    'Ater': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    'Ultimos 7 dias': [moment().subtract(6, 'days'), moment()],
                    'Ultimos 30 dias': [moment().subtract(29, 'days'), moment()],
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
            $scope.handleFilterEvents();
        });
    }

    $scope.startFilter();

    $scope.handleFilterEvents = function() {
        $('#reportrange').on('apply.daterangepicker', function (ev, picker) {
            console.log(picker.startDate.format('YYYY-MM-DD'));
            console.log(picker.endDate.format('YYYY-MM-DD'));
        });
    }

})
.controller("userController", function($scope) {

    $scope.nombre = "Juan Castagnola"

});
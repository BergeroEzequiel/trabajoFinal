var usuariosModule = angular.module('confUsuarios', [])
    .controller("usuarioController", function ($scope, $http) {
        $scope.usuarios = [];
        $scope.usuario;
        $scope.nuevoUsuario;
        $scope.roles = [];
        $scope.estados = [];
        $scope.mostrarLogin = 1;
        
        

        $scope.getUsuarios = function () {
            $http.get('http://localhost:8080/trabajoFinal/usuarios')
                    .then(onUsuariosCallback, errorCallback);
        }
        function onUsuariosCallback(response) {
            $scope.usuarios = response.data;
        }

        function errorCallback(err) {
            console.log(err);
        }
        $scope.getUsuarios();

        $scope.getRoles = function () {
            $http.get('http://localhost:8080/trabajoFinal/roles')
                    .then(onRolesCallback, errorCallback);
        }
        function onRolesCallback(response) {
            $scope.roles = response.data;
        }

        $scope.getRoles();

        $scope.editUsuario = function (usuario) {
            usuario.$original = angular.copy(usuario);
            usuario.editMode = true;
        }

        $scope.cancel = function (usuario) {
            angular.copy(usuario.$original, usuario);
            usuario.editMode = false;
        }

        $scope.updateUsuario = function (usuario) {
            $scope.usuario = usuario;
            $http.put('http://localhost:8080/trabajoFinal/usuario/', usuario)
                    .then(onSuccessUpdateCallback, errorCallback);
        }
        
        function onSuccessUpdateCallback(response) {
                $scope.usuario.editMode = false;
        }

        $scope.getEstados = function () {
            $http.get('http://localhost:8080/trabajoFinal/estados')
                    .then(onEstadosCallback, errorCallback);
        }
        function onEstadosCallback(response) {
            $scope.estados = response.data;
        }
        
        $scope.getEstados();
        
        $scope.crearUsuario = function (nuevoUsuario) {
            $http.post('http://localhost:8080/trabajoFinal/usuario/', nuevoUsuario)
                    .then(onSuccessCreateCallback, errorCallback);
        }
        
        function onSuccessCreateCallback(response) {
                $scope.nuevoUsuario = {};
        }
        
        $scope.ocultarFormLogin = function () {
            $scope.mostrarLogin = 2;
            console.log(mostrarLogin.toString());
        }
        
        $scope.mostrarFormLogin = function () {
            $scope.mostrarLogin = 1;
            console.log(mostrarLogin.toString());
        }

    })
    .controller("userController", function ($scope) {

        $scope.nombre = "Juan Castagnola"

    })
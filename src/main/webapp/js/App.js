var app = angular.module('ecommerce', [])
    app.controller('EcommerceController', ['$scope', '$http', function ($scope, $http){
        
        
        $scope.submitForm = function(isValid) {
         if(isValid){
            alert('de boa');
        }
    };
        
        $scope.buscar = function(cep){
        $http.get('https://viacep.com.br/ws/'+ cep +'/json/').success(function(local){
            $scope.endereco = local;
    });
        };
        

}]);

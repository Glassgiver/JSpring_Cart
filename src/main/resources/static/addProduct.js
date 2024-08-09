// addProduct.js
angular.module('app', []).controller('addProductController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.addNewProduct = function () {
        console.log("start adding..")
        console.log("name:" + $scope.newProduct.name)
        console.log("price:" + $scope.newProduct.price)
        $http.post(contextPath + '/products/addNewProduct', $scope.newProduct)
            .then(function () {
                $scope.newStudent = null;
                console.log('New product was successfully added!');
            }).catch(function (error) {
            console.error('Error adding product:', error);
        });
    };
});

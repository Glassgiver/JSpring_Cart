// index.js
angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.productCountInCart = 0;
    $scope.ProductList = [];
    $scope.ProductListInCart = [];
    $scope.isCartVisible = false;

    function updateProductCountInCart() {
        $http.get(contextPath + '/cart/count')
            .then(function (response) {
                $scope.productCountInCart = response.data; // Обновляем количество
            });
    }

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response);
                $scope.ProductList = response.data;
            });
    };

    $scope.addToCart = function (productId) {
        $http.post(contextPath + '/cart/add/' + productId)
            .then(function () {
                updateProductCountInCart();
                console.log('Product added to cart');
                $scope.loadProducts();
                $scope.loadCart();
            });
    };

    $scope.toggleCart = function () {
        $scope.isCartVisible = !$scope.isCartVisible;
        $scope.loadCart();
        updateProductCountInCart();
    };

    $scope.loadCart = function (){
        if ($scope.isCartVisible) {
            $http.get(contextPath + '/cart/showProducts')
                .then(function (response) {
                    console.log(response);
                    $scope.ProductListInCart = response.data;
                });
        }
    }

    $scope.removeFromCart = function (productId) {
        $http.post(contextPath + '/cart/remove/' + productId) // Предположим, у вас есть метод для удаления
            .then(function () {
                console.log('Product removed from cart');
                $scope.loadCart();
                updateProductCountInCart();
            });
    };

    $scope.loadProducts();
    updateProductCountInCart();
});

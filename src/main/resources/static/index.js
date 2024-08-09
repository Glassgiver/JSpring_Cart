// index.js
angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.productCountInCart = 0;
    $scope.ProductList = [];
    $scope.ProductListInCart = [];
    $scope.isCartVisible = false;

    $scope.loadProducts = function (pageIndex= 1) {
        $http ({
            url: contextPath + '/products',
            method: 'GET',
            params:{
                name_part: $scope.filter ? $scope.filter.name : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response){
            $scope.ProductList = response.data.content;
        });
    };

    function updateProductCountInCart() {
        $http.get(contextPath + '/cart/count')
            .then(function (response) {
                $scope.productCountInCart = response.data; // Обновляем количество
            });
    }

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
        $http.post(contextPath + '/cart/remove/' + productId)
            .then(function () {
                console.log('Product removed from cart');
                $scope.loadCart();
                updateProductCountInCart();
            });
    };

    $scope.loadProducts();
    updateProductCountInCart();
});

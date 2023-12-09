angular.module('myApp', [])
    .controller('TableController', function($scope, $http, $filter) {
        $http.get('/webapi/orders')
            .then(function (response) {
                $scope.items = response.data;
                    })
                .catch(function (error) {
                    console.error('Error sending data to the backend:', error);
                });

      $scope.sortKey = 'id';
      $scope.sortReverse = false;

      $scope.sort = function(key) {
        if ($scope.sortKey === key) {
          $scope.sortReverse = !$scope.sortReverse;
        } else {
          $scope.sortKey = key;
          $scope.sortReverse = false;
        }

        $scope.items = $filter('orderBy')($scope.items, $scope.sortKey, $scope.sortReverse);
      };
    });
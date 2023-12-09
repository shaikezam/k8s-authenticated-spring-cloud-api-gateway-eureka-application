angular.module('myApp', [])
  .controller('MainController', ['$window', function($window) {
    this.navigateToCreateOrder = function() {
      $window.location.href = 'new-order.htm';
    };

    this.navigateToWatchOrders = function() {
      $window.location.href = 'watch-orders.htm';
    };
  }]);
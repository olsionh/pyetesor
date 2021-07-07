var app = angular.module('afishoTest', []);
app.controller('afishTegjithTestet', function($scope,$http) {

	$scope.initTest =  function(){
		$http.post('http://localhost:8080/pyetesor/user/list/testeTeBera')
         .then(function(res){
            $scope.tests = res.data;
          
          });
	}
	
});
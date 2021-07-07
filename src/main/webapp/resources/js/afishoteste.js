var app = angular.module('afishoTest', []);
app.controller('afishTegjithTestet', function($scope,$http) {

	$scope.initPyetje =  function(){
		$http.post('http://localhost:8080/pyetesor/user/admin/afishoAllTests')
         .then(function(res){
            $scope.tests = res.data;
          
          });
	}

    $scope.initSeminar =  function(){
        $http.post('http://localhost:8080/pyetesor/user/list/seminaretemia')
            .then(function(res){
                $scope.seminars = res.data;

            });
    }
	
	$scope.fshiPyetjeTesti =  function(questionId,testId){
		var questionIdObject = "{\"questionId\":\""+questionId+"\",\"testId_FK\":\""+testId+"\"}";
		var obj = JSON.parse(questionIdObject);
		var u = JSON.stringify(obj);
		alert(u);
		$.ajax({//jquery form
             url: 'http://localhost:8080/pyetesor/user/fshi/pyetjeFromTest',
             type: "POST",
             data: u,
             dataType: 'JSON',
             success:function(data, textStatus, xhr){
             	alert("pyetja u fshi me " + textStatus);
             	$scope.initPyetje();
             },
             error: function(xhr){
                if(xhr.status== 200){
                 	alert("pyetja u fshi me sukses");
                 	$scope.initPyetje();
                 }
             }
         });
	}
		
	$scope.fshiPyetje=  function(questionId){
		var check = confirm("jeni i sigurt qe doni ta fshini kete pyetja nga databaza juaj ?");
        if (check == true) {
            var questionIdObject = "{\"questionId\":\""+questionId+"\"}";
			var obj = JSON.parse(questionIdObject);
			var u = JSON.stringify(obj);
			alert(u);
			$.ajax({//jquery form
	             url: 'http://localhost:8080/pyetesor/user/fshi/pyetjeFromDatabase',
	             type: "POST",
	             data: u,
	             dataType: 'JSON',
	             success:function(data, textStatus, xhr){
	             	alert("pyetja u fshi me " + textStatus);
	             	$scope.initPyetje();
	             },
	             error: function(xhr){
	                if(xhr.status== 200){
	                 	alert("pyetja u fshi me sukses");
	                 	$scope.initPyetje();
	                 }
	             }
	         });
        }
	}
		
		$scope.deteleTest=function(testId){
			var testIdObject = "{\"testId\":\""+testId+"\"}";
			var obj = JSON.parse(testIdObject);
			var u = JSON.stringify(obj);
			alert(u);
			$.ajax({//jquery form
	             url: 'http://localhost:8080/pyetesor/user/delete/test',
	             type: "POST",
	             data: u,
	             dataType: 'JSON',
	             success:function(data, textStatus, xhr){
	             	alert("testi u fshi me " + textStatus);
	             	$scope.initPyetje();
	             },
	             error: function(xhr){
	                if(xhr.status== 200){
	                 	alert("testi u fshi me sukses");
	                 	$scope.initPyetje();
	                 }
	             }
	         });
			
		}
		 
	
	
	
});

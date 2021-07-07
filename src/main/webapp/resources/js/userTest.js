var app = angular.module('listTestByCriteria', []);
app.controller('zgjidhTestet', function($scope,$http) {

	
	
	$scope.kerko =  function(){
		
		var questionIdObject = "{\"questionId\":\""+questionId+"\"}";
		var obj = JSON.parse(questionIdObject);
		var u = JSON.stringify(obj);
		alert(u);
		$.ajax({//jquery form
             url: 'http://localhost:8080/pyetesor/user/fshiPyetje',
             type: "POST",
             data: u,
             dataType: 'JSON',
             success:function(data, textStatus, xhr){
             	alert("pyetja u fshi me " + textStatus);
             	$scope.initPyetje();
             },
             error: function(xhr){
            	 alert(xhr.statusText);
                if(xhr.status== 200){
                 	alert("pyetja u fshi me sukses");
                 	$scope.initPyetje();
                 }
             }
         });
	}
		
		
		$scope.deteleTest=function(testId){
			var testIdObject = "{\"testId\":\""+testId+"\"}";
			var obj = JSON.parse(testIdObject);
			var u = JSON.stringify(obj);
			alert(u);
			$.ajax({//jquery form
	             url: 'http://localhost:8080/pyetesor/user/fshiTest',
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

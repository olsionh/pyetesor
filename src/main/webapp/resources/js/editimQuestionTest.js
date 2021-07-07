var app = angular.module('question', []);

app.controller('shikopyetje', function($scope,$http) {
	
	$scope.initAlternatives =  function(){
		var questionId = document.getElementById("questionId").value
		var questionIdObject = "{\"questionId\":\""+questionId+"\"}";
		var obj = JSON.parse(questionIdObject);
		var u = JSON.stringify(obj);
	//	alert(u); 
		$.ajax({//jquery form
	        url: 'http://localhost:8080/pyetesor/user/afisho/AlternativatPerPyetje',
	        type: "POST",
	        data: u,
	        dataType: 'JSON',
	        success:function(data, textStatus, xhr){
	        	//alert(data[0].alternativ);
	        	$scope.alt = data;

	        }
		}); 
	}
	$scope.deteleAlternativ =  function(alternativID){
		alert(alternativID);
		var questionIdObject = "{\"alternativId\":\""+alternativID+"\"}";
		var obj = JSON.parse(questionIdObject);
		var u = JSON.stringify(obj);
		alert(u); 
		$.ajax({//jquery form
	        url: 'http://localhost:8080/pyetesor/user/delete/alternativ',
	        type: "POST",
	        data: u,
	        dataType: 'JSON',
	        success:function(data, textStatus, xhr){
	        	alert("sukses");
	        	$scope.initAlternatives();
	        	location.reload(); 
	        }
		}); 
	}
	$scope.initCategory =  function(){
		$http.post('http://localhost:8080/pyetesor/user/list/category')
        .then(function(res){
           $scope.cat = res.data;
         });
		
	} 
});


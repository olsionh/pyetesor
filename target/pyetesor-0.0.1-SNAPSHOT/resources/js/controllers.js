var app = angular.module('newQuestion', []);
app.controller('addQuestion', function($scope,$http) {
	
	$scope.questionObject = {};
	
	$scope.shtoAlternativ = function() {
		var u = JSON.stringify($scope.questionObject);
	    alert(u);	 
	    
	    $.ajax({//jquery form
            url: 'http://localhost:8080/pyetesor/user/shtoPyetje',
            type: "POST",
            data: t,
            dataType: 'JSON',
            success:function(data, textStatus, xhr){
            	alert("pyetja u shtua me " + textStatus);
            },
            error: function(xhr){
               if(xhr.status== 200){
                	alert("pyetja u shtua me sukses");
                	$scope.initPyetje();
                }
            }
        });
	    
 }

});


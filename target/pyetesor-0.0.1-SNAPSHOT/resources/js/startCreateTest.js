var app = angular.module('newTesT', []);

app.controller('addTest', function($scope,$http) {
	
	$scope.initCategory =  function(){
		$http.post('http://localhost:8080/pyetesor/user/list/category')
        .then(function(res){
           $scope.cat = res.data;
         });
		
	} 
	$("#testCreate").submit(function( event ) {
		if(document.getElementById("testName").value == null ||document.getElementById("testName").value == ""){
			alert("shkruaj pyejten");
			event.preventDefault();
			return false;
		}		
	})
	$scope.initListQuestion =  function(){
		$http.post('http://localhost:8080/pyetesor/user/list/AllQuestion')
        .then(function(res){
           $scope.allQuest = res.data;
         });	
	}
	//------------------------------
	$("#shtimiPyetjeve").submit(function( event ) {
		var x = document.getElementsByName("pyetjetQeDoShtohen");
		var nr=0;
		var idSaktaPyetjeve="";
		for(var i=0;i<x.length;i++){
			if( x[i].checked == true ){
				nr++;
				idSaktaPyetjeve +=x[i].value+" ";
			}
		}
		if(nr<1){
			alert("duhet te selektoni te pakten 1 ");
			event.preventDefault();
		}	
		else{
			//alert(idSaktaPyetjeve);
			var idSaktObject = "{\"question\":\""+idSaktaPyetjeve+"\"}";
			var obj = JSON.parse(idSaktObject);
			var u = JSON.stringify(obj);
			//alert(u);
			 $.ajax({//jquery form
			       url: 'http://localhost:8080/pyetesor/user/populate/test',
			        type: "POST",
			         data: u,
			          dataType: 'JSON',
			          success:function(data, textStatus, xhr){
			                 //alert("alternativa e sakt u ruajt me " + textStatus);
			          }
			    }); 
		}
	})
});
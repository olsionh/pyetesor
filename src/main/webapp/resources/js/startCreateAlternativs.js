var app = angular.module('newAlternative', []);

app.controller('addAlternative', function($scope,$http) {
	
	$scope.objekt = {};
	$scope.fillim = {};
	$scope.fund = {};
	$scope.mes = {};
	$scope.fillim.alternativ=1;
	$scope.fund.alternativ=10;
	$scope.mes.alternativ=5;
	var type=-1;
	var qId=-1;
	$scope.result=-1;
	
	
	$scope.shtoAlternativ = function() {
		var u = JSON.stringify($scope.objekt);
	   // alert(u);
	    $.ajax({//jquery form
	       url: 'http://localhost:8080/pyetesor/user/shtoAlternativ',
	        type: "POST",
	         data: u,
	          dataType: 'JSON',
	          success:function(data, textStatus, xhr){
	                // alert("alternativa u shtua me " + textStatus);
	                  document.getElementById("myForm").reset(); 
	                  $scope.initQuestion();
	                  
	           },
	          error: function(xhr){
	        	  if(xhr.status== 200){
	        		 // alert("alternativa u shtua me sukses");
	        		  document.getElementById("myForm").reset();   
	        		  $scope.initQuestion();
	              }
	          }
	    }); 
 }


    $scope.shtoAlternativSlide = function() {
        if ($scope.fillim.alternativ > $scope.fund.alternativ || $scope.mes.alternativ < $scope.fillim.alternativ || $scope.mes.alternativ > $scope.fund.alternativ) {
            alert("Gabim");
            event.preventDefault();
            return false;
        }
        else {
            var f = JSON.stringify($scope.fillim);
            var fu = JSON.stringify($scope.fund);
            var m = JSON.stringify($scope.mes);
            // alert(u);
            $.ajax({//jquery form
                url: 'http://localhost:8080/pyetesor/user/shtoAlternativ',
                type: "POST",
                data: f,
                dataType: 'JSON',
                success: function (data, textStatus, xhr) {
                    // alert("alternativa u shtua me " + textStatus);
                    document.getElementById("myForm").reset();
                    $scope.initQuestion();

                },
                error: function (xhr) {
                    if (xhr.status == 200) {
                        // alert("alternativa u shtua me sukses");
                        document.getElementById("myForm").reset();
                        $scope.initQuestion();
                    }
                }
            });
            $.ajax({//jquery form
                url: 'http://localhost:8080/pyetesor/user/shtoAlternativ',
                type: "POST",
                data: fu,
                dataType: 'JSON',
                success: function (data, textStatus, xhr) {
                    // alert("alternativa u shtua me " + textStatus);
                    document.getElementById("myForm").reset();
                    $scope.initQuestion();

                },
                error: function (xhr) {
                    if (xhr.status == 200) {
                        // alert("alternativa u shtua me sukses");
                        document.getElementById("myForm").reset();
                        $scope.initQuestion();
                    }
                }
            });

            $.ajax({//jquery form
                url: 'http://localhost:8080/pyetesor/user/shtoAlternativ',
                type: "POST",
                data: m,
                dataType: 'JSON',
                success: function (data, textStatus, xhr) {
                    // alert("alternativa u shtua me " + textStatus);
                    document.getElementById("myForm").reset();
                    $scope.initQuestion();

                },
                error: function (xhr) {
                    if (xhr.status == 200) {
                        // alert("alternativa u shtua me sukses");
                        document.getElementById("myForm").reset();
                        $scope.initQuestion();
                    }
                }
            });
        }
    }


	$scope.kontrollo = function(tipi) {
		type=tipi;   
	}
	$scope.kontrolloPOJO= function(tipi,quesId) {
		type=tipi; 
		qId=quesId;
	}
	$("#saveAlternativs").submit(function( event ) {
		var alternativatSakt="";
		var nr=0;
	    var x = document.getElementsByName("esakta");
		if (type==1 || type == 2)
		{
			for(var i=0;i<x.length;i++){
                if( x[i].checked == true ){
                    nr++;
                    alternativatSakt += x[i].value+" ";
                }
            }
        }
        else if (type==3)
		{
			x = document.getElementById("esakta");
			alternativatSakt += x.value+" ";
		}
		if(type==1 && nr!=1){
			alert("Keni zgjedhur opsion nje alternative . Selektoni vetem 1 alternative");
			event.preventDefault();
			return false;
		}	
		else if(type==2 && nr<2){
			alert("tipi 2 , me disa alernativa , zgjidhnni me shume se 1 alternative");
			event.preventDefault();
			return false;
		}
		else{
			var altSaktObject = "{\"esakta\":\""+alternativatSakt+"\"}";
			var obj = JSON.parse(altSaktObject);
			var u = JSON.stringify(obj);
			//alert(u);
			 $.ajax({//jquery form
			       url: 'http://localhost:8080/pyetesor/user/save/alternativSakt',
			        type: "POST",
			         data: u,
			          dataType: 'JSON',
			          success:function(data, textStatus, xhr){
			                // alert("alternativa e sakt u ruajt me " + textStatus);
			          }
			    }); 
		}		
	})
	$("#pyetjePOJO").submit(function( event ) {

		if(type==0 && $scope.result!=0 && $scope.result!=1 ){
			alert("ju lutem zjgidhni po ose jo");
			event.preventDefault();
			return false;
		}	
		else{
			//alert("id"+qId);
			var altSaktObject = "{\"esakta\":\""+$scope.result+"\"}";
			var obj = JSON.parse(altSaktObject);
			var u = JSON.stringify(obj);
			//alert(u);
			 $.ajax({//jquery form
			       url: 'http://localhost:8080/pyetesor/user/save/alternativSakt/tipiPOJO',
			        type: "POST",
			         data: u,
			          dataType: 'JSON',
			          success:function(data, textStatus, xhr){
			                // alert("alternativa e sakt u ruajt me " + textStatus);
			          }
			    }); 
		}		
	})

		/*$("#pyetjeSLIDE").submit(function( event ) {

        if(type==3 && $scope.fillim > $scope.fund ){
            alert("Fillimi nuk mund te jete me i madh se fundi");
            event.preventDefault();
            return false;
        }
        else if (type==3 && $scope.sakte < $scope.fillim || $scope.sakte > $scope.fund)
		{
			alert("Pergjigja e sakte duhet te jete ndermjet vleres fillestare dhe asaj perfundimtare");
			event.preventDefault();
			return false;
		}
        else{
            //alert("id"+qId);
            var altSaktObject = "{\"esakta\":\""+$scope.sakte+"\"}";
            var obj = JSON.parse(altSaktObject);
            var u = JSON.stringify(obj);
            //alert(u);
            $.ajax({//jquery form
                url: 'http://localhost:8080/pyetesor/user/save/alternativSakt',
                type: "POST",
                data: u,
                dataType: 'JSON',
                success:function(data, textStatus, xhr){
                    // alert("alternativa e sakt u ruajt me " + textStatus);
                }
            });
        }
    })  */



	$scope.initQuestion =  function(){
		$http.post('http://localhost:8080/pyetesor/user/list/question')
        .then(function(res){
           $scope.ques = res.data;
         });
		$http.post('http://localhost:8080/pyetesor/user/show/alternative')
        .then(function(res){
           $scope.altern = res.data;
         });
	}
});
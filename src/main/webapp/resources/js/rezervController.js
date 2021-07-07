var app = angular.module('newTest', []);

app.controller('shtoTest', function($scope,$http) {
	
	$scope.testObject = {};
	var numero=1;
	var afishimi= "";
	
	$scope.myFunc = function(z) {//duhet t kontrolloj qe nuk mund ta klikoj si t sakt nqs nuk ka vler tek fusha 
		var x = document.getElementsByName("esakta");
		var i;
		var f = "alternativ"+z;
		var t = document.getElementById(f);
		if( x[z-1].checked == true && (t.value=="" || t.value==null)){
			alert("ju nuk mund ta selektoni kety pyetje pasi esht bosh brenda ");
			$(x[z-1]).prop('checked', false);
			return false;
		}
	}  
	
	$scope.shtoPyetje = function() {
		
    		var b="";
    		var x = document.getElementsByName("esakta");
    		var i;
    		var f ;
    		var t;
    		for(i=0;i<4;i++){
    			f = "alternativ"+(i+1);
    			t = document.getElementById(f);
    			if( x[i].checked == true && (t.value=="" || t.value==null)){
    				alert("ju nuk mund ta selektoni "+(i+1)+" pasi esht bosh brenda ");
    				$(x[i]).prop('checked', false);
    				return false;
    			}
    			if(x[i].checked == true && (t.value!="" || t.value!=null)){
    				b+=(i+1)+" ";
    			}	
    		} 
    		if(b!=""){
    			
	    			var u = JSON.stringify($scope.testObject);
	    			alert(u);
	        		var t=u.slice(0,u.length-1);
	        		t+=",\"esakta\":\""+b+"\"}";
	      
	        		numero++;
	        	
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
	        	 document.getElementById("myForm").reset();
    		}
    		else{
    			alert("plotesojini te dhenat si duhen dhe selektoni pergjigjen e sakt");
    			$scope.initPyetje();
    		}
    		
    	// $scope.initPyetje();// nqs nuk rifreskohet vere dhe kte prap n pune 
    
 }
	
	$scope.initPyetje =  function(){
		
		 $http.post('http://localhost:8080/pyetesor/user/admin/afishoTest')
        .then(function(res){
           $scope.tests = res.data;
         });
	}

   
});


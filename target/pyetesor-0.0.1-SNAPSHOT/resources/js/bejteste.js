var app = angular.module('listTestByCriteria', []);
app.controller('zgjidhTestet', function($scope,$http) {

	$scope.tests={};
	
	$scope.kerko =  function(){
		var menyra = document.getElementById("selekti").value;
		var kriteri = document.getElementById("kriterKerkimi").value;

		if(menyra=="kategori" && kriteri!="")
			var kerkimiObject = "{\"categoryName\":\""+kriteri+"\"}";
		else if(menyra=="emerTesti" && menyra !="")
			var kerkimiObject = "{\"testName\":\""+kriteri+"\"}";
		else
			alert("selektoni nje");
		
		var obj = JSON.parse(kerkimiObject);
		var u = JSON.stringify(obj);
		$.ajax({//jquery form
	         url: 'http://localhost:8080/pyetesor/user/listquestion/kriterKerkimi',
	         type: "POST",
	         data: u,
	         dataType: 'JSON',
	         success:function(json){
	         	$scope.tests = json;
	         	// $('#response pre').html( data );
	         	
	         },
	         error: function(xhr){
	            if(xhr.status== 200){
	            	$scope.tests = json;
	             }
	         }
	     });
	}
	$scope.initTime =  function(testId){
		
		
		/*$http.post('http://localhost:8080/pyetesor/user/list/questionOfTest/'+testId)
        .then(function(res){
           $scope.pyetjet = res.data;
         
         }); */
		
		var fiveMinutes = 60 * 5, display = document.querySelector('#time');
		$scope.startTimer(fiveMinutes, display);
		$("#butoniStart").remove();
		$("#butFinish").attr("style","display:inline");
		$("#listPyetjeAlternativa").attr("style","display:inline-block");

		
	}//nginit vere nje her per funksion fillo pyetjet se mbase kur i jep kerko t t dali me kikimin e pare 
	$scope.startTimer=function(duration, display) {
	    var timer = duration, minutes, seconds;
	    setInterval(function () {
	        minutes = parseInt(timer / 60, 10)
	        seconds = parseInt(timer % 60, 10);
	        minutes = minutes < 10 ? "0" + minutes : minutes;
	        seconds = seconds < 10 ? "0" + seconds : seconds;
	        display.textContent = minutes + ":" + seconds;
	        if (--timer < 0) {
	            timer = duration;
	        }
	    }, 1000);
	}

	$scope.kot=function(testId){
		var x = document.getElementsByName("kapigjith");
		var nr=0;
		for(var i=0;i<x.length;i++){
			var y = "counter-"+i;// per t kapur eleement , pyetjet"
			z = document.getElementById(y);
			var t = "alternativ-"+z.value;
			var perTipin = "count-"+i;// per te kapur tipin e cdo pyetjeje .
			var type = document.getElementById(perTipin);
			var tesakt = "esakta-"+i;
			var tesaktat = document.getElementById(tesakt);
			
			if(type.value==0){// keto 3 ifet mbledhin id e alternativave te chekuara 
				if(tesaktat.value==$('input[name='+t+']:checked').val())
					nr++;
			}
			else if(type.value==1){
				var e = document.getElementById(t);//per select 
				var strUser = e.options[e.selectedIndex].value;//ng-attr-id="{{'question-'+${row2.questionId}}}"
				if(tesaktat.value == strUser)
					nr++;
			}
			else if(type.value==2){
				var kontroll ="|";
				$('input[name='+t+']:checked').each(function() {//per checkbox
					  kontroll+=this.value+"|";
					});
				if(tesaktat.value == kontroll)
					nr++;
			}
			else if (type.value==3)
			{
                var e = document.getElementById(t);//per select
                var strUser = e.value;//ng-attr-id="{{'question-'+${row2.questionId}}}"
                if(tesaktat.value == strUser)
                    nr++;
			}
		}
		
		var saveResult = "{\"testId\":\""+testId+"\",\"testScore\":\""+parseInt(nr*100/x.length)+"\"}";
		var obj = JSON.parse(saveResult);
		var u = JSON.stringify(obj);
		$.ajax({//jquery form
	         url: 'http://localhost:8080/pyetesor/user/save/result',
	         type: "POST",
	         data: u,
	         dataType: 'JSON',
	     });
		var pergj = document.getElementById("pergjigje");
 		alert("Provimi perfundoi me sukses . Ju fituat "+ parseInt(nr*100/x.length)+"%" + " te pikeve.");
 		$("#testi").remove();
 		window.location.replace("http://localhost:8080/pyetesor/user/faqjakryesore");
	}
	
});

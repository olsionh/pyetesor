<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<!------ Include the above in your HEAD tag ---------->

	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
		  crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/pyetesor/resources/js/startCreateTest.js"></script>

</head>
<body>
<header class="header-user-dropdown">
	<div class="header-limiter">
		<h1><a href="#">Pyetesor<span>.com</span></a></h1>

		<nav>
			<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
			<a href="http://localhost:8080/pyetesor/user/test/bejTest">Bej test</a>
			<a href="http://localhost:8080/pyetesor/user/seminareteMia">Seminaret<span class="header-new-feature">new</span></a>

		</nav>


		<div class="header-user-menu">
			<img src="/pyetesor/resources/images/2.jpg" alt="User Image"/>

			<ul>
				<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
				<a href="http://localhost:8080/pyetesor/user/create/question">Krijo pyetje</a>
				<a href="http://localhost:8080/pyetesor/user/krijoPyetesor1">Krijo test</a>
				<a href="http://localhost:8080/pyetesor/user/krijoKurs">Krijo kurs</a>
				<a href="http://localhost:8080/pyetesor/user/seminaret">Kurset e mia</a>
			</ul>
		</div>

	</div>
</header>
			
			
	<div class="container" style="margin-top:70px;margin-bottom:20px;">
		<div class="row"><br />
			<div class="col-md-12">
	    		<div class="progress" style="background-color:white;">
	       			<div class="one success-color"><span style="font-size:30px;" class="glyphicon glyphicon-ok"></div><div class="two success-color"></div>
	  				<div class="progress-bar success-color" style="width: 68%;"></div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div style="margin-left:110px;width:84%">
		<div class="panel panel-default">
			<div class="list-group-item list-group-item-info">
				<span class="lead">Testi : ${testi.testName}</span>
			</div>
			<form:form method="POST" id="shtimiPyetjeve"  class="form-horizontal" ng-app="newTesT" ng-controller="addTest" >
				<table class="table table-hover"  ng-init="initListQuestion()">
					<tr>
						<th>Pyetjet</th>
						<th>Selekto</th>
					</tr>
					<tr  ng-repeat="x in allQuest">
						<td>{{x.question}}</td>
						<td><input type="checkbox" name="pyetjetQeDoShtohen" value="{{x.questionId}}"/></td>
					</tr>
				</table>
				<div class="form-group">
					<div style="margin-right:70px;float:right">
						<input type="submit"  id="dergo" class="btn btn-primary" value="Krijo Testin" />
					</div>
				</div>
			</form:form>
		</div>
	</div>		
</body>
</html>
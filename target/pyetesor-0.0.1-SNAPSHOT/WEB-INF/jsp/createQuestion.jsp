<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.7.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<!------ Include the above in your HEAD tag ---------->

	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
		  crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.7.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/pyetesor/resources/js/controllers.js"></script>

</head>
<body>
<header class="header-user-dropdown">
	<div class="header-limiter">
		<h1><a href="#">Pyetesor<span>.com</span></a></h1>

		<nav>
			<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
			<a href="http://localhost:8080/pyetesor/user/create/question">Krijo pyetje</a>
			<a href="http://localhost:8080/pyetesor/user/krijoPyetesor1">Krijo test</a>
			<a href="http://localhost:8080/pyetesor/user/krijoKurs">Krijo kurs</a>
			<a href="http://localhost:8080/pyetesor/user/seminaret">Kurset e mia</a>

		</nav>


		<div class="header-user-menu">
			<img src="/pyetesor/resources/images/2.jpg" alt="User Image"/>

			<ul>
				<li><a href="http://localhost:8080/pyetesor/user/profil">Profili</a></li>
				<li><a href="#">Testet e mia</a></li>
				<li><a href="http://localhost:8080/pyetesor/user/logout" class="highlight">Dil</a></li>
			</ul>
		</div>

	</div>
</header>
	
	
	
	<div  style="margin-left:50px;width:92%">
		<div class="panel panel-default">
			<div class="list-group-item list-group-item-info">
				<span class="lead">Krijo pyetje te re </span>
			</div>
			<br/><br/>
			<form:form method="POST" id="myForm"  class="form-horizontal"  ng-app="newQuestion" ng-controller="addQuestion" >
				<div class="form-group">
					<label class="control-label col-sm-2" for="question">Pyetja </label>
					<div class="col-sm-6">
						<input type="text" ng-model="questionObject.question" class="form-control"  placeholder=" Shkruaj Pyetjen" />
					</div>
				</div>
				<div style="width:100%;height:25px;border-bottom:2px solid gray;text-align:center">
					<span style="font-size: 18px;  padding: 0 10px;">Alternativat</span>
				</div><br/><p></p>
				<div class="form-group" style="width:90%;margin-left:70px">
					<div class="col-sm-5" >
						<input type="text" ng-model="questionObject.alternativ" class="form-control"  placeholder="Shkruaj Alternativen"  >
				    </div>
				    <div class="col-sm-1" style="margin-left:-10px">
				    	<label class="checkbox-inline"><input type="checkbox" ng-model="questionObject.esakt"  value="1"></label>
				    </div>
				</div>
				<div class="form-group">
					<div style="margin-right:70px;float:right">
						<input type="button" ng-click="shtoAlternativ()"  class="btn btn-success"  value="shto alternativ"></input>
						<input type="submit"  id="dergo" class="btn btn-primary" value="finish" />
					</div>
				</div>
			</form:form>
		</div>
	</div>	
		
</body>

</html>

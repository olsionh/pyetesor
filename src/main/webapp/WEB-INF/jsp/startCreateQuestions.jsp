<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<!------ Include the above in your HEAD tag ---------->

	<link href="https://stackpath.bootstrapcdn.com/font-awesome/3.3.7/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
		  crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
			
	<div class="container" style="margin-top:70px;margin-bottom:20px;">
		<div class="row"><br />
			<div class="col-md-12">
	    		<div class="progress" style="background-color:white;">
	       			<div class="one success-color"></div><div class="two success-color"></div>
	  				<div class="progress-bar success-color" style="width: 35%;"></div>
				</div>
			</div>
		</div>
	</div>
	
	<div  style="margin-left:110px;width:84%">
		<div class="panel panel-default">
			<div class="list-group-item list-group-item-info">
				<span class="lead">Krijimi i nje pyetjeje te re </span>
			</div>
			<br/><br/>
			
			<form:form method="POST" modelAttribute="newQuestion"  class="form-horizontal"  >
				<div class="form-group">
					<label class="control-label col-sm-2" for="email">Pyetja</label>
					<div class="col-sm-6">
						<form:input id="question" path="question" type="text" class="form-control"  placeholder="Shkruaj pyetjen"  />
					</div>
				</div>
				<div class="form-group">
					<div style="margin-left:250px;">
						<form:radiobutton path="type" value="1"/> Me 1 alternative <br>
						<form:radiobutton path="type" value="2"/> Me disa alternativa <br>
						<form:radiobutton path="type" value="0"/> Po/Jo <br>
						<form:radiobutton path="type" value="3"/> Slider
					</div>
				</div>
				<div class="form-group">
					<div style="margin-right:70px;float:right">
						<input type="submit" style=width:90px;" id="dergo" class="btn btn-primary" value="Next" />
					</div>
				</div>
			</form:form>
		</div>
	</div>	
	<div>
		
	</div>				
</body>

</html>

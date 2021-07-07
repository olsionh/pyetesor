<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
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
	<script src="/pyetesor/resources/js/afishoSeminare.js"></script>

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
	<br />
	<br />
	
		<form:form method="POST" modelAttribute="newTest" commandName="newTest" class="form-horizontal">
			<fieldset>
				<legend>Krijimi i nje testi te ri </legend><br />
 			
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="question1"> pyetja 1 </label>
					<div class="col-lg-10">
						<form:input placeholder='pyetje 1' id="question1" path="question1" type="text" class="form:input-large" />
						<form:input placeholder='alternativ 1' id="alternativ11" path="alternativ11" type="text" class="form:input-large" />
						<form:input placeholder='alternativ 2' id="alternativ12" path="alternativ12" type="text" class="form:input-large" />
						<form:input placeholder='alternativ 3' id="alternativ13" path="alternativ13" type="text" class="form:input-large" />
						<form:input placeholder='alternativ 4' id="alternativ14" path="alternativ14" type="text" class="form:input-large" />
					</div>
				</div>
		
				
				<div id="buildyourform"></div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="button" id="shtoPyetje" class="btn btn-primary" value="shto pyetje" />
							<input type="submit" id="dergo" class="btn btn-primary" value="finish" />

					</div>
				</div>
				
			</fieldset>
		</form:form>
</body>
</html>
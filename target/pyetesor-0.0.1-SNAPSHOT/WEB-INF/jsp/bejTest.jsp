<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<!------ Include the above in your HEAD tag ---------->

	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
		  crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/pyetesor/resources/js/bejteste.js"></script>

</head>
<body>
<header class="header-user-dropdown">
	<div class="header-limiter">
		<h1><a href="#">Pyetesor<span>.com</span></a></h1>

		<nav>
			<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
			<a href="http://localhost:8080/pyetesor/user/do/bejTest">Bej test</a>
			<a href="http://localhost:8080/pyetesor/user/seminareteMia">Seminaret<span class="header-new-feature">new</span></a>

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

	
	<img src="<c:url value="/resources/images/foto.PNG"></c:url>" alt="image" style ="margin-left:150px;margin-top:60px;height:130px;width:80%"/>
	 
	<div class="container"  style ="margin-top:10px;margin-left:150px;background-color:#D6DBDF;width:80%;">
	
		<h3 style ="color:#17202A;"> Kerko testin sipas kategorise apo sipas emrit . </h3>
		
		<section class="container" ng-app="listTestByCriteria" ng-controller="zgjidhTestet">
				<div ng-init="initTest()">
				<h4 style ="color:#17202A;">Zgjidhe menyren e kerkimit te testeve     
					<select id="selekti" style ="margin-left:60px;height:30px;">
					  <option value="kategori">Kerkimi sipas kategorise</option>
					  <option value="emerTesti">Kerkim sipas emrit </option>
					</select>
					<input style ="height:30px;" type="text" id="kriterKerkimi" placeholder="Emri Testit / Kategoria"/>
					<button  class="btn btn-primary" ng-click="kerko()">KERKO</button>
				</h4>
				
				</div><hr style ="margin-left:-20px;height:1px;background-color:white;width:94%;"><br><br>
				<div class="col-sm-3  col-lg-3" style="border-radius:15px;color:black;background-color:#7FB3D5 ;margin-left:30px;margin-bottom:25px;" ng-repeat="x in tests">
					<a style="font-size:20px;text-decoration: none;color:black;" href="<c:url value="/user/do/test/{{x.testId}}">
					</c:url>">Emri Testit : {{x.testName}}</a> <br>
					Data Krijuar : {{x.dateCreated}}  <br>
					Kategoria : ${kursi.seminar}
				</div>
		</section>
	</div>
	<div id="response pre">
	</div>
</body>
</html>

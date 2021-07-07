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
	<script src="/pyetesor/resources/js/afishoteste.js"></script>

</head>
<body>
<header class="header-user-dropdown">
	<div class="header-limiter">
		<h1><a href="#">Pyetesor<span>.com</span></a></h1>

		<nav>
			<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
			<a href="http://localhost:8080/pyetesor/user/create/question">Krijo pyetje</a>
			<a href="http://localhost:8080/pyetesor/user/krijoPyetesor1">Krijo test</a>
			<a href="http://localhost:8080/pyetesor/user/admin/testekrijuara">Testet</a>
			<a href="http://localhost:8080/pyetesor/user/admin/reports">Raportet</a>
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
	<div style="margin-top:90px;">
		<section class="container" ng-app="afishoTest" >
			<div ng-controller="afishTegjithTestet" ng-init="initPyetje()">
				<table style="background-color:#D6DBDF;border-radius:20px;" class="table table-hover" ng-repeat="x in tests">
					<tr>
						<th>Emri Testit : {{x.testi.testName}}</th>
						<th>Data Krijuar : {{x.testi.dateCreated}}</th>
						<th>Kategoria : {{x.testi.categoryName}}</th>
						<th>
						<a href="<c:url value="/user/edit/test/{{x.testi.testId}}"></c:url>"><button  class="btn btn-success" style="width:130px;height:30px;">Edit Test</button></a>
						<button  ng-click="deteleTest(x.testi.testId)" style="width:100px;height:30px;" class="btn btn-danger">Fshi Test</button>
						</th>
					</tr>
					<tr>
						<td colspan="3">PYETJA </td>
						<td></td>
					</tr>
					<tr ng-repeat="y in x.questions">
						<td>{{y.question}}</td>
						<td></td><td></td>
						<td><a href="<c:url value="/user/edit/pyetje/{{y.questionId}}"></c:url>"><button  class="btn btn-success"style="width:130px;height:30px;">Edit Pyetje</button></a>
							<button  style="width:130px;height:30px;" ng-click="fshiPyetjeTesti(y.questionId,x.testi.testId)" class="btn btn-warning">Fshi Pyetje Testi</button>
							<button style="width:100px;height:30px;" ng-click="fshiPyetje(y.questionId)" class="btn btn-danger">Fshi Pyetje</button>
						</td>
					</tr>
				</table>
				<a href="<spring:url value="/market/products"/>" class="btn btn-default"><span class="glyphicon-hand-left glyp icon"></span> Back</a>
			</div>
		</section>
	</div>
</body>
</html>

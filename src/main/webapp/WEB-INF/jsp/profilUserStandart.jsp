<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Profil User</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/pyetesor/resources/js/testeTeBera.js"></script>
<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<style>
		.outer {
			width: 1px;
			height: 10%;
			position: relative;
			overflow: hidden;
		}
		.inner {
			position: absolute;
			width:100%;
			height: 40%;
			background: grey;
			top: 30%;
			box-shadow: 0px 0px 30px 20px grey;
		}
	</style>

</head>
<body>
<header class="header-user-dropdown">

	<div class="header-limiter">
		<h1><a href="#">Pyetesor<span>.com</span></a></h1>

		<nav>
			<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
			<a href="http://localhost:8080/pyetesor/user/seminareteMia">Kurset e mia</a>
			<a href="http://localhost:8080/pyetesor/user/profil">Rezultatet e mia</a>

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
<div style="margin-top: 40px" class="container">
	<div class="row my-2">
		<div class="col-lg-8 order-lg-2">
			<ul class="nav nav-tabs">
				<li class="nav-item">
					<a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Profili</a>
				</li>
				<li class="nav-item">
					<a href="http://localhost:8080/pyetesor/user/seminareteMia" class="nav-link">Seminaret e mia</a>
				</li>
				<li class="nav-item">
					<a href="" data-target="#edit" data-toggle="tab" class="nav-link">Ndrysho profilin</a>
				</li>
			</ul>
			<div class="tab-content py-4">
				<div class="tab-pane active" id="profile">
					<h5 class="mb-3">${userLoguar.firstName} ${userLoguar.lastName}</h5>
					<div class="row">
						<div class="col-md-12">
							<h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Testet tuaja</h5>
							<section class="container">
								<div class="row">
									<div class="container" ng-app="afishoTest">
										<div ng-controller="afishTegjithTestet" ng-init="initTest()">
											<table class="table">
												<thead>
												<tr>
													<th>Emri i testit</th>
													<th>Data</th>
													<th>Piket</th>
												</tr>
												</thead>
												<tbody ng-repeat="x in tests">
												<tr>
													<td id="testName" class="table-success">{{x.testName}}</td>
													<td id="dateCreated" class="table-success">{{x.dateCreated}}</td>
													<td id="testScore" class="table-success">{{x.testScore}}</td>

												</tr>
												</tbody>
											</table>
											</div>
										</div>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4 order-lg-1 text-center">
			<img src="//placehold.it/150" class="mx-auto img-fluid img-circle d-block" alt="avatar">
			<h6 class="mt-2">Upload a different photo</h6>
			<label class="custom-file">
				<input type="file" id="file" class="custom-file-input">
				<span class="custom-file-control">Choose file</span>
			</label>
		</div>

	</div>
</div>
</body>
</html>

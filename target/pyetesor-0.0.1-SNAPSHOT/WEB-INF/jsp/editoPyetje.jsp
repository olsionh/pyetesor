<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7 /css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
	<script src="/pyetesor/resources/js/editimQuestionTest.js"></script>

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
	
	

	<div  style="margin-top:90px;margin-left:110px;width:84%">
		<div class="panel panel-default">
			<div class="list-group-item list-group-item-info">
				<span class="lead">Editimi i pyetjes </span>
			</div>
			<br/><br/>
			
				
			<form:form method="POST" modelAttribute="editQuestion"  id="forma" class="form-horizontal"  ng-app="question" ng-controller="shikopyetje"  >
				<div class="form-group" ng-init="initAlternatives()" >
					<label class="control-label col-sm-2" for="question">Pyetja </label>
					<div class="col-sm-6">
						<form:input type="hidden" id="questionId" path="questionId" class="form-control"  placeholder="Enter email"  />
						<form:input type="text" id="question" path="question" class="form-control"  placeholder="Enter email"  />
					</div>
				</div>
				<div class="form-group">
					<div style="margin-right:70px;float:right">
						<input type="button" class="btn btn-primary" ng-click="initAlternatives()" value="Edito Alternativat" />
						<input type="submit" class="btn btn-success" value="Save" />
					</div> 
				</div>  
				<div style="width: 100%; height: 25px; border-bottom: 2px solid gray; text-align: center">
				  <span style="font-size: 18px;  padding: 0 10px;">Alternativat</span>
				</div><br/><p></p>
				<section class="container"  >
					<div>
						<table class="table table-hover">
							<tr>
								<th>Alternativat</th>
								<th>Action</th> 
							</tr>
							<tr ng-repeat="x in alt">
								<td>{{x.alternativ}}</td>
								<td><button  ng-click="deteleAlternativ(x.alternativId)" class="btn btn-danger">Fshi Alternativ</button>
									<a href="<c:url value="/user/edit/alternativ/{{x.alternativId}}"></c:url>"  class="label label-success" >Edit Alternativ</a>
								</td>
							</tr>
						</table>
					</div>
				</section>
			</form:form>
		</div>
	</div>	
		
</body>

</html>

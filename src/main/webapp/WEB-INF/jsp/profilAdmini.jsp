<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Profile</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#F4F6F6">
<nav class="navbar navbar-default navbar-fixed-top">
			  <div class="container">
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>                        
			      </button>
			      <a class="navbar-brand" href="#myPage">Pyetesor.COM</a>
			    </div>
			    <div class="collapse navbar-collapse" id="myNavbar">
			      <ul class="nav navbar-nav navbar-right">
			        <li class="active"><a href="<spring:url value="/user/profil"/>">HOME</a></li>
			        <li><a href="<spring:url value="/user/create/question"/>">Krijo Pyetje</a></li>
			        <li><a href="<spring:url value="/user/krijoPyetesor1"/>">Krijo Test</a></li>
					<li><a href="<spring:url value="/user/admin/testekrijuara"/>">Testet e Krijuara </a></li>
			       <li style="background-color:#C70039"><a href="<spring:url value="/user/logout"/>"><span class="glyphicon glyphicon-user"></span>LOG OUT</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>

	<div class="container">
		<h3>${userLoguar.username}</h3>
	</div>
	<div class="container">
		<h3>Krijo Testet </h3> 
	</div>
</body>
</html>
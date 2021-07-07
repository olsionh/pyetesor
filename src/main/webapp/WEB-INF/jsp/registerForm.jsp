<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
	<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	 	 <link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<title>Registrimi</title>
</head>
<body style="background-color:#85929E;">
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
			        <li><a href="#about">ABOUT</a></li>
			        <li><a href="#services">SERVICES</a></li>
			        <li><a href="#portfolio">PORTFOLIO</a></li>
			        <li><a href="#pricing">PRICING</a></li>
			        <li><a href="#contact">CONTACT</a></li>
			        <li style="background-color:#58D68D;"><a href="http://localhost:8080/pyetesor/user/login">LOG IN</a></li>
			      </ul>
			    </div>
			  </div>
			</nav>
	<section>
		<div class="jumbotron" style="margin-top:-30px;background-color:#B2BABB;height:240px;">
			<div class="container" style="color:#17202A;">
				<h1>Regjistrohu</h1>
				<p>Fusni te dhenat tuaja personale</p>
			</div>
		</div>
	</section>
	
	<section class="container" style="margin-left:500px;">
		<form:form modelAttribute="newUser" class="form-horizontal">
			<fieldset style="color:white;">
				<p><legend style="margin-left:-250px;color:white;">Perdorues i ri </legend></p>

				<div class="form-group">
					<label class=" col-lg-2" for="email">
						<spring:message code="addUser.form.email.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2" for="firstName">
						<spring:message code="addUser.form.firstName.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2" for="lastName">
						<spring:message code="addUser.form.lastName.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2" for="username">
						<spring:message code="addUser.form.username.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="username" path="username" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2" for="password">
						<spring:message code="addUser.form.password.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="password" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" 
							value="<spring:message code="addUser.form.regjistrohu.label"/>" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
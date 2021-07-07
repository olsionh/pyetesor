<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Lowin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
    <link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
    <link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
    <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>

</head>

<body>

<header class="header-user-dropdown">

    <div class="header-limiter">

        <h1><a href="#">Pyetesor<span>.com</span></a></h1>

        <nav>
            <a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
            <a href="http://localhost:8080/pyetesor/user/admin/shtoPedagog">Shto nje pedagog</a>
            <a href="http://localhost:8080/pyetesor/user/admin/reports">Raportet<span class="header-new-feature">new</span></a>

        </nav>


        <div class="header-user-menu">
            <img src="/pyetesor/resources/images/2.jpg" alt="User Image"/>

            <ul>
                <li><a href="http://localhost:8080/pyetesor/user/profil">Profili</a></li>
                <li><a href="http://localhost:8080/pyetesor/user/admin/shtoPedagog">Shto pedagog</a></li>
                <li><a href="http://localhost:8080/pyetesor/user/logout" class="highlight">Dil</a></li>
            </ul>
        </div>
    </div>
</header>

<div class="content">
<div class="lowin">
    <div class="lowin-brand">
        <img src="/pyetesor/resources/images/kodinger.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">

        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form:form method="POST"  modelAttribute="newUser">
                    <c:if test="${regjistruar != null}">
                        <div class="alert alert-success">
                            <p>Pedagogu u shtua me sukses!</p>
                        </div>
                    </c:if>
                    <p>Shto nje pedagog</p>

                        <label><spring:message code="addUser.form.firstName.label"/></label> <form:input id="firstName" path="firstName" type="text" class="lowin-input" />

                    <div class="">
                        <label><spring:message code="addUser.form.lastName.label"/></label>
                        <form:input id="lastName" path="lastName" type="text" class="lowin-input" />
                    </div>
                    <div class="">
                        <label><spring:message code="addUser.form.email.label"/></label>
                        <form:input id="email" path="email" type="email" class="lowin-input" />
                    </div>
                    <div class="">
                        <label><spring:message code="addUser.form.username.label"/></label>
                        <form:input id="username" path="username" type="text" class="lowin-input" />
                    </div>
                    <div class="lowin-group">
                        <label><spring:message code="addUser.form.password.label"/></label>
                        <form:input id="password" path="password" type="password" class="lowin-input" />

                    </div>
                    <input type="submit" name="register" value="Shto" id="btnAdd" class="lowin-btn" />
                </form:form>
                </form>
            </div>
        </div>
    </div>

    <footer class="lowin-footer">
        Pyetesor.com
    </footer>
</div>
</div>



</body>



</html>
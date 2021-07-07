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
            <a href="http://localhost:8080/pyetesor/user/create/question">Krijo pyetje</a>
            <a href="http://localhost:8080/pyetesor/user/krijoPyetesor1">Krijo test</a>
            <a href="http://localhost:8080/pyetesor/user/krijoKurs">Krijo kurs</a>
            <a href="http://localhost:8080/pyetesor/user/seminaret">Kurset e mia</a>


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
                    <form:form method="POST"  modelAttribute="newKurs">
                        <p>Krijo nje kurs te ri</p>

                        <div class="lowin-group">
                        <label>Emri i kursit</label>
                        <form:input id="firstName" path="seminar" type="text" class="lowin-input" />
                        </div>
                        <div class="lowin-group">
                            <label>Sesioni</label>
                            <form:input id="lastName" path="sesioni" type="text" class="lowin-input" />
                        </div>

                        <input type="submit" onclick="alert('Kursi u shtua me sukses')" name="register" value="Krijo" id="btnAdd" class="lowin-btn" />
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
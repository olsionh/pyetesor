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
                <li><a href="#">Profili</a></li>
                <li><a href="#">Testet e mia</a></li>
                <li><a href="#" class="highlight">Dil</a></li>
            </ul>
        </div>

    </div>

</header>
<div class="lowin">
    <div class="lowin-brand">
        <img src="/pyetesor/resources/images/kodinger.jpg" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form method="POST">

                    <p>Ju lutemi ndryshoni fjalekalimin!</p>
                    <div class="lowin-group">
                        <label>Fjalekalimi i ri</label>
                        <input name="newpassword" required="required" type="password" class="lowin-input" />
                    </div>
                    <input type="submit" name="login" id="btnLogIn" class="lowin-btn login-btn" value="Ndrysho" />
                </form>


            </div>
        </div>

    </div>

    <footer class="lowin-footer">
        2018
    </footer>
</div>

<script src="/pyetesor/resources/js/auth.js"></script>
<script>
    Auth.init({
        login_url: '#login'
    });
</script>
</body>
</html>
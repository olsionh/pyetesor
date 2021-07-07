<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="/pyetesor/resources/js/afishoSeminare2.js"></script>


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

<div ng-app="afishoSeminar" >
    <div ng-controller="afishTegjithSeminaret" ng-init="initPostimSeminar()">
        <div class="container-fluid gedf-wrapper">
            <div class="row">
                <div class="col-md-3">
                    <div style="position: sticky; top: 30px">
                        <div class="card">
                            <div class="card-body">
                                <div class="h5">${editSeminar.seminar}</div>
                                <div class="h7 text-muted">Pershkrimi</div>
                                <div class="h7">Developer of web applications, JavaScript, PHP, Java, Python, Ruby, Java, Node.js,
                                    etc.
                                </div>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <div class="h6 text-muted">Studente te regjistruar</div>
                                    <div class="h5">${nrStudenteve}</div>
                                </li>
                                <li class="list-group-item">
                                    <spring:url value="/user/seminar/testet/${editSeminar.seminarId}" var="testlink"></spring:url>
                                    <div class="h6 text-muted"><a href="${testlink}">Teste</a></div>
                                    <div class="h5">${nrTesteve}</div>
                                </li>
                                <li class="list-group-item">
                                    <div class="h6 text-muted">Postime</div>
                                    <div class="h5">${nrPostimeve}</div>
                                </li>
                            </ul>
                        </div>
                        <br><br>
                        <div class="card">
                            <div class="card-body">
                                <div class="h5">${editSeminar.seminar}</div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1">@</span>
                                    </div>
                                    <input type="text" id="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                                </div>
                                <button ng-click="shtoPerdorues()" style="margin-left: 40px;" class="btn btn-primary">Shto perdorues</button>
                            </div>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <div class="h5">${editSeminar.seminar}</div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon2">@</span>
                                    </div>
                                    <input type="text" id="username2" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                                </div>
                                <button ng-click="hiqPerdorues()" style="margin-left: 40px;" class="btn btn-primary">Hiq perdorues</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 gedf-main">

                    <!--- \\\\\\\Post-->


                    <!-- Post /////-->

                    <!--- \\\\\\\Post-->
                    <h4>Lista e perdoruesve qe bejne pjese ne kete kurs</h4>
                    <ul class="list-group">
                        <c:forEach var="student" items="${perdorues}">
                        <li class="list-group-item">${student.firstName} ${student.lastName} <button ng-click="largoPerdorues('${student.username}')" style="position:absolute; top:5px; right: 0" class="btn btn-link dropdown-toggle" type="button" >
                            <i class="fa fa-remove"></i></button></li>
                        </c:forEach>
                    </ul>

                    <!-- Post /////-->


                    <!--- \\\\\\\Post-->


                    <!-- Post /////-->


                    <!--- \\\\\\\Post-->

                    <!-- Post /////-->



                </div>
                <div class="col-md-3">
                    <div style="position: sticky; top: 30px;">
                        <h4>Komentet e fundit</h4>
                        <div ng-repeat="a in postimetseminar">
                            <ul ng-repeat="b in a.koments | orderBy: 'postimi.koments.dateCreated':true" class="list-group">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <span ng-if="b.username != 'admin'"><span class="text-primary" >{{b.emri}} {{b.mbiemri}}</span> komentoi ne nje postim ne kursin <a ng-href="http://localhost:8080/pyetesor/user/seminar/{{a.postimi.seminarId}}">{{a.postimi.seminar}}</a> me {{b.dateCreated}}: <i class="text-info">{{b.koment}}</i></span>
                                    <span ng-if="b.username === 'admin'"><span class="text-success">{{a.postimi.pedagogu}}</span> komentoi ne nje postim ne kursin <a ng-href="http://localhost:8080/pyetesor/user/seminar/{{a.postimi.seminarId}}">{{a.postimi.seminar}}</a> me {{b.dateCreated}}: <i class="text-info">{{b.koment}}</i></span>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
</body>
<style>
    .h7 {
        font-size: 0.8rem;
    }

    .gedf-wrapper {
        margin-top: 0.97rem;
    }

    @media (min-width: 992px) {
        .gedf-main {
            padding-left: 4rem;
            padding-right: 4rem;
        }
        .gedf-card {
            margin-bottom: 2.77rem;
        }
    }

    /**Reset Bootstrap*/
    .dropdown-toggle::after {
        content: none;
    }
</style>

</html>
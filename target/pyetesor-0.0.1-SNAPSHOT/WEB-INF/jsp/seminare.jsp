<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="/pyetesor/resources/js/afishoSeminare.js"></script>

</head>
<body>
<header class="header-user-dropdown">
    <div class="header-limiter">
        <h1><a href="#">Pyetesor<span>.com</span></a></h1>

        <nav>
            <a href="#">Faqja kryesore</a>
            <a href="#">Bej test</a>
            <a href="#">Seminaret<span class="header-new-feature">new</span></a>

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
    <div ng-controller="afishTegjithSeminaret" ng-init="initPostim()">
        <div class="container-fluid gedf-wrapper">
            <div class="row">
                <div class="col-md-3">
                    <div style="position: sticky; top: 30px">
                        <h4>Kategorite e testeve</h4>
                        <ul class="list-group">
                            <c:forEach var="kategori" items="${kategoria}">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                        ${kategori.categoryName}
                                    <span class="badge badge-primary badge-pill">12</span>
                                </li>
                            </c:forEach>
                        </ul>
                        <br><br>
                        <h4>Testet e fundit</h4>
                        <ul class="list-group">
                            <c:forEach var="testi" items="${testet}">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <a href="http://localhost:8080/pyetesor/user/do/test/${testi.testId}">${testi.testName}</a>
                                    <span class="badge badge-primary badge-pill">${testi.dateCreated}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div class="col-md-6 gedf-main">

                    <!--- \\\\\\\Post-->

                    <!-- Post /////-->

                    <!--- \\\\\\\Post-->

                    <div>
                        <h4>Seminaret</h4>
                        <div class="row">
                            <c:forEach var="x" items="${semiaret}">
                                <div style="margin-top:20px;" class="col-sm-6">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">${x.testName}</h5>
                                            <p class="card-text">Data e krijimit: ${x.dateCreated}<br>Kategoria: ${x.categoryName}</p>
                                            <a href="http://localhost:8080/pyetesor/user/do/test/${x.testId}" class="btn btn-primary">Bej testin</a>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>
                    </div>

                    <!-- Post /////-->


                    <!--- \\\\\\\Post-->


                    <!-- Post /////-->


                    <!--- \\\\\\\Post-->

                    <!-- Post /////-->



                </div>
                <div class="col-md-3">
                    <div style="position: sticky; top: 30px;">
                        <h4>Komentet e fundit</h4>
                        <div ng-repeat="a in posts">
                            <ul ng-repeat="b in a.koments | orderBy: 'postimi.koments.dateCreated':true" class="list-group">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <span ng-if="b.username != 'admin'"><span class="text-primary" >{{b.emri}} {{b.mbiemri}}</span> komentoi ne nje postim ne seminarin <a ng-href="http://localhost:8080/pyetesor/user/seminar/{{a.postimi.seminarId}}">{{a.postimi.seminar}}</a> me {{b.dateCreated}}: <i class="text-info">{{b.koment}}</i></span>
                                    <span ng-if="b.username === 'admin'"><span class="text-success">{{a.postimi.pedagogu}}</span> komentoi ne nje postim ne seminarin <a ng-href="http://localhost:8080/pyetesor/user/seminar/{{a.postimi.seminarId}}">{{a.postimi.seminar}}</a> me {{b.dateCreated}}: <i class="text-info">{{b.koment}}</i></span>
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
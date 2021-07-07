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

<div ng-app="afishoSeminar" >
    <div ng-controller="afishTegjithSeminaret" ng-init="initPostim()">
        <div class="container-fluid gedf-wrapper">
            <div class="row">

                <div class="col-md-10 gedf-main">

                    <!--- \\\\\\\Post-->

                    <!-- Post /////-->

                    <!--- \\\\\\\Post-->

                    <div>
                        <h4>Raportet</h4>
                        <div class="row">


                                <div style="margin-top:20px;" class="col-sm-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 class="card-title">Perdoruesit</h5>
                                            <p class="card-text">Shkarko listen e perdoruesve</p>
                                            <a href="http://localhost:8080/pyetesor/user/perdoruesitPDF" class="btn btn-primary"><i class="fa fa-file-pdf-o"></i>  Shkarko PDF</a>
                                            <a href="http://localhost:8080/pyetesor/user/perdoruesitXLS" class="btn btn-primary"><i class="fa fa-file-excel-o"></i>  Shkarko XLS</a>
                                        </div>
                                    </div>
                                </div>

                            <div style="margin-top:20px;" class="col-sm-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Rezultatet</h5>
                                        <p class="card-text">Shkarko listen e rezultateve te perdoruesve</p>
                                        <a href="http://localhost:8080/pyetesor/user/rezultatetPDF" class="btn btn-primary"><i class="fa fa-file-pdf-o"></i>  Shkarko PDF</a>
                                        <a href="http://localhost:8080/pyetesor/user/rezultatetXLS" class="btn btn-primary"><i class="fa fa-file-excel-o"></i>  Shkarko XLS</a>
                                    </div>
                                </div>
                            </div>

                            <div style="margin-top:20px;" class="col-sm-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Mesataret</h5>
                                        <p class="card-text">Shkarko listen e mesatareve te pikeve te perdoruesve</p>
                                        <a href="http://localhost:8080/pyetesor/user/mesataretPDF" class="btn btn-primary"><i class="fa fa-file-pdf-o"></i>  Shkarko PDF</a>
                                        <a href="http://localhost:8080/pyetesor/user/mesataretXLS" class="btn btn-primary"><i class="fa fa-file-excel-o"></i>  Shkarko XLS</a>
                                    </div>
                                </div>
                            </div>

                            <div style="margin-top:20px;" class="col-sm-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Seminaret</h5>
                                        <p class="card-text">Shkarko listen e seminareve</p>
                                        <a href="http://localhost:8080/pyetesor/user/seminaretPDF" class="btn btn-primary"><i class="fa fa-file-pdf-o"></i>  Shkarko PDF</a>
                                        <a href="http://localhost:8080/pyetesor/user/seminaretXLS" class="btn btn-primary"><i class="fa fa-file-excel-o"></i>  Shkarko XLS</a>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>

                    <!-- Post /////-->


                    <!--- \\\\\\\Post-->


                    <!-- Post /////-->


                    <!--- \\\\\\\Post-->

                    <!-- Post /////-->



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
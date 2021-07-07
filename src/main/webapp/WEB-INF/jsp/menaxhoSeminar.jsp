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
            <a href="http://localhost:8080/pyetesor/user/test/bejTest">Bej test</a>
            <a href="http://localhost:8080/pyetesor/user/seminareteMia">Seminaret<span class="header-new-feature">new</span></a>

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
                                <div class="h6 text-muted">Teste</div>
                                <div class="h5">${nrTesteve}</div>
                            </li>
                            <li class="list-group-item">
                                <div class="h6 text-muted">Postime</div>
                                <div class="h5">${nrPostimeve}</div>
                            </li>

                        </ul>

                    </div>
                    <br><br>
                    <h4>Testet ne kete kurs</h4>
                    <ul class="list-group">
                        <c:forEach var="testi" items="${testkurs}" varStatus="status">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <a href="http://localhost:8080/pyetesor/user/do/test/${testi.testId}">${testi.testName}</a>
                            </li>
                        </c:forEach>
                    </ul>

                    </div>
                </div>


                <div class="col-md-6 gedf-main">

                    <!--- \\\\\\\Post-->

                    <!-- Post /////-->

                    <!--- \\\\\\\Post-->

                    <div style="width: 120%; margin-left: -10%" ng-repeat="x in postimetseminar | orderBy: '-postimi.postimId'" class="card gedf-card">
                        <div class="card-header">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="mr-2">
                                        <img class="rounded-circle" width="45" src="https://picsum.photos/50/50" alt="">
                                    </div>
                                    <div class="ml-2">
                                        <div class="h5 m-0"><a ng-href="http://localhost:8080/pyetesor/user/seminar/{{x.postimi.seminarId}}">{{x.postimi.seminar}}</a></div>
                                        <div class="h7 text-muted">${emriPedagogut}</div>
                                    </div>
                                </div>
                                <div>
                                    <div class="dropdown">
                                        <button class="btn btn-link dropdown-toggle" type="button" id="gedf-drop1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fa fa-ellipsis-h"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="gedf-drop1">
                                            <div class="h6 dropdown-header">Configuration</div>
                                            <a class="dropdown-item" href="#">Save</a>
                                            <a class="dropdown-item" href="#">Hide</a>
                                            <a class="dropdown-item" href="#">Report</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card-body">
                            <div class="text-muted h7 mb-2"> <i class="fa fa-clock-o"></i> {{x.postimi.dateCreated}}</div>
                            <a class="card-link" href="#">
                                <h5 ng-if="x.postimi.lloji === 0" class="card-title">Postim</h5>
                                <h5 ng-if="x.postimi.lloji === 1" class="card-title"><a href="http://localhost:8080/pyetesor/user/do/test/{{x.postimi.postim}}">Test</a></h5>
                            </a>

                            <p ng-if="x.postimi.lloji === 0" class="card-text">
                                {{x.postimi.postim}}
                            </p>
                            <p ng-if="x.postimi.lloji === 1" class="card-text">
                                Nje test u shtua ne kete kurs! Ju lutemi klikoni <a href="http://localhost:8080/pyetesor/user/do/test/{{x.postimi.postim}}">ketu</a> per te zhvilluar testin!
                            </p>
                        </div>
                        <div name="{{x.postimi.postimId}}" class="card-footer">
                            <a href="#" class="card-link"><i class="fa fa-gittip"></i> Like</a>
                            <a ng-click="komento(x.postimi.postimId)" href="" class="card-link"><i class="fa fa-comment"></i> Komento</a>
                            <a href="#" class="card-link"><i class="fa fa-mail-forward"></i> Shperndaje</a>
                        </div>
                        <div style="position:relative" class="card-footer" ng-repeat="y in x.koments | orderBy: 'komentId'">
                            <span ng-if="y.username != x.postimi.pedagogu"><span class="text-primary">{{y.emri}} {{y.mbiemri}}</span> {{y.koment}}</span>
                            <span ng-if="y.username === x.postimi.pedagogu"><span class="text-success">${emriPedagogut}</span> {{y.koment}}</span>
                            <button ng-click="fshiKoment(y.komentId)" ng-if="y.username === '${userLoguar.username}'" style="position:absolute; top:5px; right: 0" class="btn btn-link dropdown-toggle" type="button" >
                                <i class="fa fa-remove"></i></button>

                            <!-- The Modal
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ...
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Fundi i modalit -->


                        </div>
                        <div style="position: relative" class="card-footer">
                            <textarea id="{{x.postimi.postimId}}" class="form-control" placeholder="Shto nje koment" onfocus="this.placeholder=''" onblur="this.placeholder='Shto nje koment'"></textarea>
                            <button ng-click="shtoKoment(x.postimi.postimId)" style="float: right; margin-top: 10px;" class="btn btn-primary">Komento</button>
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
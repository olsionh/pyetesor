<%--
  Created by IntelliJ IDEA.
  User: olsio
  Date: 08/27/2018
  Time: 01:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        ul.menu {
            list-style-type: none;
            margin-top:50px;
            padding-left: 15px;
            width: 200px;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
            box-sizing: border-box;
            border-radius: 25px;
            border:2px solid #82E0AA;
            margin-bottom:5px;
            margin-left:-8px;

        }

        li a:hover {
            background-color: #34495E;
            color: #EBF5FB;
        }
        input[type=text] {
            width: 100%;
            box-sizing: border-box;
            border-radius: 25px;
            border: 2px solid #82E0AA;
            padding: 20px;
            width: 200px;
            height: 50px;
            margin-left:14px;
        }
        input[type=button], input[type=submit], input[type=reset] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 22px;
            text-decoration: none;
            margin: 10px 70px;
            cursor: pointer;
        }
        body
        {
            background-color:#f1f1f1;
        }
        input[type=text]:focus, input:focus{
            outline: none;
        }
        header {
            background: #34495E;
            margin-bottom:40px;
            margin-left:-8px;
            margin-right:-8px;
            margin-top:-20px;
        }

        .headline {
            position: relative;
            height: 100px;
            padding-top:20px;
            background-size: cover;
        &:after {
             position: absolute;
             content: '';
             top: 0;
             left: 0;
             width: 100%;
             height: 100%;
             background: rgba(#111, 0.5);
         }


        .inner {
            position: absolute;
            top: 50%;
            left: 16%;
            opacity: 0;
            z-index: 10;
            transform: translateX(-50%) translateY(-50%);
            animation: fade-in 0.75s 0.25s ease-in forwards;
        }
        h1 {
            margin: 0;
            font-size: 4em;
            line-height: 1.2em;
            font-family:Courier;
        }
        p {
            margin: 0;
            font-size: 1.4em;
            font-style: italic;
            font-family: serif;
        }
        }

        .verticalLine {
            border-left:3px solid #82E0AA;
        }

        @keyframes fade-in {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        footer{
            background: #34495E;
            position:relative;
            bottom:-20px;
            margin-left:-8px;
            margin-right:-8px;
            margin-top:20px;
            height: 70px;
            padding-bottom:20px;
        }
        a.footer{
            text-decoration: none;
            color:#EBF5FB;
        }

    </style>
</head>
<body>

<header>
    <div class="headline">
        <div class="inner">
            <a href="index.php"><img style="float:left" src="logo.svg" width="120px" height="100px"/></a>
            <a href="index.php"><h1 style="color:#EBF5FB;float:right;padding-top:18px;">Libraria Online</h1></a>
        </div>
        <a href="shporta.php"><img style="float:right;margin-right:50px; margin-top:25px" width="30px" height="30px" src="cart2.svg" /></a>
        <a href="pagesa1.php"><img style="float:right;margin-right:20px; margin-top:25px" width="30px" height="30px" src="user3.svg" /></a>
    </div>
</header>
<div style="min-height:100%;position:relative;">
    <div style="float:left;margin-left:30px;background-color: #f1f1f1;">
        <form action="Kerko.php" method="GET">
            <div style="margin-top:30px">
                <input type="text" name="kerko"/><br>
                <input type="submit" value="Kerko"/>
            </div>
        </form>


        <div class='verticalLine' style='padding-left:40px;margin-left:300px;margin-right:80px'>
            <section >
                <div class="jumbotron" style="background-color:#B2BABB;height:260px;" >
                    <div class="container" style="color:#17202A;">
                        <h1>Hyni ne faqen tuaj personale ! </h1>
                        <p>Nese nuk jeni te regjistruar mund te klikoni ketu <a href="<spring:url value="/user/register"/>">ketu</a></p>
                        <p>${mesazh}</p>
                    </div>
                </div>
            </section>
            <div class="container"  >
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Ju lutem fusni Username dhe Password</h3>
                            </div>
                            <div class="panel-body">
                                <form:form method="POST" modelAttribute="user" class="form-horizontal">

                                    <c:if test="${error != null}">
                                        <div class="alert alert-danger">
                                            <p>Invalid username and password.</p>
                                        </div>
                                    </c:if>
                                    <c:if test="${logout != null}">
                                        <div class="alert alert-success">
                                            <p>You have been logged out successfully.</p>
                                        </div>
                                    </c:if>

                                    <div class="input-group input-sm">
                                        <spring:message code="addUser.form.username.label" var="username"/>
                                        <label class="input-group-addon" for="username"><i class="glyphicon glyphicon-user"></i></label>
                                        <form:input id="username" name="username" path="username" placeholder="${username}"
                                                    required="required" type="text" class="form-control" />
                                    </div>
                                    <div class="input-group input-sm">
                                        <label class="input-group-addon" for="password"><i class="glyphicon glyphicon-lock"></i></label>
                                        <spring:message code="addUser.form.password.label" var="password"/>
                                        <form:input id="password" name="password" path="password" placeholder="${password}"
                                                    required="required" type="password" class="form-control" />
                                    </div>
                                    <br/>
                                    <div class="form-actions">
                                        <input type="submit" id="btnLogIn" class="btn btn-block btn-primary btn-default " value="Log in">
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div style="text-align:center;padding-top:35px">
                <a class="footer" style="padding-right:25px" href="index.php">Faqja kyresore</a>
                <a class="footer" style="padding-left:25px" href="rreth.php">Rreth ketij site</a>
            </div>
        </footer>
</body>
</html>

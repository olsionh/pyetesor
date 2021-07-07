<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/stilFaqePar.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/demo.css">
	<link rel="stylesheet" href="/pyetesor/resources/css/header-user-dropdown.css">
	<link rel="stylesheet" type="text/css" href="/pyetesor/resources/css/auth.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.2.0/css/bootstrap-slider.min.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
	<!------ Include the above in your HEAD tag ---------->

	<link href="https://stackpath.bootstrapcdn.com/font-awesome/3.3.7/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
		  crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.2.0/bootstrap-slider.min.js"></script>
	<script src="/pyetesor/resources/js/bejteste.js"></script>

</head>
<body>
<style>
	#ex1Slider .slider-selection {
		background: #BABABA;
	}
</style>
<header class="header-user-dropdown">
	<div class="header-limiter">
		<h1><a href="#">Pyetesor<span>.com</span></a></h1>

		<nav>
			<a href="http://localhost:8080/pyetesor/user/faqjakryesore">Faqja kryesore</a>
			<a href="http://localhost:8080/pyetesor/user/seminareteMia">Kurset e mia</a>
			<a href="http://localhost:8080/pyetesor/user/profil">Rezultatet e mia</a>

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
	<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver" 
		url = "jdbc:mysql://localhost/pyetesor" user = "root"  password = "root"/>
	
	<form:form method="POST"   class="form-horizontal" ng-app="listTestByCriteria" ng-controller="zgjidhTestet" id="testi" >
			
	<div  style="margin-left:50px;width:92%;margin-top:70px;background-color:#D6DBDF;" >
		<div class="panel panel-default">
			<div class="list-group-item list-group-item-info" style="height:90px;">
				<span class="lead">Emri i Testit : ${editTest.testName}</span><br/>
				<span class="lead">Kursi: ${kursi.seminar}</span>
				<div style="color:red;font-size:35px;float:right">Koha e mbetur : <span id="time">05:00</span></div>
			</div>
			<br/><br/>
				<input id="butoniStart" style="font-size:20px;height:40px;width:170px;text-align:center;margin-left:550px;" class="btn btn-success"  type="button" ng-click="initTime(${editTest.testId})" value="Fillo Provimin"/>
				<div id="demo"></div>
				
				<% int var=0;%>
	
				<div id="listPyetjeAlternativa" style="display:none" class="container">
					<table style="margin-top:-110px" class="table table-hover">
						<tr>
							<th class="col-md-3" style="font-size:20px;">Pyetja</th>
							<th class="col-md-4" style="font-size:20px;">Alternativat</th>
						</tr>
				 	<sql:query dataSource = "${snapshot}" var = "result">
						SELECT * from createtests WHERE testId_FK = ${editTest.testId};
					</sql:query>
					<c:forEach var = "row" items = "${result.rows}">
						<sql:query dataSource = "${snapshot}" var = "result2">
							SELECT * from questions WHERE questionId = ${row.questionId_FK};
						</sql:query>
						
						<c:forEach var = "row2" items = "${result2.rows}">
				            <tr  name="kapigjith">
				             	<td> <c:out value ="${row2.question}" /> </td>
				             	<input type="hidden" ng-attr-id="{{'counter-'+<% out.println(var); %>}}" value="<c:url value = "{{${row2.questionId}}}"/>" />
				             	<input type="hidden" ng-attr-id="{{'count-'+<% out.println(var); %>}}" value="<c:url value = "{{${row2.type}}}"/>" />
				           	
				           	
				           	<sql:query dataSource = "${snapshot}" var = "result3">
								SELECT * from alternativs WHERE questionId_FK = ${row2.questionId} ORDER BY alternativ;
							</sql:query>
								
				           
				          	<c:if test="${row2.type == 1}">
				          
					           	<td> <select id="<c:url value = "{{'alternativ-'+${row2.questionId}}}"/>">
									<c:forEach var = "row3" items = "${result3.rows}">
										<option value="${row3.alternativId}"><c:out value="${row3.alternativ}"/></option>
										<c:if test="${row3.esakt == 1}">
											<c:set var = "kot"   value = "${row3.alternativId}"/>
										</c:if>
							        </c:forEach>
							        </select>

							        <input type="hidden" ng-attr-id="{{'esakta-'+<% out.println(var); %>}}" value="<c:out value="${kot}"/>"  />
										
							     </td>
							</c:if>
				           	<c:if test="${row2.type == 2}">
					           	<td>
					           	<c:set var = "kot"   value = ""/>
									<c:forEach var = "row3" items = "${result3.rows}">
										<input name="<c:url value = "{{'alternativ-'+${row2.questionId}}}"/>" type="checkbox" value = "${row3.alternativId}">  <c:out value = "${row3.alternativ}"/>
										<c:if test="${row3.esakt == 1}">
											<c:set var = "kot"   value = "${kot}|${row3.alternativId}"/>
										</c:if>
										<br>
									</c:forEach>
									<c:set var = "kot"   value = "${kot}|"/>
									<input type="hidden" ng-attr-id="{{'esakta-'+<% out.println(var); %>}}" value="<c:out value="${kot}"/>"  />
								</td>
						    </c:if>
				           
				           	<c:if test="${row2.type == 0}">
				            	<td>
				            		<c:forEach var = "row3" items = "${result3.rows}">
										<input  type="radio" name="<c:url value = "{{'alternativ-'+${row2.questionId}}}"/>" value = "1">po
										<input  type="radio" name="<c:url value = "{{'alternativ-'+${row2.questionId}}}"/>" value = "0">jo
										<input type="hidden" ng-attr-id="{{'esakta-'+<% out.println(var); %>}}" value="<c:url value = "{{${row3.esakt}}}"/>" />
								    </c:forEach>
							     </td>
						       
				           	</c:if>
								<c:if test="${row2.type == 3}">

									<td>
										<c:set var = "vlera0"   value = "${result3.rows[0].alternativ}"/>
										<c:set var = "vlera1"   value = "${result3.rows[1].alternativ}"/>
										<c:set var = "vlera2"   value = "${result3.rows[2].alternativ}"/>
										<fmt:parseNumber type="number" var="vlera0nr" value="${vlera0}"/>
										<fmt:parseNumber type="number" var="vlera1nr" value="${vlera1}"/>
										<fmt:parseNumber type="number" var="vlera2nr" value="${vlera2}"/>

										<c:choose>
										<c:when test="${vlera0nr>vlera1nr}">
											<c:set var="max" value="${vlera0nr}"/>

										</c:when>
											<c:otherwise>
												<c:set var="max" value="${vlera1nr}"/>
											</c:otherwise>
										</c:choose>
										<c:if test="${vlera2nr>max}">
											Jo
										<c:set var="max" value="${vlera2nr}"/>
								        </c:if>

										<c:choose>
											<c:when test="${vlera0nr<vlera1nr}">
												<c:set var="min" value="${vlera0nr}"/>
											</c:when>
											<c:otherwise>
												<c:set var="min" value="${vlera1nr}"/>
											</c:otherwise>
										</c:choose>
										<c:if test="${vlera2nr<min}">
											<c:set var="min" value="${vlera2nr}"/>
										</c:if>

										<c:if test="${vlera0nr!=min && vlera0nr!=max}">
										<c:set var="mes" value="${vlera0nr}"/>
									</c:if>
										<c:if test="${vlera1nr!=min && vlera1nr!=max}">
											<c:set var="mes" value="${vlera1}"/>
										</c:if>
										<c:if test="${vlera2nr!=min && vlera2nr!=max}">
											<c:set var="mes" value="${vlera2nr}"/>
										</c:if>

										<div  class="slidecontainer">
											<input name="example" id="ex-${row2.questionId}" data-slider-id='ex1Slider' type="text" data-slider-min="${min}" data-slider-max="${max}" data-slider-step="1"/>
											<input type="hidden" id="<c:url value = "{{'alternativ-'+${row2.questionId}}}"/>" value="${mes}" />

										</div>
										<c:set var = "kot"   value = "${mes}"/>

										<input type="hidden" ng-attr-id="{{'esakta-'+<% out.println(var); %>}}" value="<c:out value="${kot}"/>"  />

									</td>
								</c:if>
					        <br/>
					         </tr>
					         <%  var++; %>
			             </c:forEach>
			              
			        </c:forEach>
			        </table>
				</div>
				<div class="form-group">
					<div style="margin-right:70px;float:right">
						<input type="button"  ng-click="kot(${editTest.testId})" id="butFinish" style="display:none;font-size:20px;height:40px;width:170px;text-align:center;" class="btn btn-success" value="Finish" />
					</div>
				</div>
		</div>
	</div>	
	</form:form>
	<div id="pergjigje" style="padding:20px;font-size:30px;color:red;margin-left:50px;width:92%;margin-top:70px;">
	</div>			
</body>
<script>
	var ex1 = document.getElementsByName("example");
	for (var i=0;i<ex1.length;i++) {
        var ex = ex1[i].id;
        $('#' + ex).slider({
            formatter: function (value) {
                return 'Vlera: ' + value;
            }
        });
    }
</script>
</html>

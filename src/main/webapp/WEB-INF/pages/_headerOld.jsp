<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='/css/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<!--  <security:authorize access="!isAuthenticated()">
            <h1><a href="/login"> Для продолжения авторизуйтесь. </a></h1>
    </security:authorize>   
 	  	<div class="page-header"> -->
	<div class="alert alert-success lead">
		<table width=100%>
			<tr>
				<td>UNTERNEHMEN SUCHT SOFTWAREENTWICKLER</td>
			 <td>	<c:if
						test="${pageContext.request.userPrincipal.name != null}">
       <td> Hello, &nbsp;
           <a href="${pageContext.request.contextPath}/accountInfo">
							${pageContext.request.userPrincipal.name} </a>
         &nbsp;!&nbsp;&nbsp;&nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a></td>

					</c:if> <c:if test="${pageContext.request.userPrincipal.name == null}">
						<a href="${pageContext.request.contextPath}/login">Login</a>
					</c:if></td>
			</tr>


		</table>
		</div>
		<!-- <div class="well well-small"> -->
		<div class="alert alert-success lead">
		
			   <a href="${pageContext.request.contextPath}/">Startseite</a>    
			<security:authorize access="hasRole('ROLE_DEVELOPER')">
 <a href="${pageContext.request.contextPath}/employersList">
					      Unternehmen  </a>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_EMPLOYER')">
				<a href="${pageContext.request.contextPath}/developersList">Bewerbers
					</a>
			</security:authorize>


			<security:authorize access="hasRole('ROLE_ADMIN')">

				<a href="${pageContext.request.contextPath}/account">Benutzer-Erstellung</a>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_DEVELOPER')">
   <a href="${pageContext.request.contextPath}/employerAccount">Neue Unternehmen registrieren</a>
 </security:authorize>

			<security:authorize access="hasRole('ROLE_EMPLOYER')">
   <a href="${pageContext.request.contextPath}/developerAccount">Neuen Bewerber registrieren</a>
 </security:authorize>

		</div>
</body>
</div>
</html>
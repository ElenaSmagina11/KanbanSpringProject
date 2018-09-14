<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='/css/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
</head>
<body>

	<div class="alert alert-success lead" style="height: 120px;"
		style="font-size: 18px">
		<table>
			<tr>
				<td class="col-lg-5">UNTERNEHMEN SUCHT SOFTWAREENTWICKLER</td>
				<th class="col-lg-6"></th>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<td class="col-lg-8">Hello, &nbsp; <a
						href="${pageContext.request.contextPath}/accountInfo">
							${pageContext.request.userPrincipal.name} </a>
						!&nbsp;&nbsp;&nbsp;|&nbsp; <a
						href="${pageContext.request.contextPath}/logout">Logout</a></td>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<td width=16%><a
						href="${pageContext.request.contextPath}/login">Login</a></td>
				</c:if>
			</tr>
		</table>
		<br>
		<!-- --------------------------------------------------------------- -->
		<nav class="navbar  navbar-static-top " style="height: 38px;">
			<ul class="nav nav-pills" id="myPill">
				<li class="nav-item"><a class="nav-link" id="tab-css"
					data-toggle="tab" href="${pageContext.request.contextPath}/">
						&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-home ">
					</span> <!--  &nbsp;Startseite-->
				</a></li>
				<li class="nav-item"><security:authorize
						access="hasRole('ROLE_DEVELOPER')">
						<a class="nav-link" id="tab-javascript" data-toggle="tab"
							href="${pageContext.request.contextPath}/employersList">
							Unternehmen</a>
					</security:authorize></li>
				<li class="nav-item"><security:authorize
						access="hasRole('ROLE_DEVELOPER')">
						<a class="nav-link active" id="tab-bootstrap" data-toggle="tab"
							href="${pageContext.request.contextPath}/employerAccount">
							Neue Unternehmen registrieren</a>
 		</security:authorize></li>
				<li class="nav-item"><security:authorize
						access="hasRole('ROLE_EMPLOYER')">
						<a class="nav-link active" id="tab-bootstrap" data-toggle="tab"
							href="${pageContext.request.contextPath}/developersList">Bewerbers</a>
 		</security:authorize></li>
				<li class="nav-item"><security:authorize
						access="hasRole('ROLE_EMPLOYER')">
						<a class="nav-link active" id="tab-bootstrap" data-toggle="tab"
							href="${pageContext.request.contextPath}/developerAccount">  
							Neuen Bewerber registrieren</a>
 		</security:authorize></li>
				<li class="nav-item"><security:authorize
						access="hasRole('ROLE_ADMIN')">
						<a class="nav-link active" id="tab-bootstrap" data-toggle="tab"
							href="${pageContext.request.contextPath}/account">Benutzer-Erstellung</a>
					</security:authorize></li>
				<li class="nav-item"><security:authorize
						access="hasAnyRole('ROLE_EMPLOYER', 'ROLE_DEVELOPER')">
						<a class="nav-link active" id="tab-bootstrap" data-toggle="tab"
							href="${pageContext.request.contextPath}/kanbanList">KanbanList</a>
					</security:authorize></li>
			</ul>
		</nav>
	</div>

</body>
</html>
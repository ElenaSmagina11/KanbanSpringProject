<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Info</title>
<link href="<c:url value='/css/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<title>UNTERNEHMEN SUCHT SOFTWAREENTWICKLER</title>
<body>

	<jsp:include page="_header.jsp" />
	
	<security:authorize access="hasRole('ROLE_ADMIN')">

		<c:if test="${not empty errorMessage }">
			<div class="error-message">${errorMessage}</div>
		</c:if>
<div class="container-fluid">

			<div class="generic-container-login" style="width: 480px;">
				<div class="login-card">
					<form:form modelAttribute="accountForm" method="POST"
						enctype="multipart/form-data">
						<span class="border-0">
							<table class="table table-bordered">
								<thead>
									<tr>
										<td width=7%><h4>Benutzername:</h4></td>
										<td width=90%><form:input path="userName"
												class="form-control input-md" />
											<div style="color: red; margin: 10px 0px;">
												<div class="container hidden">
													<form:input path="newAccount" />
												</div>
												<form:errors path="userName" class="error-message" />
											</div></td>
									</tr>
									<tr>
									<td width=7%>	<h4>Passwort:</h4></td>
									<td width=90%>	<form:input path="password" class="form-control input-md" />
										<div style="color: red; margin: 10px 0px;">
											<form:errors path="password" class="error-message" />
										</div></td>
									</tr>
									<tr>
						<td width=45%><form:radiobutton itemValue=" ${userRole}" path="userRole" value="EMPLOYER" />
											EMPLOYER
											<div style="color: red; margin: 10px 0px;">
												<form:errors path="userRole" class="error-message" /></div></td>
												
							<td width=45%>	
										<form:radiobutton itemValue=" ${userRole}" path="userRole"	value="DEVELOPER" />
											DEVELOPER 
											<div style="color: red; margin: 10px 0px;">
												<form:errors path="userRole" class="error-message" />
											</div></td>
									</tr>
						
					</thead>
					</table>
				</span>
				<table class="table border-0">
					<thead>
					<tr><td width=50%>
						<input type="submit" class="btn btn-block btn-primary btn-default"
							value="Speichern" value="Login" />
					</td>
			</tr>
			</thead>
				</table>
					</form:form>
					</div>
		</div>	</div></security:authorize>

</body>
</html>
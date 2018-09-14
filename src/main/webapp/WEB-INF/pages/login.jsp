<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value='/css/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />


	<!-- 	  <div class="login-container">  -->
	<div class="generic-container-login">
		<div class="login-card">
			<div class="login-form">
				<form method="POST"
					action="${pageContext.request.contextPath}/j_spring_security_check">

					<!-- /login?error=true -->
					<c:if test="${param.error == 'true'}">
						<div style="color: red; margin: 10px 0px;">
							Anmeldung fehlgeschlagen!<br /> Reason :
							${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
						</div>
					</c:if>

					<div class="input-group input-sm">
						<p>
						<h4>Benutzername:</h4>
						<input type="text" class="form-control" name="userName" />
					</div>
					<div class="input-group input-sm">
						<h4>Passwort:</h4>

						<input type="password" class="form-control" name="password" />
					</div>
					<div class="input-group input-sm">
						<br> <input type="submit"
							class="btn btn-block btn-primary btn-default" value="Anmelden"
							value="Login" /> <input type="reset"
							class="btn btn-block btn-primary btn-default"
							value="Zurücksetzen" />
					</div>
				</form>

				<span class="error-message">${error }</span>
			</div>
		</div>
	</div>


</body>
</html>
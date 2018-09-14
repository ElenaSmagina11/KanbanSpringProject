<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Info</title>
<link href="<c:url value='/css/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />

	<div class="generic-container-login" style="width: 500px;">
		<div class="login-card">
			<div class="page-title text-center">
				<h4>Bewerbersprofil erstellen</h4>
			</div>

			<c:if test="${not empty errorMessage }">
				<div class="error-message danger">${errorMessage}</div>
			</c:if>

			<form:form modelAttribute="developerForm" method="POST"
				enctype="multipart/form-data" class="form-horizontal">
				<span class="border-0">
					<table class="table table-bordered">
						<thead>
							<tr>
								<td width=7%>Name:</td>
								<td width=90%><form:input path="devName"
										class="form-control input-md" />
									<div style="color: red; margin: 10px 0px;">
										<div class="container hidden">
											<form:input path="newDeveloper" />
										</div>
										<form:errors path="devName" class="error-message" />
									</div></td>
							</tr>
							<tr>
								<td width=20%>Stadt:</td>
								<td width=20%><form:input path="devCity"
										class="form-control input-md" />
									<div style="color: red; margin: 10px 0px;">
										<form:errors path="devCity" class="error-message" />
									</div></td>
							</tr>
							<tr>
								<td width=30%>Job als:</td>
								<td width=30%><form:input path="devJob"
										class="form-control input-md" />
									<div style="color: red; margin: 10px 0px;">
										<form:errors path="devJob" class="error-message" />
									</div></td>
							</tr>

						</thead>
					</table>
				</span>
				<table class="table border-0">
					<thead>
						<tr>
							<td width=50%><input type="reset"
								class="btn btn-block btn-primary btn-default" value="Reset" /></td>
							<td width=50%><input type="submit" value="Speichern"
								value="developerAccount"
								class="btn btn-block  btn-primary btn-default" /></td>
						</tr>
					</thead>
				</table>
			</form:form>
		</div>
	</div>

	<jsp:include page="_footer.jsp" />

</body>
</html>
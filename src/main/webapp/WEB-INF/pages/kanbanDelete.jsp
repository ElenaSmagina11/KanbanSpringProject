<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/css/css/bootstrap.css' />"  rel="stylesheet"></link>
	 <link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>
</head>
<body>
	<jsp:include page="_header.jsp" />
	<security:authorize access="hasRole('DEVELOPER')"></security:authorize>
	
	 <div class="container-fluid text-center">
			<h3> Ablauf der Einstellung:</h3>
		<br>
	<form:form modelAttribute="kanbanForm" action="/kanbanDelete"
		enctype="multipart/form-data" method="GET">
	<h4> <mark>${kanbanForm.userName} </mark>&nbsp; 
	aus &nbsp;
	<mark>${kanbanForm.jobName}</mark> &nbsp; 
	 </h4>
	
	</form:form>
	<br>
	<br>
	<!-- ------------------------------------------------------------------- -->
	<form:form modelAttribute="kanbanForm" action="kanbanDelete"
		method="POST" enctype="multipart/form-data">
		
		
	<input type="submit" value="Entfernen"
							class="btn btn-primary btn-default" value="kanbanList">
							
		
	</form:form>
	</div>
	<jsp:include page="_footer.jsp" />

</body>
</html>
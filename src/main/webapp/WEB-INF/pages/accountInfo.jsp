<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Users Info</title>
		<link href="<c:url value='/css/css/bootstrap.css' />"  rel="stylesheet"></link>
	 <link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>
	<title>UNTERNEHMEN  SUCHT  DEVELOPER</title>
<body>
	<jsp:include page="_header.jsp" />

	 <div class="container-fluid text-left">
	 <div class="col-lg-2"></div>
		<ul>
			<li>Ihre Benutzername: ${pageContext.request.userPrincipal.name}</li>
			<li><c:forEach items="${userDetails.authorities}" var="auth">
                       ${auth.authority }
                   </c:forEach></li>
            <li>Foto:</li>
            <li>Adresse usw...:</li>
		</ul>
	</div>
	<jsp:include page="_footer.jsp" />
</body>
</html>
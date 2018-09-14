<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>UNTERNEHMEN SUCHT DEVELOPER</title>
<body>
	<jsp:include page="_header.jsp" />
	<div class="container-fluid text-center">
		<h3>Kanbanlist</h3>
	</div>

	<form:form modelAttribute="kanbanForm" action="kanbanList" method="GET"
		enctype="multipart/form-data">
		<div class="panel-heading ">
			<table class="table table-hover table-bordered  ">
				<thead>
					<tr>
						<th width=15%>Unternehmen</th>
						<th width=10%>CV gesendet am:</th>
						<th width=10%>Vorstellungsgespräch am:</th>
						<th width=10%>Stellenangebot am:</th>
						<th width=10%>Entfernen</th>
					</tr>
				</thead>
				<c:forEach items="${kanbanForm}" var="prodInfo">
					<c:choose>
						<c:when
							test="${prodInfo.userName == pageContext.request.userPrincipal.name}">
							<tr>
								<td>${prodInfo.jobName}</td>
								<td><mark>${prodInfo.CVDate}</mark></td>
								<td><mark2>${prodInfo.interviewDate}</mark2></td>
								<td><mark3>${prodInfo.jobOfferDate}</mark3></td>
								<td><a
									href="${pageContext.request.contextPath}/kanbanDelete?jobName=${prodInfo.jobName}">
										Entfernen</a></td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
			</table>
			<br>
		</div>
	</form:form>

	<jsp:include page="_footer.jsp" />

</body>
</html>
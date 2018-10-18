<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

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
	<div class="container-fluid text-center">
 <h3>Kanbanlist</h3>
 </div>
 <%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
 
 
 		
	<form:form modelAttribute="kanbanForm" action="kanbanList"
		 method="GET" enctype="multipart/form-data">
		 < var="kanbanForm">
    
   
    <display:table name="pageScope.kanbanForm.rows" />
   
	<!--  	<div class="panel-heading ">
			<table class="table table-hover table-striped table-bordered  ">
			<thead>
				<tr>
					<th width=15%>Unternehmen</th>
					<th width=10%>CV gesendet am:</th>
					<th width=10%>Vorstellungsgespräch am:</th>
					<th width=10%>Stellenangebot am:</th>
					<th width=10%>Entfernen</th>
				</tr>
			</thead>
			
	         <tr>
						<td><mark>${kanbanForm.jobName}</mark></td>
						<td>${kanbanForm.CVDate}</td>
						<td>${kanbanForm.interviewDate}</td>
						<td>${kanbanForm.jobOfferDate}</td>
						<td><a	href="${pageContext.request.contextPath}/kanbanDelete?jobName=${kanbanForm.jobName}">
										Entfernen</a></td>			
											</tr>
		
   </table>
    </form:form>
   <br>		
	  
   <c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                 <a href="kanbanList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          </div>
   </c:if>   
  
  </div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
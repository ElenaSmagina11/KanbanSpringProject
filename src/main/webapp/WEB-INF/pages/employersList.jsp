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
 <h3>Unternehmensliste</h3>
 </div>
 
 <div class="panel-heading ">
			<table class="table table-hover table-striped table-bordered "> 
	    		<thead>
		      		<tr>
				        <th width=20%>Name</th>
				        <th width=20%>Stadt</th>
				        <th width=30%>Stellenangebot </th>
				        <th width=16%>Wählen</th>
				    
					</tr>
		    	</thead>
   <c:forEach items="${paginationProducts.list}" var="prodInfo">
		   		<tr>
						<td>${prodInfo.emplName}</td>
						<td>${prodInfo.emplCity}</td>
						<td>${prodInfo.emplVacancy}</td>
							<security:authorize
								access="hasAnyRole('ROLE_DEVELOPER', 'ROLE_ADMIN')">
								<td><a
									href="${pageContext.request.contextPath}/employerChoose?emplName=${prodInfo.emplName}">
										Job auswählen</a></td>
							</security:authorize>
						</tr>
		</c:forEach>
   </table>
 
     
   <c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                    <a href="employersList?page=${page}" class="nav-item">${page}</a>
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
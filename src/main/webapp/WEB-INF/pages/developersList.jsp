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
 <h3>Kandidatenliste</h3>
 </div>
 <!-- 
  
  href="${pageContext.request.contextPath}/employersFavorits">

 xhref="${pageContext.request.contextPath}/registration"> 
        Favoriten in checkbox merken und diese taste drücken -wählen -->

 
 
 <!--  <form:form modelAttribute="emplFavForm" method="POST" enctype="multipart/form-data" >-->
  
   <div class="center-block" style="width: 900px;">
  
   <div class="panel-heading ">
			<table class="table table-hover table-striped table-bordered "> 
	    		<thead>
		      		<tr>
				        <th width=20%>Name</th>
				        <th width=20%>Stadt</th>
				        <th width=30%>Sucht Job als</th>
				        <th width=16%>Wählen</th>
				       
					</tr>
		    	</thead>
		    	 <c:forEach items="${paginationProducts.list}" var="prodInfo">
		   		<tr>
						<td>${prodInfo.devName}</td>
						<td>${prodInfo.devCity}</td>
						<td>${prodInfo.devJob}</td>

							<security:authorize
								access="hasAnyRole('ROLE_EMPLOYER', 'ROLE_ADMIN')">
								<td><a
									href="${pageContext.request.contextPath}/developerChoose?devName=${prodInfo.devName}">
										Kandidat auswählen</a></td>
							</security:authorize>
						</tr>
		</c:forEach>
   </table>
 <br>
   <c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator"  style="font-size: 18px">
     
          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                 <a href="developersList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
           
       </div>
   </c:if>
 <!-- redirect k emplFavorits -->
 <!--   <a href="${pageContext.request.contextPath}/deveplopersFavorits">
      redirect k devs Favorits
   </a>
      <input type="submit" value="Submit"/>-->
     
  
   </div> </div>
</form:form>
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
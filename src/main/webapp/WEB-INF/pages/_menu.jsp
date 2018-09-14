<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
 <html>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/css/css/bootstrap.css'/>"  rel="stylesheet"></link>
	 <link href="<c:url value='/css/css/app.css'/>" rel="stylesheet"></link>
 
<div class="navbar navbar-inverse">  
	<nav class = "navbar inner">
	<ul class="nav">
	<li class="divider-vertical"></li>
	
   <li><a href="${pageContext.request.contextPath}/">Home</a></li>
   |
<security:authorize access="hasRole('ROLE_DEVELOPER')">
 <a href="${pageContext.request.contextPath}/employersList">
      Unternehmens List
  </a>
</security:authorize>

<security:authorize access="hasRole('ROLE_EMPLOYER')">
<a href="${pageContext.request.contextPath}/developersList">
      Developers List
  </a>
</security:authorize>


<security:authorize access="hasRole('ROLE_ADMIN')">

<a href="${pageContext.request.contextPath}/account">
      Benutzer-Erstellung
   </a>
</security:authorize>
|
<security:authorize access="hasRole('ROLE_DEVELOPER')">
   <a href="${pageContext.request.contextPath}/employerAccount">
         Neue empl registrieren
     </a>
 </security:authorize>
|
<security:authorize access="hasRole('ROLE_EMPLOYER')">
   <a href="${pageContext.request.contextPath}/developerAccount">
         Neue Dev registrieren
     </a>
 </security:authorize>
 <!--   <security:authorize> access="hasAnyRole('ROLE_EMPLOYER','ROLE_MANAGER')"
	
     <a href="${pageContext.request.contextPath}/orderList">
         Order List
     </a>
	
  
   </security:authorize>
   
   <security:authorize> access=""hasRole('ROLE_MANAGER')"
         <a href="${pageContext.request.contextPath}/product">
                        Create Product
         </a>
      
   </security:authorize>--> 
  
</div>
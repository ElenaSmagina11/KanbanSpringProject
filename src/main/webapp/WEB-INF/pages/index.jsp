<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>UNTERNEHMEN  SUCHT  DEVELOPER</title>
<link href="<c:url value='/css/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/css/css/app.css' />" rel="stylesheet"></link>
</head>
<body>

   <jsp:include page="_header.jsp" />
  
 
 <div class="container bgcont center-block">
 
 	<div class="center-block" >
      <table class="table">
    
			<thead>
				<tr>
				<th><h4> Technologien:</h4></th>
				<th><h4 ><span class="glyphicon glyphicon-leaf"> </span> &nbsp;Spring MVC, Spring Security</h4> </th>
<th><h4 ><span class="glyphicon glyphicon-list-alt "> </span> &nbsp;	 MySQL, Hibernate </h4></th>
<th><h4 >	<span class="glyphicon glyphicon-cog "> </span>  &nbsp;Tomcat, HTML, CSS, Bootstrap </h4></th>
<th><h4 >	<span class="glyphicon glyphicon-thumbs-up "> </span> &nbsp;  Maven, Kanban </h4></th></tr></thead></table>
</div>
<div class="col-lg-8  col-xs-2"><div class="top-cover center-block"></div>
<p class="lead"  style="text-indent: 5%;">
Sie befinden sich auf der Internet-Seite, wo sowohl Personalabteilungsmanager
 als auch jobsuchende Softwareentwickler einen Bewerbungsablauf verwalten können.

 Dieses digitale Board lässt alle Information zur Qualifikation der Softwarespezialisten 
 sinnvoll gruppieren und strukturiert anzeigen. 
 Die Anwendung basiert auf der Kanban-Arbeitsmanagement-Methode.Der Benutzer kann seine Firmen-Favoriten
 oder Kandidaten auswählen und ihre Informationen in die Datenbank speichern und ggf. bearbeiten.<br> <br>
 Es werden folgende Prozessstufen einer Bewerbung berücksichtigt: 
 <ul>
<li><h5>wann wurden Bewerbungsunterlagen abgeschickt/eingegangen;</h5></li>
<li><h5>Termin des Bewerbungsgesprächs;</h5></li>
<li><h5>seit wann wartet der Bewerber auf das Ergebnis;</h5></li>
<li><h5>Zusage/Absage</h5></li>
</ul>
https://dev.mysql.com/doc/index-other.html    Example Databases lists some sample databases you can download.sakila database
<br>
<div class="center-block"style="width: 380px;">
<h4><strong><span class="glyphicon glyphicon-zoom-in"></span>
 &nbsp;<a href="${pageContext.request.contextPath}/toDo">Weiterentwicklung des Projekts</a></strong></h4></div>

  
   </div></div>

    <jsp:include page="_footer.jsp" />
  

</body>
</html>
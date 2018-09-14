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
 
 	
<p class="lead"  style="text-indent: 5%;">Punkte für Weiterentwicklung des Projekts: </p>
 <ul>
<li><h5>Erweiterungs des Inhalts der Datenbanken, zB. felder als 'employer_openjob', 'scills', 'comment', ...;</h5></li>
<li><h5>Möglichkeit, auf der Webseite eine Nachricht / Bewerbungsunterlagen zu senden;</h5></li>
<li><h5>Laden/Herunterladen der Bewerbungsmaterialen des Softwareentwicklers: Zeugnisse, Foto, Anschreiben, Lebenslauf;</h5></li>
<li><h5>Parsing von Internet-Seiten zur Jobsuche, um die Datenbank automatisch zu befüllen; </h5></li>
<li><h5>Bewertung des Qualifikation des Bewerbers, zB: Spring - 1, Unit-Testen – 2,  Glassfish - 3,   PostGre  - 2,
GIT, SVN  - 1,  Maven, Ant – 2, usw...;</h5></li>
</ul>
<br>


   </div>
    <jsp:include page="_footer.jsp" />
  

</body>
</html>
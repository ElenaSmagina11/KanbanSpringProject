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
	<security:authorize access="hasRole('EMPLOYER')">
	</security:authorize>
   
    <div class="container-fluid text-center">
			<h3> Ablauf der Einstellung:</h3>
		<br>
	<form:form modelAttribute="developerForm" action="/developerChoose"
		enctype="multipart/form-data" method="GET">
	<h4> <mark>${developerForm.devName} </mark>&nbsp; 
	aus &nbsp;
	<mark>${developerForm.devCity}</mark> &nbsp; 
	 sucht Job als&nbsp;
	<mark>${developerForm.devJob}</mark></h4>
	
	</form:form>
	<br>
	<br>
	<!-- ------------------------------------------------------------------- -->
	<form:form modelAttribute="kanbanForm" action="developerChoose"
		method="POST" enctype="multipart/form-data">
			
		<div class="container-fluid" style="width: 540px;">
				<div class="center-block   style="font-size: 18px;">
				

					<table style="text-align: left;">
					<thead>
                <tr>
                    <th class="col-lg-5"></th>
                    <th class="col-lg-6"></th>
                    
                </tr>
            </thead>
            <tbody>
						<tr >
							<th ><h4> Bewerbungsunterlagen erhalten am: </h4></th>
							<th><form:input path="CVDate" class="form-control input-md" /></th>
						</tr>
							<tr><th> &nbsp;</th></tr>
						<tr>
							<th><h4>Vorstellungsgespräch am: </h4></th>
							<th><form:input path="interviewDate" class="form-control input-md" /> </th>
						</tr>
						<tr><th> &nbsp;</th></tr>
						<tr>
							<th><h4>Job-Angebot am: </h4></th>
							<th style="color: red;"><form:input
									path="jobOfferDate" class="form-control input-md" /></th>
						</tr>
						<tr ><th><p style="font-size: 13px;">* Datum muss JJJJ-TT-MM sein</p></th></tr>
						<tr><th> &nbsp;</th></tr>
						<tr><th> &nbsp;</th></tr>
						<tr>
						<th ></th>
						<th><input type="submit" value="Speichern"
							class="btn btn-primary btn-default" value="developersList">
							</tr>
						</tbody>
					</table>
				</div>
										
		</div>	
	</form:form>
	</div>
	
	
	<jsp:include page="_footer.jsp" />

</body>
</html>
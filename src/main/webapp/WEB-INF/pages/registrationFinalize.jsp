<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<div id="header" class="container-fluid"><jsp:include
			page="_header.jsp" /></div>
	
		<div class="container-fluid text-center">
			<h3>Registrierung erfolgreich abgeschlossen</h3>

			<div class="embed-responsive embed-responsive-16by9 width=280px ">
				<video autoplay="autoplay" muted="muted" loop="loop">
					<source
						src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4"
						type="video/mp4" style="width: 50%; height: auto">
				</video>
			</div>
		</div>
	</div>
	<div id="footer" class="container-fluid">
		<jsp:include page="_footer.jsp" /></div>

</body>
</html>
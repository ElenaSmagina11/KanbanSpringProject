<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
   <div class="page-title">ProductEmpl</div>
  
   <c:if test="${not empty errorMessage }">
     <div class="error-message">
         ${errorMessage}
     </div>
   </c:if>
 
   <form:form modelAttribute="employerForm" method="POST" enctype="multipart/form-data">
       <table style="text-align:left;">
           <tr>
               <td>EmplName *</td>
               <td style="color:red;">
                  <c:if test="${not empty employerForm.emplName}">
                       <form:input path="emplName"/>
                       ${employerForm.emplName}
                  </c:if>
                  <c:if test="${empty employerForm.emplName}">
                       <form:input path="emplName" />
                       <form:input path="newEmployer" />
                  </c:if>
               </td>
               <td><form:errors path="emplName" class="error-message" /></td>
           </tr>
 
           <tr>
               <td>City *</td>
               <td><form:input path="emplCity" /></td>
               <td><form:errors path="emplCity" class="error-message" /></td>
           </tr>
 
           <tr>
               <td>Vacancy *</td>
               <td><form:input path="emplVacancy" /></td>
               <td><form:errors path="emplVacancy" class="error-message" /></td>
           </tr>
     <!--        <tr>
               <td>Image</td>
               <td>
               <img src="${pageContext.request.contextPath}/productImage?code=${productForm.code}" width="100"/></td>
               <td> </td>
           </tr>x
           <tr>
               <td>Upload Image</td>
               <td><form:input type="file" path="fileData"/></td>
               <td> </td>
           </tr>-->
 
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" /> <input type="reset"
                   value="Reset" /></td>
           </tr>
       </table>
   </form:form>
 
 
 
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
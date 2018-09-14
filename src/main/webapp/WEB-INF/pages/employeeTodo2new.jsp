<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
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
 <!--   <security:authorize  access="hasRole('ROLE_ADMIN')">
     </security:authorize> -->
   
<security:authorize access="hasRole('DEVELOPER')">  <!-- TAK ROBIT TOKO ESLI DEV1 zaloginilsa.... -->

This content will only be visible to users who have
the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.


   <div class="page-title"><h3>Kanban s employerom</h3></div>
   
    
    <form:form modelAttribute="employerForm"  action="/employeeChoose2" enctype="multipart/form-data" method="GET">
  
           <ul>
               
               <li>EmplName: ${employerForm.emplName}</li>
               <li>EmplCity:  ${employerForm.emplCity}</li>
               <li>EmplVacancy: ${employerForm.emplVacancy}</li>
    </form:form>
  <!-- ------------------------------------------------------------------------ 
        <form:form modelAttribute="kanbanForm" action="/employeeChoose2" enctype="multipart/form-data" method="POST">
                <li><a
                   href="${pageContext.request.contextPath}/vcToSend?emplName=${employerForm.emplName}">
 				CU zu senden:   i datu avtomatom vstavlat.kkogda sdelano v etoj ge stroke vivodit"gesendet togdato" <input type="checkbox" name="vc gesendet" />
				 </a>
				<br>
				 <a
                   href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
 				to do 2: <input type="checkbox" name="mein Favorit" />
				 </a>
					<br>
				 <a
                   href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
 				to do 3: <input type="checkbox" name="mein Favorit" />
				 </a>
				 </li>
				 </form:form>-->
<!--   <form:form modelAttribute="kanbanForm" method="POST" enctype="multipart/form-data">-->
       <table style="text-align:left;">
         <tr>
            <td>CV gesendet</td><input type="checkbox"  name="checked oder uncheked tut stavit v savisimosti ot boolean snacenia" />
         </tr>
         <tr>
               <td>CV gesendet am:</td>
  <!--               <td style="color:red;">
                  <c:if test="${not empty kanbanForm.CVDate}">
                       <form:input path="CVDate"/>
                       ${kanbanForm.CVDate}
                  </c:if>
                  <c:if test="${empty kanbanForm.CVDate}">
                       <form:input path="CVDate" />
                       <form:input path="newProduct" />  <!--  NADO TUT eto ili net poka eshe ne uverena-->
   <!--                </c:if>
               </td>
                <td><form:errors path="CVDate" class="error-message" /></td>
           </tr>
           <tr>
            <td>Interview Termin </td><input type="checkbox"  name="checked oder nein" />
         </tr>
             <tr>
               <td>Interview wird am: *</td>
               <td><form:input path="interviewDate" /></td>
               <td><form:errors path="intervirewDate" class="error-message" /></td>
           </tr>
         
           <tr>
               <td>&nbsp;</td>
               <td><input type="obnovitj" value="Submit" /> </td>
           </tr>
       </table>
   </form:form>  -->
 
				 
     </ul>
   
  
    </security:authorize>
   <jsp:include page="_footer.jsp" />
 
</body>
</html>
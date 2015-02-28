<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">
  <div class="list-group">
      <h1>Employee Information</h1>
    <a href="#" class="list-group-item clearfix">
        <c:if test="${not empty requestScope.employee}">
        
            <p>FIrst name :${requestScope.employee.empFirstname}</p>
            <p>Last name :${requestScope.employee.empLastName}</p>     
            <p>Department  name :${requestScope.employee.empDeptName}</p> 
        </c:if>
    </a>
  </div>
</div>
<%@include file="/WEB-INF/footer.jspf" %>



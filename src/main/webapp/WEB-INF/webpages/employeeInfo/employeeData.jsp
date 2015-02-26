<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">
  <div class="list-group">
      <h1>Employee Information</h1>
    <a href="#" class="list-group-item clearfix">
        <c:if test="${not empty requestScope.employee}">
        
            <p>${requestScope.employee.empFirstname}</p>
            <p>${requestScope.employee.empLastName}</p>     
        </c:if>
    </a>
  </div>
</div>
<%@include file="/WEB-INF/footer.jspf" %>



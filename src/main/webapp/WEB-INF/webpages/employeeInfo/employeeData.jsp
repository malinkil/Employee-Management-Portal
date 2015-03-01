<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">
  <div class="list-group">
      <h1>Employee Information</h1>
    <a href="#" style="background-color: #F6F2FC;border-radius: 15px;" class="list-group-item clearfix">
        <c:if test="${not empty requestScope.employee}">
        
            <div style="padding: 8px;"><span style="font-weight: bold">First name : </span> <span style="font-style: italic">${requestScope.employee.empFirstname}</span></div>
            <div style="padding: 8px;"><span style="font-weight: bold">Last name :</span> <span style="font-style: italic">${requestScope.employee.empLastName}</span></div>
            <div style="padding: 8px;"><span style="font-weight: bold">Department  name :</span> <span style="font-style: italic">${requestScope.employee.empDeptName}</span></div>
        </c:if>
    </a>
  </div>
</div>
<%@include file="/WEB-INF/footer.jspf" %>



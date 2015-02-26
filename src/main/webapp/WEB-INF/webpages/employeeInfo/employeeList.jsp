<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">
  <div class="list-group">
      <h1>Employee Information</h1>
      <ul style="list-style-type: none;padding: 1px;">
    <c:forEach items="${requestScope.employees}" var="employee">
        <li style="margin-bottom: 12px;">
        <a href="employee?id=${employee.employeeID}" class="list-group-item clearfix"> 
            <c:out value="${employee.empFirstname}"/> ${employee.empLastName}

           <span class="pull-right">
           <button class="btn btn-xs btn-info" style="padding: 10px;width: 80px;">Update</button>
           </span>
           <span class="pull-right" style="margin-right: 16px">
           <button class="btn btn-xs btn-info" style="padding: 10px;width: 80px;">Delete</button>
           </span>
        </a></li>
    </c:forEach>
      </ul>
  </div>
</div>
<%@include file="/WEB-INF/footer.jspf" %>



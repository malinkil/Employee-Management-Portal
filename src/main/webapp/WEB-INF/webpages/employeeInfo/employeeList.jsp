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
               <form action="updatereq?id=${employee.employeeID}" method="POST">
                    <input type="submit" value="UPDATE">
            </form>
           </span>
           <span class="pull-right" style="margin-right: 16px">
           <form id="deleteForm"  action="deletereq?id=${employee.employeeID}" method="POST">
               <input type="submit" onclick="deleteFunction()" value="DELETE">
            </form>
          </span>
       </a></li>
    </c:forEach>
      </ul>
  </div>
</div>
<script>
function deleteFunction() {
    var x;
    if (confirm("Are you sure you want to delete this record?") == true) {
        document.getElementById("deleteForm").submit();
    } 
}
</script>
<%@include file="/WEB-INF/footer.jspf" %>



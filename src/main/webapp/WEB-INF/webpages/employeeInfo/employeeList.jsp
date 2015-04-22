<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">
  <div class="list-group">
      <h1>Employee Information</h1>
       <ul style="list-style-type: none;padding: 1px;">
    <c:if test="${not empty requestScope.delEmpoloyee}">
       <div style="padding:10px;font-weight: bold;color: red;font-style: italic">Record deleted successfully</div> 
   </c:if>
    <c:if test="${not empty requestScope.updateEmployee}">
        <div style="padding:10px;font-weight: bold;color: green;font-style: italic">Record updated successfully</div> 
    </c:if>
    <c:forEach items="${requestScope.employees}" var="employee">
        <li style="margin-bottom: 12px;">
        <a style="background-color: #EEE9E9;" href="employee?id=${employee.employeeID}" class="list-group-item clearfix">
            <c:out value="${employee.empFirstname}"/> ${employee.empLastName}

           <span class="pull-right"> 
            <form action="updateRequest?id=${employee.employeeID}" method="POST">
                    <input style="border-radius: 5px;width: 60px;
                    padding: 8px;
                    background-color: #8B7B8B;
                    color: white;" type="submit" value="Update">
            </form>
           </span>
           <span class="pull-right" style="margin-right: 16px">
           <form id="deleteForm" onsubmit="return deleteFunction();" action="deleteRequest?id=${employee.employeeID}" method="POST">
               <input style="border-radius: 5px;width: 60px;
                    padding: 8px;
                    background-color: #8B7B8B;
                    color: white;" type="submit"  value="Delete">
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
        return true;
    }
    else
    {
        return false;
    }
}
</script>
<%@include file="/WEB-INF/footer.jspf" %>



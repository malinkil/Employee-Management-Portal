<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
    <c:forEach items="${requestScope.employees}" var="employee">
        <li>First Name: <c:out value="${employee.empFirstname}"/> Last Name: ${employee.empLastName}</li>
    </c:forEach>
</ul>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/header.jspf" %>

<h1>I am customers.jsp</h1>

<ul>
    <c:forEach items="${requestScope.employees}" var="employee">
        <li>First Name: <c:out value="${employee.empFirstname}"/> Last Name: ${employee.empLastname}</li>
    </c:forEach>
</ul>

<%@include file="/WEB-INF/footer.jspf" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">

    <h1>Welcome to Employee Management Portal</h1>
        <ul class="list-group">
            <li>
                <a  href="create">Create new Employee</a>
           </li>
           <li>
                <a  href="employees">List of Employees</a>
            </li>
            
        </ul>
</div>

<%@include file="/WEB-INF/footer.jspf" %>
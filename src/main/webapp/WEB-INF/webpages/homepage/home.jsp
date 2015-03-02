<%-- 
    Document   : home
    Created on : Feb 28, 2015, 5:24:58 PM
    Author     : Maulik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container" style="margin-left: 12px">

    <h1>Welcome to Employee Management</h1>
        <ul class="list-group">
            <li style="background-color: #F6F2FC;" class="list-group-item">
                <a  href="create">Create new Employee</a>
            </li>
            <li style="background-color: #F6F2FC;" class="list-group-item">
                <a  href="employees">List of Employees</a>
            </li>
            <li style="background-color: #F6F2FC;" class="list-group-item">
                <a  href="apidocs/index.html">Javadocs</a>
            </li>
            
        </ul>
</div>

<%@include file="/WEB-INF/footer.jspf" %>
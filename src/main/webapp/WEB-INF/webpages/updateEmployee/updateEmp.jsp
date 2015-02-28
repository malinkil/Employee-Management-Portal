<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container">
  <h2>Update Employee Information</h2>
  <form class="form-horizontal" role="form" action="updateAction/${requestScope.upEmployee.employeeID}">
    <div class="form-group">
      <label class="control-label col-sm-2" for="">First Name</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" name="first_name" value="${requestScope.upEmployee.empFirstname}">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="">Last Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="last_name" value="${requestScope.upEmployee.empLastName}">
      </div>
    </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="">Department Name:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="pwd" name="dept_name" value="${requestScope.upEmployee.empDeptName}">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Update</button>
      </div>
    </div>
  </form>
</div>
 
<%@include file="/WEB-INF/footer.jspf" %>





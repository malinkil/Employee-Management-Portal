<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>

<form class="form-horizontal" action="save" method="POST">
    <h4 style="margin-left: 5px">Enter New Employee Information</h4><hr>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">First Name: </label>
    <div class="col-sm-10">
      <input type="text" style="width: 50%;" class="form-control" id="fname" name="first_name" placeholder="first name">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Last Name:</label>
    <div class="col-sm-10">
      <input type="text" style="width: 50%;" class="form-control" id="lname" name="last_name" placeholder="last name">
    </div>
  </div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Department Name:</label>
    <div class="col-sm-10">
      <input type="text" style="width: 50%;" class="form-control" id="dname" name="dept_name" placeholder="department name">
    </div>
  </div>
    
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Birthdate</label>
      <input type="date" name="date" style="margin-left: 16px;border-radius: 8px;
             padding: 5px;
             border-color: #DFDFDF;">
    </div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Gender</label>
    
<div class="radio">
    <label  style="margin-left: 15px;">
    <input type="radio" name="gender" id="male" value="M">
    Male
  </label>
   <label>
    <input type="radio" name="gender" id="female" value="F">
    Female
  </label>
</div>
</div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit"  class="btn btn-primary">Create</button>
    </div>
  </div>
    <c:if test="${not empty requestScope.newEmp}">
        <div style="margin-left: 315px;font-size:17px;padding:10px;font-weight: bold;color: green;font-style: italic">Employee created successfully</div> 
    </c:if>
</form>
<%@include file="/WEB-INF/footer.jspf" %>
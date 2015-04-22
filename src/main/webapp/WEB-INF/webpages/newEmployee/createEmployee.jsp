<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/header.jspf" %>
<div class="container">
<form class="form-horizontal" action="save" method="POST">
    <h4 style="margin-left: 5px">Enter Employee Information</h4><hr>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">First Name: <span style="color:red">*</span></label>
    <div class="col-sm-10">
      <input type="text" style="width: 50%;" class="form-control" id="fname" name="first_name" placeholder="first name">
      <c:if test="${not empty requestScope.fnameReq}">
        <span style="padding:10px;color: red;font-style: italic">First name cannot be blank</span> 
    </c:if>
    </div>
     
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Last Name:<span style="color:red">*</span></label>
    <div class="col-sm-10">
      <input type="text" style="width: 50%;" class="form-control" id="lname" name="last_name" placeholder="last name">
    <c:if test="${not empty requestScope.lnameReq}">
        <span style="padding:10px;color: red;font-style: italic">Last name cannot be blank</span> 
    </c:if>
</div>
    
  </div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Department Name:<span style="color:red">*</span></label>
    <div class="col-sm-10">
      <input type="text" style="width: 50%;" class="form-control" id="dname" name="dept_name" placeholder="department name">
    <c:if test="${not empty requestScope.dnameReq}">
        <span style="padding:10px;color: red;font-style: italic">Department name cannot be blank</span> 
    </c:if>
</div>
    
  </div>
    
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Date of Birth:<span style="color:red">*</span></label>
      <input type="date" name="date" style="margin-left: 16px;border-radius: 8px;
             padding: 5px;
             border-color: #DFDFDF;">
    <c:if test="${not empty requestScope.dateReq}">
        <span style="padding:10px;color: red;font-style: italic;display: block;margin-left: 200px">Date cannot be blank</span> 
    </c:if>
    </div>
<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Gender:<span style="color:red">*</span></label>
    
<div class="radio">
    <label  style="margin-left: 15px;">
    <input type="radio" name="gender" id="male" value="M">
    Male
  </label>
   <label>
    <input type="radio" name="gender" id="female" value="F">
    Female
  </label>
 <c:if test="${not empty requestScope.genderReq}">
        <span style="padding:10px;color: red;font-style: italic;display: block;margin-left: 200px">Gender cannot be blank</span> 
</c:if>
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
    </div>
<%@include file="/WEB-INF/footer.jspf" %>
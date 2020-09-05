<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap-4.1.min.css">

</head>
<body>
		
		<div class="container mt-4">
			<div class="col-sm-6 offset-3">
				<s:form
					modelAttribute="user"
					action="${pageContext.request.contextPath}/user/register"
					method="POST">
				  <div class="form-row">

				  	<h1 class="display-4 my-2">Register Here</h1>

				    <div class="form-group col-md-6">
				      <label for="inputEmail4">Name</label>
				      <s:input type="text" class="form-control" id="inputEmail4" path="name" />
				      <small id="emailHelp" class="form-text text-danger "><s:errors cssClass="text-danger" path="name"></s:errors></small>
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Email</label>
				      <s:input type="email" class="form-control" id="inputPassword4" path="email" />
				      <small id="emailHelp" class="form-text text-danger "><s:errors cssClass="text-danger" path="email"></s:errors></small>
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Mobile No</label>
				      <s:input type="text" class="form-control" id="inputPassword4" path="mobileNo" />
				      <small id="emailHelp" class="form-text text-danger "><s:errors cssClass="text-danger" path="mobileNo"></s:errors></small>
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Username</label>
				      <s:input type="text" class="form-control" id="inputPassword4" path="username" />
				      <small id="emailHelp" class="form-text text-danger "><s:errors cssClass="text-danger" path="username"></s:errors></small>
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Password</label>
				      <s:input type="password" class="form-control" id="inputPassword4" path="password" />
				      <small id="emailHelp" class="form-text text-danger "><s:errors cssClass="text-danger" path="password"></s:errors></small>
				    </div>
				    <div class="form-group col-md-6">
				      <label for="inputPassword4">Confirm Password</label>
				      <s:input type="password" class="form-control" id="inputPassword4" path="confirmPassword" />
				      <small id="emailHelp" class="form-text text-danger "><s:errors cssClass="text-danger" path="confirmPassword"></s:errors></small>
				    </div>

				  </div>
				  <div class="form-group">
				    <label for="inputAddress">About You</label>
				    <input type="text" class="form-control" id="inputAddress" placeholder="Your Bio">
				  </div>
				  <button type="submit" class="btn btn-success">Register</button>
				</s:form>
			</div>
	</div>
		
		
		
		
		
		
		
</body>
</html>
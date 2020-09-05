<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error{
	color: red;}
</style>
</head>
<body>
	<h1>New User Register Here</h1>
	
	<s:form 
			modelAttribute="user"
			action="${pageContext.request.contextPath}/user/register"
			method="POST">
			
			<s:hidden path="id"/>
		
			<p>
				Name : <s:input path="name"/> <s:errors cssClass="error" path="name"></s:errors>
			</p>
			<p>
				Username : <s:input path="username"/> <s:errors cssClass="error" path="username"></s:errors>
			</p>
			<p>
				Password : <s:input path="password"/> <s:errors cssClass="error" path="password"></s:errors>
			</p>
			<p>
				Confirm password : <s:input path="confirmPassword"/> <s:errors cssClass="error" path="confirmPassword"></s:errors>
			</p>
			<p>
				Email : <s:input path="email"/> <s:errors cssClass="error" path="email"></s:errors>
			</p>
			<p>
				Mobile No. : <s:input path="mobileNo"/> <s:errors cssClass="error" path="mobileNo"></s:errors>
			</p>
			<p>
				<input type="submit" value="Register"/>
			</p>
		
	</s:form>
</body>
</html>
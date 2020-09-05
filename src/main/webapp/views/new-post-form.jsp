<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Post Here</h1>
	
	<s:form
		modelAttribute="post"
		action="${pageContext.request.contextPath}/user/posts/addPost"
		method="POST">

		<s:hidden path="id"/>
	
		<p>
			Title <s:input path="title"/><s:errors path="title"></s:errors>
		</p>
		
		<p>
			Content <s:textarea path="body"/><s:errors path="body"></s:errors>
		</p>
		
		<input type="submit" value="Add Post"/>
		
	</s:form>
</body>
</html>
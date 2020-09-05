<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>The Post</h1>
	
	<h3>${post.title}</h3>
	<p>${post.body}</p>
	
	<h1>Find Comments here</h1>
	
	
	
	<s:form 
			modelAttribute="newComment"
			action="${pageContext.request.contextPath}/user/posts/${post.id}/comments"
			method="POST">
		
				<p>
					Write Comment
					<s:textarea path="coment"/>
				</p>
				<input value="Add Post" type="submit" />
		
	</s:form>
	
	<h2>All Comments</h2>
	
	<c:forEach var="comment" items="${comments}">
		<p>${comment.coment}</p>
	</c:forEach>
	
	
</body>
</html>
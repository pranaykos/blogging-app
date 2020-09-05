<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is the home page</h1>

	<c:if test="${username != null}">
		<p>
			Hi , ${username}
			<form action="/logout" method="POST">
				<button type="submit">Logout</button>
			</form>
		<p>
		
		
      
	</c:if>
	
	<c:forEach var="post" items="${posts}">


				<c:url var="postUrl"
					value="${pageContext.request.contextPath}/user/posts/${post.id}">
		
	</c:url>
	
	
		<h3>${post.title}</h3>	
		<p>${post.body.substring(0,4)}... <a href="${postUrl}">Read More</a>
				</p>
		<hr>
		
		
		
		
			
	</c:forEach>
	

		</body>
</html>
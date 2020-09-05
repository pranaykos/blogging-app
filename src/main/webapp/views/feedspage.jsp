<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap-4.1.min.css">
</head>
<body>


	<jsp:include page="./partials/navbar.jsp"></jsp:include>

	
	
	<c:forEach var="post" items="${posts}">


				<c:url var="postUrl"
					value="${pageContext.request.contextPath}/user/posts/${post.id}">
		
	</c:url>
		
		
		<div class="container">
		<div class="row">
			<div class="col-sm-8 offset-2 my-4">
				<div class="card">
					<div class="card-header">
						<div class="media">
							<img src="..." class="mr-3" alt="...">
							<div class="media-body">
								<h5 class="mt-0">${post.createdByUser}</h5>
								About me
							</div>
						</div>
					</div>
					<div class="card-body">
						<h5 class="card-title">${post.title}</h5>
						<p class="card-text">${post.body.substring(0,4)}... </p>
						<a href="${postUrl}" class="btn btn-outline-primary btn-sm">Read More</a>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		
			
	</c:forEach>
	

		</body>
</html>
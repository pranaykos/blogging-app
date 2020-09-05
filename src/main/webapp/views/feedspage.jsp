<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap-4.1.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
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
							<img src="https://source.unsplash.com/60x60/?person" class="mr-3 rounded-circle" alt="...">
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
	
	
	<jsp:include page="./partials/footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

		</body>
</html>
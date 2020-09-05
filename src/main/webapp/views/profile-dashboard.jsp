<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap-4.1.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<jsp:include page="./partials/navbar.jsp"></jsp:include>

	<div class="container my-4">
		<div class="row">
			<div class=" col-md-6 offset-3">
				<h1 class="display-4 my-4 text-capitalize">${profileName}</h1>
			</div>
		</div>
		
		<c:if test="${isOwner}">
			<div class="row">
				<div class=" col-md-6 offset-3">
					<a href="${pageContext.	request.contextPath}/user/posts/new"
						class="btn btn-outline-primary">Add New Post</a>
				</div>
			</div>
		</c:if>
	</div>


	<div class="container my-4">
		<c:choose>
			<c:when test="${posts != null}">

				<c:forEach var="post" items="${posts}">

				
				
				<!-- Update URL -->
				<c:url var="updateLink" value="${pageContext.request.contextPath}/user/posts/delete">
					<c:param name="postId" value="${post.id}" />
				</c:url>


				<!-- Delete URL -->
				<c:url var="deleteLink" value="${pageContext.request.contextPath}/user/posts/delete">
					<c:param name="postId" value="${post.id}" />
				</c:url>
				


					<div class="row my-4">
						<div class="col-sm-8 offset-2">
							<div class="card">
								<div class="card-body">
									<h5 class="card-title">${post.title}</h5>
									<hr>
									<p class="card-text">${post.body}</p>
									
									
									
									
									
									<c:choose>
										<c:when test="${!isOwner}">
											<div class='float-left'>
												<a href='#' class='btn btn-outline-warning btn-sm'>Like</a>
												<a href='#' class='btn btn-outline-danger btn-sm'>Comment</a>
											</div>
										</c:when>
										<c:otherwise>
											<div class='float-right'>
												<a href='#' class='btn btn-outline-warning btn-sm'>Update</a>
												<a href='${updateLink}' class='btn btn-outline-danger btn-sm'>Delete</a>
											</div>
										</c:otherwise>
									</c:choose>
									
								</div>
							</div>
						</div>
					</div>








				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>No Posts Yet</h1>
			</c:otherwise>
		</c:choose>





	</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</body>
</html>